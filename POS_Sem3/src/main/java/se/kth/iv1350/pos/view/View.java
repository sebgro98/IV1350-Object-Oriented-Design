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
      
       System.out.println("Gets the information about the items whith the bara code that is in inventory system");
        ItemInformationDTO itemInformation = contr.getItemInfo("AppleBarCode"); 
        double itemPrice = itemInformation.getItemPrice(); 
        String barcode = itemInformation.getItemIdentifier(); 
        String itemName = itemInformation.getItemName(); 
        System.out.println(barcode);
        System.out.println(itemName);
        System.out.println(itemPrice);

        boolean register = contr.itemAlreadyRegistered("AppleBarCode");
        //false because it is not registered in sale yet. 
        System.out.println(register);
        
        //The total price of the sale
        
        System.out.println(contr.runningTotal());
        
        //
    }
}
