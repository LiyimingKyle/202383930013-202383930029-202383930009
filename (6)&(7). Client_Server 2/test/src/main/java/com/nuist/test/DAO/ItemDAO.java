package com.nuist.test.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuist.test.Entity.ItemTable;

import java.util.List;

public interface ItemDAO extends JpaRepository<ItemTable, Integer> {

    List<ItemTable> findByItemName(String itemName);
}