package gui.annuaire;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 20/11/2015.
 */
public class AnnuaireDownJPanel extends JPanel {
    JButton ajouter = new JButton("Ajouter");
    JButton supprimer = new JButton("Supprimer");
    JButton nettoyer = new JButton("Nettoyer");

    public AnnuaireDownJPanel() {
        ajouter.addActionListener(ajouterActionListener());
        supprimer.addActionListener(supprimerActionListener());
        nettoyer.addActionListener(nettoyerActionListener());

        this.add(ajouter);
        this.add(supprimer);
        this.add(nettoyer);
    }

    public ActionListener ajouterActionListener(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ajouter");
            }
        };
        return  actionListener;
    }

    public ActionListener supprimerActionListener(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("supprimer");
            }
        };
        return  actionListener;
    }

    public ActionListener nettoyerActionListener(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("nettoyer");
            }
        };
        return  actionListener;
    }

}
