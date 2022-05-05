package se.kth.iv1350.pos.model;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    LocalTime saleTime;
    private Receipt receipt;
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>();
    private double totalAmount;
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
      for (int itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++) {
          if(itemIdentifier.equals(itemList.get(itemInItemList).getItemIdentifier())); {
            itemList.get(itemInItemList).quantity += 1;
            return true;
            }
         
         }
        return false;
        }
    
    /**
     * Adds a new itemList where all the information about all the items scanned are stored, if the item has already been
     * registered it just adds more of the same item.
     * @param item has the information about the item
     * @param itemCheck A boolean that is true if the item has already been registered once before.
     */
    
    public void addItem (ItemInformationDTO item, boolean itemCheck) {
        if(item != null && itemCheck == false) {
             itemList.add(new ItemInformationDTO(item.getItemName(), item.getItemIdentifier(), item.getItemPrice(), item.getItemVATRate(), item.getItemQuantity())); 
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
   

