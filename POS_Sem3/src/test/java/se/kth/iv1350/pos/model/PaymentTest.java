package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
private boolean itemCheck = false;
private ItemInformationDTO itemInfo1;

    
    @BeforeEach
    public void setUp() {
        Sale sale = new Sale();
         itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 8, 0.13, 10);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testChangeToGiveCostumer() {
        Sale sale = new Sale();
        sale.addItem(itemInfo1, itemCheck);
        double cashPayed = 100;
        double expResult = 20;
        
        Payment payment = new Payment(cashPayed);
        double result = payment.changeToGiveCostumer(sale, cashPayed);
        assertEquals(expResult, result, "They are not equal");
    
    }
    
}
