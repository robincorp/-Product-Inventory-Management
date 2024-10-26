package com.example.Product.Inventory.controller;

import com.example.Product.Inventory.Repository.ProductRepository;
import com.example.Product.Inventory.dto.Requestdto;
import com.example.Product.Inventory.dto.Responsedto;
import com.example.Product.Inventory.entity.ProductInventory;
import com.example.Product.Inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productrepository;
    @Autowired
    private ProductService productService;

    @PostMapping("/import")
    public ResponseEntity<Responsedto> createProduct( @RequestBody Requestdto reqDto) {
        Responsedto response = productService.createProduct(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/Getall")
    public ResponseEntity<List<ProductInventory>> getAllEmployees() {
        List<ProductInventory> product = productService.getAllProduct();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/Particular_product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/Quantity_update/{id}")
    public ResponseEntity<Responsedto> updateProductQuantity(@PathVariable Long id,@RequestBody Map<String, Integer> request) {
        Responsedto response = productService.updateProduct(id, request.get("quantityInStock"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Responsedto> deleteProduct(@PathVariable Long id) {
        Responsedto response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
