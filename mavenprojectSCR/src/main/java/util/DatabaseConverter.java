package web.util;
import java.sql.*;

public class DatabaseConverter {
	public static void main(String args[]) {
		System.out.println("start conversion");
		
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("com.mysql.jdbc.Driverdriver");
            // connection = DriverManager.getConnection(
            //"jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false",
            //"license", "AVNS_mOUXndVvrMMxFzVCCPH");
      
            String url ="jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
            
            //
            
        //   String url ="jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?user=license&password=AVNS_mOUXndVvrMMxFzVCCPH";
           
           
           connection = DriverManager.getConnection(url,"license","AVNS_mOUXndVvrMMxFzVCCPH");
             
           System.out.println("connected");
           
           //jdbc:hsqldb:file:/Users/andrewhinton/Documents/GitHub/wizardfrontendToday//db/license;ifexists=true
 
            connection.close();
            
            
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            System.out.println("com.mysql.jdbc.Driverdriver");
            Connection hsqldbConnection = DriverManager.getConnection("jdbc:hsqldb:file:/Users/andrewhinton/Documents/GitHub/wizardfrontendToday//db/license;ifexists=true", "SA", "");
            hsqldbConnection.close();
            
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
		
	}

}
