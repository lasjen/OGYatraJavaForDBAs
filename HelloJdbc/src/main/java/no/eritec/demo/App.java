package no.eritec.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
   public final static String DB_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
   public final static String DB_USERNAME = "appdata";
   public final static String DB_PASSWORD = "app";

   public static void main(String[] args) throws SQLException{

      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      PreparedStatement ps = conn.prepareStatement("select user from dual");
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
         System.out.println("Result: " + rs.getString(1));
      }

      rs.close(); ps.close(); conn.close();
      System.out.println("Hello World!");
   }
}
