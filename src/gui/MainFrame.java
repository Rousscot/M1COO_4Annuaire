package gui;

import gui.annuaire.AnnuaireCustomJPanel;
import gui.entrees.EntreesCustomJPanel;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame{

    JPanel mainJPanel= new JPanel();

    JPanel annuaire = new AnnuaireCustomJPanel();
    JPanel entrees = new EntreesCustomJPanel();

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