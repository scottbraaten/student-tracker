
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Scott Braaten
 * 
 * Program Name: Order.java
 * Programmer's Name: Student Name 
 * Program Description: Manages the total order, storing all the items and total cost 
 * and using Item to help BurgerBarnGUI.java customize an item.
 * 
 */

public class Order {
    private ArrayList<Item> items;
    private Item tempItem;
    private double total;
    
    public Order () {
        // no need for parameters as same values are initialized regardless of circumstance
        items = new ArrayList<Item>();
        tempItem = new Item();
        total = 0;
    }

    // getters, setters
    
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Item getTempItem() {
        return tempItem;
    }

    public void setTempItem(Item tempItem) {
        this.tempItem = tempItem;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    // determines price, adds it to total, and adds Item to order
    public void addToOrder() {
        tempItem.calcPrice();
        total += tempItem.getPrice() * tempItem.getQty();
        items.add(tempItem);
    }
}
