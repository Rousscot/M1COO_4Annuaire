package gui;

import factory.Annuaire;
import gui.customPanels.AnnuairePanel;
import gui.customPanels.EntreesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame{

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
        entrees = new EntreesPanel(annuaireController);
    }
}