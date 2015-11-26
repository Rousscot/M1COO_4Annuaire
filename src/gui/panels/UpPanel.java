package gui.panels;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by ferlicot & rousseau at Las Vegas
 */
public class UpPanel extends JPanel {
    protected String[] data = {"Inria: 03.66.66.66.66", "M3: 03.77.77.77.77"};
    protected JList<String> jList = new JList(data);
    protected JScrollPane jScrollPane = new JScrollPane(jList);

    public UpPanel(String borderName) {
        Border border = new TitledBorder(borderName);
        jScrollPane.setBorder(border);
        jScrollPane.setPreferredSize(new Dimension(250,250));
        this.add(jScrollPane);
    }

    public JList<String> getjList() {
        return jList;
    }
}
