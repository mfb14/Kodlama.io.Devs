/**
 * LanguageTechnologyService.java
 */
package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.LanguageTechnology;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 5:25:07 PM
 */
public interface LanguageTechnologyService {

	List<LanguageTechnology> findAll();
}
