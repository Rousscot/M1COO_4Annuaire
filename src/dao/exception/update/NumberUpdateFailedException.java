package dao.exception.update;

import dao.exception.DAOUpdateFailedException;
import domaine.Number;

/**
 * I am an exception raised when the DAO cannot update a Number into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class NumberUpdateFailedException extends DAOUpdateFailedException {

    /**
     * The entry the DAO tried to update.
     */
    protected final Number number;

    /**
     * I am the constructor.
     *
     * @param number the entry the DAO tried to update.
     */
    public NumberUpdateFailedException(Number number) {
        this.number = number;
    }

    /**
     * I am a getter to get the entry the DAO tried to update.
     *
     * @return the entry the DAO tried to update.
     */
    public Number number() {
        return this.number;
    }
}
