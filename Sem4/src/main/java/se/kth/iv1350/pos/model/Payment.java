
package se.kth.iv1350.pos.model;


public class Payment {
    private Sale sale;
    private double payedAmount;
    private double changeForTheCostumer;
    
    /**
     * Creates an instance of the class payment
     * 
     */
    
    public Payment() {
   
    }
    /**
     *  This method counts how much money to the costumer should get back.
     * @param total the total amount.
     * @param payedAmount the amount that was payed
     * @return the change to give back.
     */
     public double changeToGiveCustomer(double total, double payedAmount){
        changeForTheCostumer =  payedAmount - total; 
        return changeForTheCostumer; 
    }
    
}
