package gui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public abstract class FullCustomPanel extends JPanel {
    protected UpPanel upPanel;
    protected CenterPanel centerPanel;
    protected DownPanel downPanel;

    public FullCustomPanel() {
        // initialize the panels
        initPanels();
        // layout
        this.setLayout(new BorderLayout());
        // add behaviour to the buttons
        addBehaviours();
        addPanelsToMainPanel();
    }

    public void addBehaviours() {
        downPanel.getAjouter().addActionListener(ajouterActionListener());
    }

    public void initPanels() {
        upPanel = new UpPanel(this.borderName());
        centerPanel = new CenterPanel(firstLabel(), secondLabel());
        downPanel = new DownPanel();
    }

    public void addPanelsToMainPanel() {
        this.add("North", upPanel);
        this.add("Center", centerPanel);
        this.add("South", downPanel);
    }

    public abstract String borderName();

    public abstract String firstLabel();

    public abstract String secondLabel();

    public abstract ActionListener ajouterActionListener();

    public UpPanel getUpPanel() {
        return upPanel;
    }

    public DownPanel getDownPanel() {
        return downPanel;
    }

}
