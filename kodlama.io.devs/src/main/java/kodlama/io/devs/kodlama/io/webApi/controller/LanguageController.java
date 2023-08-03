package kodlama.io.devs.kodlama.io.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.kodlama.io.business.abstracts.LanguageService;
import kodlama.io.devs.kodlama.io.business.requests.CreateLanguageRequest;
import kodlama.io.devs.kodlama.io.business.requests.DeleteLanguageRequest;
import kodlama.io.devs.kodlama.io.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.kodlama.io.business.responses.CreateLanguageResponse;
import kodlama.io.devs.kodlama.io.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.kodlama.io.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.kodlama.io.business.responses.UpdateLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}


	@PostMapping("/add")
	public List<CreateLanguageResponse> add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		return languageService.add(createLanguageRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdLanguageResponse getById(int id) throws Exception {
		return languageService.getById(id);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) throws Exception {
		return languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public UpdateLanguageResponse update(int id,@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
		return languageService.update(id, updateLanguageRequest);
	}
}
