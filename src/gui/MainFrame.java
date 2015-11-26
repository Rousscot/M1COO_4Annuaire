package gui;

import gui.customPanels.AnnuairePanel;
import gui.customPanels.EntreesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        // Behaviour of the Jlists
        annuaire.getUpPanel().getjList().addMouseListener(entreesMouseListener());

        mainJPanel.add(annuaire);
        mainJPanel.add(entrees);

        this.add(mainJPanel);
    }

    public MouseListener entreesMouseListener(){
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String selected = annuaire.getUpPanel().getjList().getSelectedValue();
                DefaultListModel<String> stringDefaultListModel = new DefaultListModel<>();
                stringDefaultListModel.add(0, selected);
                entrees.getUpPanel().getjList().setModel(stringDefaultListModel);
            }
        };
        return mouseListener;
    }

     public static void main(String[] args){
        new MainFrame().setVisible(true);
    }

}