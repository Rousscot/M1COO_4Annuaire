package gui.annuaire;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aurelien on 20/11/2015.
 */
public class AnnuaireCenterJPanel extends JPanel {
    JTextField first_name = new JTextField();
    JTextField last_name = new JTextField();
    JLabel prenom = new JLabel("Prenom");
    JLabel nom = new JLabel("Nom");

    public AnnuaireCenterJPanel() {
        // 2 lines, 2 columns, 5px of vertically separation
        this.setLayout(new GridLayout(2, 2, 0, 5));

        // input size
        first_name.setColumns(10);
        last_name.setColumns(10);

        this.add(prenom);
        this.add(first_name);
        this.add(nom);
        this.add(last_name);
    }
}
