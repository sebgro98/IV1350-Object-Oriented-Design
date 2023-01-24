package se.kth.iv1350.pos.startup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;

    public class MainTest {
        private Main instanceToTest;
        private ByteArrayOutputStream printout;
        private PrintStream originalSysOut;
   
    @BeforeEach
    public void setUp() {
        instanceToTest = new Main();
        
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
    public void testUIHasStarted() {
        String[] args = null;
        Main.main(args);
        String print = printout.toString();
        String expectedOutPut = "started";
        assertTrue(print.contains(expectedOutPut), "UI did not start correctly");
    }
}

