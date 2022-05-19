/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.pos.model;

public interface RevenueObserver {
    /**
     * 
     * @param totalPrice the total price of the sale.
     */
    void completedSale (double totalPrice);
      
}
