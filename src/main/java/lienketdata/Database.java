package lienketdata;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Database {
	public static void main(String[] args) {
		java.sql.Connection conn;
		try {
			String dbURL= "jdbc:sqlerver://localhost;databaseName=DANGNHAP;user=sa;password=12345";
			conn = DriverManager.getConnection(dbURL);
			if(conn != null) {
				JOptionPane.showConfirmDialog(null, " kết nối thành công ");
			}
		} catch (SQLException ex) {
			JOptionPane.showConfirmDialog(null,""+ ex);
		}
	}
}
 