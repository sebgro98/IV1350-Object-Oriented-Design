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
        ItemInformationDTO itemInformation = contr.getItemInfo("AppleBarCode"); 
        double itemPrice = itemInformation.getItemPrice(); 
        String barcode = itemInformation.getItemIdentifier(); 
        String itemName = itemInformation.getItemName();
        int itemQuantity = itemInformation.getItemQuantity();
        boolean register = contr.itemAlreadyRegistered("AppleBarCode");
        
         System.out.println("Is " + barcode + " already registered in the sale?: " + register);
        System.out.println("The code for the item is: " + barcode);
        System.out.println("The scanned item name is: " + itemName);
        System.out.println("The scanned item price is: " + itemPrice + "kr");
        System.out.println("The quantity of the item is: " + itemQuantity);
         System.out.println("The total price of the full sale is: " + contr.runningTotal());
        
        //
    }
}
