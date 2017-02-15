import java.sql.Date;
import java.util.Arrays;


public class Main {
  
  public static void main(String args[]) {
    String augend = "4:00:00";
    String addend = "5:13";

    Timestamp start = new Timestamp(augend);
    Timestamp duration = new Timestamp(addend); 
    
    Timestamp current = start.add(duration);
    
    System.out.println(current);
  }
}

class Timestamp {
  private int hours;
  private int minutes;
  private int seconds;
  
  public Timestamp(String raw) {
    String[] times = raw.split(":");
    if (times.length == 3) {
      hours = Integer.valueOf(times[0]);
      minutes = Integer.valueOf(times[1]);
      seconds = Integer.valueOf(times[2]);
    } else {
      minutes = Integer.valueOf(times[0]);
      seconds = Integer.valueOf(times[1]);
    }
  }
  
  public Timestamp(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }
  
  public Timestamp add(Timestamp other) {
    int totalHours = 0;
    int totalMinutes = 0;
    int totalSeconds = 0;
    
    totalSeconds = seconds + other.seconds;
    int plusMinutes = totalSeconds / 60;
    if (plusMinutes > 0) {
      totalSeconds = totalSeconds % 60;
    }
      
    totalMinutes = plusMinutes + minutes + other.minutes;
    int plusHours = totalMinutes / 60;
    if (plusHours > 0) {
      totalMinutes = totalMinutes % 60;
    }
    
    totalHours = plusHours + hours + other.hours;
    
    if (totalHours > 12) {
      totalHours -= 12;
    }
    return new Timestamp(totalHours, totalMinutes, totalSeconds);
  }
  
  public String toString() {
    String formatted = "";
    formatted = hours + ":";
    if (minutes < 10) {
      formatted += "0";
    }
    formatted += minutes + ":";
    if (seconds < 10) {
      formatted = formatted + "0";
    }
    formatted += seconds + "";
    return formatted;
  }
}