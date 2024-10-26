package com.example.Product.Inventory.facade;

import com.example.Product.Inventory.dto.Requestdto;
import com.example.Product.Inventory.dto.Responsedto;
import com.example.Product.Inventory.entity.ProductInventory;
import com.example.Product.Inventory.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ProductFacade {

    @Autowired
    private ProductRepository productRepository;

    public Responsedto createProduct(Requestdto reqDto) {
        StringBuilder missingFields = new StringBuilder();

        if (reqDto.getName() == null || reqDto.getName().isEmpty()) {
            missingFields.append("Name, ");
        }
        if (reqDto.getCategory() == null || reqDto.getCategory().isEmpty()) {
            missingFields.append("Category, ");
        }
        if ( reqDto.getPrice() <= 0) {
            missingFields.append("Price, ");
        }
        if (reqDto.getQuantityInStock() <= 0) {
            missingFields.append("Quantity in stock, ");
        }
        if (missingFields.length() > 0) {
            String missingFieldsStr = missingFields.substring(0, missingFields.length() - 2);
            return new Responsedto("Missing or invalid fields - " + missingFieldsStr);
        }
        ProductInventory newProduct = reqDto.getproductdetails();
        productRepository.save(newProduct);

        return new Responsedto("Product saved successfully");
    }


    public Responsedto updateProduct(Long id, int quantityInStock) {
        Optional<ProductInventory> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            ProductInventory product = existingProduct.get();
            product.setQuantityInStock(quantityInStock);
            productRepository.save(product);
            return new Responsedto("Product quantity updated successfully");
        } else {
            return new Responsedto("Product not found with ID " + id);
        }
    }


    public Responsedto deleteProduct(Long id) {
        Optional<ProductInventory> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return new Responsedto("Product deleted successfully");
        } else {
            return new Responsedto("Product not found with ID: " + id);
        }
    }
}





