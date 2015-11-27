package gui.customPanels;

import gui.panels.CenterPanel;
import gui.panels.FullCustomPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class EntreesPanel extends FullCustomPanel {
    public EntreesPanel(String borderName, String firstLabel, String secondLabel) {
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
        return actionListener;
    }

}
