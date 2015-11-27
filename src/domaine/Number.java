package domaine;

/**
 * I am a Number that is store in an Entry.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Number {

    //ATTRIBUTES

    /**
     * The id in the database.
     */
    protected Long id;

    /**
     * Define for what is the number.
     */
    protected String code;

    /**
     * The value of the number.
     */
    protected String value;

    /**
     * the Entry of the number.
     */
    protected Entry entry;

    //CONSTRUCTORS

    public Number(String code, String value) {
        this(0L, code, value, null);
    }

    public Number(String code, String value, Entry entry) {
        this(0L, code, value,entry);
    }

    public Number(Long id, String code, String value, Entry entry) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.entry = entry;
    }

    //GETTERS/SETTERS/COMMON METHODS

    public Long getId() {
        return id;
    }

    public void setId(Long id_number) {
        this.id = id_number;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public Entry getEntry() {
        return entry;
    }

    public long getEntryId() {
        return this.entry.getId();
    }

    @Override
    public String toString() {
        return "Number{id=" + this.id + ", code='" + this.code + ", value='" + this.value + ", entry=" + this.entry.getId() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;

        Number number = (Number) o;

        if (!this.code.equals(number.code)) return false;
        if (!this.value.equals(number.value)) return false;
        return !(this.entry != null ? !this.entry.equals(number.entry) : number.entry != null);
    }

    @Override
    public int hashCode() {
        int result = this.code.hashCode();
        result = 31 * result + this.value.hashCode();
        result = 31 * result + (this.entry != null ? this.entry.hashCode() : 0);
        return result;
    }
}
