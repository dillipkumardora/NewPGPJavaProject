package com.niit.SkillMapperBackend1.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SkillMapperBackend1.dao.ItemsDAO;
import com.niit.SkillMapperBackend1.model.Items;

public class ItemsTest {

	private static AnnotationConfigApplicationContext context;
	private static ItemsDAO itemsDAO;

	private static Items items;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.SkillMapperBackend1");
		context.refresh();

		itemsDAO = (ItemsDAO) context.getBean("itemsDAO");

	}
@Ignore
	@Test
	public void testAddItems() {
		items=new Items();

		items.setId(1);
		items.setDesc("This is a nice item");
		items.setPrice(20000);
		items.setQuantity(3);

		assertEquals("item is added Successfully", true, itemsDAO.addItem(items));
	}
	@Ignore
	 @Test
	 public void testGetItems(){
		  
		 items=itemsDAO.findById(1);
		  assertEquals("item is retreved Successfully",1,items.getId()
		  );
	 }
	 
	 @Test 
	 public void testDeleteItems(){
		  
		 items=itemsDAO.findById(1);
		  
		 assertEquals(true,itemsDAO.deleteItem(items));
	 }

}
