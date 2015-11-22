import dao.DAO;
import dao.implement.NumberDAO;
import domaine.Entry;
import domaine.Number;

import java.io.IOException;
import java.sql.SQLException;

/**
 * TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Entry entry = new Entry("Jean-Charle", "De la Motte de sel");
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
        }
    }
}
