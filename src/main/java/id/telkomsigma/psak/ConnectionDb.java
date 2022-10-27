package id.telkomsigma.psak;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
    public static Connection getPsakConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.192.78.18:1551:psak", "neopsakng",
                    "neo123");
            return conn;
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getPsakConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.192.78.18:1551:psak", "neopsakng",
                    "neo123");
            return conn;
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        return null;
    }
}
