package lienketdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private Connection conn;
    private Statement stm;

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=QLHH;user=sa;password=12345;encrypt=true;trustServerCertificate=true";

    public ConnectionDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Successful!");
            stm = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Fail!");
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public static void main(String[] args) {
        new ConnectionDB();
    }
}
