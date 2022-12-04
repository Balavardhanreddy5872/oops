package App;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;

abstract class sports {
  abstract void Create_matches(String file) throws Exception;

  abstract void Update_matches(String file) throws Exception;

  abstract void Delete_matches();

  abstract void print_match_details();

  abstract void search_by_ID();

  abstract void search_by_Country();

  abstract void search_by_Date();

}

class badminton_schedule extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query1 = "create table if not exists badminton_schedule (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt.executeUpdate(query1);
      String query = "insert into badminton_schedule values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update badminton_schedule set countries=?,date=?,time=?,winner=? where match_no=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from badminton_schedule where match_no=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");
      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule where match_no=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule where country like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class badminton_schedule_qualifiers extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists badminton_schedule_qualifiers (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into badminton_schedule_qualifiers values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update badminton_schedule_qualifiers set countries=?,date=?,time=?,winner=? where match_no=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from badminton_schedule_qualifiers where match_no=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");
      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_qualifiers");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_qualifiers where match_no=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from badminton_schedule_qualifiers where country like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_qualifiers where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class badminton_schedule_finals extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists badminton_schedule_finals (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into badminton_schedule_finals values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        // System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update badminton_schedule_finals set countries=?,date=?,time=?,winner=? where match_no=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from badminton_schedule_finals where match_no=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");
      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_finals");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_finals where match_no=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from badminton_schedule_finals where country like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_finals where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class tennis_schedule extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists tennis_schedule (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into tennis_schedule values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update tennis_schedule set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from tennis_schedule where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule where match_id=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class tennis_schedule_qualifiers extends sports {

  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists tennis_schedule_qualifiers (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into tennis_schedule_qualifiers values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update tennis_schedule_qualifiers set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from tennis_schedule_qualifiers where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule_qualifiers");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule_qualifiers where match_id=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from tennis_schedule_qualifiers where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule_qualifiers where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class tennis_schedule_finals extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists tennis_schedule_finals (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into tennis_schedule_finals values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update tennis_schedule_finals set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from tennis_schedule_finals where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule_finals");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule_finals where match_id=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from tennis_schedule_finals where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennis_schedule_finals where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class javalinthrow_schedule extends sports {

  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists javalinthrow_schedule (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into javalinthrow_schedule values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update javalinthrow_schedule set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from javalinthrow_schedule where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule where match_id=" + ID + "");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from javalinthrow_schedule where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class javalinthrow_schedule_qualifiers extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists javalinthrow_schedule_qualifiers (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into javalinthrow_schedule_qualifiers values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update javalinthrow_schedule_qualifiers set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from javalinthrow_schedule_qualifiers where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule_qualifiers");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule_qualifiers where match_id=" + ID + "");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from javalinthrow_schedule_qualifiers where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule_qualifiers where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class javalinthrow_schedule_finals extends sports {

  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists javalinthrow_schedule_finals (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into javalinthrow_schedule_finals values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update javalinthrow_schedule_finals set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from javalinthrow_schedule_finals where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule_finals");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule_finals where match_id=" + ID + "");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from javalinthrow_schedule_finals where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javalinthrow_schedule_finals where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class hockey_schedule extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists hockey_schedule (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into hockey_schedule values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update hockey_schedule set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from hockey_schedule where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule where match_id=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class hockey_schedule_qualifiers extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists hockey_schedule_qualifiers (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into hockey_schedule_qualifiers values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update hockey_schedule_qualifiers set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from hockey_schedule_qualifiers where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule_qualifiers");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule_qualifiers where match_id=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from hockey_schedule_qualifiers where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule_qualifiers where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class hockey_schedule_finals extends sports {
  public void Create_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      String query1 = "create table if not exists hockey_schedule_finals (match_no int,countries varchar(50) DEFAULT NULL,date varchar(30) DEFAULT NULL, time varchar(20) DEFAULT NULL, winner varchar(25) DEFAULT NULL,primary key(match_no));";
      stmt1.executeUpdate(query1);
      String query = "insert into hockey_schedule_finals values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        System.out.println(str[0]);
        ps.setInt(1, Integer.parseInt(str[0]));
        ps.setString(2, str[1]);
        ps.setString(3, str[2]);
        ps.setString(4, str[3]);
        ps.setString(5, str[4]);
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Update_matches(String file) throws Exception {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      String query = "update hockey_schedule_finals set countries=?,date=?,time=?,winner=? where match_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      Scanner sc = new Scanner(new File("C:/Users/joshi/Downloads/" + file));
      while (sc.hasNextLine()) {
        String[] str = sc.nextLine().split(",");
        ps.setString(1, str[1]);
        ps.setString(2, str[2]);
        ps.setString(3, str[3]);
        ps.setString(4, str[4]);
        ps.setInt(5, Integer.parseInt(str[0]));
        ps.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Delete_matches() {
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      System.out.println("Enter the match number:");
      String sql1 = input.nextLine();
      int rs = stmt1.executeUpdate("delete from hockey_schedule_finals where match_id=('" + sql1 + "' )");
      if (rs > 0)
        System.out.println("successfully  Deleted");

      else
        System.out.println(
            "unsucessful Deletion ");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  };

  public void print_match_details() {
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule_finals");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("|   Match_number    | Countries | Date_of_match | Time_of_Match | Winner  |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %15s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out.println("------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_ID() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter match_no:");
      int ID = input.nextInt();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule_finals where match_id=" + ID + ";");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void search_by_Country() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter country:");
      String s = input.nextLine();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1
          .executeQuery("select * from hockey_schedule_finals where countries like '" + '%' + s + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  void search_by_Date() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter date:");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt();
      date d= new date(year,(short)month,(short)day);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from hockey_schedule_finals where date like '" + '%' + d.toString() + '%' + "';");
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println("|     Match_number   |          Countries            |    Date   |    Time   |  winner    |");
      System.out.println("------------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%20s| %30s| %10s| %10s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5));
        System.out
            .println("-------------------------------------------------------------------------------------------");

      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

public class App {

  public static void main() throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the user name:");
    String user_name = input.nextLine();
    System.out.println("Enter the password:");
    String Password = input.nextLine();
    try{
    if (user_name.equals("joshit") && Password.equals("1234")) {
      System.out.println(
          "1.Badminton league\n2.Badminton qualifiers\n3.Badminton finals\n4.Tennis league\n5.Tennis qualifiers\n6.Tennis finals\n7.Javalinthrow league\n8.Javalinthrow qualifiers\n9.Javalinthrow finals\n10.Hockey league\n11.Hockey qualifiers\n12.Hockey finals");
     

      int num = input.nextInt();

      System.out.println(
          "1.Create_matches\n2.Update_matches\n3.Delete_matches\n4.Print_matches\n5.search_by_id\n6.search_by_country\n7.search_by_date\n0.exit");
      switch (num) {
        case 1: {
          System.out.println("----WELCOME TO BADMINTON TOURNMENT------");
          badminton_schedule s1 = new badminton_schedule();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("BADMANTION_SCHEDULE_Operator.csv");
              break;
            }
            case 2: {
              s1.Update_matches("BADMANTION_SCHEDULE_Operator.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 2: {
          System.out.println("----WELCOME TO BADMINTON QUALIFIER TOURNMENT------");
          sports s1 = new badminton_schedule_qualifiers();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("BADMANTION_QUALIFIED_SCHEDULE_Operator_1.csv");
              break;
            }
            case 2: {
              s1.Update_matches("BADMANTION_QUALIFIED_SCHEDULE_Operator_1.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 3: {
          System.out.println("----WELCOME TO BADMINTON FINALS TOURNMENT------");
          sports s1 = new badminton_schedule_finals();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("BADMANTION_QUALIFIED_SCHEDULE_Operator_2.csv");
              break;
            }
            case 2: {
              s1.Update_matches("BADMANTION_QUALIFIED_SCHEDULE_Operator_2.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }
          }
          break;
        }
        case 4: {
          System.out.println("----WELCOME TO TENNIS TOURNMENT------");
          sports s1 = new tennis_schedule();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("Tennies_Schedule_Operator.csv");
              break;
            }
            case 2: {
              s1.Update_matches("Tennies_Schedule_Operator.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 5: {
          System.out.println("----WELCOME TO TENNIES QUALIFIERS TOURNMENT------");
          sports s1 = new tennis_schedule_qualifiers();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("Tennies_qualified_schedule_Operator_1.csv");
              break;
            }
            case 2: {
              s1.Update_matches("Tennies_qualified_schedule_Operator_1.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 6: {
          System.out.println("----WELCOME TO TENNIES FINALS TOURNMENT------");
          sports s1 = new tennis_schedule_finals();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("Tennies_qualified_schedule_Operator_2.csv");
              break;
            }
            case 2: {
              s1.Update_matches("Tennies_qualified_schedule_Operator_2.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 7: {
          System.out.println("----WELCOME TO JAVELIN THROWTOURNMENT------");
          sports s1 = new javalinthrow_schedule();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("javelin_throw_SCHEDULE_Operator.csv");
              break;
            }
            case 2: {
              s1.Update_matches("javelin_throw_SCHEDULE_Operator.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 8: {
          System.out.println("----WELCOME TO JAVELIN THROW QUALIFIERS TOURNMENT------");
          sports s1 = new javalinthrow_schedule_qualifiers();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("javelin_throw_qualified_SCHEDULE_Operator_1.csv");
              break;
            }
            case 2: {
              s1.Update_matches("javelin_throw_qualified_SCHEDULE_Operator_1.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 9: {
          System.out.println("----WELCOME TO  JAVELIN THROW FINALS TOURNMENT------");
          sports s1 = new javalinthrow_schedule_finals();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("javelin_throw_qualified_SCHEDULE_Operator_2.csv");
              break;
            }
            case 2: {
              s1.Update_matches("javelin_throw_qualified_SCHEDULE_Operator_2.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 10: {
          System.out.println("----WELCOME TO HOCKEY TOURNMENT------");
          sports s1 = new hockey_schedule();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("HOCKEY_schedule_Operator.csv");
              break;
            }
            case 2: {
              s1.Update_matches("HOCKEY_schedule_Operator.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            
            case 0: {
              break;
            }

          }
          break;
        }
        case 11: {
          System.out.println("----WELCOME TO HOCKEY QUALIFIERS TOURNMENT------");
          sports s1 = new hockey_schedule_qualifiers();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("Hockey_qualified_Schedule_Operator_1.csv");
              break;
            }
            case 2: {
              s1.Update_matches("Hockey_qualified_Schedule_Operator_1.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        case 12: {
          System.out.println("----WELCOME TO HOCKEY FINALS TOURNMENT------");
          sports s1 = new hockey_schedule_finals();
          int number = input.nextInt();

          switch (number) {
            case 1: {
              s1.Create_matches("Hockey_qualified_Schedule_Operator_2.csv");
              break;
            }
            case 2: {
              s1.Update_matches("Hockey_qualified_Schedule_Operator_2.csv");
              break;
            }
            case 3: {
              s1.Delete_matches();
              break;
            }
            case 4: {
              s1.print_match_details();
              break;
            }

            case 5: {
              s1.search_by_ID();
              break;
            }
            case 6: {
              s1.search_by_Country();
              break;
            }
            case 7:{
              s1.search_by_Date();
            }
            case 0: {
              break;
            }

          }
          break;
        }
        default:{
          System.out.println("Input should be in 1 to 12");
        }
      }
    } else {
      System.out.println("Username or password is incorrect");
    }
  }
  catch(InputMismatchException e){
    System.out.println("Input is incorrect,please check");
  }
  }
}

