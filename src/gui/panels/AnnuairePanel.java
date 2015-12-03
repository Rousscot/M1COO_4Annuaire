package gui.panels;

import dao.exception.delete.EntryDeleteException;
import dao.exception.insert.EntryInsertException;
import domaine.Entry;
import domaine.NullEntry;
import domaine.exceptions.DuplicateEntryException;
import domaine.exceptions.EntryNotFoundException;
import factory.Annuaire;
import gui.MainFrame;
import gui.model.EntryListDataSource;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aurelien on 22/11/2015.
 */
public class AnnuairePanel extends ApplicationPanel implements ActionListener {

    protected static final String BORDERNAME = "Annuaire";
    protected Annuaire annuaireController;
    protected EntryForm entryForm;
    protected AnnuaireButtonsBar buttonsBar;
    protected JList<Entry> jList;
    protected JScrollPane jScrollPane;
    protected Border border;
    protected MainFrame owner;

    public AnnuairePanel(Annuaire annuaireController, MainFrame owner) {
        this.owner = owner;
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

    public void addPanelsToMainPanel() {
        this.setLayout(new BorderLayout());
        this.add("North", jScrollPane);
        this.add("Center", entryForm);
        this.add("South", buttonsBar);
    }

    public void initComponents() {
        initJList(annuaireController);
        initScrollPane(AnnuairePanel.BORDERNAME);
        entryForm = new EntryForm();
        buttonsBar = new AnnuaireButtonsBar();
        buttonsBar.addListenerToAllButtons(this);
    }

    public void addListener(MainFrame frame) {
        jList.addListSelectionListener(frame);
    }

    public Entry getEntrySelected() {
        return jList.getSelectedValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO : This need improvement but I don't have the time now.
        // This would be so easy if we had method level reflexivity…
        if (e.getActionCommand().equals("add")) {
            addEntry();
        } else if (e.getActionCommand().equals("delete")) {
            removeSelectedEntry();
        } else if (e.getActionCommand().equals("clean")) {
            cleanFields();
        } else {
            JOptionPane.showMessageDialog(this, "This should not happen! If this happen it's because I am a naughty boy that didn't finished :(");
        }
    }

    public void cleanFields() {
        entryForm.cleanFields();
    }

    public void removeSelectedEntry() {
        Entry entry = jList.getSelectedValue();
        if (entry == null) {
            JOptionPane.showMessageDialog(this, "Pas de contact selectionné.");
        } else {
            try {
                annuaireController.deleteEntry(entry);
                refresh();
                owner.refreshNumbersWith(new NullEntry(null, null));
            } catch (EntryNotFoundException | EntryDeleteException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
            }
        }
    }

    public void addEntry() {
        try {
            annuaireController.createEntry(firstName(), lastName());
            refresh();
        } catch (EntryInsertException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
        } catch (DuplicateEntryException e) {
            JOptionPane.showMessageDialog(this, "Ce contact existe déjà.");
        }
    }

    public String lastName() {
        return entryForm.firstName();
    }

    public String firstName() {
        return entryForm.lastName();
    }

    public void refresh() {
        //I don't know why but the repaint or revalidate doesn't work :(
        jList.setModel(new EntryListDataSource(annuaireController));
    }
}
