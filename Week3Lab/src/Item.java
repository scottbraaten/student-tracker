/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Scott Braaten
 * 
 * Program Name: Item.java
 * Programmer's Name: Student Name 
 * Program Description: Facilitates the specifications of an item being ordered
 * in BurgerBarnGUI.java and stored in Order.java.
 * 
 */

public class Item {
    private int patties, qty;
    private boolean cheese, bacon, meal;
    private double price;
    
    public Item() {
        cheese = false;
        bacon = false;
        meal = false;
        qty = 1;
        patties = 0;
    }

    public Item(int patties, int qty, boolean cheese, boolean bacon, boolean meal) {
        this.patties = patties;
        this.qty = qty;
        this.cheese = cheese;
        this.bacon = bacon;
        this.meal = meal;
    }
    
    public Item(Item old) {
        this(old.getPatties(), old.getQty(), old.isCheese(), old.isBacon(), old.isMeal());
    }

    public int getPatties() {
        return patties;
    }

    public void setPatties(int patties) {
        this.patties = patties;
        calcPrice();
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
        calcPrice();
    }

    public boolean isBacon() {
        return bacon;
    }

    public void setBacon(boolean bacon) {
        this.bacon = bacon;
        calcPrice();
    }

    public boolean isMeal() {
        return meal;
    }

    public void setMeal(boolean meal) {
        this.meal = meal;
    }
    
    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public void calcPrice() {
        price = 0.0;
        
        if (patties == 1) {
            price += 3.50;
        } else if (patties == 2) {
            price += 4.75;
        }
        
        if (cheese) {
            price += 0.50;
        }
        
        if (bacon) {
            price += 1.25;
        }
        
        if (meal) {
            price += 4.0;
        }
    }
}
