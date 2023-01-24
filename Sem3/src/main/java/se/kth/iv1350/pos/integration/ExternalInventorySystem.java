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
        itemList.add(new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10));
        itemList.add(new ItemInformationDTO("Milk", "MilkBarCode", 10, 0.11, 2));
        
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
     *  This method looks for the item that has the same item identifier as the one scanned by the cashier. if it is the same
    * 
    * @param itemIdentifier This is the barcode that is getting scanned to get information about the item
    * @return if the item doesn't exist return null.
    */
  public ItemInformationDTO getItemInfomation (String itemIdentifier, int quantity){
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemIdentifier().equals(itemIdentifier)) {
                return itemList.get(i);
            }
        }

    return null; 
    }
    
    /**
     * updates the inventory when the sale ends
     * @param sale contains the entire sale information
     */
    public void updateInventory(Sale sale) {
    
    }
}