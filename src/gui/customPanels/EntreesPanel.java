package gui.customPanels;

import factory.Annuaire;
import gui.panels.CenterPanel;
import gui.panels.FullCustomPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class EntreesPanel extends FullCustomPanel {

    protected Annuaire annuaireController;

    public EntreesPanel() {
        super();
    }

    public EntreesPanel(Annuaire annuaireController){
        this();
        this.annuaireController = annuaireController;
    }

    @Override
    public ActionListener ajouterActionListener(CenterPanel centerPanel) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(centerPanel.getFirstLabelToString() + " " + centerPanel.getSecondLabelToString());
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
