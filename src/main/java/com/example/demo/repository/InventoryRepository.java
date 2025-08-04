package com.example.demo.repository;

import com.example.demo.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

 
    @Query("SELECT i FROM Inventory i JOIN i.supplier s ORDER BY s.name ASC")
    List<Inventory> sortBySupplierName();

    @Query("SELECT i FROM Inventory i JOIN i.supplier s ORDER BY s.id ASC")
    List<Inventory> sortBySupplierId();

    @Query("SELECT i FROM Inventory i JOIN i.supplier s ORDER BY s.name ASC, i.description ASC")
    List<Inventory> supplierSortInventorySort();
    
    //named query
    @Query(name = "Inventory.sortByCategoryId")
    List<Inventory> sortByCategoryNamedQuery();
    
    
    //native query
    @Query(value = "SELECT i.* FROM inventory i JOIN type t ON i.type_id = t.id ORDER BY t.name ASC", nativeQuery = true)
    List<Inventory> sortByTypeNameNative();

}
