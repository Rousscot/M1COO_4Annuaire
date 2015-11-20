package dao.exception.insert;

import dao.exception.DAOCannotInsertException;
import domaine.Entry;

/**
 * I am an exception raised if the DAO cannot insert an Entry ino the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class EntryInsertException extends DAOCannotInsertException {

    /**
     * The entry the DAO tried to insert into the database.
     */
    protected final Entry entry;

    /**
     * I am the constructor of the exception.
     *
     * @param entry the entry the DAO tried to insert into the database.
     */
    public EntryInsertException(Entry entry) {
        this.entry = entry;
    }

    /**
     * I am a getter to get the entry the DAO tried to add to the database.
     *
     * @return a Customer the DAO tried to add to the database
     */
    public Entry entry() {
        return entry;
    }
}
