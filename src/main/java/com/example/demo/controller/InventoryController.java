package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;


    @GetMapping("/sortedWithSupplierName&InventoryDescrip")
    public List<Inventory> getSorted() {
        return inventoryRepository.supplierSortInventorySort();
    }

    @GetMapping("/sortBySupplierName")
    public List<Inventory> getSortedBySupplierName() {
        return inventoryRepository.sortBySupplierName();
    }

    @GetMapping("/sortBySupplierId")
    public List<Inventory> getSortedBySupplierId() {
        return inventoryRepository.sortBySupplierId();
    }


    
    //named query

    @GetMapping("/sortByCategory")
    public List<Inventory> sortByCategory() {
        return inventoryRepository.sortByCategoryNamedQuery();
    }
    
    
    //native query
    @GetMapping("/sortByTypeName")
    public List<Inventory> sortByTypeName() {
        return inventoryRepository.sortByTypeNameNative();
    }
}

