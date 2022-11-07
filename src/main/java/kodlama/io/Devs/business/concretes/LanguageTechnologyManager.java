/**
 * LanguageTechnologyManager.java
 */
package kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import kodlama.io.Devs.business.requests.languageTechnologies.LanguageTechnologyCreateRequest;
import kodlama.io.Devs.business.requests.languageTechnologies.LanguageTechnologyUpdateRequest;
import kodlama.io.Devs.business.responses.languageTechnologies.LanguageTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.LanguageTechnologyRepository;
import kodlama.io.Devs.entities.Language;
import kodlama.io.Devs.entities.LanguageTechnology;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 11:06:01 PM
 */
@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {

	LanguageRepository languageRepository;
	LanguageTechnologyRepository languageTechnologyRepository;
	
	
	
	public LanguageTechnologyManager(LanguageRepository languageRepository,
			LanguageTechnologyRepository languageTechnologyRepository) {
		this.languageRepository = languageRepository;
		this.languageTechnologyRepository = languageTechnologyRepository;
	}

	@Override
	public LanguageTechnology save(LanguageTechnologyCreateRequest request) {
		LanguageTechnology tech = new LanguageTechnology();
		Language lang = languageRepository.findById(request.getLanguageId()).get();
		tech.setName(request.getName());
		tech.setLanguage(lang);
		return languageTechnologyRepository.save(tech);
		
	}

	@Override
	public List<LanguageTechnologyResponse> findAll() {
	
		return languageTechnologyRepository.findAll().stream()
													 .map(LanguageTechnologyResponse::from)
													 .collect(Collectors.toList());
		
	}

	@Override
	public LanguageTechnologyResponse update(LanguageTechnologyUpdateRequest request, Integer id) {
		LanguageTechnology languageTechnology = languageTechnologyRepository.findById(id).get();
		
		languageTechnology.setName(request.getName());
		languageTechnology.setLanguage(languageRepository.findById(request.getLanguageId()).get());
		languageTechnologyRepository.save(languageTechnology);
		return LanguageTechnologyResponse.from(languageTechnology);
		
	}

	@Override
	public void deleteById(Integer id) {
		languageTechnologyRepository.deleteById(id);

	}

	@Override
	public List<LanguageTechnologyResponse> findByNameContainingIgnoreCase(String name) {
		return languageTechnologyRepository.findByNameContainingIgnoreCase(name).stream()
																				.map(LanguageTechnologyResponse::from)
																				.collect(Collectors.toList());
	}

	@Override
	public LanguageTechnologyResponse findById(Integer id) {
		return LanguageTechnologyResponse.from(languageTechnologyRepository.findById(id).get());
	}

	@Override
	public List<LanguageTechnologyResponse> findAllByLanguageName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
