/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import java.util.Objects;

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

    public SalesLineItem(int quantity, Item item, float packetPrice) {
        this.quantity = quantity;
        this.item = item;
        this.packetPrice = packetPrice;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getPacketPrice() {
        return packetPrice * quantity;
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
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SalesLineItem other = (SalesLineItem) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return item.getItemName() + "(" + quantity + ")";
    }

}
