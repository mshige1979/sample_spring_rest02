package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	public Item findById(Integer id);
	
	@Query("select i from Item i order by i.id asc")
	public List<Item> findByAll();
}
