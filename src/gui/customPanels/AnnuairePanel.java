package gui.customPanels;

import domaine.Entry;
import factory.Annuaire;
import gui.panels.CenterPanel;
import gui.panels.FullCustomPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends FullCustomPanel {

    protected Annuaire annuaireController;

    public AnnuairePanel( String firstLabel, String secondLabel) {
        super(firstLabel, secondLabel);
        this.getUpPanel().setTextFieldValues(testEntries(), ".");
    }

    public AnnuairePanel(Annuaire annuaireController){
        super( "Nom", "Prénom");
        this.annuaireController = annuaireController;
    }

    public List<Entry> testEntries(){
        Entry e1 = new Entry("Bond", "James");
        Entry e2 = new Entry("Hollande", "François");
        List<Entry> entries = new LinkedList<>();
        entries.add(e1);
        entries.add(e2);
        return entries;
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
        return "Annuaire";
    }

}
