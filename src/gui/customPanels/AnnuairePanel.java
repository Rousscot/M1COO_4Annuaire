package gui.customPanels;

import domaine.Entry;
import factory.Annuaire;
import gui.panels.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends JPanel {

    protected Annuaire annuaireController;
    protected JPanel upPanel;
    protected JPanel centerPanel;
    protected JPanel downPanel;

    public AnnuairePanel(Annuaire annuaireController) {
        this.annuaireController = annuaireController;
        initPanels();
        addPanelsToMainPanel();
    }

    private void addPanelsToMainPanel() {
        this.add("North", upPanel);
        this.add("Center", centerPanel);
        this.add("South", downPanel);
    }

    private void initPanels() {
        upPanel = new UpEntryPanel(borderName());
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
}
