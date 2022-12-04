package csv1;
import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class csv1 {
    public static void addDetails(String file) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root",
            "Bjr@2003");
        Statement stmt = con.createStatement();
        String query = "create table if not exists Country (COUNTRIES varchar(30),Gold int DEFAULT NULL,Silver int DEFAULT NULL, Bronze int DEFAULT NULL,  Total_Medals int DEFAULT NULL,primary key(COUNTRIES))";
        stmt.executeUpdate(query);
        Scanner sc = new Scanner(new File("C:\\Users\\joshi\\OneDrive\\Documents\\" + file));
        query = "insert into Country values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        while (sc.hasNextLine()) {
          String[] str = sc.nextLine().split(",");
          ps.setString(1, str[0]);
          ps.setInt(2, Integer.parseInt(str[1]));
          ps.setInt(3, Integer.parseInt(str[2]));
          ps.setInt(4, Integer.parseInt(str[3]));
          ps.setInt(5, Integer.parseInt(str[4]));
          ps.executeUpdate();
        }
      }
    
      public static void updateTable(String file) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root",
            "Bjr@2003");
        Statement stmt = con.createStatement();
        String query = "update Country set Gold=?,Silver=?,Bronze=?,Total_medals=? where COUNTRIES=?";
        PreparedStatement ps = con.prepareStatement(query);
        Scanner sc = new Scanner(new File("C:\\Users\\joshi\\OneDrive\\Documents\\" + file));
        while (sc.hasNextLine()) {
          String[] str = sc.nextLine().split(",");
          ps.setInt(1, Integer.parseInt(str[1]));
          ps.setInt(2, Integer.parseInt(str[2]));
          ps.setInt(3, Integer.parseInt(str[3]));
          ps.setInt(4, Integer.parseInt(str[4]));
          ps.setString(5, str[0]);
          ps.executeUpdate();
        } 
      }
}
