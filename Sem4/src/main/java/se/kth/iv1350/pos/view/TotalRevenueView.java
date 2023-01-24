package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    
    private double totalRevenue;
    
    public TotalRevenueView() {
        totalRevenue = 0;
    }
    /**
     *  prints the total revenue to the console/view.
     * @param totalPrice the total price of the entire sale
     */
    @Override
     public void completedSale (double totalPrice) {
         
         totalRevenue = totalRevenue + totalPrice;
         System.out.println("Total Revenue generated: " +  totalRevenue);
         
    
    }
    
}
