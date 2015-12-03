package factory;

import dao.exception.delete.EntryDeleteException;
import dao.exception.delete.NumberDeleteException;
import dao.exception.insert.EntryInsertException;
import dao.exception.insert.NumberInsertException;
import dao.implement.EntryDAO;
import domaine.Entry;
import domaine.Number;
import domaine.exceptions.DuplicateEntryException;
import domaine.exceptions.DuplicateNumberException;
import domaine.exceptions.EntryNotFoundException;
import domaine.exceptions.NumberNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 */
public class Annuaire {

    protected List<Entry> entries;

    public Annuaire() {
        this.entries = new ArrayList<>();
    }

    public Annuaire createEntry(String firstName, String lastName) throws EntryInsertException, DuplicateEntryException {
        this.addEntry((new EntryDAO()).create(new Entry(firstName, lastName)));
        return this;
    }

    public Annuaire addEntry(Entry entry) throws DuplicateEntryException {
        if (this.entries.contains(entry)) {
            throw new DuplicateEntryException(entry);
        }
        this.entries.add(entry);
        return this;
    }

    public Annuaire createNumberFor(Entry entry, String code, String value) throws NumberInsertException, DuplicateNumberException, EntryNotFoundException {
        if (this.entries.contains(entry)) {
            entry.createNumber(entry, code, value);
            return this;
        }
        throw new EntryNotFoundException(entry);
    }

    public Annuaire deleteNumberOf(Entry entry, Number number) throws EntryNotFoundException, NumberNotFoundException, NumberDeleteException {
        if (this.entries.contains(entry)) {
            entry.deleteNumber(number);
            return this;
        }
        throw new EntryNotFoundException(entry);
    }

    public Annuaire deleteEntry(Entry entry) throws EntryNotFoundException, EntryDeleteException {
        if (this.entries.contains(entry)) {
            this.entries.remove(entry);
            (new EntryDAO()).delete(entry);
            return this;
        }
        throw new EntryNotFoundException(entry);
    }

    // GETTER SETTER

    public List<Entry> entries() {
        return entries;
    }

    public void entries(List<Entry> entries) {
        this.entries = entries;
    }

    public int numberOfEntries() {
        return entries.size();
    }

    public Entry getEntryAt(int index) {
        return entries.get(index);
    }
}
