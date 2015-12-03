import dao.exception.find.AnnuaireNotFoundInDBException;
import dao.implement.AnnuaireDAO;
import gui.MainFrame;

import java.io.IOException;

/**
 * TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            new MainFrame((new AnnuaireDAO()).find(null)).setVisible(true);
        } catch (AnnuaireNotFoundInDBException e) {
            System.out.println("ERROR DURING INITIALIZATION.");
            System.exit(666);
        }
    }
}
