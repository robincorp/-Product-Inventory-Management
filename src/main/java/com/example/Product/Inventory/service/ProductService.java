package com.example.Product.Inventory.service;

import com.example.Product.Inventory.dto.Requestdto;
import com.example.Product.Inventory.dto.Responsedto;
import com.example.Product.Inventory.entity.ProductInventory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

     Responsedto createProduct(Requestdto reqDto);

     List<ProductInventory> getAllProduct();

     Responsedto updateProduct(Long id, int quantityInStock) ;

     ResponseEntity<Object> getProductById(long id);

     Responsedto deleteProduct(Long id);

}