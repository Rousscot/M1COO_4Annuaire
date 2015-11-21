package gui.annuaire;

import javax.swing.*;

/**
 * Created by aurelien on 20/11/2015.
 */
public class AnnuaireDownJPanel extends JPanel {
    JButton ajouter = new JButton("Ajouter");
    JButton supprimer = new JButton("Supprimer");
    JButton nettoyer = new JButton("Nettoyer");

    public AnnuaireDownJPanel() {
        this.add(ajouter);
        this.add(supprimer);
        this.add(nettoyer);
    }
}
