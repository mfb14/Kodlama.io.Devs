/**
 * InMemeoryLanguageRepository.java
 */
package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:04:59 PM
 */
@Repository
public class InMemeoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	public InMemeoryLanguageRepository() {
		languages = new ArrayList<>();
		
		languages.add(new Language(1, "C"));
		languages.add(new Language(2, "C++"));
		languages.add(new Language(3, "Java"));
		languages.add(new Language(4, "Go"));
		languages.add(new Language(5, "Python"));
		languages.add(new Language(6, "Scala"));
		
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public void saveLanguage(Language language) {
		
		  languages.add(language);
	}

	@Override
	public Language updateLanguage(String name, Integer id) {
		 languages.get(id).setName(name);
		 return languages.get(id);
		
	}

	@Override
	public Language findLanguageById(Integer id) {
		return languages.get(id);
	}

	/**
	 * @param name	the name to search in List
	 * return	language
	 * */
	@Override
	public Language findLanguageByName(String name) {

	Language lang =	languages.stream()
				 			 .filter(x -> name.equals(x.getName()))
				 			 .findAny()
				 			 .orElse(null);
		
		return lang;		 
				 
	}

	@Override
	public void deleteLanguage(Integer id) {
		languages.remove(id-1);

	}

}
