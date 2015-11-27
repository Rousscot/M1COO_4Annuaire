package gui.customPanels;

import gui.panels.CenterPanel;
import gui.panels.FullCustomPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends FullCustomPanel{
    public AnnuairePanel(String borderName, String firstLabel, String secondLabel) {
        super(borderName, firstLabel, secondLabel);
    }

    @Override
    public ActionListener ajouterActionListener(CenterPanel centerPanel) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(centerPanel.getFirstLabelToString() + " " + centerPanel.getSecondLabelToString());
            }
        };
        return  actionListener;
    }

    @Override
    public ActionListener supprimerActionListener(CenterPanel centerPanel) {
        return null;
    }

    @Override
    public ActionListener nettoyerActionListener(CenterPanel centerPanel) {
        return null;
    }
}
