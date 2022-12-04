package App;
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

abstract class sports {

  void host_country() {
    System.out.println("---------------OLYMPICS HOSTED BY INDIA\n------------------");
  }

  abstract void create_league_games();

  abstract void create_qualifier_league();
}

class badminton extends sports {
  void create_league_games() {
    System.out.println("League_match_schedule");
    Scanner input = new Scanner(System.in);

    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_tournment");
      System.out.println("------------------------------------------------------");
      System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
      System.out.println("------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4));
        System.out.println("------------------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(
        "Enter\n1.search by date\n2.search by time\n3.UPDATE_RESULTS\n4.RESULTS\n5.COUNTRY\n6.Match_no\ndefault.exit");
    int value = input.nextInt();
    switch (value) {
      case 1: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  DATE MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from badminton_schedule_tournment where date=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 2: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  TIME MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from badminton_schedule_tournment where time=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 3: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update badminton_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update badminton_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update badminton_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 4\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update badminton_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('4')");
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 4: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from badminton_schedule_tournment");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 5: {
        try {
          String game = input.next();
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1
              .executeQuery("select *from badminton_schedule_tournment where COUNTRY like '" + '%' + game + '%' + "';");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 6: {
        try {
          int nop;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER MATCH_NO FOR DETAILS :");
          nop = input.nextInt();
          String sqlquery = "select * from badminton_schedule_tournment where Match_no=('" + nop + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      default: {
        break;
      }

    }
  }

  void create_qualifier_league() {
    Scanner input = new Scanner(System.in);
    System.out.println("QUALIFIED_SCHEDULE\n");
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from  badminton_qualified_schedule_tournment ");
      System.out.println("---------------------------------------------");
      System.out.printf("|Match_no|       PLAYER\t        |  COUNTRY  |  \n");
      System.out.println("---------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
        System.out.println("---------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("ENTER 1.semifinals\n2.FINALS");
    int sru = input.nextInt();
    switch (sru) {
      case 1: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from badminton_qualified_schedule_tournment_1");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update badminton_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update badminton_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update badminton_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from badminton_qualified_schedule_tournment_1 ");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }

      case 2: {
        System.out.println("\n------------WELCOME TO badminton FINAL----------------\n");
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from badminton_qualified_schedule_tournment_2");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update badminton_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from badminton_qualified_schedule_tournment_2 ");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        System.out.println("\n---------------CONGRATULATIONS TO THE WINNING TEAM-----------------\n");
      }

    }

  }
}

class javalion_throw extends sports {
  void create_league_games() {
    System.out.println("League_match_schedule");
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from javelin_throw_schedule_tournment");
      System.out.println("------------------------------------------------------");
      System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
      System.out.println("------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4));
        System.out.println("------------------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(
        "Enter\n1.search by date\n2.search by time\n3.UPDATE_RESULTS\n4.RESULTS\n5.COUNTRY\n6.Match_no\ndefault.exit");
    int value = input.nextInt();
    switch (value) {
      case 1: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  DATE MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from javelin_throw_schedule_tournment where date=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 2: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  TIME MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from javelin_throw_schedule_tournment where time=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 3: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update javelin_throw_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update javelin_throw_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update javelin_throw_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 4\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update javelin_throw_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('4')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 5\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update javelin_throw_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('5')");
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 4: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from javelin_throw_schedule_tournment");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 5: {
        try {
          String game = input.next();
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1
              .executeQuery("select *from javelin_throw_schedule_tournment where COUNTRY like '" + '%' + game + '%' + "';");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 6: {
        try {
          int nop;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER MATCH_NO FOR DETAILS :");
          nop = input.nextInt();
          String sqlquery = "select * from javelin_throw_schedule_tournment where Match_no=('" + nop + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      default: {
        break;
      }

    }

  }

  void create_qualifier_league() {
    Scanner input = new Scanner(System.in);
    System.out.println("QUALIFIED_SCHEDULE\n");
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from  javelin_throw_qualified_schedule_tournment");
      System.out.println("---------------------------------------------");
      System.out.printf("|PLAYER_ID|       PLAYER\t        |  COUNTRY  |  \n");
      System.out.println("---------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
        System.out.println("---------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("ENTER 1.semifinals\n2.FINALS");
    int su = input.nextInt();
    switch (su) {
      case 1: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from javelin_throw_qualified_schedule_tournment_1");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update javelin_throw_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update javelin_throw_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update javelin_throw_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from javelin_throw_qualified_schedule_tournment_1 ");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 2: {
        System.out.printf("------------WELCOME TO JAVALION_THROW FINALS-----------\n");
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  javelin_throw_qualified_schedule_tournment_2");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  javelin_throw_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  javelin_throw_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from javelin_throw_qualified_schedule_tournment_2");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        System.out.println("\n---------------CONGRATULATIONS TO THE WINNING TEAM-----------------\n");

      }
    }

  }
}

class Tennies extends sports {
  void create_league_games() {
    System.out.println("League_match_schedule");
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from tennies_schedule_tournment");
      System.out.println("------------------------------------------------------");
      System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
      System.out.println("------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4));
        System.out.println("------------------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(
        "Enter\n1.search by date\n2.search by time\n3.UPDATE_RESULTS\n4.RESULTS\n5.COUNTRY\n6.Match_no\ndefault.exit");
    int oop = input.nextInt();
    switch (oop) {
      case 1: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  DATE MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from tennies_schedule_tournment where date=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 2: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  TIME MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from tennies_schedule_tournment where time=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 3: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update tennies_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update tennies_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update tennies_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 4\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update tennies_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('4')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 5\n");
          String sql1 = input.next();
          int rs = stmt1
              .executeUpdate("update tennies_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('5')");
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 4: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from tennies_schedule_tournment");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 5: {
        try {
          String game = input.next();
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1
              .executeQuery("select * from tennies_schedule_tournment where COUNTRY like '" + '%' + game + '%' + "';");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 6: {
        try {
          int nop;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER MATCH_NO FOR DETAILS :");
          nop = input.nextInt();
          String sqlquery = "select * from tennies_schedule_tournment where Match_no=('" + nop + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      default: {
        break;
      }

    }
  }

  void create_qualifier_league() {
    Scanner input = new Scanner(System.in);
    System.out.println("QUALIFIED_SCHEDULE\n");
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from  tennies_qualified_schedule_tournment");
      System.out.println("---------------------------------------------");
      System.out.printf("|PLAYER_ID|       PLAYER\t        |  COUNTRY  |  \n");
      System.out.println("---------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
        System.out.println("---------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("ENTER 1.semifinals\n2.FINALS");
    int z = input.nextInt();
    switch (z) {
      case 1: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  tennies_qualified_schedule_tournment_1");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  tennies_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  tennies_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  tennies_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  tennies_qualified_schedule_tournment_1 ");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 2: {
        System.out.printf("------------WELCOME TO TENNIES FINALS-----------\n");
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  tennies_qualified_schedule_tournment_2");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  tennies_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  tennies_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from tennies_qualified_schedule_tournment_2");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        System.out.println("\n---------------CONGRATULATIONS TO THE WINNING TEAM-----------------\n");
      }
    }

  }
}

class Hockey extends sports {
  void create_league_games() {
    System.out.println("League_match_schedule");
    Scanner input = new Scanner(System.in);
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from Hockey_schedule_tournment");
      System.out.println("------------------------------------------------------");
      System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
      System.out.println("------------------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4));
        System.out.println("------------------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(
        "Enter\n1.search by date\n2.search by time\n3.UPDATE_RESULTS\n4.RESULTS\n5.COUNTRY\n6.Match_no\ndefault.exit");
    int v = input.nextInt();
    switch (v) {
      case 1: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  DATE MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from Hockey_schedule_tournment where date=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 2: {
        try {
          String given;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER  TIME MATCH FOR DETAILS :");
          given = input.next();
          String sqlquery = "select * from Hockey_schedule_tournment where time=('" + given + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 3: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update Hockey_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update Hockey_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update Hockey_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 4\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update Hockey_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('4')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 5\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate("update Hockey_schedule_tournment set winner =(' " + sql1 + " ') where match_no=('5')");
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 4: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from Hockey_schedule_tournment");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }

      case 5: {
        try {
          String game = input.next();
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1
              .executeQuery("select * from Hockey_schedule_tournment where COUNTRY like '" + '%' + game + '%' + "';");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      case 6: {
        try {
          int number;
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER MATCH_NO FOR DETAILS :");
          number = input.nextInt();
          String sqlquery = "select * from Hockey_schedule_tournment where Match_no=('" + number + "')";
          ResultSet rs = stmt1.executeQuery(sqlquery);
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

      }
      default: {
        break;
      }

    }
  }

  void create_qualifier_league() {
    Scanner input = new Scanner(System.in);
    System.out.println("QUALIFIED_SCHEDULE\n");
    try {
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
      Statement stmt1 = con.createStatement();
      ResultSet rs = stmt1.executeQuery("select * from  Hockey_qualified_schedule_tournment");
      System.out.println("---------------------------------------------");
      System.out.printf("|PLAYER_ID|       PLAYER\t        |  COUNTRY  |  \n");
      System.out.println("---------------------------------------------");
      while (rs.next()) {
        System.out.printf("|%8s| %20s | %10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
        System.out.println("---------------------------------------------");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("ENTER 1.semifinals\n2.FINALS");
    int z = input.nextInt();
    switch (z) {
      case 1: {
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  Hockey_qualified_schedule_tournment_1");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  Hockey_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  Hockey_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 3\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  Hockey_qualified_schedule_tournment_1 set winner =(' " + sql1 + " ') where match_no=('3')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  Hockey_qualified_schedule_tournment_1 ");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      case 2: {
        System.out.printf("------------WELCOME TO TENNIES FINALS-----------\n");
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          ResultSet rs = stmt1.executeQuery("select * from  Hockey_qualified_schedule_tournment_2");
          System.out.println("------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  |\n");
          System.out.println("------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
            System.out.println("------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 1\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  tHockey_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('1')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("ENTER THE COUNTRY WINNER OF MATCH_NO 2\n");
          String sql1 = input.next();
          int rs = stmt1.executeUpdate(
              "update  Hockey_qualified_schedule_tournment_2 set winner =(' " + sql1 + " ') where match_no=('2')");
        } catch (Exception e) {
          System.out.println(e);
        }
        try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
          Statement stmt1 = con.createStatement();
          System.out.println("\nENTER  MATCH FOR DETAILS :");
          ResultSet rs = stmt1.executeQuery("select * from Hockey_qualified_schedule_tournment_2");
          System.out.println("---------------------------------------------------------------");
          System.out.printf("|Match_no|       COUNTRY\t|  DATE     |  TIME  | WINNER |\n");
          System.out.println("---------------------------------------------------------------");
          while (rs.next()) {
            System.out.printf("|%8s| %20s | %10s|%8s| %5s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5));
            System.out.println("---------------------------------------------------------------");
          }
          con.close();
        } catch (Exception e) {
          System.out.println(e);
        }

        System.out.println("\n---------------CONGRATULATIONS TO THE WINNING TEAM-----------------\n");
      }
    }
  }
}

public class TOURNMENT {
  public static void main() {
    Scanner input = new Scanner(System.in);
    

    while (true) {
      System.out.printf("ENTER\n1.badminton\n2.javelin throw\n3.tennies\n4.Hockey\n");
      int num = input.nextInt();
      switch (num) {
        case 1: {
          System.out.println("-------WELCOME TO badminton TOURNMENT----------");
          badminton s1 = new badminton();
          
          System.out.println("Enter\n1.league_maatches\n2.qualifier_matches\n3.exit\n");
          int no = input.nextInt();
          switch (no) {
            case 1: {
              s1.create_league_games();
            }
            case 2: {
              s1.create_qualifier_league();
            }
            case 3: {
              break;
            }
          }
        }
        case 2: {
          javalion_throw s2 = new javalion_throw();
          s2.hashCode();
          System.out.println("Enter\n1.league_maatches\n2.qualifier_matches\n3.exit\n");
          int n = input.nextInt();
          switch (n) {
            case 1: {
              s2.create_league_games();
            }
            case 2: {
              s2.create_qualifier_league();
            }
            case 3: {
              break;
            }
          }

        }

        case 3: {
          Tennies s3 = new Tennies();
          System.out.println("Enter\n1.league_maatches\n2.qualifier_matches\n3.exit\n");
          int p = input.nextInt();
          switch (p) {
            case 1: {
              s3.create_league_games();
            }
            case 2: {
              s3.create_qualifier_league();
            }
            case 3: {
              break;
            }
          }
        }
        case 4: {
          Hockey s4 = new Hockey();
          System.out.println("Enter\n1.league_maatches\n2.qualifier_matches\n3.exit\n");
          int yes = input.nextInt();
          switch (yes) {
            case 1: {
              s4.create_league_games();
            }
            case 2: {
              s4.create_qualifier_league();
            }
            case 3: {
              break;
            }
          }
        }
      }
    }
  }
}
