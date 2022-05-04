package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.ItemInformationDTO;
import se.kth.iv1350.pos.model.Sale;

public class ExternalInventorySystemTest {
private ItemInformationDTO itemInfo1;
private ItemInformationDTO itemInfo2;
private ItemInformationDTO itemInfo3;
private Sale saleInstance = new Sale();
private boolean itemCheckFalse= false;
private boolean itemCheckTrue = true;
    
    public ExternalInventorySystemTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.25, 10);
      
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetItemInformation() {
        ExternalInventorySystem inventoryInstance = new ExternalInventorySystem();
        inventoryInstance.addItem(itemInfo1);
        
        String itemIdentifier = "AppleBarCode";
        ItemInformationDTO expResult = itemInfo1;
        
        ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier);
        assertEquals(expResult, result, "The item was not found in the inventory");
    }

@Test
    public void testGetItemInformationNull() {
        ExternalInventorySystem inventoryInstance = new ExternalInventorySystem();
        inventoryInstance.addItem(itemInfo1);
        
        String itemIdentifier = "RandomBarCode";
        ItemInformationDTO expResult = null;
        
        ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier);
        assertEquals(expResult, result, "The item was not found in the inventory");
    }
}