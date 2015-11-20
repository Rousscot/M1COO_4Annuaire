package domaine.exceptions;

import domaine.Number;

/**
 * TODO
 */
public class DuplicateNumberException extends Exception {

    protected final Number number;

    public DuplicateNumberException(Number number) {
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }
}
