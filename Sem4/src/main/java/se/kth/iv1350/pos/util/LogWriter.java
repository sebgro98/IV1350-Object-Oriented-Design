package se.kth.iv1350.pos.util;

public class LogWriter {
    public void log(Exception exception){
        System.out.println("LOG ENTRY | " + exception.getMessage()
        + " | "
        + java.time.LocalDateTime.now()
        + "\nEND LOG\n--------\n");     
    }
}