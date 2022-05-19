package se.kth.iv1350.pos.view;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import se.kth.iv1350.pos.controller.Controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printout;
    private PrintStream originalSysOut;
   
    @BeforeEach
    public void setUp() {
        Controller contr = new Controller();
        instanceToTest = new View(contr);
        
        printout = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printout);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        
        printout = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRunFakeExecution() {
        instanceToTest.runFakeExecution();
        String print = printout.toString();
        String expectedOutPut = "started";
        assertTrue(print.contains(expectedOutPut), "UI did not start correctly");
    }
    
}
