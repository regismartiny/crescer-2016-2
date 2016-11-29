package br.com.cwi.crescer.aula2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String HOST = "192.168.2.109";
    private static final int PORT = 1521;
    private static final String SID = "xe";
    private static final String URL = "jdbc:oracle:thin:@"+HOST+":"+PORT+":"+SID;
    private static final String USER = "crescer";
    private static final String PASS = "crescer";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
   
