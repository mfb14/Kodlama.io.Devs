/**
 * LanguageUpdateRequest.java
 */
package kodlama.io.Devs.business.requests.languages;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 6:37:19 PM
 */
@Data
public class LanguageUpdateRequest {

	@JsonIgnore
	Integer id;
	String name;
	
}
