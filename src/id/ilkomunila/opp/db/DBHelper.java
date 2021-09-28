package id.ilkomunila.opp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "accholder";
//    private static final String SQCONN = "jdbc:sqlite:D:\\KULIAH\\KMMI\\PROJECT\\SQLiteDB\\AccHolder.sqlite"; //Choose DB Path
    private static final String SQCONN = "jdbc:sqlite:AccHolder.sqlite"; //Choose DB Path

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(SQCONN);
            createTable(conn);
//            System.out.println("Library ada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void createTable(Connection conn) throws SQLException{
        String sqlCreate = "";
        sqlCreate = "CREATE TABLE IF NOT EXISTS  account_holder (" +
                "    holder_id INT (10)      PRIMARY KEY," +
                "    name      VARCHAR (100)," +
                "    address   VARCHAR (100) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS account (" +
                "    acc_number INT (10)    PRIMARY KEY," +
                "    balance    DOUBLE (16)," +
                "    holder_id  INT (10)    REFERENCES account_holder (holder_id) ON DELETE RESTRICT" +
                "                                                                 ON UPDATE CASCADE" +
                ");" +
                "CREATE TABLE IF NOT EXISTS corporate_holder (" +
                "    holder_id INT (10)      PRIMARY KEY" +
                "                            REFERENCES account_holder (holder_id) ON DELETE RESTRICT" +
                "                                                                  ON UPDATE CASCADE," +
                "    contact   VARCHAR (100) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS  individual_holder (" +
                "    holder_id INT (10)     PRIMARY KEY" +
                "                           REFERENCES account_holder (holder_id) ON DELETE RESTRICT" +
                "                                                                 ON UPDATE CASCADE," +
                "    gender    VARCHAR (10)," +
                "    birthdate DATE" +
                ");";
        String sqls[] = sqlCreate.split(";");
        for (String sql : sqls) {
            PreparedStatement stmtHolder = conn.prepareStatement(sql);
            stmtHolder.execute();
        }
    }
}
