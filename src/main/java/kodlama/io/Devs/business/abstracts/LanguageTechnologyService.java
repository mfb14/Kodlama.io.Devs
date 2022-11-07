/**
 * LanguageTechnologyService.java
 */
package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languageTechnologies.LanguageTechnologyCreateRequest;
import kodlama.io.Devs.business.requests.languageTechnologies.LanguageTechnologyUpdateRequest;
import kodlama.io.Devs.business.responses.languageTechnologies.LanguageTechnologyResponse;
import kodlama.io.Devs.entities.LanguageTechnology;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 5:25:07 PM
 */
public interface LanguageTechnologyService {

	public LanguageTechnology save(LanguageTechnologyCreateRequest request);
	public List<LanguageTechnologyResponse> findAll();
	public LanguageTechnologyResponse update(LanguageTechnologyUpdateRequest request, Integer id);
	public void deleteById(Integer id);
	public List<LanguageTechnologyResponse> findByNameContainingIgnoreCase(String name);
	public LanguageTechnologyResponse findById(Integer id);
	public List<LanguageTechnologyResponse> findAllByLanguageName(String name);
	
	
}
