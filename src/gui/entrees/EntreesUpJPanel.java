package gui.entrees;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by aurelien on 21/11/2015.
 */
public class EntreesUpJPanel extends JPanel {

    String[] data = {"Inria: 03.66.66.66.66", "M3: 03.77.77.77.77"};
    JList<String> jList = new JList(data);
    JScrollPane jScrollPane = new JScrollPane(jList);

    public EntreesUpJPanel() {
        Border border = new TitledBorder("Entrées");
        jScrollPane.setBorder(border);
        jScrollPane.setPreferredSize(new Dimension(250,250));
        this.add(jScrollPane);
    }
}