package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
    private ArrayList<ItemInformationDTO> listOfItems; 
    private LocalTime saleTime;
    private StoreAddress storeAdress; 
    private double totalPrice;
    private double totalVAT;
    private double paidAmount;
    private double change;
    private Sale sale;
    private Payment payment;
    
    public Receipt() {
    
    }
   /**
    *  Creates a receipt, contains the necessary information about the sale.
    * @param sale All the Sale information
    * @param storeAdress The address of the place
    * @param payment The amount payed.
    */
    public Receipt (Sale sale, StoreAddress storeAdress, Payment payment) {
        this.sale = sale;
        this.storeAdress = storeAdress;
        this.payment = payment;
        this.change = payment.changeToGiveCustomer(sale, payment.getPayedAmount()); 
        this.saleTime = sale.saleTime;
        this.totalPrice = sale.getTotalAmount();
        this.listOfItems = sale.getListOfItems();
    }
   
    public StoreAddress getStoreAddress() {
    return storeAdress;
    }
    
    public double getTotalAmount () {
    
        return totalPrice;
    }
    
    public double getChange () {
   
        return change;
   }
    
    public LocalTime getTimeOfSale() {
    
        return saleTime;
        
    }
    
    public  ArrayList<ItemInformationDTO> getItemList() {
    
        return listOfItems;
    }
    
    public double getTotalVatRate () {
    
    return totalVAT;
        
    }
}

