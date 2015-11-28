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

        try {
            Annuaire annuaireController = (new AnnuaireDAO()).find(null);
            new MainFrame(annuaireController).setVisible(true);
        } catch (AnnuaireNotFoundInDBException e) {
            System.out.println("ERROR DURING INITIALIZATION.");
            System.exit(666);
        }
        */
        Entry e1 = new Entry(1L, "James", "Bond");
        Entry e2 = new Entry(2L, "Patrick", "Fiori");
        Number n1 = new Number(1L, "portable", "0202020202", e1);
        Number n2 = new Number(2L, "maison", "0333333333", e1);
        Number n3 = new Number(1L, "portable", "0202020202", e2);
        try {
            e1.addNumber(n1);
            e1.addNumber(n2);
            e2.addNumber(n3);
        } catch (DuplicateNumberException e) {
            e.printStackTrace();
        }
        Annuaire annuaireController = new Annuaire();
        try {
            annuaireController.addEntry(e1);
            annuaireController.addEntry(e2);
        } catch (DuplicateEntryException e) {
            e.printStackTrace();
        }
        new MainFrame(annuaireController).setVisible(true);
    }
}
