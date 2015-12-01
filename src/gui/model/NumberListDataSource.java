package gui.model;

import domaine.Entry;
import domaine.Number;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Created by rousseaua on 30/11/15.
 */
public class NumberListDataSource extends DefaultListModel<Number> {
    protected Entry entry;

    public NumberListDataSource(Entry entry) {
        this.entry = entry;
    }

    @Override
    public int getSize() {
        return entry.numberOfNumbers();
    }

    @Override
    public Number getElementAt(int index) {
        return entry.getNumberAt(index);
    }
}
