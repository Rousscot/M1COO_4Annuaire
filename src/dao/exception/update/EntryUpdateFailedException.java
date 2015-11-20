package dao.exception.update;

import dao.exception.DAOUpdateFailedException;
import domaine.Entry;

/**
 * I am an exception raised when the DAO cannot update an Entry into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class EntryUpdateFailedException extends DAOUpdateFailedException {

    /**
     * The entry the DAO tried to update.
     */
    protected final Entry entry;

    /**
     * I am the constructor.
     *
     * @param entry the entry the DAO tried to update.
     */
    public EntryUpdateFailedException(Entry entry) {
        this.entry = entry;
    }

    /**
     * I am a getter to get the entry the DAO tried to update.
     *
     * @return the entry the DAO tried to update.
     */
    public Entry entry() {
        return this.entry;
    }
}
