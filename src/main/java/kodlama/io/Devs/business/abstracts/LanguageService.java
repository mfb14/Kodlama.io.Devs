/**
 * LanguageService.java
 */
package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languages.LanguageCreateRequest;
import kodlama.io.Devs.business.requests.languages.LanguageUpdateRequest;
import kodlama.io.Devs.business.responses.languages.LanguageListResponse;
import kodlama.io.Devs.business.responses.languages.LanguageListWithTechnologyResponse;
import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:00:24 PM
 */
public interface LanguageService {
	
	public List<Language> getAll();
	public Language save(LanguageCreateRequest language) throws Exception;
	public Language updateLanguage(LanguageUpdateRequest language, Integer id) throws Exception;
	public LanguageListResponse findLanguageById(Integer id);
	public List<LanguageListResponse> findLanguageByName(String name);
	void deleteLanguage(Integer id) throws Exception;
	public List<LanguageListWithTechnologyResponse> getAllwithTechs();


	

}
