package gui.annuaire;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by aurelien on 20/11/2015.
 */
public class AnnuaireUpJPanel extends JPanel {

    String[] data = {"James Bond", "François Hollande", "Vladimir Poutine", "Johnny Haliday", "Albert Einstein", "Zinedine Zidane"};
    JList<String> jList = new JList(data);
    JScrollPane jScrollPane = new JScrollPane(jList);

    public AnnuaireUpJPanel() {
        Border border = new TitledBorder("Annuaire");
        jScrollPane.setBorder(border);
        jScrollPane.setPreferredSize(new Dimension(250,250));
        this.add(jScrollPane);
    }
}