package se.kth.iv1350.pos.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.pos.model.RevenueObserver;

public class TotalRevenueFileOutput implements RevenueObserver {
    private static final String REVENUE_FILE_NAME = "total-revenue.txt";
    private double totalRevenue;
    private PrintWriter revenueFile;
    
    /**
     * Writes the total revenue to file.
     */
    public TotalRevenueFileOutput() {
        totalRevenue = 0;
        try {
            revenueFile = new PrintWriter(new FileWriter(REVENUE_FILE_NAME), true);
        } catch (IOException e) {
            System.out.println("Could not create revenue file");
            e.printStackTrace();
        }
    }

    /** 
     * Adds the price of a new sale to the total revenue and prints it to a file.
     * @param totalPrice - the price to be added.
     */
    @Override
    public void completedSale(double totalPrice) {
        totalRevenue += totalPrice;
        printRevenue();
    }
    
    private void printRevenue() {
        revenueFile.println("Total Revenue " + totalRevenue);
    }
}



