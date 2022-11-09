/**
 * LanguageListWithTechnologyResponse.java
 */
package kodlama.io.Devs.business.responses.languages;


import java.util.List;

import kodlama.io.Devs.entities.Language;
import kodlama.io.Devs.entities.LanguageTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 8, 2022 3:52:00 PM
 */
@Data
@NoArgsConstructor
public class LanguageListWithTechnologyResponse {

	String name;
	List<LanguageTechnology> techs;
	
	private LanguageListWithTechnologyResponse(String name, List<LanguageTechnology> techs) {
		this.name = name;
		this.techs = techs;
	}
	
	public static LanguageListWithTechnologyResponse from(Language languages) {
		return new LanguageListWithTechnologyResponse(languages.getName(),languages.getLanguageTechnology());
	}
	
	
	
}
