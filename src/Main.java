import dao.DAO;
import dao.exception.find.AnnuaireNotFoundInDBException;
import dao.implement.AnnuaireDAO;
import dao.implement.NumberDAO;
import domaine.Entry;
import domaine.Number;
import factory.Annuaire;
import gui.MainFrame;

import java.io.IOException;
import java.sql.SQLException;

/**
 * TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {
/*
        Entry entry = new Entry("Jean-Charles", "De la Motte de sel");
        Number num = new Number("Foo", "010101010", entry);
        try {
            DAO<Number> numberDAO = new NumberDAO();

            // Add
            num = numberDAO.create(num);

            // Get
            System.out.println(numberDAO.find(num.getId()));

            // Update
            num.setCode("Baracuda!");
            numberDAO.update(num);
            System.out.println(numberDAO.find(num.getId()));

            // Delete
            numberDAO.delete(num);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try {
            Annuaire annuaire = (new AnnuaireDAO()).find(null);
            new MainFrame(annuaire).setVisible(true);
        } catch (AnnuaireNotFoundInDBException e) {
            System.out.println("ERROR DURING INITIALIZATION.");
            System.exit(666);
        }
    }
}
