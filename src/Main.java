package App;
import java.util.*;


public class project {
  public static void main(String[] args) throws Exception{
    Scanner s= new Scanner(System.in);
    String a=s.nextLine();
    switch(a){
        case "1":{
            App.main();
        }
        case "2":{
            participants.main();
        }
        case "3":{
            TOURNMENT.main();
        }
        case "4":{
            Medalswon.main();
        }
        
    
        default :{
            System.out.println("s");
        }
    }
  }  
}
