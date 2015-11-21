package domaine.exceptions;

import domaine.Entry;

/**
 * TODO
 */
public class DuplicateEntryException extends Exception {

    protected final Entry entry;

    public DuplicateEntryException(Entry entry) {
        this.entry = entry;
    }

    public Entry getEntry() {
        return entry;
    }
}
