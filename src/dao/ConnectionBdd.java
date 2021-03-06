package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * I am the class that manage the connection to the database.
 * I am a Singleton to avoid multi-connections.
 * I am use by the DAO.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class ConnectionBdd {

    //protected String url = "jdbc:postgresql://postgresql1.alwaysdata.com:5432/cestpasfaux_annuaire";

    //protected String user = "cestpasfaux";

    protected String url = "jdbc:postgresql://webtp.fil.univ-lille1.fr:5432/ferlicotdelbe";

    protected String user = "ferlicotdelbe";


    protected String passwd;

    protected static Connection connection;

    /**
     * I am the constructor. I also check that the connection works.
     */
    private ConnectionBdd() {
        try {
            //I just try to instantiate the driver to check that the driver is here.
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");
            System.out.println("Password");
            //this.passwd = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            this.passwd = "genji1&2";
            connection = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection O.K.");
        } catch (ClassNotFoundException e) {
            System.out.println("There is a problem with the instantiation of the driver. Check that the driver is on your classpath.");
            System.exit(10);
        } catch (SQLException e) {
            System.out.println("There is a problem with the url/login/password of the database :(");
            System.exit(15);
        }
    }

    /**
     * I am the only way to get an instance of ConnectionBdd.
     *
     * @return The unique instance of a ConnectionBdd.
     */
    public static Connection current() {
        if (connection == null) {
            new ConnectionBdd();
        }
        return connection;
    }
}
