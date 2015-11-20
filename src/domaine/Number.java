package domaine;

/**
 * Created by rousseau & ferlicot on 20/11/15.
 * <p>
 * This class represents a number of an entry.
 */
public class Number {
    protected Long id;
    protected String code;
    protected String value;

    public Number(Long id, String code, String value) {
        this.id = id;
        this.code = code;
        this.value = value;
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
}
