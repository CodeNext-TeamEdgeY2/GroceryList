package com.example.grocerylist;

public class CategoryItem {
    private String name;
    private int quantity;

    public CategoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity() { this.quantity = quantity; }
}