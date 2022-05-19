package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.DatabaseServerNotRunning;
import se.kth.iv1350.pos.integration.ItemNotFoundInInventoryException;
import se.kth.iv1350.pos.model.ItemInformationDTO;
import se.kth.iv1350.pos.util.TotalRevenueFileOutput;

/**
 * This is a placeholder for the real view. It contains a hard-coded execution with calls to all
 * System operations in the controller.
 */
public class View {
    private Controller contr; 
    /**
    * Creates a new instance, that uses the specified controller for att calls 
    * to other layers. 
    * @param contr The controller to use for all calls to
    */
    public View (Controller contr){
        this.contr = contr; 
        contr.addRevenueObserver(new TotalRevenueView());
        contr.addRevenueObserver(new TotalRevenueFileOutput());
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
    */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started.");

       // ItemInformationDTO itemInfo = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10);
       //ExternelInventorySystem inventoryInstance = new ExternelInventorySystem();
       // inventoryInstance.additem(itemInfo);
        
    

        System.out.println("Gets the information about the items with the bara code that is in inventory system");
        
        ItemInformationDTO item = new ItemInformationDTO();
       try{
            item = contr.scanItem("AppleBarCode", 10);
           //item = contr.scanItem("InvalidItemName", 10);
            }
        catch (DatabaseServerNotRunning | ItemNotFoundInInventoryException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println(item.getItemName());
        System.out.println("A item has been scanned");
        
        System.out.println("The current Running total for the sale, "+ contr.runningTotal());

        // The total amount for tha sale 
        System.out.println("The total amount for the sale, "+ contr.totalAmount());


        System.out.println("Returns how much change to give customer, " + contr.registerPayment(300.2));

    }

}