package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ItemResDto;
import com.example.entity.Item;
import com.example.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public ItemResDto detail(@PathVariable Integer id) {
		
		// サービスより取得
		Item item = service.getItem(id);
		
		// レスポンスに値を設定
		ItemResDto res;
		if(item != null) {
			res = new ItemResDto(item.getId(), 
					item.getName(), 
					item.getPrice(), 
					item.getCreateAt(), 
					item.getUpdateAt());
		} else {
			res = null;
		}
		return res;
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public List<ItemResDto> list() {
		
		// サービスより取得
		List<Item> items = service.getItems();
		
		// レスポンスに値を設定
		List<ItemResDto> res;
		if(items != null) {
			res = new ArrayList<>();
			for(Item item : items) {
				ItemResDto itemDto = new ItemResDto(item.getId(), 
						item.getName(), 
						item.getPrice(), 
						item.getCreateAt(), 
						item.getUpdateAt()); 
				res.add(itemDto);
			}
		} else {
			res = null;
		}
		return res;
	}
}
