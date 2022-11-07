/**
 * LanguageTechnologyResponse.java
 */
package kodlama.io.Devs.business.responses.languageTechnologies;

import kodlama.io.Devs.entities.LanguageTechnology;
import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 10:34:15 PM
 */
@Data
public class LanguageTechnologyResponse {

	String name;
	String languageName;
	private LanguageTechnologyResponse(LanguageTechnology languageTechnology){
		this.name=languageTechnology.getName();
		this.languageName = languageTechnology.getLanguage().getName();
	}
	
	public static LanguageTechnologyResponse from(LanguageTechnology languageTechnology) {
		return new LanguageTechnologyResponse(languageTechnology);
	}


	
	
}
