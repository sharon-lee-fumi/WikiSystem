package ca.sheridancollege.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.beans.Contents;
import ca.sheridancollege.beans.Item;
import ca.sheridancollege.dao.DAO;

class SaveItemTest {

	DAO dao = new DAO();
	
	@BeforeEach
	void initialize() {
		
		Item item = new Item("Sheridan College");
		dao.saveOrUpdateItem(item);
	}
	
	@Test
	void saveItemTest() {

		Item search = dao.searchItemList("Sheridan College").get(0);
		Contents contents = new Contents();
		Item item = new Item(search.getId(), "FAST", "Society", "College in Ontario", contents);
		dao.saveOrUpdateItem(item);
		Item result = dao.getItem(search.getId());
		assertEquals("FAST", result.getTitle());
	}
	
	@AfterEach
	void clean() {

		Item item = dao.searchItemList("FAST").get(0);
		dao.deleteItem(item.getId());
	}
}
