package ca.sheridancollege.controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Item;
import ca.sheridancollege.dao.DAO;

@Controller
public class HomeController {

/* Extra Functionality: 
 * JUnit test DAO functions: saveOrUpdateItem & searchItemList
 * 
 */
	
	private DAO dao = new DAO();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("itemList", dao.getItemList());
		return "home";
	}

	@RequestMapping(value="/createItem", method=RequestMethod.GET)
	public String createItem(Model model)
	{
		Item item = new Item();
		dao.saveOrUpdateItem(item);
		model.addAttribute("item", item);
		return "createItem";
	}
	
	@RequestMapping(value="/createPage/{id}", method=RequestMethod.POST)
	public String createPage(Model model, @ModelAttribute Item item)
	{
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Item>> constraintViolations =
				validator.validate(item);
		
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Item> violation : constraintViolations) {
				model.addAttribute(violation.getPropertyPath().toString() .replace(".",
			"_"), violation.getMessage());
			model.addAttribute("item", item);
			}
			return "createItem";
		}
		else {
			dao.saveOrUpdateItem(item);
		}
		model.addAttribute("item", item);
		return "displayPage";
	}
	
	@RequestMapping(value="editItem/{id}", method=RequestMethod.GET)
	public String editItem(Model model, @PathVariable int id)
	{
		Item item = dao.getItem(id);
		model.addAttribute("item", item);
		return "createItem";
	}
	
	@RequestMapping(value="deleteItem/{id}", method=RequestMethod.GET)
	public String deleteItem(Model model, @PathVariable int id) {
		
		dao.deleteItem(id);
		model.addAttribute("itemList", dao.getItemList());
		return "home";
	}
	
	@RequestMapping(value="/displayPage/{id}", method=RequestMethod.GET)
	public String displayPage(Model model, @PathVariable int id)
	{
		Item item = dao.getItem(id);
		model.addAttribute("item", item);
		return "displayPage";
	}
	
	@RequestMapping(value="/searchItem", method=RequestMethod.GET)
	public String searchItem(Model model, @RequestParam String word)
	{
		model.addAttribute("itemList", dao.searchItemList(word));
		return "home";
	}
	
}
