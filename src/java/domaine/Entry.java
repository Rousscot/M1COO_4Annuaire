package java.domaine;

/**
 * Created by rousseau & ferlicot on 20/11/15.
 *
 * This class represents an entry of a directory.
 */
public class Entry {
    protected String last_name;
    protected String first_name;

    public Entry(String last_name, String prenom) {
        this.last_name = last_name;
        this.first_name = prenom;
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
}
