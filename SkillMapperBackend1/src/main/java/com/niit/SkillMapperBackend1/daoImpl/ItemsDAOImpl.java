package com.niit.SkillMapperBackend1.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SkillMapperBackend1.dao.ItemsDAO;
import com.niit.SkillMapperBackend1.model.Items;

@Repository("itemsDAO")
@Transactional
public class ItemsDAOImpl implements ItemsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Items> findall() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Items",Items.class).getResultList();
	}

	@Override
	public Items findById(int id) {
		try{
			return sessionFactory.getCurrentSession().get(Items.class, Integer.valueOf(id));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addItem(Items items) {
		try{
			sessionFactory.getCurrentSession().persist(items);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItem(Items items) {
		try{
			sessionFactory.getCurrentSession().update(items);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteItem(Items items) {
		try {
			sessionFactory.getCurrentSession().delete(items);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
