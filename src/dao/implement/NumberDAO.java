package dao.implement;

import dao.DAO;
import dao.exception.delete.NumberDeleteException;
import dao.exception.find.NumberNotFoundException;
import dao.exception.insert.NumberInsertCustomerException;
import dao.exception.update.NumberUpdateFailedException;

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
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO NUMBER (id_number, code, value) VALUES(?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, number.getCode());
                prepare.setString(3, number.getValue());
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
                " value = '" + number.getValue() + "'"
                " WHERE cust_id = " + number.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            number = this.find(number.getId());
        } catch (SQLException e) {
            throw new NumberUpdateFailedException(number);
        }
        return number;
    }

    @Override
    public Number find(Long id) throws NumberNotFoundException {
        String request = "SELECT * FROM NUMBER WHERE id_number = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                return new Number(id, result.getString("code"), result.getString("value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NumberNotFoundException(id);
    }
}
