package gui.entrees;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aurelien on 21/11/2015.
 */
public class EntreesCenterJPanel  extends JPanel {
    JTextField first_name = new JTextField();
    JTextField last_name = new JTextField();
    JLabel prenom = new JLabel("Code");
    JLabel nom = new JLabel("Valeur");

    public EntreesCenterJPanel() {
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
