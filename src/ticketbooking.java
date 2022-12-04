
import java.sql.*;
import java.util.Scanner;
import java.lang.Math;



public class ticketbooking 
{
        private static Connection con = null;
    public static void main(String[] args )
    {
 

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/lab4";
        String username="root";
        String password="Saipavan$$03";
        
        Scanner input = new Scanner(System.in);

        con= DriverManager.getConnection(url,username, password);


       System.out.println("\t\t   WELCOME TO TICKET BOOKING PORTAL  ");

       System.out.println("\nALREADY EXISTING USER   \n \t\t 1.LOGIN");
       System.out.println("\n NEW USER\n\t\t 2.REGISTER");


       int n1;
       n1=input.nextInt();

       if(n1==1)
       {
        System.out.println("ENTER YOUR USERNAME :");
        String gusername=input.next();
        System.out.println("ENTER YOUR PASSWORD  :");
        String gpass =input.next();
        System.out.println("ENTER YOUR PHONENUMBER");
        String gpno=input.next();                //////////////
        int count=0;

        String sqlquery0="select * from users";
        Statement stmt0 = con.createStatement();
        ResultSet result0 = stmt0.executeQuery(sqlquery0);
      //  System.out.println("\n ........................................................................................................................................");
        while(result0.next())
        {
            String name = result0.getString("USERNAME");
            String pass=result0.getString("PASSWORD");
              if(name.equals(gusername) && pass.equals(gpass))
            {
              count++;
            }
       }
       if(count==0)
       {
        System.out.println("\nLOGIN FAILED.....INVALID DETAILS ENTERED....");
        System.out.println("\nREGISTER IF YOU ARE NEW USER");
       }

  else if(count==1)
    {
        System.out.println("\n LOGIN SUCCESSFULL");
    
     for(int i=0;i<30;i++){
       System.out.println("\n\t1.BOOK NEW TICKETS");
       System.out.println("\n\t2.SHOW RECENT BOOKINGS");
       System.out.println("\n\t3.CANCLE BOOKED TICKETS");
       System.out.println("\n\t 4.SEARCH FOR A MATCH AND BOOK");
       System.out.println("\n\t 5.SEARCH YOUR TICKET WITH BOOKING ID");
       System.out.println("\n\t 6.SEARCH FOR MATCHES WITH TICKETS AVAILABILITY");
       System.out.println("\n\t 7.EXIT");

       int n2;
       System.out.println("\n\tENTER YOUR CHOICE : ");
       n2=input.nextInt(); 
       if(n2==1)
       {
        System.out.println("\n\t ..........INSIDE BOOK NEW TICKET.............");
        System.out.println("\n\tENTER GAME THAT U WANT TO BOOK TICKET");
        System.out.println("\n1.HOCKEY");
        System.out.println("\n2.BADMINTON");
        System.out.println("\n3.TENNIS");
        System.out.println(" \nENTER YOUR CHOICE :");

        int num;
        num=input.nextInt();

        if(num==1)
        {
            System.out.println("..........HOCKEYMATCH TICKET BOOKING PORTAL..........");
            String sqlquery ="select * from hockeymatches";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sqlquery);
            System.out.println("\n ............................................................................................");
            while(result.next())
            {
                String dateofmatch = result.getString("DATEOFMATCH");
                String matchdetails=result.getString("matchdetails");
                int ticketsavailable = result.getInt("TICKETS_AVAILABLE");

               
                System.out.printf("\nDATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",dateofmatch ,matchdetails,ticketsavailable);
                System.out.println("\n .........................................................................................");
            }

            System.out.println("\nENTER DATE AND DETAILS OF MATCH THAT U WANT TO BOOK TICKET");
            System.out.println("\n\tTICKET PRICE =100");
            System.out.println("\nENTER DATE :");
            String gdate =input.next();
            System.out.println("\nENTER MATCH:");
            String gmatch=input.next();
            //System.out.println("ENTER YOUR NAME :");
            //String gname =input.next();
           // System.out.println("ENTER YOUR PHONE NUMBER :");
           // String gno =input.next();
            System.out.println("ENTER NO OF TICKETS :");
            int gtickets =input.nextInt();
            int total=gtickets*100;
            
            String sqlquery1= "insert into newviewer values(?,?,?,?,?,?,now(),?)";
            PreparedStatement ps = con.prepareStatement(sqlquery1); 
            int randid =(int)(Math.random()*(9999999-1000000+1)+1000000); 
            String id ="ID"+randid;
           
            ps.setString(1,id);
            ps.setString(2,gusername);
            ps.setString(3,gpno);
            ps.setString(4,gmatch);
            ps.setString(5,gdate);
            ps.setInt(6,gtickets);
            ps.setInt(7,total);
             
            int rand =(int)(Math.random()*(9999-1000+1)+1000);  
            System.out.println("CAPTCHA = "+rand);

    
            System.out.println("\nENTER THE CAPTCHA GIVEN FOR VERIFICATION :");
            int verify =input.nextInt();
            if(rand==verify)
            {

            
            int rows= ps.executeUpdate();       
            if(rows>0)
            {
                System.out.println(".............TICKET SUCCESSFULLY BOOKED.............");
            }   
        }else{
            System.out.println("\nINCORRECT CAPTCHA ENTERED \n TICKET BVOOKING FAILED");
        }   
            String sqlquery2="select * from newviewer";
            Statement stmt1 = con.createStatement();
            ResultSet result1 = stmt1.executeQuery(sqlquery2);
            System.out.println("\n \t.......................................................................");
            while(result1.next())
            {

            
                String name = result1.getString("name");
                String phone=result1.getString("phonenumber");
                String match = result1.getString("matchdetails");
               String datee=result1.getString("dateofmatch");
                int notickets =result1.getInt("ticketsbooked");
                String bid =result1.getString("BOOKING_ID");
                int tot = result1.getInt("TOTAL_AMOUNT");

                if(name.equals(gusername) && phone.equals(gpno)){
               
            // System.out.printf("\n BOOKING_ID =%s  \t  MATCHDETAILS =%s   \t DATEOFMATCH=%s   \n  \t             TICKETSBOOKED = %d \n NAME=%s  \t \t\t    PHONE=%s \n\t\t\t TOTAL AMOUNT = %d",id,match,datee,notickets,name,phone,tot);
            System.out.println("\n \t.......................................................................");
            System.out.printf("\n\t\t\t    BOOKING_ID=%s                       ",id);
            System.out.printf("\n\t\t\t    MATCHDETAILS=%s                    ",match);
            System.out.printf("\n\t\t\t    DATE_OF_MATCH=%s                   ",datee);
            System.out.printf("\n\t\t\t    NO_OF_TICKETS =%d                           ",notickets);
            System.out.printf("\n\t\t\t    NAME=%s                                    ",name);
            System.out.printf("\n\t\t\t    PHONE NUMBER =%s                   ",phone);
            System.out.printf("\n\t\t\t    TOTALAMOUNT=%d                            ",tot);
           System.out.println("\n\t ...........................................................................");
                
            
            String sqlquery4 ="UPDATE hockeymatches set TICKETS_AVAILABLE=TICKETS_AVAILABLE-? WHERE (DATEOFMATCH =? && MATCHDETAILS=? ) ";
            PreparedStatement ps1 = con.prepareStatement(sqlquery4);
            ps1.setInt(1,notickets);
            ps1.setString(2,datee);
            ps1.setString(3,match);
            int k=ps1.executeUpdate();
            if(k>0)
            {
            System.out.println("\nSUCCESSFULLY UPDATED TICKETS COUNT IN HOCKEYMATCHES TABLE");
            }
                }
            }







        }else if(num==2)
        {
            System.out.println("..........BADMINTONMATCHES TICKET BOOKING PORTAL..........");
            String sqlquery ="select * from badmintonmatches";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sqlquery);
            System.out.println("\n ............................................................................................");
            while(result.next())
            {
                String dateofmatch = result.getString("DATEOFMATCH");
                String matchdetails=result.getString("matchdetails");
                int ticketsavailable = result.getInt("TICKETS_AVAILABLE");

               
                System.out.printf("\nDATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",dateofmatch ,matchdetails,ticketsavailable);
                System.out.println("\n .........................................................................................");
            }

            System.out.println("\nENTER DATE AND DETAILS OF MATCH THAT U WANT TO BOOK TICKET");
            System.out.println("\n\tTICKET PRICE =100");
            System.out.println("\nENTER DATE :");
            String gdate =input.next();
            System.out.println("\nENTER MATCH:");
            String gmatch=input.next();
            //System.out.println("ENTER YOUR NAME :");
            //String gname =input.next();
           // System.out.println("ENTER YOUR PHONE NUMBER :");
           // String gno =input.next();
            System.out.println("ENTER NO OF TICKETS :");
            int gtickets =input.nextInt();
            int total=gtickets*100;
            
            String sqlquery1= "insert into newviewer values(?,?,?,?,?,?,now(),?)";
            PreparedStatement ps = con.prepareStatement(sqlquery1); 
            int randid =(int)(Math.random()*(9999999-1000000+1)+1000000); 
            String id ="ID"+randid;
           
            ps.setString(1,id);
            ps.setString(2,gusername);
            ps.setString(3,gpno);
            ps.setString(4,gmatch);
            ps.setString(5,gdate);
            ps.setInt(6,gtickets);
            ps.setInt(7,total);
             
            int rand =(int)(Math.random()*(9999-1000+1)+1000);  
            System.out.println("CAPTCHA = "+rand);

    
            System.out.println("\nENTER THE CAPTCHA GIVEN FOR VERIFICATION :");
            int verify =input.nextInt();
            if(rand==verify)
            {

            
            int rows= ps.executeUpdate();       
            if(rows>0)
            {
                System.out.println(".............TICKET SUCCESSFULLY BOOKED.............");
            }   
        }else{
            System.out.println("\nINCORRECT CAPTCHA ENTERED \n TICKET BVOOKING FAILED");
        }   
            String sqlquery2="select * from newviewer";
            Statement stmt1 = con.createStatement();
            ResultSet result1 = stmt1.executeQuery(sqlquery2);
            System.out.println("\n \t.......................................................................");
            while(result1.next())
            {

            
                String name = result1.getString("name");
                String phone=result1.getString("phonenumber");
                String match = result1.getString("matchdetails");
               String datee=result1.getString("dateofmatch");
                int notickets =result1.getInt("ticketsbooked");
                String bid =result1.getString("BOOKING_ID");
                int tot = result1.getInt("TOTAL_AMOUNT");

                if(name.equals(gusername) && phone.equals(gpno)){
               
            // System.out.printf("\n BOOKING_ID =%s  \t  MATCHDETAILS =%s   \t DATEOFMATCH=%s   \n  \t             TICKETSBOOKED = %d \n NAME=%s  \t \t\t    PHONE=%s \n\t\t\t TOTAL AMOUNT = %d",id,match,datee,notickets,name,phone,tot);
            System.out.println("\n \t.......................................................................");
            System.out.printf("\n\t\t\t    BOOKING_ID=%s                       ",id);
            System.out.printf("\n\t\t\t    MATCHDETAILS=%s                    ",match);
            System.out.printf("\n\t\t\t    DATE_OF_MATCH=%s                   ",datee);
            System.out.printf("\n\t\t\t    NO_OF_TICKETS =%d                           ",notickets);
            System.out.printf("\n\t\t\t    NAME=%s                                    ",name);
            System.out.printf("\n\t\t\t    PHONE NUMBER =%s                   ",phone);
            System.out.printf("\n\t\t\t    TOTALAMOUNT=%d                            ",tot);
           System.out.println("\n\t ...........................................................................");
                
            
            String sqlquery4 ="UPDATE badmintonmatches set TICKETS_AVAILABLE=TICKETS_AVAILABLE-? WHERE (DATEOFMATCH =? && MATCHDETAILS=? ) ";
            PreparedStatement ps1 = con.prepareStatement(sqlquery4);
            ps1.setInt(1,notickets);
            ps1.setString(2,datee);
            ps1.setString(3,match);
            int k=ps1.executeUpdate();
            if(k>0)
            {
            System.out.println("\nSUCCESSFULLY UPDATED TICKETS COUNT IN BADMINTONMATCHES TABLE");
            }
                }
            }







        }
        else if(num==3)
        {
            System.out.println("..........TENNIS TICKET BOOKING PORTAL..........");
            String sqlquery ="select * from tennismatches";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sqlquery);
            System.out.println("\n ............................................................................................");
            while(result.next())
            {
                String dateofmatch = result.getString("DATEOFMATCH");
                String matchdetails=result.getString("matchdetails");
                int ticketsavailable = result.getInt("TICKETS_AVAILABLE");

               
                System.out.printf("\nDATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",dateofmatch ,matchdetails,ticketsavailable);
                System.out.println("\n .........................................................................................");
            }

            System.out.println("\nENTER DATE AND DETAILS OF MATCH THAT U WANT TO BOOK TICKET");
            System.out.println("\n\tTICKET PRICE =100");
            System.out.println("\nENTER DATE :");
            String gdate =input.next();
            System.out.println("\nENTER MATCH:");
            String gmatch=input.next();
            //System.out.println("ENTER YOUR NAME :");
            //String gname =input.next();
           // System.out.println("ENTER YOUR PHONE NUMBER :");
           // String gno =input.next();
            System.out.println("ENTER NO OF TICKETS :");
            int gtickets =input.nextInt();
            int total=gtickets*100;
            
            String sqlquery1= "insert into newviewer values(?,?,?,?,?,?,now(),?)";
            PreparedStatement ps = con.prepareStatement(sqlquery1); 
            int randid =(int)(Math.random()*(9999999-1000000+1)+1000000); 
            String id ="ID"+randid;
           
            ps.setString(1,id);
            ps.setString(2,gusername);
            ps.setString(3,gpno);
            ps.setString(4,gmatch);
            ps.setString(5,gdate);
            ps.setInt(6,gtickets);
            ps.setInt(7,total);
             
            int rand =(int)(Math.random()*(9999-1000+1)+1000);  
            System.out.println("CAPTCHA = "+rand);

    
            System.out.println("\nENTER THE CAPTCHA GIVEN FOR VERIFICATION :");
            int verify =input.nextInt();
            if(rand==verify)
            {

            
            int rows= ps.executeUpdate();       
            if(rows>0)
            {
                System.out.println(".............TICKET SUCCESSFULLY BOOKED.............");
            }   
        }else{
            System.out.println("\nINCORRECT CAPTCHA ENTERED \n TICKET BVOOKING FAILED");
        }   
            String sqlquery2="select * from newviewer";
            Statement stmt1 = con.createStatement();
            ResultSet result1 = stmt1.executeQuery(sqlquery2);
            System.out.println("\n \t.......................................................................");
            while(result1.next())
            {

            
                String name = result1.getString("name");
                String phone=result1.getString("phonenumber");
                String match = result1.getString("matchdetails");
               String datee=result1.getString("dateofmatch");
                int notickets =result1.getInt("ticketsbooked");
                String bid =result1.getString("BOOKING_ID");
                int tot = result1.getInt("TOTAL_AMOUNT");

                if(name.equals(gusername) && phone.equals(gpno)){
               
            // System.out.printf("\n BOOKING_ID =%s  \t  MATCHDETAILS =%s   \t DATEOFMATCH=%s   \n  \t             TICKETSBOOKED = %d \n NAME=%s  \t \t\t    PHONE=%s \n\t\t\t TOTAL AMOUNT = %d",id,match,datee,notickets,name,phone,tot);
            System.out.println("\n \t.......................................................................");
            System.out.printf("\n\t\t\t    BOOKING_ID=%s                       ",id);
            System.out.printf("\n\t\t\t    MATCHDETAILS=%s                    ",match);
            System.out.printf("\n\t\t\t    DATE_OF_MATCH=%s                   ",datee);
            System.out.printf("\n\t\t\t    NO_OF_TICKETS =%d                           ",notickets);
            System.out.printf("\n\t\t\t    NAME=%s                                    ",name);
            System.out.printf("\n\t\t\t    PHONE NUMBER =%s                   ",phone);
            System.out.printf("\n\t\t\t    TOTALAMOUNT=%d                            ",tot);
           System.out.println("\n\t ...........................................................................");
                
            
            String sqlquery4 ="UPDATE tennismatches set TICKETS_AVAILABLE=TICKETS_AVAILABLE-? WHERE (DATEOFMATCH =? && MATCHDETAILS=? ) ";
            PreparedStatement ps1 = con.prepareStatement(sqlquery4);
            ps1.setInt(1,notickets);
            ps1.setString(2,datee);
            ps1.setString(3,match);
            int k=ps1.executeUpdate();
            if(k>0)
            {
            System.out.println("\nSUCCESSFULLY UPDATED TICKETS COUNT IN TENNISMATCHES TABLE");
            }
                }
            }







        }
        else{

        }

       }
    
      /*  else {
                  System.out.println("....INVALID DETAILS...LOGIN FAILED....");
       }*/
       if(n2==2)
       {

        System.out.println("\n\t..............INSIDE SHOW RECENT BOOKINGS...........");

        String sqlquery4="select * from newviewer";
        Statement stmt4 = con.createStatement();
        ResultSet result4 = stmt4.executeQuery(sqlquery4);
        System.out.println("\n ........................................................................................................................................");
      
        while(result4.next())
        {
            String name = result4.getString("name");
            String phone=result4.getString("phonenumber");
            String match4 = result4.getString("matchdetails");
            String datee4=result4.getString("dateofmatch");
            int notickets4 =result4.getInt("ticketsbooked");   
            int totall = result4.getInt("TOTAL_AMOUNT");  
            if(name.equals(gusername) && phone.equals(gpno))
            {

                System.out.printf("\n MATCHDETAILS =%s\n DATEOFMATCH=%s \nTICKETSBOOKED = %d \n NAME=%s \nPHONE=%s \nTOTAL AMOUNT = %d",match4,datee4,notickets4,name,phone,totall);
                System.out.println("\n ...................................................................................................................................");    
            }
       }






       }
       if(n2==3)
       {

        System.out.println("...........INSIDE CANCLE BOOKED TICKETS PORTAL ..............");

        System.out.println("\n\t    ........YOUR RECENT BOOKINGS............ ");

        String sqlquery5="select * from newviewer";
        Statement stmt5 = con.createStatement();
        ResultSet result5 = stmt5.executeQuery(sqlquery5);
        System.out.println("\n ........................................................................................................................................");
      
        while(result5.next())
        {
            String name = result5.getString("name");
            String phone=result5.getString("phonenumber");
            String match4 = result5.getString("matchdetails");
            String datee4=result5.getString("dateofmatch");
            int notickets4 =result5.getInt("ticketsbooked");   
            int totall = result5.getInt("TOTAL_AMOUNT");    
            String bid =result5.getString("BOOKING_ID");
            if(name.equals(gusername) && phone.equals(gpno))
            {

                System.out.printf("\n BOOKING_ID=%s \nMATCHDETAILS =%s\n DATEOFMATCH=%s   \nTICKETSBOOKED = %d \n NAME=%s\nPHONE=%s\nTOTAL_AMOUNT= %d",bid,match4,datee4,notickets4,name,phone,totall);
                System.out.println("\n ...................................................................................................................................");    
            }
       }

       System.out.println("ENTER BOOKING ID TO CANCLE YOUR TICKETS  :");
       String ebid=input.next();
       String sqlquery7="select * from newviewer where BOOKING_ID=('"+ebid+"')";
       Statement stmt8 = con.createStatement();
       ResultSet result55 = stmt8.executeQuery(sqlquery7);
       System.out.println("\n ........................................................................................................................................");
       if(result55.next())
       {
        String name111 = result55.getString("name");
        String phone111=result55.getString("phonenumber");
        String match4111 = result55.getString("matchdetails");
        String datee4111=result55.getString("dateofmatch");
        int notickets4111 =result55.getInt("ticketsbooked");   
        int totall111 = result55.getInt("TOTAL_AMOUNT");    
        String bid111 =result55.getString("BOOKING_ID");
      
      String sqlquery11="insert into cancelled values(?,?,?,?,?,now(),'CANCELLED')";
      PreparedStatement ps = con.prepareStatement(sqlquery11);
      ps.setString(1,ebid);
      ps.setString(2,name111);
      ps.setString(3,phone111);
      ps.setInt(4,notickets4111);
      ps.setInt(5,totall111);
      int rows= ps.executeUpdate();                              
        if(rows>0)
        {
            System.out.println("CANCELLATION SUCCESSFUL");
        }
      
     }


       String sqlquery6= "delete from newviewer where BOOKING_ID ='"+ebid+"' ";
       Statement stmt9 = con.createStatement();
       int rows2 = stmt9.executeUpdate(sqlquery6);



    
       



       }
       if(n2==4)
       {
        System.out.println("SEARCH FOR A GAME (enter atleast three letters to search ) :");
        String ser ;
        ser=input.next();
        String sqlquery="select * from tennismatches where matchdetails like CONCAT('%','"+ser+"','%') UNION ALL select * from hockeymatches where matchdetails like  CONCAT('%','"+ser+"','%')  UNION ALL select * from badmintonmatches where matchdetails like  CONCAT('%','"+ser+"','%') ";
 
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sqlquery);
        
         while(result.next())                   
             {
                 String Sport =result.getString("Sport");
                 String dateofmatch = result.getString("DATEOFMATCH");
                 String matchdetails=result.getString("matchdetails");
                 int ticketsavailable = result.getInt("TICKETS_AVAILABLE");
 
                
                 System.out.printf("\n SPORT =%s  \t DATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",Sport,dateofmatch ,matchdetails,ticketsavailable);
                 System.out.println("\n .........................................................................................");
             }
             System.out.println("ENTER SPORT:");
             String spt =input.next();
             System.out.println("ENTER DATE:");
             String dat =input.next();
          
             System.out.println("\nENTER MATCH:");
             String gmatch=input.next();
             System.out.println("ENTER NO OF TICKETS :");
             int tic =input.nextInt();
      
            if(spt.equals("TENNIS")) 
            {
              String sql="UPDATE  tennismatches set TICKETS_AVAILABLE=TICKETS_AVAILABLE-? WHERE DATEOFMATCH ='"+dat+"' ";
            
              PreparedStatement ps =con.prepareStatement(sql);
             ps.setInt(1,tic);
              int rows = ps.executeUpdate();
      
              ps.setInt(1,tic);
             if(rows >0)
              {
                  System.out.println("SUCCESSFULLY UPDATED");
              }
              String sqlq ="insert into newviewer values";
            }
            if(spt.equals("HOCKEY")) 
            {
              String sql="UPDATE hockeymatches set TICKETS_AVAILABLE=TICKETS_AVAILABLE-? WHERE DATEOFMATCH ='"+dat+"' ";
            
              PreparedStatement ps =con.prepareStatement(sql);
             ps.setInt(1,tic);
              int rows = ps.executeUpdate();
      
              ps.setInt(1,tic);
             if(rows >0)
              {
                  System.out.println("SUCCESSFULLY UPDATED");
              }
            }
      
            if(spt.equals("BADMINTON")) 
            {
              String sql="UPDATE badmintonmatches set TICKETS_AVAILABLE=TICKETS_AVAILABLE-? WHERE DATEOFMATCH ='"+dat+"' ";
            
              PreparedStatement ps =con.prepareStatement(sql);
             ps.setInt(1,tic);
              int rows = ps.executeUpdate();
      
              ps.setInt(1,tic);
             if(rows >0)
              {
                  System.out.println("SUCCESSFULLY UPDATED");
              }
            }
         
          
            //System.out.println("ENTER YOUR NAME :");
            //String gname =input.next();
           // System.out.println("ENTER YOUR PHONE NUMBER :");
           // String gno =input.next();
          
            int total=tic*100;
            
            String sqlquery1= "insert into newviewer values(?,?,?,?,?,?,now(),?)";
            PreparedStatement ps = con.prepareStatement(sqlquery1); 
            int randid =(int)(Math.random()*(9999999-1000000+1)+1000000); 
            String id ="ID"+randid;
           
            ps.setString(1,id);
            ps.setString(2,gusername);
            ps.setString(3,gpno);
            ps.setString(4,gmatch);
            ps.setString(5,dat);
            ps.setInt(6,tic);
            ps.setInt(7,total);
             
            int rand =(int)(Math.random()*(9999-1000+1)+1000);  
            System.out.println("CAPTCHA = "+rand);

    
            System.out.println("\nENTER THE CAPTCHA GIVEN FOR VERIFICATION :");
            int verify =input.nextInt();
            if(rand==verify)
            {

            
            int rows= ps.executeUpdate();       
            if(rows>0)
            {
                System.out.println(".............TICKET SUCCESSFULLY BOOKED.............");
            }   
        }else{
            System.out.println("\nINCORRECT CAPTCHA ENTERED \n TICKET BVOOKING FAILED");
        } 
      
      
 
       }
       if(n2==5)
       {
        System.out.println("INSIDE SEARCH TICKET WITH BOOKING ID ");

        System.out.println("\n\tENTER BOOKING ID :");
        String bid=input.next();
        String sqll ="select * from newviewer where BOOKING_ID = ('"+bid+"')";
        Statement stmt1 = con.createStatement();
        ResultSet result1 = stmt1.executeQuery(sqll);
        System.out.println("\n \t.......................................................................");
        while(result1.next())
        {

        
            String name = result1.getString("name");
            String phone=result1.getString("phonenumber");
            String match = result1.getString("matchdetails");
           String datee=result1.getString("dateofmatch");
            int notickets =result1.getInt("ticketsbooked");
            String bidd =result1.getString("BOOKING_ID");
            int tot = result1.getInt("TOTAL_AMOUNT");

            if(name.equals(gusername) && phone.equals(gpno)){
           
        // System.out.printf("\n BOOKING_ID =%s  \t  MATCHDETAILS =%s   \t DATEOFMATCH=%s   \n  \t             TICKETSBOOKED = %d \n NAME=%s  \t \t\t    PHONE=%s \n\t\t\t TOTAL AMOUNT = %d",id,match,datee,notickets,name,phone,tot);
        System.out.println("\n \t.......................................................................");
        System.out.printf("\n\t\t\t    BOOKING_ID=%s                       ",bid);
        System.out.printf("\n\t\t\t    MATCHDETAILS=%s                    ",match);
        System.out.printf("\n\t\t\t    DATE_OF_MATCH=%s                   ",datee);
        System.out.printf("\n\t\t\t    NO_OF_TICKETS =%d                           ",notickets);
        System.out.printf("\n\t\t\t    NAME=%s                                    ",name);
        System.out.printf("\n\t\t\t    PHONE NUMBER =%s                   ",phone);
        System.out.printf("\n\t\t\t    TOTALAMOUNT=%d                            ",tot);
       System.out.println("\n\t ...........................................................................");
            
            
            }
        }
       }

       if(n2==6)
       {
        System.out.println("\n\tINSIDE SEARCH MATCHES WITH AVAILABILITY OF TICKETS ");
        System.out.println("ENTER NO OF TICKETS U WANT :");
       
        int tick =input.nextInt();

      //  System.out.println("ENTER SPORT :");
       // String game =input.next();
       // String sqlquery="select * from tennismatches where TICKETS_AVAILABLE > 50 UNION ALL select * from hockeymatches where  where TICKETS_AVAILABLE > 50 UNION ALL select * from badmintonmatches where  TICKETS_AVAILABLE >  50";
      
       String sqlquery ="select * from tennismatches where TICKETS_AVAILABLE > "+tick;
       Statement stmt = con.createStatement();
       ResultSet result = stmt.executeQuery(sqlquery);
        
        
       while(result.next())                   
       {
           String Sport =result.getString("Sport");
           String dateofmatch = result.getString("DATEOFMATCH");
           String matchdetails=result.getString("matchdetails");
           int ticketsavailable = result.getInt("TICKETS_AVAILABLE");

          
           System.out.printf("\n SPORT =%s  \t DATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",Sport,dateofmatch ,matchdetails,ticketsavailable);
           System.out.println("\n .........................................................................................");
       }
       String sqlquery1 ="select * from hockeymatches where TICKETS_AVAILABLE > "+tick;
       Statement stmt1 = con.createStatement();
       ResultSet result1 = stmt1.executeQuery(sqlquery1);
       while(result1.next())                   
       {
           String Sport =result1.getString("Sport");
           String dateofmatch = result1.getString("DATEOFMATCH");
           String matchdetails=result1.getString("matchdetails");
           int ticketsavailable = result1.getInt("TICKETS_AVAILABLE");

          
           System.out.printf("\n SPORT =%s  \t DATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",Sport,dateofmatch ,matchdetails,ticketsavailable);
           System.out.println("\n .........................................................................................");
       }
       String sqlquery2 ="select * from badmintonmatches where TICKETS_AVAILABLE > "+tick;
    
       Statement stmt2 = con.createStatement();
       ResultSet result2 = stmt2.executeQuery(sqlquery2);
            while(result2.next())                   
             {
                 String Sport =result2.getString("Sport");
                 String dateofmatch = result2.getString("DATEOFMATCH");
                 String matchdetails=result2.getString("matchdetails");
                 int ticketsavailable = result2.getInt("TICKETS_AVAILABLE");
 
                
                 System.out.printf("\n SPORT =%s  \t DATE OF MATCH = %s  \t  MATCHDETAILS = %s  \t TICKETS_AVAILABLE =%d",Sport,dateofmatch ,matchdetails,ticketsavailable);
                 System.out.println("\n .........................................................................................");
             }

       }else if(n2==7 )
       {
          
          break;
       }

    } //
       
    }


       }
       else if(n1==2)
       {

        System.out.println("INSIDE REGISTRATION MODULE");

        System.out.println("ENTER USERNAME :");
        String newusername=input.next();
        System.out.println("ENTER PASSWORD :");
        String newuserpassword1=input.next();
        System.out.println("RE-ENTER PASSWORD :");
        String newuserpassword2=input.next();
        if(newuserpassword1.equals(newuserpassword2))
        {
            
           String sqlquery="insert into users values(?,?,now()) ";
           PreparedStatement ps = con.prepareStatement(sqlquery);   
           ps.setString(1,newusername)  ;
           ps.setString(2,newuserpassword1);
           int rows= ps.executeUpdate();                              
           if(rows>0)
           { 
            System.out.println("\n............REGISTRATION SUCCESSFULL ........");
            System.out.println("\n...SWITCH TO LOGIN PAGE TO ENTER BOOKING PORTAL..");
           }
           

        }
        else
        {
            System.out.println("\n..PASSWORD SETUP FAILED..");

        }
       } 
        }
        catch(Exception e)
        {
            throw new RuntimeException("!!!!!SOMETHING ERROR !!!!");
        }


    }


    
}