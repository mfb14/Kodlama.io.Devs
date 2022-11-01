/**
 * LanguageRestController.java
 */
package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.Language;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 9:17:50 PM
 */
@RestController
@RequestMapping("/language")
public class LanguageRestController {

	LanguageService languageService;
	
	public LanguageRestController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@GetMapping
	public List<Language> getAlL(){
		return languageService.getAll();
	}
	
	@PostMapping("/create")
	public void saveLanguage(@RequestBody Language language) throws Exception {
		languageService.saveLanguage(language);
	}
	@PutMapping("/update/{id}")
	public Language updateLanguage(@RequestParam String language, @PathVariable Integer id) {
		return languageService.updateLanguage(language, id);
	}
	@GetMapping("/name")
	public Language findLanguageByName(@RequestParam String name) {
		return languageService.findLanguageByName(name);
	}
	
	@GetMapping("/id")
	public Language findLanguageById(@RequestParam Integer id) {
		return languageService.findLanguageById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteLanguage(@PathVariable Integer id) {
		languageService.deleteLanguage(id);
	}
}
