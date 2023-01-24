package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.util.*;


import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.integration.*;

/**
 * This is the applications only controller. All calls to the model pass through this class
 *
 */
public class Controller {   
    private Sale sale; 
    private ExternalInventorySystem externelInventorySystem = new ExternalInventorySystem(); 
    private ExternalAccountingSystem externelAccountingSystem;
    private double change; 
    private Printer printer;
    private Receipt receipt; 
    private StoreAddress storeAddress; 
    Payment Payment = new Payment();
    private LogWriter log = new LogWriter(); 
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    /**
     * Start a new sale. This method must be called before doing anything else 
     * during a sale. 
    */
    public void startSale(){
        sale = new Sale();
        sale.addRevenueObservers(revenueObservers);
    }
   
    
    /**
     * ScanItems.Adds a scanned item to the current sale. 
     * @param itemIdentifier. A number or bar code that represents a specific item.
     * @param quantity
     * @return Returns the information about the item and it is not in inventory it returns null.  
     * @throws se.kth.iv1350.pos.integration.ItemNotFoundInInventoryException throws an exception If an item with the item identifier is not found in external inventory system.
     * @throws se.kth.iv1350.pos.integration.DatabaseServerNotRunning throws database failure exception when a search is made for a particular, hard coded,item identifier.
     */
    public ItemInformationDTO scanItem (String itemIdentifier, int quantity) throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        ItemInformationDTO itemInfo;
        try{
            itemInfo = externelInventorySystem.getItemInfomation(itemIdentifier, quantity); 
            }
        
        catch (ItemNotFoundInInventoryException exception) {
            throw exception; 
            }
       
        catch (DatabaseServerNotRunning exception) {
            log.log(exception);
            throw exception; 
            }

        sale.additem(itemInfo);
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
     * @param amountPayed This is the amount payed by the customer.
     * @return this method gets the change that is needed to give to the customer. 
     */
    public double registerPayment (double amountPayed){ 
         double totalAmount = sale.registerPayment(amountPayed);
        change = Payment.changeToGiveCustomer(totalAmount, amountPayed);
        return change; 
    }

    /**
     * Ends the sale process.
     * 
     */
    public void endSale(){
    }

     /**
     * updates the external inventory system. 
     * @param sale Has the information about the current sale.. 
     */
    public void updateInventorySystem(Sale sale){
        externelInventorySystem.updateInventory(sale);
    }
    
     /**
     * @return This method returns the Total amount of the entire sale. 
     */
    public double totalAmount(){
        return sale.getTotalAmount(); 
    }

    /**
     * updates the external accounting system. 
     * @param sale Has the information about the current sale. 
     */
    public void updateAccountingSystem(Sale sale){
        externelAccountingSystem.updateExternalAccountingSystem(sale);
    }
   

    /**
     * this methods is used for getting the necessary information in receipt. 
     * @param sale  Has the information about the current sale
     * @param storeAddress Address of the store
     * @param Payment Information about the change and payment. 
     * @return
     */
    public Receipt getReceipt(Sale sale, StoreAddress storeAddress, Payment Payment){
         return new Receipt(sale, storeAddress, Payment); 
    }

    
    /**
     * This method prints out the receipt. 
     */
    public void printReceipt(){
        receipt = getReceipt(sale, storeAddress, Payment); 
        printer.printReceipt(receipt);
    }
    
    /**
     * Adds observers to a list.
     * @param revenueObserver 
     */
    public void addRevenueObserver(RevenueObserver revenueObserver) {
        revenueObservers.add(revenueObserver);
    }
}
    
