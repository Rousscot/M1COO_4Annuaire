package dao.implement;

import dao.DAO;
import dao.exception.delete.AnnuaireDeleteException;
import dao.exception.find.AnnuaireNotFoundInDBException;
import dao.exception.insert.AnnuaireInsertException;
import dao.exception.update.AnnuaireUpdateFailedException;
import domaine.Entry;
import factory.Annuaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 */
public class AnnuaireDAO extends DAO<Annuaire> {

    protected EntryDAO entryDAO;

    public AnnuaireDAO() {
        super();
        this.entryDAO = new EntryDAO();
    }

    @Override
    public Annuaire create(Annuaire annuaire) throws AnnuaireInsertException {
        try {
            for (Entry entry : annuaire.entries()) {
                if (entry.getId().equals(0L)) {
                    this.entryDAO.create(entry);
                }
            }
            return this.find(null);
        } catch (SQLException e) {
            throw new AnnuaireInsertException(annuaire);
        }
    }

    @Override
    public void delete(Annuaire annuaire) throws AnnuaireDeleteException {
        try {
            for (Entry entry : annuaire.entries()) {
                this.entryDAO.delete(entry);
            }
        } catch (SQLException e) {
            throw new AnnuaireDeleteException(annuaire);
        }
    }

    @Override
    public Annuaire update(Annuaire annuaire) throws AnnuaireUpdateFailedException {
        try {
            for (Entry entry : annuaire.entries()) {
                this.entryDAO.update(entry);
            }
            return this.find(null);
        } catch (SQLException e) {
            throw new AnnuaireUpdateFailedException(annuaire);
        }
    }

    @Override
    public Annuaire find(Long id) throws AnnuaireNotFoundInDBException {
        try {
            Annuaire annuaire = new Annuaire();
            String request = "SELECT * FROM entry";
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            List<Entry> entries = new LinkedList<>();
            while (result.next()) {
                entries.add(this.entryDAO.find(result.getLong("id_entry")));
            }
            annuaire.entries(entries);
            return annuaire;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new AnnuaireNotFoundInDBException(id);
    }
}
