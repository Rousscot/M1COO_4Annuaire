package dao.exception.insert;

import dao.exception.DAOCannotInsertException;
import factory.Annuaire;

/**
 * I am an exception raised if the DAO cannot insert an Annuaire ino the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class AnnuaireInsertException extends DAOCannotInsertException {

    /**
     * The annuaire the DAO tried to insert into the database.
     */
    protected final Annuaire annuaire;

    /**
     * I am the constructor of the exception.
     *
     * @param annuaire the annuaire the DAO tried to insert into the database.
     */
    public AnnuaireInsertException(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    /**
     * I am a getter to get the annuaire the DAO tried to add to the database.
     *
     * @return a Customer the DAO tried to add to the database
     */
    public Annuaire annuaire() {
        return annuaire;
    }
}
