package dao.implement;

import dao.DAO;
import dao.exception.delete.NumberDeleteException;
import dao.exception.find.NumberNotFoundInDBException;
import dao.exception.insert.NumberInsertException;
import dao.exception.update.NumberUpdateFailedException;
import domaine.Number;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * I am a DAO that manage Number objects.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class NumberDAO extends DAO<Number> {

    /**
     * I am a method that add a Number to the database.
     *
     * @param number the entry I need to add.
     * @return the entry with the id updated.
     * @throws NumberInsertException if I cannot insert the entry or if the Number is already in the table.
     */
    @Override
    public Number create(Number number) throws NumberInsertException {

        // If the id is not 0, the element need an update and not an insert.
        if (!number.getId().equals(0L)) {
            throw new NumberInsertException(number);
        }

        String idRequest = "SELECT NEXTVAL('number_id_seq') AS id";

        try {
            // If the Entry does not exist we insert it into the database.
            if (number.getId() != null && number.getEntryId() == 0L) {
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
            throw new NumberInsertException(number);
        }
        return number;
    }

    /**
     * I am a method that delete a Number of the database.
     *
     * @param number the entry I need to delete.
     * @throws NumberDeleteException raised if I cannot delete the Number from the database.
     */
    @Override
    public void delete(Number number) throws NumberDeleteException {
        String request = "DELETE FROM NUMBER WHERE id_number = " + number.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new NumberDeleteException(number);
        }
    }

    /**
     * I am a method that update a method in a database.
     *
     * @param number the entry I need to update.
     * @return the entry updated (should not change)
     * @throws NumberUpdateFailedException if I cannot update the Number.
     */
    @Override
    public Number update(Number number) throws NumberUpdateFailedException {
        String request = "UPDATE Number SET code = '" + number.getCode() + "'," + " value = '" + number.getValue() + "'," + " id_entry = '" + number.getEntryId() + "' WHERE id_number = " + number.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            number = this.find(number.getId());
        } catch (SQLException e) {
            throw new NumberUpdateFailedException(number);
        }
        return number;
    }

    /**
     * I am a method that visit the database and return a Number from an id.
     *
     * @param id the id of the Number.
     * @return the Number matching the id.
     * @throws NumberNotFoundInDBException raised if the Number is not found.
     */
    @Override
    public Number find(Long id) throws NumberNotFoundInDBException {
        try {
            Number number = this.findWithoutEntry(id);
            String request = "SELECT id_entry FROM NUMBER WHERE id_number = " + id;
            Statement statement = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery(request);
            if(result.first()) {
                Long id_entry = result.getLong("id_entry");
                number.setEntry((new EntryDAO()).find(id_entry));
            }
                return number;
            } catch ( SQLException e) {
            e.printStackTrace();
        }
        throw new NumberNotFoundInDBException(id);
    }

    /**
     * I am a method that visit the database and return a Number from an id without the entry set. This avoid an infinite loop when we try to find an entry.
     *
     * @param id the id of the Number.
     * @return the Number matching the id.
     * @throws NumberNotFoundInDBException raised if the Number is not found.
     */
    public Number findWithoutEntry(Long id) throws NumberNotFoundInDBException {
        String request = "SELECT * FROM NUMBER WHERE id_number = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                return new Number(id, result.getString("code"), result.getString("value"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NumberNotFoundInDBException(id);
    }
}
