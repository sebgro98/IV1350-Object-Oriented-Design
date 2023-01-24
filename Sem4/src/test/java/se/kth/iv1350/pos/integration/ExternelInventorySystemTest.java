package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.ItemInformationDTO;
import se.kth.iv1350.pos.model.Sale;
import java.util.ArrayList;
public class ExternelInventorySystemTest {
    
    private ItemInformationDTO itemInfo1; 
    private ItemInformationDTO itemNotInInv;

    public ExternelInventorySystemTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemInfo1 =new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10); 
        itemNotInInv =new ItemInformationDTO("Apple", "BarCode", 15, 0.13, 10); 
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetItemInformationSucess() throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        ExternalInventorySystem inventoryInstance = new ExternalInventorySystem();
        try{
            inventoryInstance.addItem(itemInfo1);
            String itemIdentifier = "AppleBarCode";
            ItemInformationDTO expResult = itemInfo1;
            ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier, 10);
            assertEquals(expResult.getItemIdentifier(), result.getItemIdentifier(), "The item was not fount in inventory");
            assertEquals(expResult.getItemName(), result.getItemName(), "The item was not fount in inventory");
            assertEquals(expResult.getItemPrice(), result.getItemPrice(), "The item was not fount in inventory");
        }
        catch(DatabaseServerNotRunning | ItemNotFoundInInventoryException exception){
            assert(false);
            fail("Got exception form successfullly getting ItemInformation"); 
        }
    }
    
    @Test
    public void testGetItemInformationNull()throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        try{
            ExternalInventorySystem inventoryInstance = new ExternalInventorySystem();
            inventoryInstance.addItem(itemInfo1);
            String itemIdentifier = "OrgangebarCode";
            inventoryInstance.getItemInfomation(itemIdentifier, 10);
            fail("Manage to get item infomation that is not in inventory");
        }
        catch(DatabaseServerNotRunning | ItemNotFoundInInventoryException exception)
        {
           assert(true); 
        }
        
    }

    @Test
    public void testGetItemInformationTrue()throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        try{
            ExternalInventorySystem inventoryInstance = new ExternalInventorySystem();
            String itemIdentifier = "AppleBarCode";
            inventoryInstance.getItemInfomation(itemIdentifier, 10);
        }
        catch(DatabaseServerNotRunning | ItemNotFoundInInventoryException exception)
        {
           assert(true); 
           fail("Got exception form successfullly getting ItemInformation"); 
        }
    }
}