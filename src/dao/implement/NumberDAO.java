package dao.implement;

import dao.DAO;
import dao.exception.delete.NumberDeleteException;
import dao.exception.find.NumberNotFoundInDBException;
import dao.exception.insert.NumberInsertCustomerException;
import dao.exception.update.NumberUpdateFailedException;
import domaine.Entry;
import domaine.Number;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 */
public class NumberDAO extends DAO<Number> {

    public NumberDAO() {
        super();
    }

    @Override
    public Number create(Number number) throws NumberInsertCustomerException {
        String idRequest = "SELECT NEXTVAL('number_id_seq') AS id";
        try {

            // If the Entry does not exist we insert it into the database.
            if(number.getEntryId() == Long.valueOf(0)){
                number.setEntry((new EntryDAO()).create(number.getEntry()));
            }

            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO NUMBER (id_number, code, value, id_entry) VALUES(?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, number.getCode());
                prepare.setString(3, number.getValue());
                prepare.setLong(4, number.getEntryId());
                prepare.executeUpdate();
                number = this.find(id);
            }
        } catch (SQLException e) {
            throw new NumberInsertCustomerException(number);
        }
        return number;
    }

    @Override
    public void delete(Number number) throws NumberDeleteException {
        String request = "DELETE FROM NUMBER WHERE id_number = " + number.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new NumberDeleteException(number);
        }

    }

    @Override
    public Number update(Number number) throws NumberUpdateFailedException {
        String request = "UPDATE Number SET code = '" + number.getCode() + "'," +
                " value = '" + number.getValue() + "'," +
                " id_entry = '" + number.getEntryId() + "' WHERE id_number = " + number.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            number = this.find(number.getId());
        } catch (SQLException e) {
            throw new NumberUpdateFailedException(number);
        }
        return number;
    }

    @Override
    public Number find(Long id) throws NumberNotFoundInDBException {
        String request = "SELECT * FROM NUMBER WHERE id_number = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                Entry entry = (new EntryDAO()).find(result.getLong("id_entry"));
                return new Number(id, result.getString("code"), result.getString("value"), entry );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NumberNotFoundInDBException(id);
    }
}
