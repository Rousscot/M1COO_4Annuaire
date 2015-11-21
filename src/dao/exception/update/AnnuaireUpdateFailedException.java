package dao.exception.update;

import dao.exception.DAOUpdateFailedException;
import factory.Annuaire;

/**
 * I am an exception raised when the DAO cannot update an Annuaire into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class AnnuaireUpdateFailedException extends DAOUpdateFailedException {

    /**
     * The annuaire the DAO tried to update.
     */
    protected final Annuaire annuaire;

    /**
     * I am the constructor.
     *
     * @param annuaire the annuaire the DAO tried to update.
     */
    public AnnuaireUpdateFailedException(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    /**
     * I am a getter to get the annuaire the DAO tried to update.
     *
     * @return the annuaire the DAO tried to update.
     */
    public Annuaire annuaire() {
        return this.annuaire;
    }
}
