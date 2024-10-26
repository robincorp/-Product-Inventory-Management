package com.example.Product.Inventory.Repository;

import com.example.Product.Inventory.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductInventory, Long> {
}