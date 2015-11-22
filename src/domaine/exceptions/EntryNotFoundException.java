package domaine.exceptions;

import domaine.Entry;

/**
 * I am an exception raised when an Entry is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class EntryNotFoundException extends Exception {
    /**
     * The entry not found.
     */
    protected final Entry entry;

    /**
     * I am the constructor of the exception.
     *
     * @param entry the entry needed to find.
     */
    public EntryNotFoundException(Entry entry) {
        this.entry = entry;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the entry of the object that the DAO wanted to find.
     */
    public Entry entry() {
        return entry;
    }

}
