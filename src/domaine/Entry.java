package domaine;

import dao.exception.insert.NumberInsertException;
import dao.implement.NumberDAO;
import domaine.exceptions.DuplicateNumberException;
import domaine.exceptions.NumberNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * I am an Entry of the Annuaire.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Entry {

    //ATTRIBUTES

    /**
     * Id inside the database.
     */
    protected Long id;

    /**
     * Last name of the contact.
     */
    protected String lastName;

    /**
     * First name of the contact.
     */
    protected String firstName;

    /**
     * Numbers of the contact.
     */
    protected List<Number> numbers;

    //CONSTRUCTORS

    public Entry(String lastName, String firstName) {
        this(0L, lastName, firstName);
    }

    public Entry(Long id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.numbers = new ArrayList<>();
    }

    // GETTERS SETTERS AND COMMON METHODS

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

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.lastName.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry entry = (Entry) o;

        return this.lastName.equals(entry.lastName) && this.firstName.equals(entry.firstName) && this.numbers.equals(entry.numbers);

    }

    @Override
    public int hashCode() {
        int result = this.lastName.hashCode();
        result = 31 * result + this.firstName.hashCode();
        return result;
    }

    // Actions

    /**
     * I am a method that udd a Number to my list of numbers.
     *
     * @param number The number I need to add.
     * @return Myself to allow cascade if needed.
     * @throws DuplicateNumberException In case I already have this number.
     */
    public Entry addNumber(Number number) throws DuplicateNumberException {
        if(this.numbers.contains(number)){
            throw new DuplicateNumberException(number);
        }
        this.numbers.add(number);
        return this;
    }

    /**
     * I am a method that delete a number of my numbers.
     *
     * @param number the number I need to delete.
     * @return myself to allow cascade if needed.
     * @throws NumberNotFoundException If the number is not in the numbers.
     */
    public Entry deleteNumber(Number number) throws NumberNotFoundException {
        if(this.numbers.contains(number)){
            throw new NumberNotFoundException(number);
        }
        this.numbers.remove(number);
        return this;
    }

    /**
     * I am a method that create a new number and add it to my numbers.
     *
     * @param code the code of the number.
     * @param value the value on the number.
     * @return myself to allow cascade if needed.
     * @throws NumberInsertException raised if there is a problem with the insertion of the number in the database.
     * @throws DuplicateNumberException raised if the number already exist.
     */
    public Entry createNumber(String code, String value) throws NumberInsertException, DuplicateNumberException {
        this.addNumber((new NumberDAO()).create(new Number(code, value)));
        return this;
    }

    public int numberOfNumbers() {
        return numbers.size();
    }

    public Number getNumberAt(int index) {
        return numbers.get(index);
    }
}
