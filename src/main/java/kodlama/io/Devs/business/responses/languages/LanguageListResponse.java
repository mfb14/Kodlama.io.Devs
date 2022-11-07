/**
 * LanguageListResponse.java
 */
package kodlama.io.Devs.business.responses.languages;



import kodlama.io.Devs.entities.Language;
import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 9:40:13 PM
 */
@Data
public class LanguageListResponse {

	String name;

	
	LanguageListResponse(String name){
		this.name=name;
		
	}
	
	public static LanguageListResponse from(Language language) {
		
		return new LanguageListResponse(language.getName());
	
	}

	
}
