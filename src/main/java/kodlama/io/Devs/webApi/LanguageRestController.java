/**
 * LanguageRestController.java
 */
package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import kodlama.io.Devs.business.requests.languages.LanguageCreateRequest;
import kodlama.io.Devs.business.requests.languages.LanguageUpdateRequest;
import kodlama.io.Devs.business.responses.languages.LanguageListResponse;
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
	public ResponseEntity<Language> saveLanguage(@RequestBody LanguageCreateRequest language) throws Exception {
		return new ResponseEntity<Language>(languageService.save(language), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<Language> updateLanguage(@RequestBody LanguageUpdateRequest language,@PathVariable Integer id) throws Exception {
		return new ResponseEntity<Language>(languageService.updateLanguage(language, id), HttpStatus.OK);
	}
	
	@GetMapping("/name")
	public ResponseEntity<List<LanguageListResponse>> findLanguageByName(@RequestParam String name) {
		return new ResponseEntity<List<LanguageListResponse>>(languageService.findLanguageByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<LanguageListResponse> findLanguageById(@RequestParam Integer id) {
		return ResponseEntity.ok(languageService.findLanguageById(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLanguage(@PathVariable Integer id) throws Exception {
		languageService.deleteLanguage(id);
		return ResponseEntity.noContent().build();
	}
}
