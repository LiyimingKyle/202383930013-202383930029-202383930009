package com.nuist.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuist.test.DAO.ItemDAO;
import com.nuist.test.Entity.ItemTable;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDAO itemDAO;

    public List<ItemTable> findItemsByName(String itemName) {
        return itemDAO.findByItemName(itemName);
    }

    public ItemTable addItem(ItemTable item) {
        return itemDAO.save(item);
    }

    public void deleteItemById(Integer id) {
        itemDAO.deleteById(id);
    }

    public List<ItemTable> findAllItems() {
        return itemDAO.findAll();
    }
}
