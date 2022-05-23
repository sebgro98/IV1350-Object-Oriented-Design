package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    private ItemInformationDTO itemInfo1; 

    public PaymentTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10); 
    }
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null; 
    }

    @Test
    public void testChangeToGiveCostumer() {
        Sale sale = new Sale(); 
        sale.additem(itemInfo1);
        double cashPayed = 200;
        double expResult = 50;

        Payment payment = new Payment(); 
        double result = payment.changeToGiveCustomer(sale.getTotalAmount(), cashPayed);

        assertEquals(expResult, result, "The test case is a prototype.");
    }
    
}