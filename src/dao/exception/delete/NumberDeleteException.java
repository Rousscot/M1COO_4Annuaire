package dao.exception.delete;

import dao.exception.DAODeleteException;
import domaine.Number;

/**
 * I am an exception raised if the deletion of a Number into the database fail.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class NumberDeleteException extends DAODeleteException {

    /**
     * I am the number that the DAO tried to delete.
     */
    protected final Number number;

    /**
     * I am the constructor.
     *
     * @param number is the number I tried to delete.
     */
    public NumberDeleteException(Number number) {
        this.number = number;
    }

    /**
     * I return the number that the DAO tried to delete.
     *
     * @return the number the DAO tried to delete.
     */
    public Number number() {
        return number;
    }
}
