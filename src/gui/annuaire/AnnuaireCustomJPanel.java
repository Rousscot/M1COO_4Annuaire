package gui.annuaire;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aurelien on 20/11/2015.
 */
public class AnnuaireCustomJPanel extends JPanel {

    public AnnuaireCustomJPanel() {
        this.setLayout(new BorderLayout());

        this.add("North", new AnnuaireUpJPanel());
        this.add("Center", new AnnuaireCenterJPanel());
        this.add("South", new AnnuaireDownJPanel());
    }

}
