
public class Main {
  
  public static void main(String args[]) {
    String augend = "12:59:59";
    String addend = "0:02";
    Timestamp start = new Timestamp(augend);
    Timestamp duration = new Timestamp(addend); 
    Timestamp current = start.add(duration);
    System.out.println(current);
  }
}

class Timestamp {
  private static final int SECONDS_PER_MINUTE = 60;
  private static final int MINUTES_PER_HOUR = 60;
  private static final int HOURS_PER_CYCLE = 12;  
  private int hours;
  private int minutes;
  private int seconds;
  
  public Timestamp(String raw) {
    String[] times = raw.split(":");
    if (times.length == 3) {
      hours = Integer.valueOf(times[0]);
      minutes = Integer.valueOf(times[1]);
      seconds = Integer.valueOf(times[2]);
    } else if (times.length == 2) {
      minutes = Integer.valueOf(times[0]);
      seconds = Integer.valueOf(times[1]);
    } else {
      seconds = Integer.valueOf(raw);
    }
  }
  
  public Timestamp(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;

  }
  
  public Timestamp add(Timestamp other) {    
    int totalSeconds = seconds + other.seconds;
    int rolloverMinute = totalSeconds / SECONDS_PER_MINUTE;
    totalSeconds %= SECONDS_PER_MINUTE;
    
    int totalMinutes = rolloverMinute + minutes + other.minutes;
    int rolloverHour = totalMinutes / MINUTES_PER_HOUR;
    totalMinutes %= MINUTES_PER_HOUR;
    
    int totalHours = rolloverHour + hours + other.hours;
    totalHours %= HOURS_PER_CYCLE;
    
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