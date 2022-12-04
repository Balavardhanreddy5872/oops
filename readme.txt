	                   
                               INTERNATIONAL OLYMPIC MANAGMENT SYSTEM 


Overview

* Features: The user will be able to input a lot of data such as (but not limited to):
  Participants , Tournaments ,Medals, Operator, Rules and Regulations.
  
* Player specific data (Nationality, Id, participating sport) 
  • Medal Leaderboard 
  • Events/Sports (Timetables, who is participating, tournament name and ID, etc.) 
  • Inserting/Removing/Changing who is participating (Name, Id, Country, etc.) 
  • Score tracking of each game 
  • Results overall => determines who gets the medal 
  • Database Relational Mangement usage

* -> This application will work as how an Olympic Games is organized.
  -> The general purpose of this program is to input specific data and have that data be used in methods
     that will compile them into one section. For example, the scores of the game will determine 
     who will get the gold,silver, and bronze medal. 
  -> The data will automatically compile things such as participants that are playing in the same event, 
     the winners of each event, and the overall scores. In the end, it would display everything that was 
     inputted.

Usage 

* Currently can only be run using java but there are future plans to extend this program to run on other
  platforms/languages. Java is required to run & compile this program.

Technologies

* Project is designed with:
  1.vs_code 
  2.MySQL Connector/J ver. 8.0.21

Database_Setup 

* A MySQL database is required to use this program on your machine. After creating a database schema you
  must change two lines of code in Connect.java Line 12: String url must be changed to your hosting 
  address or to localhost if you're only running it on your local machine. Line 13: String path must to
  changed to your local path file name.

Sqlqueries 

* 1.By using sql queries update/insert/delete values from sports schedules for each sport 
  2.Insert participants in different sports .
  3.delete matches from sports schedule.
  4. also use sql queries for priniting medals .

* sql files 
   
-> 	1.Participants :-
            Badminton.csv
            Hockey.csv
            javelien_throw.csv
            Tennies.csv

   2. Tournments :-
             badminton_qualified_schedule.csv       
             badminton_qualified_schedule_1.csv     
             badminton_qualified_schedule_2.csv    
             badminton_schedule.csv                 
             hockey_qualified_schedule.csv          
             hockey_qualified_schedule_1.csv        
             hockey_qualified_schedule_2.csv       
             hockey_schedule.csv                   
             javelin_throw.csv                     
             javelin_throw_qualified_schedule.csv   
             javelin_throw_qualified_schedule_1.csv 
             javelin_throw_qualified_schedule_2.csv 
             javelin_throw_schedule.csv             
             tennies.csv                            
             tennies_qualified_schedule_1.csv       
             tennies_qualified_schedule_2.csv       
             tennies_schedule.csv                   
             tennis.csv                             
             tennis_qualified_schedule.csv                                                
   
   3. TotalMEDALS:-
             country.csv
             goldmedals.csv
             bronzemedals.csv 

Java source file 

 participants.java
 Tournment.java
 operator.java

 PACKAGES    :Medalswon.java
SUBPACKAGES  :1.search.java
              2.CSV1.java 
 Rules_and_Regulations.java

How To run the code ??

1. First run the participants.java then will see the players of different sports , can search 
   different players based on country, id can use partial strings too. then select one from different 
   options given in code .
2. Next run tournment.java can see four sports select one sport and search different matches based on 
   given options in the code 
3. To print the medals won run medalswon.java select print leaderboard to display medals won by each
   country
4. with the options available select between 1 to 9 for further implementation
5. run rulesand regulations.java 
   