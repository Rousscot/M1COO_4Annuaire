package gui.panels;

import domaine.Entry;
import domaine.Number;
import gui.model.NumberListDataSource;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by aurelien on 22/11/2015.
 */
public class EntreesPanel extends JPanel {

    protected static final String BORDERNAME = "Entrees";
    protected static final String FIRSTLABEL = "Code";
    protected static final String SECONDLABEL = "Numero";
    protected JPanel centerPanel;
    protected JPanel downPanel;
    protected JList<Number> jList;
    protected JScrollPane jScrollPane;
    protected Border border;


    public EntreesPanel(Entry entryController) {
        initPanels(entryController);
        addPanelsToMainPanel();
    }

    public void initJList(Entry entry) {
        jList = new JList<>();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(new NumberListDataSource(entry));
    }

    public void initScrollPane(String borderName) {
        border = new TitledBorder(borderName);
        jScrollPane = new JScrollPane(jList);
        jScrollPane.setBorder(border);
        jScrollPane.setPreferredSize(new Dimension(250, 250));
    }

    private void initPanels(Entry entryController) {
        initJList(entryController);
        initScrollPane(EntreesPanel.BORDERNAME);
        centerPanel = new CenterPanel(EntreesPanel.FIRSTLABEL, EntreesPanel.SECONDLABEL);
        downPanel = new DownPanel();
    }

    private void addPanelsToMainPanel() {
        this.setLayout(new BorderLayout());
        this.add("North", jScrollPane);
        this.add("Center", centerPanel);
        this.add("South", downPanel);
    }

    public void entreeController(Entry entry) {
        jList.setModel(new NumberListDataSource(entry));
    }

    public void refresh() {
        //TODO
    }
}
