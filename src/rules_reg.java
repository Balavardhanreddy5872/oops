package App;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;
import java.sql.*;


interface printrules
{
  void print();
  void insert();
  void update();
  void delete();
}

class olympics {
  
    void rules()
    {
        System.out.println("OLYMPIC INSERT");
    }
  
}
class hockey extends olympics implements printrules {

    public static Connection con= null;
    void rules()
    {
      System.out.println("INSIDE HOCKEY AFTER POLYMORPHISMMMM");
    }

  
    public void insert()
    {
        System.out.println("IN METHOD INSERTRULE");
    
        try{
          System.out.println("enteredddddddddd");
          Class.forName( "com.mysql.cj.jdbc.Driver");
          String URL="jdbc:mysql://localhost:3306/oops_project";
          String USERNAME="root";
          String PASSWORD="Bjr@2003";
          con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Scanner input1 = new Scanner(System.in);
            String sqlquery="insert into hockeyrules(rules) values(6,?) ";
            PreparedStatement ps = con.prepareStatement(sqlquery);                 // CREATING PLATFORM TO EXECUTE QUERY
            System.out.println("ENTER NEW RULE :");
            ps.setString(1,input1.next());
          
            
            int rows= ps.executeUpdate();                              
            if(rows>0)
            {
                System.out.println("NEW ROW INSERTED SUCCESSFULLY");
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(".........SOME ERROR OCCURED......");
        }
    
    }
    
    
    public void update()
    {
        System.out.println("IN METHOD UPDATERULE");
        
       try{ 
        Class.forName( "com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://localhost:3306/oops_project";
        String USERNAME="root";
        String PASSWORD="Saipavan$$03";
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    
    
        Scanner input1=new Scanner(System.in);
        String oldrule;
        System.out.println("\nENTER EXISTING RULE U WISH TO UPDATE:");
        oldrule =input1.next();
    
            
          String sqlquery1=" update hockeyrules set rules=? where rules =('"+oldrule+"') ";
          PreparedStatement ps1 =con.prepareStatement(sqlquery1);
            System.out.println("ENTER NEW RULE :");
            ps1.setString(1,input1.next());
          
            int rows1 = ps1.executeUpdate();
            if(rows1 >0)
             {
                 System.out.println("SUCCESSFULLY UPDATED");
             }
            }
            catch(Exception e)
            {
                throw new RuntimeException("SOME ERROR!!!!!!!");
            }
        
    }
     
    public void delete()
    
    {
        System.out.println("IN METHOD DELETERULE");
        Scanner input3= new Scanner(System.in);
      
      try
    {  
      Class.forName( "com.mysql.cj.jdbc.Driver");
      String URL="jdbc:mysql://localhost:3306/oops_project";
      String USERNAME="root";
      String PASSWORD="Saipavan$$03";
      con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String OLD;
        System.out.println("\nENTER EXISTING RULE U WISH TO DELETE:");
        OLD=input3.next();
        
        String sqlquery2 ="delete from hockeyrules where rules=('"+OLD+"')  ";
        Statement stmt = con.createStatement();
        int rows2 = stmt.executeUpdate(sqlquery2);
        if(rows2>0)
        {
            System.out.println("..............SUCCESSFULLY DELETED.........");
        }
    }
    catch(Exception e)
    {
        throw new RuntimeException(".............ERROR..........");
    }
    
    }
   
    public void print()
    {
        System.out.println("\n  IN METHOD PRINTRULES");
      try{
        Class.forName( "com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://localhost:3306/oops_project";
        String USERNAME="root";
        String PASSWORD="Saipavan$$03";
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String sqlquery2="select * from hockeyrules";
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sqlquery2);
        System.out.println("\n ...................................................");
        while(result.next())
        {
            String rul = result.getString("rules");
            int num=result.getInt("number");
           
            System.out.printf("rules =%s ",rul);
            System.out.println("\n ...................................................");
        }
        
    
      }
      catch(Exception e)
      {
        throw new RuntimeException(".......SOME ERROR IN PRINTRULES BLOCK.......");
      }
    }
}

class badminton extends olympics implements printrules{

    public static Connection con= null;

   
    public void insert()
    {
        System.out.println("IN METHOD INSERTRULE");
    
        try{
          Class.forName( "com.mysql.cj.jdbc.Driver");
          String URL="jdbc:mysql://localhost:3306/oops_project";
          String USERNAME="root";
          String PASSWORD="Saipavan$$03";
          con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Scanner input1 = new Scanner(System.in);
            String sqlquery="insert into badmintonrules(rules) values(?) ";
            PreparedStatement ps = con.prepareStatement(sqlquery);                 // CREATING PLATFORM TO EXECUTE QUERY
            System.out.println("ENTER NEW RULE :");
            ps.setString(1,input1.next());
          /*   System.out.println("ENTER CUSTOMER STREET :");                    // EXECUTONG QUERY
            ps.setString(2,input1.next());
    
            System.out.println("ENTER CUSTOMER CITY :");
            ps.setString(3,input1.next());*/
            
            int rows= ps.executeUpdate();                              
            if(rows>0)
            {
                System.out.println("NEW ROW INSERTED SUCCESSFULLY");
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(".........SOME ERROR OCCURED......");
        }
    
    }
   
    public void update()
    {
        System.out.println("IN METHOD UPDATERULE");
        
       try{ 
        Class.forName( "com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://localhost:3306/oops_project";
        String USERNAME="root";
        String PASSWORD="Saipavan$$03";
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    
    
        Scanner input1=new Scanner(System.in);
        String oldrule;
        System.out.println("\nENTER EXISTING RULE U WISH TO UPDATE:");
        oldrule =input1.next();
    
            
          String sqlquery1=" update badmintonrules set rules=? where rules =('"+oldrule+"') ";
          PreparedStatement ps1 =con.prepareStatement(sqlquery1);
            System.out.println("ENTER NEW RULE :");
            ps1.setString(1,input1.next());
          
            int rows1 = ps1.executeUpdate();
            if(rows1 >0)
             {
                 System.out.println("SUCCESSFULLY UPDATED");
             }
            }
            catch(Exception e)
            {
                throw new RuntimeException("SOME ERROR!!!!!!!");
            }
        
    }
    
    public void delete()
    
    {
        System.out.println("IN METHOD DELETERULE");
        Scanner input3= new Scanner(System.in);
      
      try
    {  
      Class.forName( "com.mysql.cj.jdbc.Driver");
      String URL="jdbc:mysql://localhost:3306/oops_project";
      String USERNAME="root";
      String PASSWORD="Saipavan$$03";
      con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String OLD;
        System.out.println("\nENTER EXISTING RULE U WISH TO DELETE:");
        OLD=input3.next();
        
        String sqlquery2 ="delete from badmintonrules where rules=('"+OLD+"')  ";
        Statement stmt = con.createStatement();
        int rows2 = stmt.executeUpdate(sqlquery2);
        if(rows2>0)
        {
            System.out.println("..............SUCCESSFULLY DELETED.........");
        }
    }
    catch(Exception e)
    {
        throw new RuntimeException(".............ERROR..........");
    }
    
    }
   
    public void print()
    {
        System.out.println("\n  IN METHOD PRINTRULES");
      try{
        Class.forName( "com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://localhost:3306/oops_project";
        String USERNAME="root";
        String PASSWORD="Saipavan$$03";
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String sqlquery2="select * from badmintonrules";
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sqlquery2);
        System.out.println("\n ...................................................");
        while(result.next())
        {
            String rul = result.getString("rules");
            int num=result.getInt("number");
           
            System.out.printf("rules =%s ",rul);
            System.out.println("\n ...................................................");
        }
        
    
      }
      catch(Exception e)
      {
        throw new RuntimeException(".......SOME ERROR IN PRINTRULES BLOCK.......");
      }
    }
}


class longjump extends olympics implements printrules{

     public static Connection con= null;
     
   
     
    
    public void insert()
    {
        System.out.println("IN METHOD INSERTRULE");
    
        try{
          Class.forName( "com.mysql.cj.jdbc.Driver");
          String URL="jdbc:mysql://localhost:3306/oops_project";
          String USERNAME="root";
          String PASSWORD="Saipavan$$03";
          con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Scanner input1 = new Scanner(System.in);
            String sqlquery="insert into longjump(rules) values(?) ";
            PreparedStatement ps = con.prepareStatement(sqlquery);                 // CREATING PLATFORM TO EXECUTE QUERY
            System.out.println("ENTER NEW RULE :");
            ps.setString(1,input1.next());
       
            
            int rows= ps.executeUpdate();                              
            if(rows>0)
            {
                System.out.println("NEW ROW INSERTED SUCCESSFULLY");
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(".........SOME ERROR OCCURED......");
        }
    
    }
     
    public void update()
    {
        System.out.println("IN METHOD UPDATERULE");
        
       try{ 
        Class.forName( "com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://localhost:3306/oops_project";
        String USERNAME="root";
        String PASSWORD="Saipavan$$03";
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    
    
        Scanner input1=new Scanner(System.in);
        String oldrule;
        System.out.println("\nENTER EXISTING RULE U WISH TO UPDATE:");
        oldrule =input1.next();
    
            
          String sqlquery1=" update longjumprules set rules=? where rules =('"+oldrule+"') ";
          PreparedStatement ps1 =con.prepareStatement(sqlquery1);
            System.out.println("ENTER NEW RULE :");
            ps1.setString(1,input1.next());
          
            int rows1 = ps1.executeUpdate();
            if(rows1 >0)
             {
                 System.out.println("SUCCESSFULLY UPDATED");
             }
            }
            catch(Exception e)
            {
                throw new RuntimeException("SOME ERROR!!!!!!!");
            }
        
    }
  
    
    public void delete()
    
    {
        System.out.println("IN METHOD DELETERULE");
        Scanner input3= new Scanner(System.in);
      
      try
    {  
      Class.forName( "com.mysql.cj.jdbc.Driver");
      String URL="jdbc:mysql://localhost:3306/oops_project";
      String USERNAME="root";
      String PASSWORD="Saipavan$$03";
      con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String OLD;
        System.out.println("\nENTER EXISTING RULE U WISH TO DELETE:");
        OLD=input3.next();
        
        String sqlquery2 ="delete from longjumprules where rules=('"+OLD+"')  ";
        Statement stmt = con.createStatement();
        int rows2 = stmt.executeUpdate(sqlquery2);
        if(rows2>0)
        {
            System.out.println("..............SUCCESSFULLY DELETED.........");
        }
    }
    catch(Exception e)
    {
        throw new RuntimeException(".............ERROR..........");
    }
    
    }
    public void print()
    {
        System.out.println("\n  IN METHOD PRINTRULES");
      try{
        Class.forName( "com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://localhost:3306/oops_project";
        String USERNAME="root";
        String PASSWORD="Saipavan$$03";
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String sqlquery2="select * from longjumprules";
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sqlquery2);
        System.out.println("\n ...................................................");
        while(result.next())
        {
            String rul = result.getString("rules");
            int num=result.getInt("number");
           
            System.out.printf(" number=%d \t rules =%s ",num,rul);
            System.out.println("\n ...................................................");
        }
        
    
      }
      catch(Exception e)
      {
        throw new RuntimeException(".......SOME ERROR IN PRINTRULES BLOCK.......");
      }
    }
}

public class rules_reg {


    public static Connection con= null;
    public static void main(String[] args)
        {
           
            hockey hockey = new hockey();
          badminton badminton = new badminton();
            longjump longjump = new longjump();
           
         

          
              try{       
                Class.forName( "com.mysql.cj.jdbc.Driver");
                String URL="jdbc:mysql://localhost:3306/oops_project";
                String USERNAME="root";
                String PASSWORD="Saipavan$$03";
                con = DriverManager.getConnection(URL,USERNAME,PASSWORD);  
                
                Scanner input = new Scanner(System.in);

                System.out.println("POLYMORPHISM :");
              
              
        
        
                System.out.println("\n1.HOCKEY");
                System.out.println("\n2.BADMINTON");
                System.out.println("\n3.LONGJUMP");
        
                System.out.println(" \nENTER YOUR CHOICE :");
        
                int var;
                var=input.nextInt();
        
                if(var==1)
                {
                  for(int i= 0 ;i<20 ;i++)
                  {
                  System.out.println("\n1.ADD NEW RULE");
                  System.out.println("\n2.UPDATE EXISTING RULE");
                  System.out.println("\n3.DELETE EXISTING RULE");
                  System.out.println("\n4. PRINT ALL RULES");
                  int num;
                  System.out.println("ENTER YOUR CHOICE :");
                  num=input.nextInt();
                  switch(num)
                  {
                      case 1:
                      hockey.insert();
          
                      break;
          
                      case 2:
                      hockey.update();
          
                      break;
                      case 3:
                      hockey.delete();
          
                      break;
                      case 4:
                      hockey.print();
                      break;
          
                      default:
                      System.out.println("\n ENTER VALID CHOICE");
                      break;
          
          
                  }
                  if(num==5)
                  {
                    break;
                  }
        
                }
              }
                else if(var==2)
                {
                  for(int i= 0 ;i<20 ;i++)
                  {
                  System.out.println("\n1.ADD NEW RULE");
                  System.out.println("\n2.UPDATE EXISTING RULE");
                  System.out.println("\n3.DELETE EXISTING RULE");
                  System.out.println("\n4. PRINT ALL RULES");
                  int num;
                  System.out.println("ENTER YOUR CHOICE :");
                  num=input.nextInt();
                  switch(num)
                  {
                    case 1:
                    badminton.insert();
        
                    break;
        
                    case 2:
                    badminton.update();
        
                    break;
                    case 3:
                    badminton.delete();
        
                    break;
                    case 4:
                   badminton.print();
                    break;
        
                    default:
                    System.out.println("\n ENTER VALID CHOICE");
                    break;
                  
          
                  }
                  if(num==5)
                  {
                    break;
                  }
                }
        
                }else if(var==3)
                {
                  for(int i=0 ;i<20 ;i++)
                  {
                  System.out.println("\n1.ADD NEW RULE");
                  System.out.println("\n2.UPDATE EXISTING RULE");
                  System.out.println("\n3.DELETE EXISTING RULE");
                  System.out.println("\n4. PRINT ALL RULES");
                  int num;
                  System.out.println("ENTER YOUR CHOICE :");
                  num=input.nextInt();
                  switch(num)
                  {
                      
                      case 1:
                     longjump.insert();
          
                      break;
          
                      case 2:
                      longjump.update();
          
                      break;
                      case 3:
                      longjump.delete();
          
                      break;
                      case 4:
                      longjump.print();
                      break;
          
                      default:
                      System.out.println("\n ENTER VALID CHOICE");
                      break;
          
                  }
                
                if(num==5)
                  {
                    break;
                  }
                }
                }
        
        
                
                    }
              catch(Exception e)
             {
                throw new RuntimeException("SOMETHING WENT WRONG !!!!!!");
             }
            }
        
            
        
    
}
