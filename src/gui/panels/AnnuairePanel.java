package gui.panels;

import domaine.Entry;
import factory.Annuaire;
import gui.MainFrame;
import gui.model.EntryListDataSource;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends JPanel {

    protected static final String BORDERNAME = "Annuaire";
    protected static final String FIRSTLABEL = "Nom";
    protected static final String SECONDLABEL = "Prenom";
    protected Annuaire annuaireController;
    protected JPanel centerPanel;
    protected JPanel downPanel;
    protected JList<Entry> jList;
    protected JScrollPane jScrollPane;
    protected Border border;

    public AnnuairePanel(Annuaire annuaireController) {
        this.annuaireController = annuaireController;
        initComponents();
        addPanelsToMainPanel();
    }

    public void initJList(Annuaire annuaire) {
        jList = new JList<>();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(new EntryListDataSource(annuaire));
    }

    public void initScrollPane(String borderName) {
        border = new TitledBorder(borderName);
        jScrollPane = new JScrollPane(jList);
        jScrollPane.setBorder(border);
        jScrollPane.setPreferredSize(new Dimension(250, 250));
    }

    private void addPanelsToMainPanel() {
        this.setLayout(new BorderLayout());
        this.add("North", jScrollPane);
        this.add("Center", centerPanel);
        this.add("South", downPanel);
    }

    private void initComponents() {
        initJList(annuaireController);
        initScrollPane(AnnuairePanel.BORDERNAME);
        centerPanel = new CenterPanel(AnnuairePanel.FIRSTLABEL, AnnuairePanel.SECONDLABEL);
        downPanel = new DownPanel();
    }

    public void addListener(MainFrame frame) {
        jList.addListSelectionListener(frame);
    }

    public Entry getEntryAt(int index) {
        return jList.getModel().getElementAt(index);
    }

}
