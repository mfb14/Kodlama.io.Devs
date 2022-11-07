/**
 * LanguageCreateRequest.java
 */
package kodlama.io.Devs.business.requests.languages;

import javax.validation.constraints.NotBlank;


import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 5:52:04 PM
 */
@Data
public class LanguageCreateRequest {
	
	@NotBlank
	String name;
}
