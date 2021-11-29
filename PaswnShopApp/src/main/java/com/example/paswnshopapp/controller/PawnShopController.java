package com.example.paswnshopapp.controller;

import com.example.paswnshopapp.entity.Item;
import com.example.paswnshopapp.service.PawnShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class PawnShopController {

    private PawnShopService pawnShopService;

    @Autowired
    public PawnShopController(PawnShopService pawnShopService) {
        this.pawnShopService = pawnShopService;
    }

    @PostMapping("/delete")
    public Item addItem(Item item) {
        return pawnShopService.addItem(item);
    }

    @GetMapping("/getAll")
    public List<Item> getAllItems() {
        return pawnShopService.getAllItems();
    }
}
