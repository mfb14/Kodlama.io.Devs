/**
 * LanguageTechnologyRepository.java
 */
package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.LanguageTechnology;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 5:25:45 PM
 */
@Repository
public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology, Integer>{

	/**
	 * @param name
	 */
	List<LanguageTechnology> findByNameContainingIgnoreCase(String name);

}
