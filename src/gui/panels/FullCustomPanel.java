package gui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public abstract class FullCustomPanel extends JPanel{
    protected UpPanel upPanel;
    protected CenterPanel centerPanel;
    protected DownPanel downPanel;

    public FullCustomPanel(String borderName, String firstLabel, String secondLabel){
        // initialize the panels
        upPanel = new UpPanel(borderName);
        centerPanel = new CenterPanel(firstLabel, secondLabel);
        downPanel = new DownPanel();
        // layout
        this.setLayout(new BorderLayout());
        // add behaviour to the buttons
        downPanel.getAjouter().addActionListener(ajouterActionListener(centerPanel));
        // add the panels
        // add the panels
        this.add("North", upPanel);
        this.add("Center",centerPanel);
        this.add("South", downPanel);
    }

    public UpPanel getUpPanel() {
        return upPanel;
    }

    public DownPanel getDownPanel() {
        return downPanel;
    }

    public abstract ActionListener ajouterActionListener(CenterPanel centerPanel);

}
