package domaine;

import domaine.exceptions.DuplicateNumberException;
import domaine.exceptions.NumberNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rousseau & ferlicot on 20/11/15.
 *
 * This class represents an entry of a directory.
 */
public class Entry {

    protected Long id;

    protected String last_name;

    protected String first_name;

    protected Set<Number> numbers;

    public Entry(String last_name, String first_name) {
        this(Long.valueOf(0), last_name, first_name);
    }

    public Entry(Long id, String last_name, String first_name) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.numbers = new HashSet();
    }

    public Entry addNumber(Number number) throws DuplicateNumberException {
        if(this.numbers.contains(number)){
            throw new DuplicateNumberException(number);
        }
        this.numbers.add(number);
        return this;
    }

    public Entry deleteNumber(Number number) throws NumberNotFoundException {
        if(this.numbers.contains(number)){
            throw new NumberNotFoundException(number);
        }
        this.numbers.remove(number);
        return this;
    }

    // GETTERS SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id_entry) {
        this.id = id_entry;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setNumbers(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public Set<Number> getNumbers() {
        return numbers;
    }
}
