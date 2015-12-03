package gui;

import domaine.NullEntry;
import factory.Annuaire;
import gui.panels.AnnuairePanel;
import gui.panels.EntreesPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame implements ListSelectionListener {

    protected JPanel mainJPanel;
    protected AnnuairePanel annuaire;
    protected EntreesPanel entrees;

    public MainFrame(Annuaire annuaireController) {
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
        annuaire = new AnnuairePanel(annuaireController);
        entrees = new EntreesPanel(new NullEntry(null, null)); //We set it to null because the entry of this panel will be decide by the selection on the fist panel.
        annuaire.addListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
            entrees.entreeController(annuaire.getEntryAt(e.getLastIndex()));
        }
    }

    public void refresh(){
        annuaire.refresh();
        entrees.refresh();
    }
}