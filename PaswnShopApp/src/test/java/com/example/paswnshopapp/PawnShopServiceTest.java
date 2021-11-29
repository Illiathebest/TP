package com.example.paswnshopapp;

import com.example.paswnshopapp.entity.Item;
import com.example.paswnshopapp.repository.PawnShopRepository;
import com.example.paswnshopapp.service.PawnShopService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PawnShopServiceTest {

    @Autowired
    private PawnShopRepository pawnShopRepository;

    @Autowired
    private PawnShopService pawnShopService;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        pawnShopRepository.deleteAll();
    }

    @Test
    public void addItemTest() {
        Item item = new Item();
        item.setId(1L);
        item.setItemName("item1");
        item.setCost(500);

        Assert.assertEquals(0, pawnShopRepository.count());
        pawnShopService.addItem(item);
        Assert.assertEquals(1, pawnShopRepository.count());
    }

    @Test
    public void editItemTest() {
        Item item = new Item();
        item.setId(1L);
        item.setItemName("item1");
        item.setCost(500);

        pawnShopService.addItem(item);

        Item newItem = new Item();
        newItem.setItemName("newName");
        pawnShopService.editItem(item.getId(), newItem);

        var editedItem = pawnShopService.getAllItems().get(0);

        Assert.assertEquals(newItem.getItemName(), editedItem.getItemName());
    }

    @Test
    public void deleteTest() {
        Item item = new Item();
        item.setId(1L);
        item.setItemName("item1");
        item.setCost(500);

        pawnShopService.addItem(item);

        Assert.assertEquals(1, pawnShopRepository.count());

        pawnShopService.deleteItem(item.getId());

        Assert.assertEquals(0, pawnShopRepository.count());
    }

    @Test
    public void getAllTest() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setItemName("item1");
        item1.setCost(500);
        Item item2 = new Item();
        item2.setId(2L);
        item2.setItemName("item2");
        item2.setCost(400);
        Item item3 = new Item();
        item3.setId(3L);
        item2.setItemName("item3");
        item2.setCost(300);

        pawnShopService.addItem(item1);
        pawnShopService.addItem(item2);
        pawnShopService.addItem(item3);

        Assert.assertEquals(3, pawnShopService.getAllItems().size());
    }
}
