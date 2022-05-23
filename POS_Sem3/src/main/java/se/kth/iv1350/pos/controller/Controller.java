package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;


/**
 * This is the applications's only controller. All calls to the model pass through this class
 *
 */
public class Controller {
    private Sale sale;
    private ExternalInventorySystem externalinventorySystem = new ExternalInventorySystem();
    private ExternalAccountingSystem externalAccountingSystem;
    private Payment payment = new Payment();
    private double change;
    private Receipt receipt;
    private Printer printer;
     private StoreAddress storeAddress; 

    /**
     * Starts a new sale. This method must be called first before doing anything else during a sale
     */
    public void startSale () {
        sale = new Sale();
    }
      /**
     * ScanItems. Adds a scanned item to the current sale. 
     * @param itemIdentifier. A number or bar code that represents a specific item.
     * @return Returns the information about the item and it is not in inventory it returns null.   
     */
    public ItemInformationDTO scanItem (String itemIdentifier, int quantity){
        ItemInformationDTO itemInfo =  sale.addItem(itemIdentifier, quantity);
        return itemInfo; 
    }

       /**
     * gets the current sale running total
     * @return the currents sale running total. 
     */
    public double runningTotal (){
        double runningTotal = sale.countRunningTotal();
        return runningTotal;
    }
    
     /**
     * @return This method returns the Total amount of the entire sale. 
     */
    public double totalAmount(){
        return sale.getTotalAmount(); 
    }
    
    /**
     * This method get the change that is needed to give to the customer
     * @param amountPayedByCostumer The amount payed by the customer 
     * @return the money to give back to the costumer.
     */
    public double registerPayment(double amountPayedByCostumer) {
        change = payment.changeToGiveCustomer(sale, amountPayedByCostumer);
        return change;
    }

/**
     * Ends the sale process.
     * 
     *
     */
    public void endSale() {
   
    }
    /**
     * Method that get the receipt.
     * @param sale has the information about the sale.
     * @param storeaddress the address of the store.
     * @param payment the amount needed to pay.
     * @return 
     */
    public Receipt getReceipt (Sale sale, StoreAddress storeaddress, Payment payment) {
           return receipt;
    }
    /**
     * prints out the receipt 
     */
     public void printReceipt(){
        receipt = getReceipt(sale, storeAddress, payment); 
        printer.printReceipt(receipt);
    }
     /**
      * updates the external inventory system
      * @param sale has the information about the sale
      */ 
    public void updateInventorySystem (Sale sale) {
        externalinventorySystem.updateInventory(sale);
    }
    /**
     * Updates the external accounting system
     * @param sale has the information about the sale
     */
    public void updateAccountingSystem(Sale sale) {
        externalAccountingSystem.updateExternalAccountingSystem(sale);
    }
    
}