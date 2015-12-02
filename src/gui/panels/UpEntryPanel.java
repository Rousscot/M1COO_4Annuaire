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
 * Created by ferlicot & rousseau at Las Vegas
 */
public class UpEntryPanel extends JPanel {
    protected JList<Entry> jList;
    protected JScrollPane jScrollPane;
    protected Border border;

    public UpEntryPanel(String borderName, Annuaire annuaire) {
        initJList(annuaire);
        initScrollPane(borderName);
        this.add(jScrollPane);
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

    public void addListener(MainFrame frame) {
        jList.addListSelectionListener(frame);
    }

    public Entry getEntryAt(int index) {
        return jList.getModel().getElementAt(index);
    }
}
