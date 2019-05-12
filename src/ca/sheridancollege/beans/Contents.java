package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contents implements Serializable {

	private String content;
	@Pattern(regexp="^(|https?:\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?)$", message="Invalid Link! Example: 'https://stackoverflow.com'. Use ';' to seperate multiple links")
	private String referenceLink;
	
}
