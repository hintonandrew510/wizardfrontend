//package web.data;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Tester {
      public static void main(String [] args) throws Exception {
          Class.forName("com.mysql.cj.jdbc.Driver");
          System.out.println("Driver loaded");
        // Class.forName( "com.mysql.jdbc.Driver" ); // do this in init
        // // edit the jdbc url 
    String url = "jdbc:mysql://db4free.net:3306/license123";
                                                        //characterEncoding=latin1&autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC
    //dbc:mysql://mysql:3306//sampledb?user=userUVH&password=1Rue1H2sYLxalBKP
        String username= "license123";
        String password = "batman123";
        Connection con = DriverManager.getConnection(
            url, username, password);
        System.out.println(
            "Connection Established successfully");

      // Connection conn = DriverManager.getConnection(url);
        //"
        // Statement st = conn.createStatement();
        // ResultSet rs = st.executeQuery( "select * from table" );

        
    }

}
