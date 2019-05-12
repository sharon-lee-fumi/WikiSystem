package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Item;

public class DAO {
	
	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void saveOrUpdateItem(Item item) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(item);
		
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Item> getItemList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createNamedQuery("Item.getItemList");
		List<Item> itemList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return itemList;
	}
	
	public List<Item> searchItemList(String word) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createNamedQuery("Item.searchItemList");
		query.setParameter("word", "%" + word + "%");
		List<Item> itemList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return itemList;
	}
	
	public Item getItem(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createNamedQuery("Item.getItem");
		query.setParameter("id", id);
		Item item = (Item) query.getResultList().get(0);
		
		session.getTransaction().commit();
		session.close();
		
		return item;
		
	}
	
	public void deleteItem(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Item toDelete = session.get(Item.class, id);
		session.delete(toDelete);
		
		session.getTransaction().commit();
		session.close();
	}

}
