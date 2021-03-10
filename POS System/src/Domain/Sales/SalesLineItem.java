/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

/**
 *
 * @author User
 */
public class SalesLineItem {
    private int quantity;
    private float packetPrice = 0;
    private int idItem;
    private int idSale;
    private Item item;

    public SalesLineItem(int quantity) {
        this.quantity = quantity;
    }

    public SalesLineItem(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getPacketPrice() {
         return packetPrice*quantity;
    }

    public void setPacketPrice(float packetPrice) {
        this.packetPrice = packetPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "SalesLineItem{" + "quantity=" + quantity + ", packetPrice=" + packetPrice + '}';
    }


    
}
