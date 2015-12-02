package domaine;

/**
 * Created by JeCisC on 02/12/2015.
 */
public class NullEntry extends Entry {
    public NullEntry(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public int numberOfNumbers() {
        return 0;
    }

}
