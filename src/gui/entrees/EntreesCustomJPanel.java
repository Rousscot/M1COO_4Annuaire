package gui.entrees;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 21/11/2015.
 */
public class EntreesCustomJPanel extends JPanel {

    EntreesUpJPanel entreesUpJPanel = new EntreesUpJPanel();
    EntreesCenterJPanel entreesCenterJPanel = new EntreesCenterJPanel();
    EntreesDownJPanel entreesDownJPanel = new EntreesDownJPanel();


    public EntreesCustomJPanel() {
        this.setLayout(new BorderLayout());

        // add behaviour to the buttons
        entreesDownJPanel.getAjouter().addActionListener(ajouterActionListener(entreesCenterJPanel));
        entreesDownJPanel.getSupprimer().addActionListener(supprimerActionListener(entreesCenterJPanel));
        entreesDownJPanel.getNettoyer().addActionListener(nettoyerActionListener(entreesCenterJPanel));

        // add the panels
        this.add("North", entreesUpJPanel);
        this.add("Center", entreesCenterJPanel);
        this.add("South", entreesDownJPanel);
    }

    public ActionListener ajouterActionListener(EntreesCenterJPanel entreesCenterJPanel){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(entreesCenterJPanel.getFirstNameToString()+": "+entreesCenterJPanel.getLastNameToString());
            }
        };
        return  actionListener;
    }

    public ActionListener supprimerActionListener(EntreesCenterJPanel entreesCenterJPanel){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("supprimer");
            }
        };
        return  actionListener;
    }

    public ActionListener nettoyerActionListener(EntreesCenterJPanel entreesCenterJPanel){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("nettoyer");
            }
        };
        return  actionListener;
    }

}
