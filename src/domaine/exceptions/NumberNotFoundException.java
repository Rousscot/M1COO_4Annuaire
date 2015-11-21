package domaine.exceptions;

import domaine.Number;

/**
 * I am an exception raised when a Number is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class NumberNotFoundException extends Exception {
    /**
     * The entry not found.
     */
    protected final Number number;

    /**
     * I am the constructor of the exception.
     *
     * @param number the entry needed to find.
     */
    public NumberNotFoundException(Number number) {
        this.number = number;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the entry of the object that the DAO wanted to find.
     */
    public Number number() {
        return number;
    }

}
