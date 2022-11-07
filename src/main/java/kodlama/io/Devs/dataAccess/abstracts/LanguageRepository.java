/**
 * LanguageRepository.java
 */
package kodlama.io.Devs.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:03:14 PM
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{



	Language findByName(String name);


	/**
	 * @param name
	 */
	List<Language> findByNameContainingIgnoreCase(String name);


}
