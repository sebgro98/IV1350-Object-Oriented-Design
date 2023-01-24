package se.kth.iv1350.pos.model;
import java.time.LocalTime;
import java.util.ArrayList;
import se.kth.iv1350.pos.integration.ExternalInventorySystem;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    LocalTime saleTime;
    private Receipt receipt;
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>();
    private double totalAmount;
    private ExternalInventorySystem externelInventorySystem = new ExternalInventorySystem();
    private int itemInItemList;
    private boolean itemCheck;
    /**
     * Creates an instance and saves the time of the sale.
     */
    public Sale () {
        saleTime = LocalTime.now();
        receipt = new Receipt();
    }
    /**
     * This method checks if an item has already been registered and if its in the itemList. If an item already
     * been registered then it will just add up the quantity of that item.
     * @param ItemIdentifier the bar code of the item being scanned
     * @return true, it will change the status of the item to true so that the system will know that this item has already
     * been scanned before and should only add quantity
     */
    public boolean checkIfItemAlreadyRegistered(String itemIdentifier ) {
         for( itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++) {
            if(itemIdentifier.equals(itemList.get(itemInItemList).getItemIdentifier())) {
                return true; 
            }
        }
    return false; 
    }
    
    /**
     * If an item is already been registered this method increases the quantity of the item. 
     * @param itemIdentifier A number or bar code that represents a specific item.
     * @param quantity the quantity of an item
     */
    public ItemInformationDTO increaseQuantity (String itemIdentifier, int quantity){
        itemList.get(itemInItemList).quantity += quantity; 
        return itemList.get(itemInItemList); 
    }
    
    
     /**
     * This method calls for externelInventorySystem to get information about a specefic item.
     * and adds it to the sale but if an item already has been registered it just adds up the quantity. 
     * @param itemIdentifier: A code that represents an specific item. 
     * @param qiantity: the quantity of the item 
     * @return : returns the information about the item. But if it is already registered it returns the information 
     *                with the updated quantity. 
    */
    
     public ItemInformationDTO addItem(String itemIdentifier, int quantity){
        itemCheck = checkIfItemAlreadyRegistered(itemIdentifier);
        if (itemCheck == false) {
            ItemInformationDTO item = externelInventorySystem.getItemInfomation(itemIdentifier, quantity); 
             itemList.add(new ItemInformationDTO(item.getItemName(), item.getItemIdentifier(), item.getItemPrice(), item.getItemVATRate(), item.getItemQuantity())); 
             return item; 
        }
        else{
            ItemInformationDTO item = increaseQuantity(itemIdentifier, quantity);
            return item; 
            }
    }
    /**
     * Method that Returns the current list of items in the sale.
     * @return itemList
     */
    public ArrayList<ItemInformationDTO> getListOfItems () {
        return this.itemList;
        
    }
    
   /**
     * This method updates the running total going through the list of all the items scanned.
     * @return runningTotal 
     */
    public double countRunningTotal() {
        double runningTotal = 0; 
        for(int itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++){
            runningTotal +=  itemList.get(itemInItemList).quantity * itemList.get(itemInItemList).getItemPrice();  
        }
        return runningTotal; 
    }
    
    public double getTotalAmount() {
        totalAmount = countRunningTotal();
        return totalAmount;
    }
 
}
   

