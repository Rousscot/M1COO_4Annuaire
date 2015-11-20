package dao.exception.delete;

import dao.exception.DAODeleteException;
import domaine.Entry;

/**
 * I am an exception raised if the deletion of an Entry into the database fail.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class EntryDeleteException extends DAODeleteException {

    /**
     * I am the entry that the DAO tried to delete.
     */
    protected final Entry entry;

    /**
     * I am the constructor.
     *
     * @param entry is the entry I tried to delete.
     */
    public EntryDeleteException(Entry entry) {
        this.entry = entry;
    }

    /**
     * I return the entry that the DAO tried to delete.
     *
     * @return the entry the DAO tried to delete.
     */
    public Entry entry() {
        return entry;
    }
}
