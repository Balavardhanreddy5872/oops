package search;
import java.sql.*;
import java.util.Scanner;

abstract class medals{
  static String country;
  static int Gold;
  static int Silver;
  static int Bronze;
  static int TotalMedals;
}
public class search extends medals{
    public static void Retrivedata() {// numeric fields
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root", "b2a1l9u9");
          Scanner sc4 = new Scanner(System.in);
          System.out.println("please select between 1-4  ");// to retive data how many countries won the no.of medals
          System.out.println(" 1.gold \n 2.silver \n 3.bronze \n 4.TotalMedals");
          int number = sc4.nextInt();
          switch (number) {
            case 1: {
              System.out.println("Enter > or < or =");
              String s = sc4.next();
              System.out.println("enter the no.of gold medals: ");
              Gold = sc4.nextInt();
              Statement stmt2 = con.createStatement();
              ResultSet rs = stmt2.executeQuery("select COUNTRIES,Gold from country where Gold" + s + "'" + Gold + "';");
              int k = 0;
              System.out.println("------------------------------------");
              System.out.printf("|%15s | %15s |\n", "COUNTRIES", "Gold");
              System.out.println("------------------------------------");
              while (rs.next()) {
                k = 1;
                System.out.printf("|%15s | %15s | \n", rs.getString(1), rs.getInt(2));
              }
              System.out.println("------------------------------------");
              if (k == 0) {
                System.out.println("\nNo Country with the selected Medals\n");
              }
              break;
            }
            case 2: {
              System.out.println("Enter > or < or =");
              String s = sc4.next();
              System.out.println("enter the no.of Silver medals: ");
              Silver = sc4.nextInt();
              Statement stmt2 = con.createStatement();
              ResultSet rs = stmt2
                  .executeQuery("select COUNTRIES,Silver from country where Gold" + s + "'" + Silver + "';");
              int k = 0;
              System.out.println("------------------------------------");
              System.out.printf("|%15s | %15s |\n", "COUNTRIES", "Silver");
              System.out.println("------------------------------------");
              while (rs.next()) {
                k = 1;
                System.out.printf("|%15s | %15s | \n", rs.getString(1), rs.getInt(2));
              }
              System.out.println("------------------------------------");
              if (k == 0) {
                System.out.println("\nNo Country with the selected Medals\n");
              }
              break;
            }
            case 3: {
              System.out.println("Enter > or < or =");
              String s = sc4.next();
              System.out.println("enter the no.of Bronze medals: ");
              Bronze = sc4.nextInt();
              Statement stmt2 = con.createStatement();
              ResultSet rs = stmt2
                  .executeQuery("select COUNTRIES,Bronze from country where Gold" + s + "'" + Bronze + "';");
              int k = 0;
              System.out.println("------------------------------------");
              System.out.printf("|%15s | %15s |\n", "COUNTRIES", "Bronze");
              System.out.println("------------------------------------");
              while (rs.next()) {
                k = 1;
                System.out.printf("|%15s | %15s | \n", rs.getString(1), rs.getInt(2));
              }
              System.out.println("------------------------------------");
              if (k == 0) {
                System.out.println("\nNo Country with the selected Medals\n");
              }
              break;
            }
            case 4: {
              System.out.println("Enter > or < or =");
              String s = sc4.next();
              System.out.println("enter the Total medals: ");
              TotalMedals = sc4.nextInt();
              Statement stmt2 = con.createStatement();
              ResultSet rs = stmt2
                  .executeQuery("select COUNTRIES,Total_Medals from country where Gold" + s + "'" + TotalMedals + "';");
              int k = 0;
              System.out.println("------------------------------------");
              System.out.printf("|%15s | %15s |\n", "COUNTRIES", "Total_Medals");
              System.out.println("------------------------------------");
              while (rs.next()) {
                k = 1;
                System.out.printf("|%15s | %15s | \n", rs.getString(1), rs.getInt(2));
              }
              System.out.println("------------------------------------");
              if (k == 0) {
                System.out.println("\nNo Country with the selected Medals\n");
              }
              break;
            }
            default: {
              System.out.println("\n=========ERROR!!=========\n");
              break;
            }
          }
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      
  public static void countrydetails() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root", "b2a1l9u9");
      Scanner sc2 = new Scanner(System.in);
      System.out.println("search country via 1 or 2");
      System.out.println("1.complete name \n 2.partial name");
      int x = sc2.nextInt();
      String country;
      String count;
      switch (x) {
        case 1: {
          sc2.nextLine();
          System.out.println("enter the country name: ");
          country = sc2.nextLine();
          Statement stmt2 = con.createStatement();
          ResultSet rs = stmt2.executeQuery("select * from country where COUNTRIES = '" + country + "';");
          System.out.println("------------------------------------------------------------------------------");
          System.out.printf("|%15s | %15s | %15s | %7s | %7s|\n", "COUNTRIES", "Gold", "Silver", "Bronze",
              "Total Medals");
          System.out.println("------------------------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%15s | %15s | %15s |%8s | %12s|\n", rs.getString(1), rs.getInt(2), rs.getInt(3),
                rs.getInt(4), rs.getInt(5));
          }
          System.out.println("-------------------------------------------------------------------------------");
          break;
        }
        case 2: {
          sc2.nextLine();
          System.out.println("enter the country name:");
          count = sc2.nextLine();
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("select * from country where COUNTRIES like '"  + count + '%' + "';");
          System.out.println("------------------------------------------------------------------------------");
          System.out.printf("|%15s | %15s | %15s | %7s | %7s|\n", "COUNTRIES", "Gold", "Silver", "Bronze",
              "Total Medals");
          System.out.println("------------------------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%15s | %15s | %15s |%8s | %12s|\n", rs.getString(1), rs.getInt(2), rs.getInt(3),
                rs.getInt(4), rs.getInt(5));
          }
          System.out.println("-------------------------------------------------------------------------------");
          break;
        }
        default: {
          System.out.println("\n=========ERROR!!=========\n");
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
