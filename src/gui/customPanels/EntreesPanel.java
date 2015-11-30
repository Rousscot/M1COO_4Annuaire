package gui.customPanels;

import factory.Annuaire;
import gui.panels.FullCustomPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class EntreesPanel extends FullCustomPanel {

    protected Annuaire annuaireController;

    public EntreesPanel(Annuaire annuaireController){
        super();
        this.annuaireController = annuaireController;

    }

    public void addBehaviours(){
        super.addBehaviours();
        downPanel.getNettoyer().addActionListener(nettoyerActionListener());
    }

    // TODO set the values into the jList, modify it with the real values (Database instead of Annuaire)
    public void refresh() {
    }

    // TODO add the real behaviour -> add an Entry if the first+last name are filled, then refresh the jList
    @Override
    public ActionListener ajouterActionListener() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entrées ajouter");
            }
        };
        return actionListener;
    }

    // TODO add the real behaviour -> delete all Entries then refresh the jList
    public ActionListener nettoyerActionListener(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = new DefaultListModel<>();
                upPanel.getJList().setModel(model);
            }
        };
        return actionListener;
    }

    @Override
    public String borderName(){
        return "Entrees";
    }

    @Override
    public String firstLabel() {
        return "Code";
    }

    @Override
    public String secondLabel() {
        return "Value";
    }

}
