package gui.customPanels;

import domaine.Entry;
import factory.Annuaire;
import gui.panels.FullCustomPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends FullCustomPanel {

    protected Annuaire annuaireController;

    public AnnuairePanel(Annuaire annuaireController) {
        super();
        this.annuaireController = annuaireController;
        refresh();
    }

    // TODO set the values into the jList, modify it with the real values (Database instead of Annuaire)
    public void refresh() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Entry entry : annuaireController.entries()) {
            model.addElement(entry.getFirstName() + " " + entry.getLastName());
        }
        this.getUpPanel().getjList().setModel(model);
    }


    // TODO add the real behaviour -> add an Entry if the first+last name are filled, then refresh the jList
    @Override
    public ActionListener ajouterActionListener() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("annuaire ajouter");
            }
        };
        return actionListener;
    }

    @Override
    public String borderName() {
        return "Annuaire";
    }

    @Override
    public String firstLabel() {
        return "Nom";
    }

    @Override
    public String secondLabel() {
        return "Prénom";
    }

}
