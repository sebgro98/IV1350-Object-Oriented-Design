package se.kth.iv1350.pos.model;

public class ItemInformationDTO {
    private String itemName; 
    private String itemIdentifier; 
    private double itemPrice; 
    private double itemVATRate; 
    int quantity; 


    /**
     * Creates an instance of class ItemInformationDTO.
     * @param itemName. Name of the item.
     * @param itemIdentifier. The zipcode that represents the item.
     * @param itemPrice. The price of the item.
     * @param itemVATRate. The VAT rate of the item. 
     * @param quantity The amount of the same item.
     */
    public ItemInformationDTO(String itemName, String itemIdentifier, double itemPrice,
        double itemVATRate, int quantity){
        this.itemName = itemName; 
        this.itemIdentifier = itemIdentifier; 
        this.itemPrice = itemPrice; 
        this.itemVATRate = itemVATRate; 
        this.quantity = quantity; 
    }
    /**
     *  creates a new default instance of itemInformationDTO.
     */
        public ItemInformationDTO() {
        itemName =" ";
        itemPrice = 0;
        itemIdentifier = " ";
        itemVATRate = 0.0;
        quantity = 0;
        
        
        }

    /**
     * @return. Returns the name of the item.
     */
    public String getItemName(){
        return itemName; 
    }

    /**
     * @return. Returns the itemIdentifier of the item.
     */
    public String getItemIdentifier(){
        return itemIdentifier; 
    }

    /**
     * @return. Returns the price of the item.
     */
    public double getItemPrice(){
        return itemPrice;
    } 

    /**
     * @return. Returns the VATRate of the item.
     */
    public double getItemVATRate(){
        return itemVATRate;
    }

    /**
     * @return. Returns the quantity of the item.
     */
    public int getItemQuantity(){
        return quantity;
    }
}