package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
	@NamedQuery(name="Item.getItemList", query="from Item"),
	@NamedQuery(name="Item.getItem", query="from Item where id=:id"),
	@NamedQuery(name="Item.searchItemList", query="from Item where title like :word or category like :word or summary like :word"),
}) 
public class Item implements Serializable{
	
	private final String[] CATEGORYS = new String[]{"Arts", "Biography", "History", "Science", "Technology", "Society"};
	
	@Id
	@GeneratedValue
	@Positive
	private int id;	// primary key
	@Length(min=3, max=40)
	private String title;
	private String category;
	//@Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message="Invalid phone number! Example: (123)123-1234")
	@Length(min=10, message = "Summary must be at least 10 characters")
	private String summary;
	//@Pattern(regexp="([ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][ ]?\\d[ABCEGHJ-NPRSTV-Z]\\d)", message="Invalid postal code! Example: A3J 4G5")
	
	@Embedded
	@Valid
	private Contents contents;
	
	public Item(String title) {
		super();
		this.title = title;
	}
	
	
}
