/**
 * LanguageRepository.java
 */
package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:03:14 PM
 */
public interface LanguageRepository extends JpaRepository<Language, Integer>{

	List<Language> getAll();
	void saveLanguage(Language language);
	Language updateLanguage(String name, Integer id);
	Language findLanguageById(Integer id);
	Language findLanguageByName(String name);
	void deleteLanguage(Integer id);
}
