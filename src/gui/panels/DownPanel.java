package gui.panels;

import javax.swing.*;

/**
 * Created by ferlicot & rousseau at Ponyland
 */
public class DownPanel extends JPanel {
    protected JButton ajouter;
    protected JButton supprimer;
    protected JButton nettoyer;

    public DownPanel() {
        initButtons();
        addButtonsToPanel();
    }

    public void initButtons(){
        this.ajouter = new JButton("Ajouter");
        this.supprimer = new JButton("Supprimer");
        this.nettoyer = new JButton("Nettoyer");
    }

    public void addButtonsToPanel(){
        this.add(ajouter);
        this.add(supprimer);
        this.add(nettoyer);
    }

    // GETTER SETTER

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
