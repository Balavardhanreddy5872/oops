package App;
import search.*;
import java.sql.*;
import csv1.*;
import java.util.Scanner;
import java.io.*;

abstract class medals {
  String country;
  int Gold;
  int Silver;
  int Bronze;
  int TotalMedals;

  abstract void displayLeaderBoard();

  abstract void setvalues();

  abstract void deletecountry();
}
class DistributeMedals extends medals {
   public void displayLeaderBoard(){};
   public void setvalues(){};
   public void deletecountry(){};
   public void allocate_bronze(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select winner,count(winner) from bronzemedals group by winner;");
      while(rs.next())
      {
          Statement stmt2 = con.createStatement();
          String query = "update country set bronze=bronze+"+rs.getInt(2)+" where countries ='"+rs.getString(1)+"';";
          stmt2.executeUpdate(query);
          String query2 = "update country set Total_medals = Gold+Silver+Bronze where countries ='"+rs.getString(1)+"';";
          stmt2.executeUpdate(query2);
      }
    }catch (Exception e) {
      System.out.println(e);
    }
   }
   public void allocate_gold(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select winner,count(winner) from goldmedals group by winner;");
      while(rs.next())
      {
          Statement stmt2 = con.createStatement();
          String query = "update country set gold=gold+"+rs.getInt(2)+" where countries ='"+rs.getString(1)+"';";
          stmt2.executeUpdate(query);
          String query2 = "update country set Total_medals = Gold+Silver+Bronze where countries ='"+rs.getString(1)+"';";
          stmt2.executeUpdate(query2);
      }
    }catch (Exception e) {
      System.out.println(e);
    }
   }
   public void allocate_silver(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select RUNNERS,count(RUNNERS) from goldmedals group by RUNNERS;");
      while(rs.next())
      {
          Statement stmt2 = con.createStatement();
          String query = "update country set silver = silver+"+rs.getInt(2)+" where countries ='"+rs.getString(1)+"';";
          stmt2.executeUpdate(query);
          String query2 = "update country set Total_medals = Gold+Silver+Bronze where countries ='"+rs.getString(1)+"';";
          stmt2.executeUpdate(query2);
      }
    }catch (Exception e) {
      System.out.println(e);
    }
   }
}

class result extends medals {
  public void displayLeaderBoard() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from country;");
      System.out.println("------------------------------------------------------------------------------");
      System.out.printf("|%15s | %15s | %15s | %7s | %7s|\n", "COUNTRIES", "Gold", "Silver", "Bronze", "Total Medals");
      System.out.println("------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%15s | %15s | %15s |%8s | %12s|\n", rs.getString(1), rs.getInt(2), rs.getInt(3),
            rs.getInt(4), rs.getInt(5));
      }
      System.out.println("-------------------------------------------------------------------------------");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void setvalues() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      PreparedStatement stmt = con.prepareStatement("insert into country values(?,?,?,?,?)");
      // members
      Scanner sc = new Scanner(System.in);
      System.out.println("enter the country name:");
      country = sc.nextLine();
      System.out.println("enter Gold medals:");
      Gold = sc.nextInt();
      System.out.println("enter the silver medals:");
      Silver = sc.nextInt();
      System.out.println("enter the bronze medals:");
      Bronze = sc.nextInt();
      TotalMedals = Gold + Silver + Bronze;
      Statement st = con.createStatement();
      ResultSet r1 = st
          .executeQuery("select count(COUNTRIES) as cnt from country where COUNTRIES = '" + country + "';");
      sc.nextLine();
      r1.next();
      if (r1.getInt(1) <= 0) {
        // insert into database
        stmt.setString(1, country);
        stmt.setInt(2, Gold);
        stmt.setInt(3, Silver);
        stmt.setInt(4, Bronze);
        stmt.setInt(5, TotalMedals);
        stmt.executeUpdate();
      } else {
        st.executeUpdate("update country set Gold = " + Gold + ", Silver = " + Silver + ", Bronze = " + Bronze
            + ", Total_Medals = " + TotalMedals + " where countries = '" + country + "';");
      }
      System.out.println("ID:" + country + "   Gold:" + Gold + "    Silver:" + Silver + "    Bronze:" + Bronze
          + "TotalMedals" + TotalMedals);
      System.out.println("Success!");
      System.out.println("-------------------------------------------------------------------------------");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void deletecountry() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Scanner sc1 = new Scanner(System.in);
      String country;
      System.out.println("enter the country name: ");
      country = sc1.nextLine();
      Statement mt = con.createStatement();
      System.out.println("delete from country where COUNTRIES= '" + country + "';");
      mt.executeUpdate("delete from country where COUNTRIES= '" + country + "';");
      System.out.println("deletion successful");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void sort() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt = con.createStatement();
      System.out.println("Fetching records in ascending order...");
      ResultSet rs = stmt.executeQuery("select * from country order by Total_medals asc");
      System.out.println("------------------------------------------------------------------------------");
      System.out.printf("|%15s | %15s | %15s | %7s | %7s|\n", "COUNTRIES", "Gold", "Silver", "Bronze", "Total Medals");
      System.out.println("------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%15s | %15s | %15s |%8s | %12s|\n", rs.getString(1), rs.getInt(2), rs.getInt(3),
            rs.getInt(4), rs.getInt(5));
      }
      System.out.println("-------------------------------------------------------------------------------");
      System.out.println("Fetching records in descending order...");
      rs = stmt.executeQuery("select * from country order by Total_medals desc");
      System.out.println("------------------------------------------------------------------------------");
      System.out.printf("|%15s | %15s | %15s | %7s | %7s|\n", "COUNTRIES", "Gold", "Silver", "Bronze", "Total Medals");
      System.out.println("------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%15s | %15s | %15s |%8s | %12s|\n", rs.getString(1), rs.getInt(2), rs.getInt(3),
            rs.getInt(4), rs.getInt(5));
      }
      System.out.println("-------------------------------------------------------------------------------");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

public class Medalswon {
  public static void main() throws Exception {
    Scanner i = new Scanner(System.in);
    // result rs=new result();
    // rs.addDetails("Country.csv");//to insert a new csv file 
    DistributeMedals d = new DistributeMedals();
    while (true) {
      System.out.println("Enter the number between 1 to 5 to see list of participants");
      System.out.println(" 1.Print leaderBoard\n 2.insert or update into leaderBoard \n 3.Add data into csv files \n 4. update via csv file  \n 5.delete country  \n 6.countrydetails \n 7.retivedata \n 8.Sort \n 9.Allocate medals from Tournament \n 10.EXIT");
      int num = i.nextInt();
      result r = new result();
      switch (num) {
        case 1: {
          System.out.println("\nPrint leaderBoard\n");
          r.displayLeaderBoard();
          break;
        }
        case 2: {
          r.setvalues();
          break;
        }
        case 3: {
          csv1.addDetails("Country.csv");
          break;
        }
        case 4: {
          csv1.updateTable("Country.csv");
          break;
        }
        case 5: {
          r.deletecountry();
          break;
        }
        case 6: {
          search.countrydetails();
          break;
        }
        case 7: {
          search.Retrivedata();
          break;
        }
        case 8:{
          r.sort();
          break;
        }
        case 9:{
          System.out.println("Distributing medals...\n");
          d.allocate_gold();
          d.allocate_silver();
          d.allocate_bronze();
          System.out.println("Distributed Successfully..");
          break;
        }
        case 10:{
          return;
        }
        default: {
          System.out.println("\n=========ERROR!!=========\n");
        }
      }
    }
  }
}
