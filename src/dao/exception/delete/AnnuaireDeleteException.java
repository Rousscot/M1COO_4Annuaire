package dao.exception.delete;

import dao.exception.DAODeleteException;
import factory.Annuaire;

/**
 * I am an exception raised if the deletion of an Annuaire into the database fail.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class AnnuaireDeleteException extends DAODeleteException {

    /**
     * I am the annuaire that the DAO tried to delete.
     */
    protected final Annuaire annuaire;

    /**
     * I am the constructor.
     *
     * @param annuaire is the annuaire I tried to delete.
     */
    public AnnuaireDeleteException(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    /**
     * I return the annuaire that the DAO tried to delete.
     *
     * @return the annuaire the DAO tried to delete.
     */
    public Annuaire annuaire() {
        return annuaire;
    }
}
