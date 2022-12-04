package App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class hockeycsv_sai
{

    static String jdbcUrl = "jdbc:mysql://localhost:3306/oops_project";
    static String username = "root";
    static String password = "Bjr@2003";
 
    




    public static void hockey()
    {
        String filePath = "C:\\Users\\joshi\\OneDrive\\Documents\\hockeyfinal.csv";
        int batchSize = 100;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            String sql2="drop table if exists hockeyrules ; ";

            String sql1 =" Create table hockeyrules(number varchar(10) ,rules varchar(300))";
            String sql = "insert into hockeyrules values(?,?)";
            Statement St = connection.createStatement();
            St.executeUpdate(sql2);
            St.executeUpdate(sql1);
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
            String lineText = null;
            int count1 = 0;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String number = data[0];
                String rules = data[1];
               
    
                statement.setString(1, number);
                statement.setString(2, rules);
                
                
                statement.addBatch();
                if (count1 % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
   
    public static void main(String[] args) {
       
        hockeycsv_sai.hockey();
        

        System.out.println("SUCCESSFULL");
    }


    
}



