package se.kth.iv1350.pos.integration;

public class ItemNotFoundInInventoryException extends Exception {
    /**
     *  This exception is thrown if an item with a specified item identifier is not found in inventory.
     * @param errorMessage the message that is sent from external inventory system.
     */
    public ItemNotFoundInInventoryException(String errorMessage) {
        super(errorMessage);
    }
}