package com.niit.SkillMapperRestApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SkillMapperBackend1.dao.ItemsDAO;
import com.niit.SkillMapperBackend1.model.Items;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins="http://localhost:4200")
public class RestControllers {

	@Autowired
	ItemsDAO itemsDAO;
	
	//for all items
	@RequestMapping(value = {"/listitems"}, method = RequestMethod.GET)
	public ResponseEntity<List<Items>> listItems() {
		List<Items> item = itemsDAO.findall();
		System.out.println(item);
		
		return new ResponseEntity<List<Items>>(item, HttpStatus.OK);
			
	}
	
	//for add items
	@RequestMapping(value = {"/additems"}, method = RequestMethod.POST)
	public ResponseEntity<Items> addItems(@RequestBody Items items) {
		System.out.println("Add now...................");
		itemsDAO.addItem(items);
		return new ResponseEntity<Items>(items,HttpStatus.OK);
			
	}
	//for update items
	@RequestMapping(value = {"/updateitems"}, method = RequestMethod.PUT)
	public ResponseEntity<Items> updateItems(@RequestBody Items items) {
		System.out.println("update now...................");
		itemsDAO.updateItem(items);
		return new ResponseEntity<Items>(items,HttpStatus.OK);
			
	}
	
	//for delete items
	@RequestMapping(value={"/deleteitems/{id}"},method=RequestMethod.DELETE)
	public ResponseEntity<Items> deleteItems(@PathVariable("id") int id)
	{
		Items items=itemsDAO.findById(id) ;
		itemsDAO.deleteItem(items);
				return new ResponseEntity<Items>(items,HttpStatus.NO_CONTENT);
	}
	

		@RequestMapping(value={"/find/item/{id}"} , method=RequestMethod.GET)
		public ResponseEntity<Items> findById(@PathVariable("id") int id)
		{
			Items item=itemsDAO.findById(id);
			
			return new ResponseEntity<Items>(item,HttpStatus.OK);
		}
		
}
