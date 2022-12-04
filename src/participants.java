package App;
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
abstract class sports {
    abstract void show_players();
  }

class tennis extends sports{
  void show_players(){
    try {
    //  Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project","root","Bjr@2003");
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from tennis;");
        System.out.println("----------------------------------------------");
        System.out.printf("|%7s | %15s | %15s |\n","ID","Name","country");
        System.out.println("----------------------------------------------");
        while(rs.next())
       {
        System.out.printf("|%7s | %15s | %15s |\n",rs.getString(1),rs.getString(2),rs.getString(3));
       }
       System.out.println("----------------------------------------------");
       con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }
}

class badminton extends sports{
  void show_players(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project","root","Bjr@2003");
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from badminton;");
        System.out.println("----------------------------------------------");
        System.out.printf("|%7s | %15s | %15s |\n","ID","Name","country");
        System.out.println("----------------------------------------------");
        while(rs.next())
       {
        System.out.printf("|%7s | %15s | %15s |\n",rs.getString(1),rs.getString(2),rs.getString(3));
       }
       System.out.println("----------------------------------------------");
       con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }
}

class hockey extends sports{
  void show_players(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project?allowPublicKeyRetrieval=true&useSSL=false&jdbcCompliantTruncation=false","root","Bjr@2003");
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from hockey;");
        System.out.println("----------------------------------------------");
        System.out.printf("|%7s | %15s | %15s |\n","ID","Name","country");
        System.out.println("----------------------------------------------");
        while(rs.next())
       {
        System.out.printf("|%7s | %15s | %15s |\n",rs.getString(1),rs.getString(2),rs.getString(3));
       }
       System.out.println("----------------------------------------------");
       con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }
}

class javelinthrow extends sports{
  void show_players(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project","root","Bjr@2003");
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from javelinthrow;");
        System.out.println("----------------------------------------------");
        System.out.printf("|%7s | %15s | %15s |\n","ID","Name","country");
        System.out.println("----------------------------------------------");
        while(rs.next())
       {
        System.out.printf("|%7s | %15s | %15s |\n",rs.getString(1),rs.getString(2),rs.getString(3));
       }
       System.out.println("----------------------------------------------");
       con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }
}





public class participants{
    public static void main() throws SQLException{
//==================================================================================================================================== 
     try (Scanner i = new Scanner(System.in)) {
      
   while(true){
    System.out.println("\nEnter the number between 1 to 4 to see list of participants");
    System.out.println("  1.tennis\n  2.badminton\n  3.hockey\n  4.javelin throw\n  5.EXIT\n");
    int num = i.nextInt();
     switch(num)
        {
            case 1:
            { 
              System.out.println("\nPARTICIPANTS OF TENNIS\n");
               tennis s1 = new tennis();
               s1.show_players();
                while(true){
                  System.out.println("\nEnter the number between 1 to 5 to edit list of participants");
                System.out.println(" 1.INSERT\n 2.DELETE\n 3.SEARCH\n 4.UPDATE\n 5.EXIT\n");
                int choice = i.nextInt();
              switch(choice)
                    {
//====================================================================================================================================
                      case 1:
                      Scanner input = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
              
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
              
                      String sqlquery="insert into tennis values(?,?,?) ";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                      System.out.println("ENTER ID :");
                      ps.setString(1,input.next());
                      System.out.println("ENTER NAME :");                   
                      ps.setString(2,input.next());
              
                      System.out.println("ENTER COUNTRY :");
                      ps.setString(3,input.next());
                      
                      int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("NEW ROW INSERTED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                                   break;
//====================================================================================================================================
                    case 2:
                    Scanner inp = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
                      System.out.println("ENTER ID TO DELETE PARTICIPANT:");
                      String id = inp.next();
                      String sqlquery="delete from tennis where ID = '"+id+"'";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                     // ps.setString(1,inp.next());
                     int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("ROW DELETED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                            break;
//====================================================================================================================================
                    case 3:
                     while(true){
                      System.out.println("ENTER THE OPTION YOU WANT TO SEARCH FOR\n");
                      System.out.println(" 1.SEARCH BY ID\n 2.SEARCH BY STRING\n 3.SEARCH BY PARTIAL STRINGS\n 4.EXIT\n");
                      Scanner in = new Scanner(System.in);
                      int sins = in.nextInt();
                    
                      switch(sins){
//========================================================
                        case 1:
                         try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String URL= "jdbc:mysql://localhost:3306/oops_project";
                            String USERNAME ="root";
                            String PASSWORD ="Bjr@2003";
                            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                            System.out.println("ENTER ID TO SEARCH :");
                            Scanner s = new Scanner(System.in);
                            String id=s.next();
                
                            String sqlquery="select * from tennis where ID = '"+id+"'";
                
                            Statement stmt = con.createStatement();
                            ResultSet result = stmt.executeQuery(sqlquery);
                            if(result.next()) 
                            {
                                String cid = result.getString("ID");
                                String cname = result.getString("NAME");
                                String ccountry = result.getString("COUNTRY");
                                System.out.println("...................................................\n");
                                System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                System.out.println("...................................................\n");
                
                            }
                            else{
                                System.out.println("\n\nNO RECORD FOUND");
                            }
                            }
                        catch(Exception e)
                        {
                            throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                        }
                             break;
//==================================================
                        case 2:
                        try{
                          Class.forName("com.mysql.cj.jdbc.Driver");
                          String URL= "jdbc:mysql://localhost:3306/oops_project";
                          String USERNAME ="root";
                          String PASSWORD ="Bjr@2003";
                          Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                          System.out.println("ENTER NAME TO SEARCH :");
                          Scanner s = new Scanner(System.in);
                          String NAME=s.next();
              
                          String sqlquery="select * from tennis where NAME = ('"+NAME+"')";
              
                          Statement stmt = con.createStatement();
                          ResultSet result = stmt.executeQuery(sqlquery);
                          if(result.next()) 
                          {
                              String cid = result.getString("ID");
                              String cname = result.getString("NAME");
                              String ccountry = result.getString("COUNTRY");
                              System.out.println("...................................................\n");
                              System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                              System.out.println("...................................................\n");
              
                          }
                          else{
                              System.out.println("\n\nNO RECORD FOUND");
                          }
                          }
                      catch(Exception e)
                      {
                          throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                      }
                           break;
 //===========================================================
                      case 3:

                      try {
                        
                        Scanner s = new Scanner(System.in);
                        System.out.println("enter the partial country name:");
                        String game = s.next();
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
                        Statement stmt1 = con.createStatement();
                       
                        ResultSet rs = stmt1.executeQuery("select * from tennis where COUNTRY like '" + '%' + game + '%' + "';");
                        System.out.println("------------------------------------------------------");
                        System.out.printf("|%8s|%20s|%10s|\n","ID","Name","country");
                        System.out.println("------------------------------------------------------");
                        while (rs.next()) {
                          System.out.printf("|%8s|%20s|%10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
                          System.out.println("------------------------------------------------------");
                        }
                        con.close();
                      } catch (Exception e) {
                        System.out.println(e);
            }
                    break;
                //======================================================
                        case 4:
                         System.out.println("YAY.. YOU ARE EXIT\n");
                          break;
                          default:
                         {
                           System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                         }
                      }
                      if(sins == 4){
                        break;
                      }
                     }
                    break;
//====================================================================================================================================  
                   case 4:
                    Scanner sin = new Scanner(System.in);
                    try
                    {
                    Class.forName( "com.mysql.cj.jdbc.Driver");
                    String URL="jdbc:mysql://localhost:3306/oops_project";
                    String USERNAME="root";
                    String PASSWORD="Bjr@2003";
                    Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                    System.out.println("ENTER NAME TO CHANGE THEIR ID :");
                    String namee=sin.next();
                    System.out.println("ENTER NEW ID :");
                    String idd=sin.next();
                   String sqlquery ="update tennis set ID = '"+idd+"' where NAME = '"+namee+"' ";
                   PreparedStatement ps =con.prepareStatement(sqlquery);
                   int rows = ps.executeUpdate();
                   if(rows >0)
                    {
                        System.out.println("SUCCESSFULLY UPDATED");
                    }
                    String sqlquery2="select * from tennis";
                    Statement stmt = con.createStatement();
                    ResultSet result = stmt.executeQuery(sqlquery2);
                   /*  while(result.next())
                    {
                        String cid = result.getString("ID");
                        String cname=result.getString("NAME");
                        String ccountry=result.getString("COUNTRY");
                        System.out.println("----------------------------------------------");
                        System.out.printf("|ID = %7s |NAME = %15s |COUNTRY = %11s |\n",cid,cname,ccountry);
                        System.out.println("----------------------------------------------");
                        
                    }*/
                    }
                    catch(Exception e)
                    {
                        throw new RuntimeException("!!!!  SOMETHING WENT WRONG !!!!!!");
                    }
                     break;
//====================================================================================================================================
                    case 5:
                    System.out.println("\nYAY.. YOU ARE EXIT\n");
                     break;
                    }
                  if(choice == 5){
                    break;
                  }
                }
                break;
            }
//=======================================================================================================================================================================
////====================================================================================================================================    
            case 2:
            { 
              System.out.println("\nPARTICIPANTS OF BADMINTON\n");
               sports sl2 = new badminton();
                extracted(sl2);
                while(true){
                  System.out.println("\nEnter the number between 1 to 5 to edit list of participants");
                  System.out.println("  1.INSERT\n  2.DELETE\n 3.SEARCH\n 4.UPDATE\n 5.EXIT\n");
                int choice = i.nextInt();
              switch(choice)
                    {
                      case 1:
                      Scanner input = new Scanner(System.in);
                    try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
                       Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
                      String sqlquery="insert into badminton values(?,?,?) ";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                      System.out.println("ENTER ID :");
                      ps.setString(1,input.next());
                      System.out.println("ENTER NAME :");                   
                      ps.setString(2,input.next());
              
                      System.out.println("ENTER COUNTRY :");
                      ps.setString(3,input.next());
                      
                      int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("NEW ROW INSERTED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                                   break;

                    case 2:
                    Scanner inp = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
                      System.out.println("ENTER ID TO DELETE PARTICIPANT:");
                      String id = inp.next();
                      String sqlquery="delete from badminton where ID = "+id+"";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                
                     int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("ROW DELETED SUCCESSFULLY");
                      }
                     }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                            break;
                     case 3:
                            while(true){
                             System.out.println("ENTER THE OPTION YOU WANT TO SEARCH FOR\n");
                             System.out.println(" 1.SEARCH BY ID\n 2.SEARCH BY STRING\n 3.SEARCH BY PARTIAL STRINGS\n 4.EXIT");
                             Scanner in = new Scanner(System.in);
                             int sins = in.nextInt();
                           
                             switch(sins){
                               case 1:
                                try{
                                   Class.forName("com.mysql.cj.jdbc.Driver");
                                   String URL= "jdbc:mysql://localhost:3306/oops_project";
                                   String USERNAME ="root";
                                   String PASSWORD ="Bjr@2003";
                                   Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                   System.out.println("ENTER ID TO SEARCH :");
                                   Scanner s = new Scanner(System.in);
                                   String id=s.next();
                       
                                   String sqlquery="select * from badminton where ID = '"+id+"'";
                       
                                   Statement stmt = con.createStatement();
                                   ResultSet result = stmt.executeQuery(sqlquery);
                                   if(result.next()) 
                                   {
                                       String cid = result.getString("ID");
                                       String cname = result.getString("NAME");
                                       String ccountry = result.getString("COUNTRY");
                                       System.out.println("...................................................\n");
                                       System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                       System.out.println("...................................................\n");
                       
                                   }
                                   else{
                                       System.out.println("\n\nNO RECORD FOUND");
                                   }
                                   }
                               catch(Exception e)
                               {
                                   throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                               }
                                    break;
                               case 2:
                                    try{
                                      Class.forName("com.mysql.cj.jdbc.Driver");
                                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                                      String USERNAME ="root";
                                      String PASSWORD ="Bjr@2003";
                                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                      System.out.println("ENTER NAME TO SEARCH :");
                                      Scanner s = new Scanner(System.in);
                                      String NAME=s.next();
                          
                                      String sqlquery="select * from badminton where NAME = '"+NAME+"'";
                          
                                      Statement stmt = con.createStatement();
                                      ResultSet result = stmt.executeQuery(sqlquery);
                                      if(result.next()) 
                                      {
                                          String cid = result.getString("ID");
                                          String cname = result.getString("NAME");
                                          String ccountry = result.getString("COUNTRY");
                                          System.out.println("...................................................\n");
                                          System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                          System.out.println("...................................................\n");
                          
                                      }
                                      else{
                                          System.out.println("\n\nNO RECORD FOUND");
                                      }
                                      }
                                  catch(Exception e)
                                  {
                                      throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                                  }
                                       break;
             //===========================================================
                                  case 3:
            
                                  try {
                                    
                                    Scanner s = new Scanner(System.in);
                                    System.out.println("enter the partial country name:");
                                    String game = s.next();
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
                                    Statement stmt1 = con.createStatement();
                                   
                                    ResultSet rs = stmt1.executeQuery("select * from badminton where COUNTRY like '" + '%' + game + '%' + "';");
                                    System.out.println("------------------------------------------------------");
                                    System.out.printf("|%8s|%20s|%10s|\n","ID","Name","country");
                                    System.out.println("------------------------------------------------------");
                                    while (rs.next()) {
                                      System.out.printf("|%8s|%20s|%10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
                                      System.out.println("------------------------------------------------------");
                                    }
                                    con.close();
                                  } catch (Exception e) {
                                    System.out.println(e);
                        }
                                break;
                                case 4:
                                {
                                 System.out.println("\nYAY.. YOU ARE EXIT\n");   
                                 break; 
                                }
                                default:
                                {
                                  System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                                }
                                            break;
                             }
                             if(sins == 4){
                               break;
                             }
       
                                  break;
                             }
                             
                            
                                  case 4:
                                 Scanner sin = new Scanner(System.in);
                                 try
                                 {
                                 Class.forName( "com.mysql.cj.jdbc.Driver");
                                 String URL="jdbc:mysql://localhost:3306/oops_project";
                                 String USERNAME="root";
                                 String PASSWORD="Bjr@2003";
                                 Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                 System.out.println("ENTER NAME TO CHANGE THEIR ID :");
                                 String namee=sin.next();
                                 System.out.println("ENTER NEW ID :");
                                 String idd=sin.next();
                                String sqlquery ="update badminton set ID = '"+idd+"' where NAME = '"+namee+"' ";
                                PreparedStatement ps =con.prepareStatement(sqlquery);
                                int rows = ps.executeUpdate();
                                if(rows >0)
                                 {
                                     System.out.println("SUCCESSFULLY UPDATED");
                                 }
                                 String sqlquery2="select * from badminton";
                                 Statement stmt = con.createStatement();
                                 ResultSet result = stmt.executeQuery(sqlquery2);
                                 while(result.next())
                                 {
                                     String cid = result.getString("ID");
                                     String cname=result.getString("NAME");
                                     String ccountry=result.getString("COUNTRY");
                                     System.out.println("----------------------------------------------");
                                     System.out.printf("|ID = %7s |NAME = %15s |COUNTRY = %11s |\n",cid,cname,ccountry);
                                    System.out.println("----------------------------------------------");
                                 }
                                 }
                                 catch(Exception e)
                                 {
                                     throw new RuntimeException("!!!!  SOMETHING WENT WRONG !!!!!!");
                                 }
                    case 5:
                    System.out.println("\nYAY.. YOU ARE EXIT\n");
                     break;
                     default:
                      {
                        System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                        }
                    }
                  if(choice == 5){
                    break;
                  }
                }
                break;
            }
            case 3:
            { 
              System.out.println("\nPARTICIPANTS OF HOCKEY\n");
               hockey s3 = new hockey();
                s3.show_players();
                while(true){
                  System.out.println("\nEnter the number between 1 to 5 to edit list of participants");
                  System.out.println("  1.INSERT\n  2.DELETE\n 3.SEARCH\n 4.UPDATE\n 5.EXIT\n");
                int choice = i.nextInt();
              switch(choice)
                    {
                      case 1:
                      Scanner input = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
              
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
              
                      String sqlquery="insert into hockey values(?,?,?) ";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                      System.out.println("ENTER ID :");
                      ps.setString(1,input.next());
                      System.out.println("ENTER NAME :");                   
                      ps.setString(2,input.next());
              
                      System.out.println("ENTER COUNTRY :");
                      ps.setString(3,input.next());
                      
                      int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("NEW ROW INSERTED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                                   break;

                    case 2:
                    Scanner inp = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
                      System.out.println("ENTER ID TO DELETE PARTICIPANT:");
                      String id = inp.next();
                      String sqlquery="delete from hockey where ID = "+id+"";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                     // ps.setString(1,inp.next());
                      
                      int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("ROW DELETED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                            break;
                            case 3:
                            while(true){
                             System.out.println("ENTER THE OPTION YOU WANT TO SEARCH FOR\n");
                             System.out.println(" 1.SEARCH BY ID\n 2.SEARCH BY STRING\n 3.SEARCH BY PARTIAL STRINGS\n 4.EXIT");
                             Scanner in = new Scanner(System.in);
                             int sins = in.nextInt();
                           
                             switch(sins){
                               case 1:
                                try{
                                   Class.forName("com.mysql.cj.jdbc.Driver");
                                   String URL= "jdbc:mysql://localhost:3306/oops_project";
                                   String USERNAME ="root";
                                   String PASSWORD ="Bjr@2003";
                                   Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                   System.out.println("ENTER ID TO SEARCH :");
                                   Scanner s = new Scanner(System.in);
                                   String id=s.next();
                       
                                   String sqlquery="select * from hockey where ID = '"+id+"'";
                       
                                   Statement stmt = con.createStatement();
                                   ResultSet result = stmt.executeQuery(sqlquery);
                                   if(result.next()) 
                                   {
                                       String cid = result.getString("ID");
                                       String cname = result.getString("NAME");
                                       String ccountry = result.getString("COUNTRY");
                                       System.out.println("...................................................\n");
                                       System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                       System.out.println("...................................................\n");
                       
                                   }
                                   else{
                                       System.out.println("\n\nNO RECORD FOUND");
                                   }
                                   }
                               catch(Exception e)
                               {
                                   throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                               }
                                    break;
                              case 2:
                                    try{
                                      Class.forName("com.mysql.cj.jdbc.Driver");
                                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                                      String USERNAME ="root";
                                      String PASSWORD ="Bjr@2003";
                                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                      System.out.println("ENTER NAME TO SEARCH :");
                                      Scanner s = new Scanner(System.in);
                                      String NAME=s.next();
                          
                                      String sqlquery="select * from hockey where NAME = '"+NAME+"'";
                          
                                      Statement stmt = con.createStatement();
                                      ResultSet result = stmt.executeQuery(sqlquery);
                                      if(result.next()) 
                                      {
                                          String cid = result.getString("ID");
                                          String cname = result.getString("NAME");
                                          String ccountry = result.getString("COUNTRY");
                                          System.out.println("...................................................\n");
                                          System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                          System.out.println("...................................................\n");
                          
                                      }
                                      else{
                                          System.out.println("\n\nNO RECORD FOUND");
                                      }
                                      }
                                  catch(Exception e)
                                  {
                                      throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                                  }
                                       break;
             //===========================================================
                                  case 3:
            
                                  try {
                                    
                                    Scanner s = new Scanner(System.in);
                                    System.out.println("enter the partial country name:");
                                    String game = s.next();
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
                                    Statement stmt1 = con.createStatement();
                                   
                                    ResultSet rs = stmt1.executeQuery("select * from hockey where COUNTRY like '" + '%' + game + '%' + "';");
                                    System.out.println("------------------------------------------------------");
                                    System.out.printf("|%8s|%20s|%10s|\n","ID","Name","country");
                                    System.out.println("------------------------------------------------------");
                                    while (rs.next()) {
                                      System.out.printf("|%8s|%20s|%10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
                                      System.out.println("------------------------------------------------------");
                                    }
                                    con.close();
                                  } catch (Exception e) {
                                    System.out.println(e);
                        }
                      break;
                          
                                case 4:
                                {
                                 System.out.println("\nYAY.. YOU ARE EXIT\n");   
                                 break; 
                                }
                                default:
                                {
                                  System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                                }
                                            break;
                             }
                             if(sins == 4){
                               break;
                             }
                                           break;
                              }
                            break;
                           case 4:
                                 Scanner sin = new Scanner(System.in);
                                 try
                                 {
                                 Class.forName( "com.mysql.cj.jdbc.Driver");
                                 String URL="jdbc:mysql://localhost:3306/oops_project";
                                 String USERNAME="root";
                                 String PASSWORD="Bjr@2003";
                                 Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                 System.out.println("ENTER NAME TO CHANGE THEIR ID :");
                                 String namee=sin.next();
                                 System.out.println("ENTER NEW ID :");
                                 String idd=sin.next();
                                String sqlquery ="update hockey set ID = '"+idd+"' where NAME = '"+namee+"' ";
                                PreparedStatement ps =con.prepareStatement(sqlquery);
                                int rows = ps.executeUpdate();
                                if(rows >0)
                                 {
                                     System.out.println("SUCCESSFULLY UPDATED");
                                 }
                                 String sqlquery2="select * from hockey";
                                 Statement stmt = con.createStatement();
                                 ResultSet result = stmt.executeQuery(sqlquery2);
                                 while(result.next())
                                 {
                                     String cid = result.getString("ID");
                                     String cname=result.getString("NAME");
                                     String ccountry=result.getString("COUNTRY");
                                     System.out.println("----------------------------------------------");
                                     System.out.printf("|ID = %7s |NAME = %15s |COUNTRY = %11s |\n",cid,cname,ccountry);
                                     System.out.println("----------------------------------------------");
                                 }
                                 }
                                 catch(Exception e)
                                 {
                                     throw new RuntimeException("!!!!  SOMETHING WENT WRONG !!!!!!");
                                 }   
                    case 5:
                    System.out.println("\nYAY.. YOU ARE EXIT\n");
                     break;
                     default:
                     {
                       System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                     }
                    }
                  if(choice == 5){
                    break;
                  }
                }
                break;
            }
            case 4:
            { 
              System.out.println("\nPARTICIPANTS OF JAVELIN THROW\n");
               javelinthrow s4 = new javelinthrow();
                s4.show_players();
                while(true){
                  System.out.println("\nEnter the number between 1 to 5 to edit list of participants");
                  System.out.println("  1.INSERT\n  2.DELETE\n 3.SEARCH\n 4.UPDATE\n 5.EXIT\n");
                int choice = i.nextInt();
              switch(choice)
                    {
                      case 1:
                      Scanner input = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
              
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
              
                      String sqlquery="insert into javelinthrow values(?,?,?) ";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                      System.out.println("ENTER ID :");
                      ps.setString(1,input.next());
                      System.out.println("ENTER NAME :");                   
                      ps.setString(2,input.next());
              
                      System.out.println("ENTER COUNTRY :");
                      ps.setString(3,input.next());
                      
                      int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("NEW ROW INSERTED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                                   break;

                    case 2:
                    Scanner inp = new Scanner(System.in);

                      try{
                      Class.forName("com.mysql.cj.jdbc.Driver");                     
                      String URL= "jdbc:mysql://localhost:3306/oops_project";
                      String USERNAME ="root";
                      String PASSWORD ="Bjr@2003";
                      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);                
                      System.out.println("ENTER ID TO DELETE PARTICIPANT:");
                      String id = inp.next();
                      String sqlquery="delete from javelinthrow where ID = "+id+"";
                      PreparedStatement ps = con.prepareStatement(sqlquery);                 
                     // ps.setString(1,inp.next());
                      
                      int rows= ps.executeUpdate();                              
                      if(rows>0)
                      {
                          System.out.println("ROW DELETED SUCCESSFULLY");
                      }
                  }
                      catch(Exception e){
                          throw new RuntimeException("SOME ERROR OCCURED !!!!!!!!!!!!!!");
                      }
                            break;
                            case 3:
                     while(true){
                      System.out.println("ENTER THE OPTION YOU WANT TO SEARCH FOR\n");
                      System.out.println(" 1.SEARCH BY ID\n 2.SEARCH BY STRING\n 3.SEARCH BY PARTIAL STRINGS\n 4.EXIT");
                      Scanner in = new Scanner(System.in);
                      int sins = in.nextInt();
                    
                      switch(sins){
                        case 1:
                         try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String URL= "jdbc:mysql://localhost:3306/oops_project";
                            String USERNAME ="root";
                            String PASSWORD ="Bjr@2003";
                            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                            System.out.println("ENTER ID TO SEARCH :");
                            Scanner s = new Scanner(System.in);
                            String id=s.next();
                
                            String sqlquery="select * from javelinthrow where ID = '"+id+"'";
                
                            Statement stmt = con.createStatement();
                            ResultSet result = stmt.executeQuery(sqlquery);
                            if(result.next()) 
                            {
                                String cid = result.getString("ID");
                                String cname = result.getString("NAME");
                                String ccountry = result.getString("COUNTRY");
                                System.out.println("...................................................\n");
                                System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                System.out.println("...................................................\n");
                
                            }
                            else{
                                System.out.println("\n\nNO RECORD FOUND");
                            }
                            }
                        catch(Exception e)
                        {
                            throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                        }
                             break;
                             case 2:
                             try{
                               Class.forName("com.mysql.cj.jdbc.Driver");
                               String URL= "jdbc:mysql://localhost:3306/oops_project";
                               String USERNAME ="root";
                               String PASSWORD ="Bjr@2003";
                               Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                               System.out.println("ENTER NAME TO SEARCH :");
                               Scanner s = new Scanner(System.in);
                               String NAME=s.next();
                   
                               String sqlquery="select * from javelinthrow where NAME = '"+NAME+"'";
                   
                               Statement stmt = con.createStatement();
                               ResultSet result = stmt.executeQuery(sqlquery);
                               if(result.next()) 
                               {
                                   String cid = result.getString("ID");
                                   String cname = result.getString("NAME");
                                   String ccountry = result.getString("COUNTRY");
                                   System.out.println("...................................................\n");
                                   System.out.printf("ID = %s\n NAME = %s\n COUNTRY = %s\n",cid,cname,ccountry);
                                   System.out.println("...................................................\n");
                   
                               }
                               else{
                                   System.out.println("\n\nNO RECORD FOUND");
                               }
                               }
                           catch(Exception e)
                           {
                               throw new RuntimeException("SOMETHING WENT WRONG!!!!!!!!!!!");
                           }
                                break;
      //===========================================================
                           case 3:
     
                           try {
                             
                             Scanner s = new Scanner(System.in);
                             System.out.println("enter the partial country name:");
                             String game = s.next();
                             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops_project", "root", "Bjr@2003");
                             Statement stmt1 = con.createStatement();
                            
                             ResultSet rs = stmt1.executeQuery("select * from javelinthrow where COUNTRY like '" + '%' + game + '%' + "';");
                             System.out.println("------------------------------------------------------");
                             System.out.printf("|%8s|%20s|%10s|\n","ID","Name","country");
                             System.out.println("------------------------------------------------------");
                             while (rs.next()) {
                               System.out.printf("|%8s|%20s|%10s|\n", rs.getString(1), rs.getString(2), rs.getString(3));
                               System.out.println("------------------------------------------------------");
                             }
                             con.close();
                           } catch (Exception e) {
                             System.out.println(e);
                 }
                         break;
                         case 4:
                         {
                          System.out.println("\nYAY.. YOU ARE EXIT\n");   
                          break; 
                         }
                         default:
                         {
                           System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                         }
                                     break;
                      }
                      if(sins == 4){
                        break;
                      }

                     }
                           break;
                                  case 4:
                                 Scanner sin = new Scanner(System.in);
                                 try
                                 {
                                 Class.forName( "com.mysql.cj.jdbc.Driver");
                                 String URL="jdbc:mysql://localhost:3306/oops_project";
                                 String USERNAME="root";
                                 String PASSWORD="Bjr@2003";
                                 Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                                 System.out.println("ENTER NAME TO CHANGE THEIR ID :");
                                 String namee=sin.next();
                                 System.out.println("ENTER NEW ID :");
                                 String idd=sin.next();
                                String sqlquery ="update javelinthrow set ID = '"+idd+"' where NAME = '"+namee+"' ";
                                PreparedStatement ps =con.prepareStatement(sqlquery);
                                int rows = ps.executeUpdate();
                                if(rows >0)
                                 {
                                     System.out.println("SUCCESSFULLY UPDATED");
                                 }
                                 String sqlquery2="select * from javelinthrow";
                                 Statement stmt = con.createStatement();
                                 ResultSet result = stmt.executeQuery(sqlquery2);
                                 while(result.next())
                                 {
                                     String cid = result.getString("ID");
                                     String cname=result.getString("NAME");
                                     String ccountry=result.getString("COUNTRY");
                                     System.out.println("----------------------------------------------");
                                     System.out.printf("|ID = %7s |NAME = %15s |COUNTRY = %11s |\n",cid,cname,ccountry);
                                     System.out.println("----------------------------------------------");
                                 }
                                 }
                                 catch(Exception e)
                                 {
                                     throw new RuntimeException("!!!!  SOMETHING WENT WRONG !!!!!!");
                                 }   
                    case 5:
                    System.out.println("\nYAY.. YOU ARE EXIT\n");
                     break;
                    default:
                     {
                       System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
                     }
                    }
                  if(choice == 5){
                    break;
                  }
                }
                break;
            }
            case 5:
            {
             System.out.println("\nYAY.. YOU ARE EXIT\n");   
             break; 
            }
            default:
            {
              System.out.println("\n============== ERROR!! PLEASE ENTER VALID NUMBER ==============\n");
            }
        }
        if(num==5)
        {
          break;
        }
      }
    }
  }

    private static void extracted(sports sl2) {
      sl2.show_players();
    }
}