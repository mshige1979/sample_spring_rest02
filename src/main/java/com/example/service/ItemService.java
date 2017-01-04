package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	ItemRepository repo;
	
	/**
	 * 1件取得
	 * @param id
	 * @return
	 */
	public Item getItem(Integer id) {
		Item item = repo.findById(id);
		return item;
	}
	
	/**
	 * 全件取得
	 * @return
	 */
	public List<Item> getItems() {
		List<Item> items = repo.findByAll();
		return items;
	}
}
