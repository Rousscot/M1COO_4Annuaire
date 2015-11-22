package gui;

import gui.customPanels.AnnuairePanel;
import gui.customPanels.EntreesPanel;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame{

    JPanel mainJPanel= new JPanel();

    AnnuairePanel annuaire = new AnnuairePanel("Annuaire", "Nom", "Prénom");
    EntreesPanel entrees = new EntreesPanel("Entrées", "Code", "Valeur");

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Annuaire");
        this.setLocation(200, 200);
        this.setSize(500, 500);
        Dimension dimension = new Dimension(700,500);

        this.setMinimumSize(dimension);

        mainJPanel.add(annuaire);
        mainJPanel.add(entrees);

        this.add(mainJPanel);
    }

     public static void main(String[] args){
        new MainFrame().setVisible(true);
    }

}