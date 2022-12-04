package App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Tenniescsv {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/oops_project?allowPublicKeyRetrieval=true&useSSL=false&jdbcCompliantTruncation=false";
    static String username = "root";
    static String password = "Bjr@2003";

    public static void Tennies_Schedule() {
        String filePath = "C:\\Users\\joshi\\OneDrive\\Documents\\Tennies_Schedule.csv";
        int batchSize = 100;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            String sql2 = "drop table if exists Tennies_Schedule ; ";

            String sql1 = " Create table Tennies_Schedule (match_no int, country varchar(25), date varchar(12),time varchar(7),winner varchar(15))";
            String sql = "insert into Tennies_Schedule values(?,?,?,?,?)";
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
                String match_no = data[0];
                String country = data[1];
                String date = data[2];
                String time = data[3];
                String winner = data[4];

                statement.setString(1, match_no);
                statement.setString(2, country);
                statement.setString(3, date);
                statement.setString(4, time);
                statement.setString(5, winner);

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
   
    public static void tennis()
    {
        String filePath = "C:\\Users\\joshi\\OneDrive\\Documents\\Tennies_qualified_schedule.csv";
        int batchSize = 100;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            String sql2="drop table if exists tennis_qualified_schedule ; ";

            String sql1 =" Create table tennis_qualified_schedule (ID varchar(50),NAME varchar(50),COUNTRY varchar(20))";
            String sql = "insert into tennis_qualified_schedule values(?,?,?)";
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
                String ID = data[0];
                String NAME = data[1];
                String COUNTRY=data[2];
    
                statement.setString(1, ID);
                statement.setString(2, NAME);
                statement.setString(3, COUNTRY);
                
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

    

    public static void Tennies_qualified_Schedule_1() {
        String filePath = "C:\\Users\\joshi\\OneDrive\\Documents\\Tennies_qualified_schedule_1.csv";
        int batchSize = 100;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            String sql2 = "drop table if exists Tennies_qualified_schedule_1   ; ";

            String sql1 = " Create table Tennies_qualified_schedule_1 (match_no int, country varchar(25), date varchar(12),time varchar(7),winner varchar(15))";
            String sql = "insert into Tennies_qualified_schedule_1 values(?,?,?,?,?)";
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
                String match_no = data[0];
                String country = data[1];
                String date = data[2];
                String time = data[3];
                String winner = data[4];

                statement.setString(1, match_no);
                statement.setString(2, country);
                statement.setString(3, date);
                statement.setString(4, time);
                statement.setString(5, winner);

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

    public static void Tennies_qualified_Schedule_2()
    {
        String filePath = "C:\\Users\\joshi\\OneDrive\\Documents\\Tennies_qualified_schedule_2.csv";
        int batchSize = 100;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            String sql2="drop table if exists Tennies_qualified_schedule_2 ; ";

            String sql1 =" Create table Tennies_qualified_schedule_2 (match_no int, country varchar(30), date varchar(12),time varchar(7),winner varchar(15))";
            String sql = "insert into Tennies_qualified_schedule_2 values(?,?,?,?,?)";
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
                String match_no = data[0];
                String country = data[1];
                String date=data[2];
                String time=data[3];
                String winner=data[4];

    
                statement.setString(1, match_no);
                statement.setString(2, country);
                statement.setString(3, date);
                statement.setString(4, time); 
                statement.setString(5, winner);
                
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
        Tenniescsv.Tennies_Schedule();
        Tenniescsv.Tennies_qualified_Schedule_1();
        Tenniescsv.Tennies_qualified_Schedule_2();
        Tenniescsv.tennis();

    }

}