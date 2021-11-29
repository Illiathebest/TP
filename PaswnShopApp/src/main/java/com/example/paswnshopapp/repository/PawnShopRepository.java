package com.example.paswnshopapp.repository;

import com.example.paswnshopapp.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PawnShopRepository extends CrudRepository<Item, Long> {
    void deleteById(Long id);
    List<Item> findAll();
}
