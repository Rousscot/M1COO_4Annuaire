package gui.customPanels;

import domaine.Entry;
import gui.panels.CenterPanel;
import gui.panels.DownPanel;
import gui.panels.UpNumberPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aurelien on 22/11/2015.
 */
public class EntreesPanel extends JPanel {

    protected Entry entryController;
    protected JPanel upPanel;
    protected JPanel centerPanel;
    protected JPanel downPanel;

    public EntreesPanel(Entry entryController){
        this.entryController = entryController;
        initPanels();
        addPanelsToMainPanel();
    }

    private void initPanels() {
        upPanel = new UpNumberPanel(borderName(), entryController);
        centerPanel = new CenterPanel(firstLabel(), secondLabel());
        downPanel = new DownPanel();
    }


    private void addPanelsToMainPanel() {
        this.setLayout(new BorderLayout());
        this.add("North", upPanel);
        this.add("Center", centerPanel);
        this.add("South", downPanel);
    }



    public String borderName(){
        return "Entrees";
    }


    public String firstLabel() {
        return "Code";
    }


    public String secondLabel() {
        return "Value";
    }

}
