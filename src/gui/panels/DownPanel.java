package gui.panels;

import javax.swing.*;

/**
 * Created by ferlicot & rousseau at Ponyland
 */
public class DownPanel extends JPanel {
    protected JButton ajouter = new JButton("Ajouter");
    protected JButton supprimer = new JButton("Supprimer");
    protected JButton nettoyer = new JButton("Nettoyer");

    public DownPanel() {
        this.add(ajouter);
        this.add(supprimer);
        this.add(nettoyer);
    }

    public void initButtons(String ajouter, String supprimer, String nettoyer){

    }

    public JButton getAjouter() {
        return ajouter;
    }

    public JButton getSupprimer() {
        return supprimer;
    }

    public JButton getNettoyer() {
        return nettoyer;
    }
}
