package gui.entrees;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aurelien on 21/11/2015.
 */
public class EntreesCustomJPanel extends JPanel {


    public EntreesCustomJPanel() {
        this.setLayout(new BorderLayout());

        this.add("North", new EntreesUpJPanel());
        this.add("Center", new EntreesCenterJPanel());
        this.add("South", new EntreesDownJPanel());
    }

}
