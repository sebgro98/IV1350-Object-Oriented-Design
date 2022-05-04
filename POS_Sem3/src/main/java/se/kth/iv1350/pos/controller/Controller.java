package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.ItemInformationDTO;
import se.kth.iv1350.pos.model.Payment;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.StoreAddress;


/**
 * This is the applications's only controller. All calls to the model pass through this class
 *
 */
public class Controller {
    private Sale sale;
    private ExternalInventorySystem externalinventorySystem = new ExternalInventorySystem(); 
    private ExternalAccountingSystem externalAccountingSystem; 
    private boolean itemCheck;
    private Payment payment;
    private double change;
    private Receipt receipt;
    private Printer printer;

    /**
     * Starts a new sale. This method must be called first before doing anything else during a sale
     */
    public void startSale () {
        sale = new Sale();
    }
    /**
     *  This method calls for checkIfItemAlreadyRegistered has been registered or not.
     * @param ItemIdentifier a barcode of an item that is being scanned.
     * @return if the item has already been registered or not.
     */
    public boolean itemAlreadyRegistered (String ItemIdentifier) {
        Sale registretionInfo = new Sale();
        itemCheck = registretionInfo.checkIfItemAlreadyRegistered(ItemIdentifier);
        return itemCheck;
    }
    
    /**
     *  This method calls for externalinventorysystem to get information about the item that is getting scanned
     * @param itemIdentifier A barcode that represents a specific item
     * @param itemQuantity Number of that item
     * @return returns information about that said item or null if it doesn't exist.
     */
    public ItemInformationDTO getItemInfo (String itemIdentifier) {
        ItemInformationDTO itemInfo = externalinventorySystem.getItemInfomation(itemIdentifier);
        itemCheck = itemAlreadyRegistered(itemIdentifier);
        sale.addItem(itemInfo, itemCheck);
            return itemInfo;
    }
    /**
     * 
     * @return This method returns the TotalAmount of the entire sale.
     */
    
    public double runningTotal() {
        return sale.getTotalAmount();
    }
    /**
     * This method get the change that is needed to give to the customer
     * @param amountPayedByCostumer The amount payed by the customer 
     * @return the money to give back to the costumer.
     */
    public double registerPayment(double amountPayedByCostumer, Sale sale) {
        change = payment.changeToGiveCostumer(sale, amountPayedByCostumer);
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
    public void printReceipt () {
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