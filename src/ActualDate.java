import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class ActualDate {    
	
  String getDate() {
	  
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   
   return (String)dtf.format(now);
  }    
} 