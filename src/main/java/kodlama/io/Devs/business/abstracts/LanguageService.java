/**
 * LanguageService.java
 */
package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:00:24 PM
 */
public interface LanguageService {
	
	public List<Language> getAll();
	public void saveLanguage(Language language) throws Exception;
	public Language updateLanguage(String name, Integer id);
	public Language findLanguageById(Integer id);
	public Language findLanguageByName(String name);
	public void deleteLanguage(Integer id);
	public boolean isNameExist(Language language);
	public boolean isNameEmpty(Language language);
	public boolean isIdExist(Language language);
	

}
