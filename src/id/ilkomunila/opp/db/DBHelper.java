package id.ilkomunila.opp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "accholder";
    private static final String SQCONN = "jdbc:sqlite:D:\\KULIAH\\KMMI\\PROJECT\\SQLiteDB\\AccHolder.sqlite"; //Choose DB Path

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(SQCONN);
//            System.out.println("Library ada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
