package com.example.Product.Inventory.service;

import com.example.Product.Inventory.Repository.ProductRepository;
import com.example.Product.Inventory.dto.Requestdto;
import com.example.Product.Inventory.dto.Responsedto;
import com.example.Product.Inventory.entity.ProductInventory;
import com.example.Product.Inventory.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplimentation implements ProductService {

    @Autowired
    private ProductFacade productFacade;
    @Autowired ProductRepository productrepository;

    public Responsedto createProduct(Requestdto reqDto) {
        return productFacade.createProduct(reqDto);
    }

    @Override
    public List<ProductInventory> getAllProduct() {
        return productrepository.findAll();
    }

    public ResponseEntity<Object> getProductById(long id) {
        Optional<ProductInventory> product = productrepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.ok("Product not found with ID: " + id);
        }
    }

    public Responsedto updateProduct(Long id, int quantityInStock) {
        return productFacade.updateProduct(id, quantityInStock);
    }

    public Responsedto deleteProduct(Long id) {
        return productFacade.deleteProduct(id);
    }
}
