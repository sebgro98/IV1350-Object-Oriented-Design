
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
    boolean itemCheckFalse = false; 
    boolean itemCheckTrue = true; 
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10); 
        itemInfo2 = new ItemInformationDTO("Milk", "MilkBarCode", 10, 0.11, 2); 
        itemInfo3 = new ItemInformationDTO(); 

    }
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null; 
        itemInfo2 = null; 
        itemInfo3 = null; 
    }

    @Test
    public void testIncreaseQuantity() {
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        ItemInformationDTO item =  instance.increaseQuantity("AppleBarCode", 11);
        int expResult = 21; 
        int result = item.getItemQuantity();
        assertEquals(expResult, result, "The test case is a prototype.");
    }
    
    @Test
    public void testAddOneItem() {
        saleInstance.additem(itemInfo1);
        ArrayList<ItemInformationDTO> testItemList = saleInstance.getListOfItems();  
        ArrayList<ItemInformationDTO> goodsItemList = new ArrayList<ItemInformationDTO>();  
        goodsItemList.add(itemInfo1); 
        assertEquals(testItemList.get(0).getItemIdentifier(), goodsItemList.get(0).getItemIdentifier(), "The items in the two lists are not the same"); 
        assertEquals(testItemList.get(0).getItemName(), goodsItemList.get(0).getItemName(), "The items in the two lists are not the same");   
        assertEquals(testItemList.get(0).getItemPrice(), goodsItemList.get(0).getItemPrice(), "The items in the two lists are not the same");     
    }

    @Test
    public void testAddMultipelItem() {
        saleInstance.additem(itemInfo1);
        saleInstance.additem(itemInfo2);
        ArrayList<ItemInformationDTO> testItemList = saleInstance.getListOfItems();  

        ArrayList<ItemInformationDTO> goodsItemList = new ArrayList<ItemInformationDTO>();  
        goodsItemList.add(itemInfo1); 
        goodsItemList.add(itemInfo2);

        assertEquals(testItemList.get(0).getItemIdentifier(), goodsItemList.get(0).getItemIdentifier(), "The items in the two lists are not the same");   
        assertEquals(testItemList.get(1).getItemIdentifier(), goodsItemList.get(1).getItemIdentifier(), "The items in the two lists are not the same");
    }


    @Test
    public void testCheckIfItemAlreadyRegisterFalse() {
        String itemIdentifier = "RandomBarCode";
        Sale instance = new Sale();
        boolean expResult = false;
        boolean result = instance.checkIfItemAlreadyRegister(itemIdentifier);
        assertEquals(expResult, result, "Item ditected when its is not in the sale list.");
    }

 
    @Test
    public void testCheckIfItemIsNotRegistered() {
        String itemIdentifier = "AppleBarCode";
         boolean expResult = true;
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        
        boolean result = instance.checkIfItemAlreadyRegister(itemIdentifier);
        assertEquals(expResult, result, "Item detected when it's not in the sale list.");
    }

    @Test
    public void testCountRunningTotal() {
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        instance.additem(itemInfo2);
        double runningTotal = instance.countRunningTotal();

        double testRunningTotal = itemInfo1.getItemQuantity() * itemInfo1.getItemPrice(); 
        testRunningTotal += itemInfo2.getItemQuantity() * itemInfo2.getItemPrice(); 
        assertEquals(runningTotal, testRunningTotal, "the running total are not same.");
    }


    @Test
    public void testGetTotalAmount() {
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        instance.additem(itemInfo2);
        double runningTotal = instance.getTotalAmount();

        double testGetExpectedTotalAmount = itemInfo1.getItemQuantity() * itemInfo1.getItemPrice(); 
        testGetExpectedTotalAmount += itemInfo2.getItemQuantity() * itemInfo2.getItemPrice(); 
        assertEquals(runningTotal, testGetExpectedTotalAmount, "the running total are not same.");
    }
    
}