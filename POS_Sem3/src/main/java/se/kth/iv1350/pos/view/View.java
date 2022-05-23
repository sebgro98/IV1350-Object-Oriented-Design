package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.ItemInformationDTO;

/**
 * This is a placeholder for the real view. It contains a hard-coded execution with calls to all
 * System operations in the controller.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */

    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     *
     */
    public void runFakeExecution () {
        contr.startSale();
        System.out.println("A new sale has been started.");
      
       System.out.println("Gets the information about the items whith the barcode that is in the inventory system");
        ItemInformationDTO itemInformation = contr.scanItem("AppleBarCode", 10); 
        double itemPrice = itemInformation.getItemPrice(); 
        String barcode = itemInformation.getItemIdentifier(); 
        String itemName = itemInformation.getItemName();
        int itemQuantity = itemInformation.getItemQuantity();
        double getItemVATRate = itemInformation.getItemVATRate(); 

        System.out.println("An item has been scanned: " + itemName);
        System.out.println("The code for the item is: " + barcode);
        System.out.println("The scanned item price is: " + itemPrice + "kr");
        System.out.println("The quantity of the item is: " + itemQuantity);
        System.out.println("item Vat Rate, " + getItemVATRate + "%");
        System.out.println("The running total of the sale is: " + contr.runningTotal());
        System.out.println("The total amount for the sale, "+ contr.totalAmount());
        System.out.println("Returns how much change to give customer, " + contr.registerPayment(300));
         
        
        //
    }
}
