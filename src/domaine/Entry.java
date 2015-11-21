package domaine;

import dao.exception.insert.NumberInsertException;
import dao.implement.NumberDAO;
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

    protected String lastName;

    protected String firstName;

    protected Set<Number> numbers;

    public Entry(String lastName, String firstName) {
        this(Long.valueOf(0), lastName, firstName);
    }

    public Entry(Long id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return "Entry{id=" + this.id +", lastName='" + this.lastName + ", firstName='" + this.firstName + ", numbers=" + this.numbers + '}';
    }

    public Entry createNumber(String code, String value) throws NumberInsertException, DuplicateNumberException {
        this.addNumber((new NumberDAO()).create(new Number(code, value)));
        return this;
    }

    // GETTERS SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id_entry) {
        this.id = id_entry;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNumbers(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public Set<Number> getNumbers() {
        return numbers;
    }

}
