package com.niit.SkillMapperBackend1.dao;

import java.util.List;

import com.niit.SkillMapperBackend1.model.Items;

public interface ItemsDAO {

	List<Items> findall();
	Items findById(int id);
	boolean addItem(Items items);
	boolean updateItem(Items items);
	boolean deleteItem(Items items);
	
	
}
