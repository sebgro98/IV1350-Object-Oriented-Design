package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.ItemInformationDTO;


public class ExternalInventorySystemTest {
private ItemInformationDTO itemInfo1;

    
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

        ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier, 10);
        assertEquals(expResult.getItemIdentifier(), result.getItemIdentifier(), "The item was not fount in inventory");
        assertEquals(expResult.getItemName(), result.getItemName(), "The item was not fount in inventory");
        assertEquals(expResult.getItemPrice(), result.getItemPrice(), "The item was not fount in inventory");
    }

@Test
   public void testGetItemInformationNull() {
        ExternalInventorySystem inventoryInstance = new ExternalInventorySystem();
        inventoryInstance.addItem(itemInfo1);

        String itemIdentifier = "OrgangebarCode";
        ItemInformationDTO expResult = null;

        ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier, 10);
        assertEquals(expResult, result, "The item was not fount in inventory");
    }
}