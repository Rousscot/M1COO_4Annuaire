package dao.implement;

import dao.DAO;
import dao.exception.DAOCannotInsertException;
import dao.exception.DAONotFoundException;
import dao.exception.DAOUpdateFailedException;
import dao.exception.delete.EntryDeleteException;
import dao.exception.find.EntryNotFoundInDBException;
import dao.exception.insert.EntryInsertException;
import dao.exception.update.EntryUpdateFailedException;
import domaine.Entry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 */
public class EntryDAO extends DAO<Entry> {

    /**
     * TODO
     *
     * @param entry
     * @return
     * @throws DAOCannotInsertException
     */
    @Override
    public Entry create(Entry entry) throws EntryInsertException {

        //TODO iterate on the Numbers and add them if they are not on the db.

        String idRequest = "SELECT NEXTVAL('entry_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO ENTRY (id_entry, first_name, last_name) VALUES(?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, entry.getFirstName());
                prepare.setString(3, entry.getLastName());
                prepare.executeUpdate();
                entry = this.find(id);
            }
        } catch (SQLException e) {
            throw new EntryInsertException(entry);
        }
        return entry;
    }

    /**
     * TODO
     *
     * @param entry
     * @throws EntryDeleteException
     */
    @Override
    public void delete(Entry entry) throws EntryDeleteException {

        //TODO Delete numbers !

        String request = "DELETE FROM ENTRY WHERE id_entry = " + entry.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new EntryDeleteException(entry);
        }
    }

    /**
     * TODO
     *
     * @param entry
     * @return
     * @throws DAOUpdateFailedException
     */
    @Override
    public Entry update(Entry entry) throws EntryUpdateFailedException {

        //TODO Update numbers !

        String request = "UPDATE ENTRY SET first_name = '" + entry.getFirstName() + "'," +
                " last_name = '" + entry.getLastName() + "' WHERE id_entry = " + entry.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            entry = this.find(entry.getId());
        } catch (SQLException e) {
            throw new EntryUpdateFailedException(entry);
        }
        return entry;
    }

    /**
     * TODO
     * @param id the id of the object.
     * @return
     * @throws EntryNotFoundInDBException
     */
    @Override
    public Entry find(Long id) throws EntryNotFoundInDBException {
        String request = "SELECT * FROM ENTRY WHERE id_entry = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                Entry entry = new Entry(id, result.getString("first_name"), result.getString("last_name"));

                //TODO manage numbers.

                return entry;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new EntryNotFoundInDBException(id);
    }
}
