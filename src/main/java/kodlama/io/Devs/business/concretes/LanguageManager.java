/**
 * LanguageManager.java
 */
package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languages.LanguageCreateRequest;
import kodlama.io.Devs.business.requests.languages.LanguageUpdateRequest;
import kodlama.io.Devs.business.responses.languageTechnologies.LanguageTechnologyResponse;
import kodlama.io.Devs.business.responses.languages.LanguageListResponse;
import kodlama.io.Devs.business.responses.languages.LanguageListWithTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.LanguageTechnologyRepository;
import kodlama.io.Devs.entities.Language;
import kodlama.io.Devs.entities.LanguageTechnology;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:17:24 PM
 */
@Service
public class LanguageManager implements LanguageService {

	LanguageRepository languageRepository;
	LanguageTechnologyRepository languageTechnologyRepository;
	
	public LanguageManager(LanguageRepository languageRepository,LanguageTechnologyRepository languageTechnologyRepository) {
		this.languageRepository = languageRepository;
		this.languageTechnologyRepository=languageTechnologyRepository;
	}

	
	@Override
	public List<Language> getAll() {
		return languageRepository.findAll();
	}

	@Override
	public Language save(LanguageCreateRequest language) throws Exception{
		
		Language lang = new Language();
		if(isNameExist(language.getName())) {
			lang.setName(language.getName());
			return languageRepository.save(lang);		
		}
		else
			throw new Exception("Language Name is Already Exist!!");	
		
	}

	@Override
	public Language updateLanguage(LanguageUpdateRequest language, Integer id) throws Exception {
		if(isIdExist(id)) {
			Language lang = languageRepository.findById(id).get();
			if(isNameExist(language.getName())) {
				lang.setName(language.getName());
				return lang;
			}	
			else
				throw new Exception("Name is already exist!");
		}
		else
			throw new Exception("LanguageId is not exist!");
			
		
	}

	@Override
	public LanguageListResponse findLanguageById(Integer id) {

		return LanguageListResponse.from(languageRepository.findById(id).get());
	}

	@Override
	public List<LanguageListResponse> findLanguageByName(String name) {
		
		return languageRepository.findByNameContainingIgnoreCase(name).stream()
															          .map(LanguageListResponse::from)
															          .collect(Collectors.toList());
	}

	@Override
	public void deleteLanguage(Integer id) throws Exception {
		if(isIdExist(id))
			languageRepository.deleteById(id);
		else
			throw new Exception("The language with this id could not be found!");

	}

	public boolean isNameExist(String name) {
		
		if(languageRepository.findByName(name)==null)
			return true;
		else
			return false;
	}


	public boolean isIdExist(Integer id) {
		if(languageRepository.findById(id).get().getId()==null)
			return false;
		else
			return true;
	}


	@Override
	public List<LanguageListWithTechnologyResponse> getAllwithTechs() {
		List<Language> lang = languageRepository.findAll();
		List<LanguageTechnology> tech = languageTechnologyRepository.findAll();
		
		List<LanguageListWithTechnologyResponse> list = new ArrayList<LanguageListWithTechnologyResponse>();
		
		for(Language language : lang) {
			List<LanguageTechnologyResponse> techList = new ArrayList<LanguageTechnologyResponse>();
			
			for(LanguageTechnology technology:tech) {
				if(technology.getLanguage().getId()==language.getId())
					techList.add(LanguageTechnologyResponse.from(technology));
			}
			list.add(LanguageListWithTechnologyResponse.from(language));
		}
		return list;
		
	}
}
