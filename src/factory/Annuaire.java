package factory;

import domaine.Entry;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 */
public class Annuaire {

    protected List<Entry> entries;

    public Annuaire(){
        this.entries = new LinkedList();
    }

    public List<Entry> entries() {
        return entries;
    }

    public void entries(List<Entry> entries) {
        this.entries = entries;
    }
}
