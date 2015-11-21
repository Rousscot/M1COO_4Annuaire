package gui.entrees;

import javax.swing.*;

/**
 * Created by aurelien on 21/11/2015.
 */
public class EntreesDownJPanel extends JPanel {
    JButton ajouter = new JButton("Ajouter");
    JButton supprimer = new JButton("Supprimer");
    JButton nettoyer = new JButton("Nettoyer");

    public EntreesDownJPanel() {
        this.add(ajouter);
        this.add(supprimer);
        this.add(nettoyer);
    }
}
