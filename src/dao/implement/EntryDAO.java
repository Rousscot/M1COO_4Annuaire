package dao.implement;

import dao.DAO;
import dao.exception.delete.EntryDeleteException;
import dao.exception.find.EntryNotFoundInDBException;
import dao.exception.insert.EntryInsertException;
import dao.exception.update.EntryUpdateFailedException;
import domaine.Entry;
import domaine.Number;
import domaine.exceptions.DuplicateNumberException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * I am a DAO that manage Entry objects.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class EntryDAO extends DAO<Entry> {

    /**
     * I save a DAO<Number> because all my methods need it, so I prefer be initialized with it.
     */
    protected NumberDAO numberDAO;

    public EntryDAO() {
        super();
        this.numberDAO = new NumberDAO();
    }

    /**
     * I am a method that insert an Entry inside a database.
     * If the Entry have Numbers that are not in the database, I add them too.
     *
     * @param entry is the object I add to the database.
     * @return The object with the id set
     * @throws EntryInsertException raised if the entry (or one of his entry) cannot be added or is already added (id != 0).
     */
    @Override
    public Entry create(Entry entry) throws EntryInsertException {

        //If the id is 0 the element need an update and not insert.
        if (entry.getId() != 0) {
            throw new EntryInsertException(entry);
        }

        String idRequest = "SELECT NEXTVAL('entry_id_seq') AS id";

        try {

            for (Number number : entry.getNumbers()) {
                if (!number.getId().equals(0L)) {
                    this.numberDAO.create(number);
                }
            }

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
     * I am a method that delete an Entry and his numbers from a database.
     *
     * @param entry is the entry I delete.
     * @throws EntryDeleteException raised if I cannot delete the Entry (or one of his entry).
     */
    @Override
    public void delete(Entry entry) throws EntryDeleteException {
        String request = "DELETE FROM ENTRY WHERE id_entry = " + entry.getId();
        try {

            for (Number number : entry.getNumbers()) {
                this.numberDAO.delete(number);
            }

            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new EntryDeleteException(entry);
        }
    }

    /**
     * I am a method that update an Entry.
     *
     * @param entry the entry I update.
     * @return the entry updated. (should be the same as the parameter)
     * @throws EntryUpdateFailedException raised if I cannot update the entry (or one of his entry).
     */
    @Override
    public Entry update(Entry entry) throws EntryUpdateFailedException {

        String request = "UPDATE ENTRY SET first_name = '" + entry.getFirstName() + "'," + " last_name = '" + entry.getLastName() + "' WHERE id_entry = " + entry.getId();
        try {

            for (Number number : entry.getNumbers()) {
                this.numberDAO.update(number);
            }

            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            entry = this.find(entry.getId());
        } catch (SQLException e) {
            throw new EntryUpdateFailedException(entry);
        }
        return entry;
    }

    /**
     * I am a method that visit a database and create an Entry from an id.
     *
     * @param id the id of the Entry I need to create.
     * @return an Entry matching the id.
     * @throws EntryNotFoundInDBException if I cannot find the Entry.
     */
    @Override
    public Entry find(Long id) throws EntryNotFoundInDBException {
        String request = "SELECT * FROM ENTRY WHERE id_entry = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);

            if (result.first()) {
                Entry entry = new Entry(id, result.getString("first_name"), result.getString("last_name"));

                String requestNumber = "SELECT * FROM NUMBER WHERE id_entry = " + id;
                ResultSet resultNumbers = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(requestNumber);
                while (resultNumbers.next()) {
                    try {
                        entry.addNumber(this.numberDAO.find(resultNumbers.getLong("id_number")));
                    } catch (DuplicateNumberException e) {
                        //Should not happen
                    }
                }
                return entry;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new EntryNotFoundInDBException(id);
    }
}
