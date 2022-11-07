/**
 * LanguageTechnologyUpdateRequest.java
 */
package kodlama.io.Devs.business.requests.languageTechnologies;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 10:45:47 PM
 */
@Data
public class LanguageTechnologyUpdateRequest {

	@NotBlank
	String name;
	Integer languageId;
	
}
