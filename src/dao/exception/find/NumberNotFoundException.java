package dao.exception.find;

import dao.exception.DAONotFoundException;

/**
 * I am an exception raised in case the DAO cannot find a Number into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class NumberNotFoundException extends DAONotFoundException {

    public NumberNotFoundException(Long id) {
        super(id);
    }

}
