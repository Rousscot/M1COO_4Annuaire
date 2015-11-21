package dao.exception.find;

import dao.exception.DAONotFoundException;

/**
 * I am an exception raised in case the DAO cannot find an Annuaire into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class AnnuaireNotFoundInDBException extends DAONotFoundException {

    public AnnuaireNotFoundInDBException(Long id) {
        super(id);
    }

}
