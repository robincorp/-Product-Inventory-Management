package com.example.Product.Inventory.dto;

import com.example.Product.Inventory.entity.ProductInventory;
import lombok.Data;

@Data
public class Requestdto {

    private String name;
    private String category;
    private double price;
    private int quantityInStock;

    public ProductInventory getproductdetails() {

        ProductInventory productinventory = new ProductInventory();
        productinventory.setName(this.name);
        productinventory.setCategory(this.category);
        productinventory.setPrice(this.price);
        productinventory.setQuantityInStock(this.quantityInStock);

        return productinventory;
    }
}
