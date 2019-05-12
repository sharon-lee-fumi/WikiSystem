package ca.sheridancollege.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.beans.Item;
import ca.sheridancollege.dao.DAO;

class SearchItemTest {

	DAO dao = new DAO();
	
	@BeforeEach
	void initialize() {

		Item item = new Item("Every Day is a New Day!");
		dao.saveOrUpdateItem(item);
	}
	
	@Test
	void searchItemTest() {

		Item result = dao.searchItemList("Every Day is a New Day!").get(0);
		assertEquals("Every Day is a New Day!", result.getTitle());
	}

	
	@AfterEach
	void clean() {

		Item result = dao.searchItemList("Every Day is a New Day!").get(0);
		dao.deleteItem(result.getId());
	}
}
