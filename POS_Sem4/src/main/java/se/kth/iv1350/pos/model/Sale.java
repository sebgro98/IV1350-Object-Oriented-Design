package se.kth.iv1350.pos.model;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.integration.*;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    LocalTime saleTime; 
    private Receipt receipt;
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>(); 
    private double totalAmount;
    private int itemInItemList;
    private boolean itemCheck;
    private ExternalInventorySystem externelInventorySystem = new ExternalInventorySystem(); 
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
 
   
    /**
     * Creates a new instance and saves the time of the sale.
    */
    public Sale(){
        saleTime = LocalTime.now();
        receipt = new Receipt(); 
    }  
    
    /**
     * This method checks if a item has already been register and if it is in itemList. If a item has already been
     * registered the it just adds up the quantity of the item. 
     * @param itemIdentifier A number or bar code that represents a specific item.
     * @return if the item has already been register it returns true else it returns false. 
     */
    public boolean checkIfItemAlreadyRegister (String itemIdentifier){
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
     * @param quantity
     */
    public ItemInformationDTO increaseQuantity (String itemIdentifier, int quantity){
        itemList.get(itemInItemList).quantity += quantity; 
        return itemList.get(itemInItemList); 
    }

    
    /**
     * This method calls for externelInventorySystem to get information about a specific item.and adds it to the sale but if an item already has been registered it just adds up the quantity.
     * @param item 
     * @return : returns the information about the item. But if it is already registered it returns the information 
     *                with the updated quantity. 
    */
    public ItemInformationDTO additem(ItemInformationDTO item){
        itemCheck = checkIfItemAlreadyRegister(item.getItemIdentifier());
        if (itemCheck == false) {
             itemList.add(new ItemInformationDTO(item.getItemName(), item.getItemIdentifier(), item.getItemPrice(), item.getItemVATRate(), item.getItemQuantity())); 
             return item; 
        }
        else{
            ItemInformationDTO itemInfo = increaseQuantity(item.getItemIdentifier(), item.getItemQuantity());
            return itemInfo; 
            }
    }
    

    /**
     * @return  the current list of item in the sale. 
     */
    public ArrayList<ItemInformationDTO> getListOfItems(){
        return this.itemList; 
    }

    /**
     * This method updates the running total by going through the item list and the quantity of an item times the price of the item
     * is the running total.
     * @return returning the current running total of the sale.  
     */
    public double countRunningTotal(){
        double runningTotal = 0; 
        for(int itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++){
            runningTotal +=  itemList.get(itemInItemList).quantity * itemList.get(itemInItemList).getItemPrice();  
        }
        return runningTotal; 
    }
    
    /** 
     * @return this method gets the running total of the sale. At the end of the sale it is the total price of the sale. 
     */
    public double getTotalAmount() {
        totalAmount = countRunningTotal();
        notifyObservers();
        return totalAmount; 
        
    }
    
/**
 * Goes through the list of observers and calls the method completed sale.
 */
    private void notifyObservers() {
        for (RevenueObserver revenueObserber: revenueObservers){
            revenueObserber.completedSale(totalAmount);
        }
    }
    
    /**
     * Adds a list of observers to the revenueObserves list.
     * @param observers - the list of observers to add.
     */
    public void addRevenueObservers(List<RevenueObserver > observers) {
        revenueObservers.addAll(observers);
    }
    
}


