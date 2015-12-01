package gui.model;

import domaine.Entry;
import factory.Annuaire;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Created by rousseaua on 30/11/15.
 */
public class EntryListDataSource extends DefaultListModel<Entry> {
    protected Annuaire annuaire;

    public EntryListDataSource(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    @Override
    public int getSize() {
        return annuaire.numberOfEntries();
    }

    @Override
    public Entry getElementAt(int index) {
        return annuaire.getEntryAt(index);
    }
}
