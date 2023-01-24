package se.kth.iv1350.pos.integration;


public class DatabaseServerNotRunning extends Exception {
    /**
     *  This exception is thrown if an item does not equal the specified item identifier.
     * @param errorMessage the message that is sent from external inventory system.
     */
    public DatabaseServerNotRunning(String errorMessage) {
        super(errorMessage);
    }
}