package dao.exception.find;

import dao.exception.DAONotFoundException;

/**
 * I am an exception raised in case the DAO cannot find an Entry into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class EntryNotFoundInDBException extends DAONotFoundException {

    public EntryNotFoundInDBException(Long id) {
        super(id);
    }

}
