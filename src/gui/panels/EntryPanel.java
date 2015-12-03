package gui.panels;

import domaine.Entry;
import domaine.Number;
import gui.MainFrame;
import gui.model.NumberListDataSource;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class EntryPanel extends ApplicationPanel implements ActionListener {

    protected static final String BORDERNAME = "Entrees";
    protected Entry entryController;
    protected NumberForm numberForm;
    protected EntryButtonsBar buttonsBar;
    protected JList<Number> jList;
    protected JScrollPane jScrollPane;
    protected Border border;
    protected MainFrame owner;

    public EntryPanel(Entry entryController, MainFrame owner) {
        this.entryController = entryController;
        this.owner = owner;
        initComponents();
        addPanelsToMainPanel();
    }

    public void initJList() {
        jList = new JList<>();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(new NumberListDataSource(entryController));
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
        this.add("Center", numberForm);
        this.add("South", buttonsBar);
    }

    public void initComponents() {
        initJList();
        initScrollPane(EntryPanel.BORDERNAME);
        numberForm = new NumberForm();
        buttonsBar = new EntryButtonsBar();
        buttonsBar.addListenerToAllButtons(this);
    }

    public void entreeController(Entry entry) {
        entryController = entry;
        jList.setModel(new NumberListDataSource(entry));
    }

    public void refresh() {
        //I don't know why but the repaint or revalidate doesn't work :(
        jList.setModel(new NumberListDataSource(entryController));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {
            addNumberToSelectedEntry();
        } else if (e.getActionCommand().equals("delete")) {
            removeNumber();
        } else if (e.getActionCommand().equals("clean")) {
            cleanFields();
        } else {
            JOptionPane.showMessageDialog(this, "This should not happen! If this happen it's because I am a naughty boy that didn't finished :(");
        }
    }

    public void removeNumber(){
        Number number = jList.getSelectedValue();
        if (number == null) {
            JOptionPane.showMessageDialog(this, "Pas de numero selectionné.");
        } else {
                owner.deleteNumberFor(entryController, number);
                refresh();
        }
    }

    public void cleanFields(){
        numberForm.cleanFields();
    }

    public void addNumberToSelectedEntry() {
        owner.createNumberForSelectedEntryWith(code(), value());
        refresh();
    }

    public String code() {
        return numberForm.code();
    }

    public String value() {
        return numberForm.value();
    }

}
