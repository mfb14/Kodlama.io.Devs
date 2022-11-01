/**
 * LanguageManager.java
 */
package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:17:24 PM
 */
@Service
public class LanguageManager implements LanguageService {

	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	LanguageRepository languageRepository;
	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public void saveLanguage(Language language) throws Exception{
		
		if(language.getName().isEmpty())
			throw new Exception("Name is empty, fill the blanks!");
		else {
			if(!isNameExist(language)||!isIdExist(language)) {
				throw new Exception("Name or Id already exist. Try Again");
			}
			else
				languageRepository.saveLanguage(language);
		}

	}

	@Override
	public Language updateLanguage(String name, Integer id) {
			return languageRepository.updateLanguage(name, id);
	}

	@Override
	public Language findLanguageById(Integer id) {
		
		return languageRepository.findLanguageById(id-1);
	}

	@Override
	public Language findLanguageByName(String name) {
		return languageRepository.findLanguageByName(name);
	}

	@Override
	public void deleteLanguage(Integer id) {
		languageRepository.deleteLanguage(id);

	}

	@Override
	public boolean isNameExist(Language language) {
		return language.getName().equals(findLanguageById(language.getId()-1).getName())?false:true; 
		
	}

	@Override
	public boolean isNameEmpty(Language language) {
		return language.getName().isEmpty()?false:true;
	}

	@Override
	public boolean isIdExist(Language language) {
		return language.getId().equals(findLanguageById(language.getId()-1).getId())?false:true;
	}

}
