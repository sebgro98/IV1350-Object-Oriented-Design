
package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
    
    private ItemInformationDTO itemInfo1;
    private ItemInformationDTO itemInfo2;
    private ItemInformationDTO itemInfo3;
    private Sale saleInstance = new Sale();
    private boolean itemCheckFalse= false;
     private boolean itemCheckTrue = true;
    
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.25, 10);
        itemInfo2 = new ItemInformationDTO("Milk", "MilkBarCode", 11, 0.25, 4);
        itemInfo3 = new ItemInformationDTO();
    
    }
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null;
        itemInfo2 = null;
        itemInfo3 = null;
                
    }

    @Test
    public void testAddOneItem() {
        saleInstance.addItem(itemInfo1, itemCheckFalse);
        ArrayList<ItemInformationDTO> testItemList = saleInstance.getListOfItems();
       
        ArrayList<ItemInformationDTO> goodList = new ArrayList<ItemInformationDTO>(); 
         goodList.add(itemInfo1);
         
           assertEquals(goodList.get(0), testItemList.get(0), "The items in the two lists are not the same");
               
    }
   @Test
    public void testAddOneItemAlreadyRegister() {
        Sale instance = new Sale();
        instance.addItem(itemInfo1, itemCheckTrue);
        instance.addItem(itemInfo2, itemCheckFalse);
        ArrayList<ItemInformationDTO> testItemList = instance.getListOfItems();  

        ArrayList<ItemInformationDTO> goodsItemList = new ArrayList<ItemInformationDTO>();  
        goodsItemList.add(itemInfo2); 
        
        assertEquals(testItemList.get(0), goodsItemList.get(0), "Item added when it is already registered");  
    }

    
    
    @Test
    public void testAddMultipleItem() {
        saleInstance.addItem(itemInfo1, itemCheckFalse);
        saleInstance.addItem(itemInfo2, itemCheckFalse);
        saleInstance.addItem(itemInfo3, itemCheckFalse);
        ArrayList<ItemInformationDTO> testItemList = saleInstance.getListOfItems();
        
        ArrayList<ItemInformationDTO> goodList = new ArrayList<ItemInformationDTO>();
         goodList.add(itemInfo1);
         goodList.add(itemInfo2);
         goodList.add(itemInfo3);
         
           assertEquals(goodList.get(0), testItemList.get(0), "The items1 in the two lists are not the same");
           assertEquals(goodList.get(1), testItemList.get(1), "The items2 in the two lists are not the same");
           assertEquals(goodList.get(2), testItemList.get(2), "The items3 in the two lists are not the same");
        }

 @Test
    public void testCheckIfItemAlreadyRegistered() {
        String itemIdentifier = "RamdomBarCode";
        Sale instance = new Sale();
        boolean expResult = false;
        boolean result = instance.checkIfItemAlreadyRegistered(itemIdentifier);
        assertEquals(expResult, result, "Item detected when it's not in the sale list.");
    }
 @Test
    public void testCheckIfItemIsNotRegistered() {
        String itemIdentifier = "AppleBarCode";
         boolean expResult = true;
        Sale instance = new Sale();
        instance.addItem(itemInfo1, itemCheckFalse);
        
        boolean result = instance.checkIfItemAlreadyRegistered(itemIdentifier);
        assertEquals(expResult, result, "Item detected when it's not in the sale list.");
    }



    @Test
    public void testCountRunningTotal() {
        Sale instance = new Sale();
        instance.addItem(itemInfo1, itemCheckFalse);
        instance.addItem(itemInfo2, itemCheckFalse);
       double runningTotal = instance.countRunningTotal();
       
       double testRunningTotal = itemInfo1.getItemQuantity() * itemInfo1.getItemPrice();
       testRunningTotal += itemInfo2.getItemQuantity() * itemInfo2.getItemPrice();
      assertEquals(runningTotal, testRunningTotal, "This is not the same total amount.");
       
    }

    @Test
    public void testGetTotalAmount() {
       Sale instance = new Sale();
        instance.addItem(itemInfo1, itemCheckFalse);
        instance.addItem(itemInfo2, itemCheckFalse);
       double runningTotal = instance.getTotalAmount();
       
       double testGetTotalAmount = itemInfo1.getItemQuantity() * itemInfo1.getItemPrice();
       testGetTotalAmount += itemInfo2.getItemQuantity() * itemInfo2.getItemPrice();
      assertEquals(runningTotal, testGetTotalAmount, "This is not the same total amount.");
    }
    
}
