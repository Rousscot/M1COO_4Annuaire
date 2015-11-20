package dao.exception.insert;

import dao.exception.DAOCannotInsertException;

/**
 * I am an exception raised if the DAO cannot insert a Number ino the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class NumberInsertCustomerException extends DAOCannotInsertException {

    /**
     * The number the DAO tried to insert into the database.
     */
    protected final Number number;

    /**
     * I am the constructor of the exception.
     *
     * @param number the number the DAO tried to insert into the database.
     */
    public NumberInsertCustomerException(Number number) {
        this.number = number;
    }

    /**
     * I am a getter to get the number the DAO tried to add to the database.
     *
     * @return a Customer the DAO tried to add to the database
     */
    public Number number() {
        return number;
    }
}
