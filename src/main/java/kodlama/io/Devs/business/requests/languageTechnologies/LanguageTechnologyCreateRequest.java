/**
 * LanguageTechnologyCreateRequest.java
 */
package kodlama.io.Devs.business.requests.languageTechnologies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 6:00:22 PM
 */
@Data
public class LanguageTechnologyCreateRequest {
	
	@NotBlank
	String name;
	@NotNull
	Integer languageId;
}
