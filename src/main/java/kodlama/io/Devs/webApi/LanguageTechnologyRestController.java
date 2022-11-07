/**
 * LanguageTechnologyRestController.java
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

import kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import kodlama.io.Devs.business.requests.languageTechnologies.LanguageTechnologyCreateRequest;
import kodlama.io.Devs.business.requests.languageTechnologies.LanguageTechnologyUpdateRequest;
import kodlama.io.Devs.business.responses.languageTechnologies.LanguageTechnologyResponse;
import kodlama.io.Devs.entities.LanguageTechnology;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 7, 2022 10:21:41 PM
 */
@RestController
@RequestMapping("/technologies")
public class LanguageTechnologyRestController {
	LanguageTechnologyService languageTechnologyService;
	
	
	
	public LanguageTechnologyRestController(LanguageTechnologyService languageTechnologyService) {
		this.languageTechnologyService = languageTechnologyService;
	}

	@PostMapping("create")
	public ResponseEntity<LanguageTechnology> save(@RequestBody LanguageTechnologyCreateRequest request){
		
		return new ResponseEntity<LanguageTechnology>(languageTechnologyService.save(request),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<LanguageTechnologyResponse> update(@RequestBody LanguageTechnologyUpdateRequest request, @PathVariable Integer id){
		return new ResponseEntity<LanguageTechnologyResponse>(languageTechnologyService.update(request, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		languageTechnologyService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<LanguageTechnologyResponse>> findAll(){
		return new ResponseEntity<List<LanguageTechnologyResponse>>(languageTechnologyService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/name")
	public ResponseEntity<List<LanguageTechnologyResponse>> findTechnologyByName(@RequestParam String name){
		return ResponseEntity.ok(languageTechnologyService.findByNameContainingIgnoreCase(name));
	}
	
	@GetMapping("/id")
	public ResponseEntity<LanguageTechnologyResponse> findTechnologyById(@RequestParam Integer id){
		return ResponseEntity.ok(languageTechnologyService.findById(id));
	}
	
	@GetMapping("/languageName")
	public ResponseEntity<List<LanguageTechnologyResponse>> findAllByLanguageName(@RequestParam String name){
		languageTechnologyService.findAllByLanguageName(name);
	}
}
