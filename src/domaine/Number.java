package domaine;

/**
 * Created by rousseau & ferlicot on 20/11/15.
 * <p>
 * This class represents a entry of an entry.
 */
public class Number {

    protected Long id;

    protected String code;

    protected String value;

    protected Entry entry;

    public Number(String code, String value, Entry entry) {
        this(Long.valueOf(0), code, value,entry);
    }

    public Number(Long id, String code, String value, Entry entry) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.entry = entry;
    }

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

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public long getEntryId() {
        return this.entry.getId();
    }
}
