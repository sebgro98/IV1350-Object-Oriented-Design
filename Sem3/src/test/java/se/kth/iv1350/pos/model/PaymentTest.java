package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
private boolean itemCheck = false;
private ItemInformationDTO itemInfo1;

    
    @BeforeEach
    public void setUp() {;
         itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 8, 0.13, 10);
    }
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null;
    }

    @Test
     public void testChangeToGiveCostumer() {
        Sale sale = new Sale(); 
        sale.addItem("AppleBarCode", 10);
        double cashPayed = 200;
        double expResult = 50;

        Payment payment = new Payment(); 
        double result = payment.changeToGiveCustomer(sale, cashPayed);

        assertEquals(expResult, result, "The test case is a prototype.");
    }
    
}
