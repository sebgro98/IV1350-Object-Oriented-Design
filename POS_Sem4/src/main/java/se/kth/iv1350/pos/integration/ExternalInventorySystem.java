package se.kth.iv1350.pos.integration;
import java.util.ArrayList;
import se.kth.iv1350.pos.model.*;
/**
 * Inventory system that has all the information about how many items there are in the store, and price etc.
 *  
 */
public class ExternalInventorySystem {
    
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>();
    
    /**
    *  An instance of the External Inventory System.
    */
    public ExternalInventorySystem() { 
        itemList.add(new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.11, 10));
        itemList.add(new ItemInformationDTO("Milk", "MilkBarCode", 10, 0.11, 2));;
        itemList.add(new ItemInformationDTO("Orange", "OrangeBarCode", 17, 0.11, 6));
        itemList.add(new ItemInformationDTO("Cheese", "CheeseBarCode", 5, 0.11, 6));
        itemList.add(new ItemInformationDTO("Potato", "PotatoBarCode", 23, 0.11, 6));
        
    } 
   
    /**
     *  Adds a new item to the inventory where all the information about the items are stored.
     * @param item The item that is added to the inventory
     */
       public void addItem (ItemInformationDTO item) {
        if(item != null) {
            itemList.add(item);
        }
    }
    
    /**
     *  This method looks for the item that has the same item identifier as the one scanned by the cashier.if it is the same
    * 
    * @param itemIdentifier This is the bar code that is getting scanned to get information about the item
     * @param quantity the quantity of a same item.
    * @return if the item doesn't exist return null.
     * @throws se.kth.iv1350.pos.integration.ItemNotFoundInInventoryException throws an exception If an item with the item identifier is not found in external inventory system.
     * @throws se.kth.iv1350.pos.integration.DatabaseServerNotRunning throws database failure exception when a search is made for a particular, hard coded,item identifier.
    */
 public ItemInformationDTO getItemInfomation (String itemIdentifier, int quantity) throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
     
     ItemInformationDTO item = new ItemInformationDTO();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemIdentifier().equals(itemIdentifier)) {
                return itemList.get(i);
            }   
            else if("InvalidItemName".equals(itemIdentifier)){
                throw new DatabaseServerNotRunning("The database is currently offline");
            }
        }
          
        throw new ItemNotFoundInInventoryException("This item with itemIdentifier: "+ itemIdentifier+ " was not found in inventory" );
}
    
    /**
     * updates the inventory when the sale ends
     * @param sale contains the entire sale information
     */
    public void updateInventory(Sale sale) {
    
    }
}