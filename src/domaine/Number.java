package domaine;

/**
 * Created by rousseau & ferlicot on 20/11/15.
 *
 * This class represents a number of an entry.
 */
public class Number {
    protected int id_number;
    protected String code;
    protected String value;

    public Number(String code, String value) {
        this.code = code;
        this.value = value;
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
