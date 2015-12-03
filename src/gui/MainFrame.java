package gui;

import dao.exception.insert.NumberInsertException;
import domaine.Entry;
import domaine.NullEntry;
import domaine.Number;
import domaine.exceptions.DuplicateNumberException;
import domaine.exceptions.EntryNotFoundException;
import domaine.exceptions.NumberNotFoundException;
import factory.Annuaire;
import gui.panels.AnnuairePanel;
import gui.panels.EntreesPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.sql.SQLException;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame implements ListSelectionListener {

    protected JPanel mainJPanel;
    protected AnnuairePanel annuaire;
    protected EntreesPanel entrees;
    protected Annuaire annuaireController;

    public MainFrame(Annuaire annuaireController) {
        this.annuaireController = annuaireController;
        initFrameParameters();
        initPanels(annuaireController);
        addPanelsToFrame();
    }

    public void addPanelsToFrame() {
        mainJPanel.add(annuaire);
        mainJPanel.add(entrees);
        this.add(mainJPanel);
    }

    public void initFrameParameters(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Annuaire");
        this.setLocation(200, 200);
        this.setSize(500, 500);
        this.setMinimumSize(new Dimension(700,500));
    }

    public void initPanels(Annuaire annuaireController){
        mainJPanel = new JPanel();
        annuaire = new AnnuairePanel(annuaireController, this);
        entrees = new EntreesPanel(new NullEntry(null, null), this); //We set it to null because the entry of this panel will be decide by the selection on the fist panel.
        annuaire.addListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
           refreshNumbersWith(annuaire.getEntrySelected());
        }
    }

    public void refreshNumbersWith(Entry entry) {
        entrees.entreeController(entry);
    }

    public void createNumberForSelectedEntryWith(String code, String value) {
        try {
            annuaireController.createNumberFor(annuaire.getEntrySelected(), code, value);
        } catch (NumberInsertException | EntryNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
        } catch (DuplicateNumberException e) {
            JOptionPane.showMessageDialog(this, "Ce contact possède déjà ce numéro.");
        }
    }

    public void deleteNumberFor(Entry entry, Number number) {
        try {
            annuaireController.deleteNumberOf(entry, number);
        } catch (SQLException | NumberNotFoundException | EntryNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
        }
    }
}