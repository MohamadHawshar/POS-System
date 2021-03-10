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
public class Item {
    private int idItem;
    private float price;
    private String itemName;

    public Item(int idItem, float price, String itemName) {
        this.idItem = idItem;
        this.price = price;
        this.itemName = itemName;
    }

    public Item(float price, String itemName) {
        this.price = price;
        this.itemName = itemName;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Item{" + "idItem=" + idItem + ", price=" + price + ", itemName=" + itemName + '}';
    }
    
}
