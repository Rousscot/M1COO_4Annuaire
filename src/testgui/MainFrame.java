package testgui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame{

    JPanel mainJPanel= new JPanel();

    JPanel annuaire = new JPanel();
    JPanel entrees = new JPanel();
    JButton ajouterA = new JButton("Ajouter");
    JButton modifierA = new JButton("Modifier");
    JButton supprimerA = new JButton("Supprimer");
    JButton ajouterE = new JButton("Ajouter");
    JButton modifierE = new JButton("Modifier");
    JButton supprimerE = new JButton("Supprimer");


    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Annuaire");
        this.setLocation(200, 200);
        this.setSize(400, 300);
        Dimension dimension = new Dimension();

        this.setMinimumSize();

        annuaire.add(ajouterA);
        annuaire.add(modifierA);
        annuaire.add(supprimerA);
        mainJPanel.add(annuaire);

        entrees.add(ajouterE);
        entrees.add(modifierE);
        entrees.add(supprimerE);
        mainJPanel.add(entrees);

        this.add(mainJPanel);
    }

    public static void main(String[] args){
        new MainFrame().setVisible(true);
    }

}