package org;
import java.sql.*;

public class DatabaseConverter {
	public static void main(String args[]) {
		System.out.println("start conversion");
		
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("com.mysql.cj.jdbc.Driver");
            // connection = DriverManager.getConnection(
            //"jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false",
            //"license", "AVNS_mOUXndVvrMMxFzVCCPH");
      
            String url ="jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
            
            //
            
        //   String url ="jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?user=license&password=AVNS_mOUXndVvrMMxFzVCCPH";
           /*   VARCHAR(250) not null,
 
 

   datetime DEFAULT NULL,
   datetime NOT NULL,
  timestamp DEFAULT NULL,
  datetime NOT NULL,
   varchar(250) NOT NULL,
   tinyint DEFAULT NULL,
   varchar(45) NOT NULL,
varchar(250) NOT NULL,
  city varchar(250) NOT NULL,
   varchar(250) NOT NULL,
   varchar(250) NOT NULL,
   varchar(250) DEFAULT NULL,
   varchar(50) NOT NULL,
            */
           
           connection = DriverManager.getConnection(url,"license","AVNS_mOUXndVvrMMxFzVCCPH");

           Class.forName("org.hsqldb.jdbc.JDBCDriver" );
           System.out.println("com.mysql.jdbc.Driverdriver");
           String hsqldbURL = "jdbc:hsqldb:file:/Users/andrewhinton/Documents/GitHub/wizardfrontendToday//db/license;ifexists=true";
           Connection hsqldbConnection = DriverManager.getConnection(hsqldbURL,"SA","");
         
           
           StringBuilder contactbuilder = new StringBuilder();
           contactbuilder.append("INSERT INTO contact ("
           		+ "contact_id"
           		+ ", name, "
           		+ "uuid, "
           		+ "license, "
           		+ "general_information"
           		+ ", phone, "
           		+ "address, "
           		+ "streetaddress, "
           		+ "city, "
           		+ "state, "
           		+ "zipcode,"
           		+ " emailaddress, "
           		+ "password,"
           		+ " client_type"
           		+ ", usage_date, "
           		+ "created_date, "
           		+ "start_date,"
           		+ " end_date,"
           		+ " active) ");
           contactbuilder.append(" VALUES ");
           contactbuilder.append("("
           		+ "?, "
           		+ "?,"
           		+ " ?, "
           		+ "?, "
           		+ "? ,"
           		+ " ?,"
           		+ " ?,"
           		+ " ?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, "
           		+ "?, ?)");
           
           
           
           System.out.println("connected");
           String QUERY = "SELECT * from contact";
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(QUERY);
           
           while(rs.next()){
               //Display values
               int id =  rs.getInt("contact_id");
               String name =  rs.getString("name");
               String uuid =  rs.getString("uuid");
               String license =  rs.getString("license");
               String generalinformation =  rs.getString("general_information");
               String phone =  rs.getString("phone");
               String address =  rs.getString("address");
               String streetaddress  =  rs.getString("streetaddress");
               String city =  rs.getString("city");
               
               String state =  rs.getString("state");
               String zipcode =  rs.getString("zipcode");
               String emailaddress  =  rs.getString("emailaddress");
               String password =  rs.getString("password");
               String client_type =  rs.getString("client_type");
               
               Time usage_date =  rs.getTime("usage_date");
               Time created_date =  rs.getTime("created_date");
               Time  start_date =  rs.getTime("start_date");
               Time  end_date =  rs.getTime("end_date");
               Boolean  active =  rs.getBoolean("active");
               
               //
              
               
               
               PreparedStatement preparedStatement = hsqldbConnection.prepareStatement(contactbuilder.toString());
               preparedStatement.setInt(1, id);
               preparedStatement.setString(2, name);
               preparedStatement.setString(3, uuid);
               preparedStatement.setString(4, license);
               preparedStatement.setString(5, generalinformation);
               preparedStatement.setString(6, address);
               preparedStatement.setString(7, phone);
               preparedStatement.setString(8, streetaddress);
               preparedStatement.setString(9, city);
               preparedStatement.setString(10, state);
               
               preparedStatement.setString(11, zipcode);
               preparedStatement.setString(12, emailaddress);
               preparedStatement.setString(13, password);
               preparedStatement.setString(14, client_type);
               
               
               preparedStatement.setTime(15, usage_date);
               preparedStatement.setTime(16,  created_date);
               preparedStatement.setTime(17, start_date);
               preparedStatement.setTime(18, end_date);
               preparedStatement.setBoolean(19, active);
               
               preparedStatement.executeUpdate();
               System.out.println("usage_date " + usage_date);
              
            }
           
           //jdbc:hsqldb:file:/Users/andrewhinton/Documents/GitHub/wizardfrontendToday//db/license;ifexists=true
 
            connection.close();
            
            
            hsqldbConnection.close();
            
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
		
	}

}
