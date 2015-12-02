package gui.panels;

import domaine.Entry;
import domaine.Number;
import gui.model.NumberListDataSource;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by ferlicot & rousseau at Las Vegas
 */
public class UpNumberPanel extends JPanel {
    protected JList<Number> jList;
    protected JScrollPane jScrollPane;
    protected Border border;

    public UpNumberPanel(String borderName, Entry entry) {
        initJList(entry);
        initScrollPane(borderName);
        this.add(jScrollPane);
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

    public void entryController(Entry entry) {
        jList.setModel(new NumberListDataSource(entry));
    }
}
