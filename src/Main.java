import dao.DAO;
import dao.exception.find.AnnuaireNotFoundInDBException;
import dao.implement.AnnuaireDAO;
import dao.implement.NumberDAO;
import domaine.Entry;
import domaine.Number;
import domaine.exceptions.DuplicateEntryException;
import domaine.exceptions.DuplicateNumberException;
import factory.Annuaire;
import gui.MainFrame;

import java.io.IOException;

/**
 * TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {
/*
        Entry entry = new Entry("Jean-Charles", "De la Motte de sel");
        Number num = new Number("Foo", "010101010", entry);

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
*/
        try {
            new MainFrame((new AnnuaireDAO()).find(null)).setVisible(true);
        } catch (AnnuaireNotFoundInDBException e) {
            System.out.println("ERROR DURING INITIALIZATION.");
            System.exit(666);
        }

    }
}
