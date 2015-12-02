package gui.customPanels;

import domaine.Entry;
import factory.Annuaire;
import gui.MainFrame;
import gui.panels.CenterPanel;
import gui.panels.DownPanel;
import gui.panels.UpEntryPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends JPanel {

    protected Annuaire annuaireController;
    protected UpEntryPanel upPanel;
    protected JPanel centerPanel;
    protected JPanel downPanel;

    public AnnuairePanel(Annuaire annuaireController) {
        this.annuaireController = annuaireController;
        initPanels();
        addPanelsToMainPanel();
    }

    private void addPanelsToMainPanel() {
        this.setLayout(new BorderLayout());
        this.add("North", upPanel);
        this.add("Center", centerPanel);
        this.add("South", downPanel);
    }

    private void initPanels() {
        upPanel = new UpEntryPanel(borderName(), annuaireController);
        centerPanel = new CenterPanel(firstLabel(), secondLabel());
        downPanel = new DownPanel();
    }

    public String borderName() {
        return "Annuaire";
    }

    public String firstLabel() {
        return "Nom";
    }

    public String secondLabel() {
        return "Prénom";
    }

    public void addListener(MainFrame frame) {
        upPanel.addListener(frame);
    }

    public Entry getEntryAt(int index) {
       return upPanel.getEntryAt(index);
    }
}
