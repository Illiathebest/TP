package com.example.paswnshopapp.service;

import com.example.paswnshopapp.entity.Item;
import com.example.paswnshopapp.repository.PawnShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawnShopService {

    private PawnShopRepository pawnShopRepository;

    public PawnShopService(PawnShopRepository pawnShopRepository) {
        this.pawnShopRepository = pawnShopRepository;
    }

    public Item addItem(Item item) {
       return pawnShopRepository.save(item);
    }

    public void editItem(Long itemId, Item item) {
        item.setId(itemId);
        pawnShopRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        pawnShopRepository.deleteById(itemId);
    }

    public Long countItems() {
        return pawnShopRepository.count();
    }

    public Boolean deleteAllItems() {
        pawnShopRepository.deleteAll();
        return true;
    }

    public List<Item> getAllItems() {
        return pawnShopRepository.findAll();
    }

}
