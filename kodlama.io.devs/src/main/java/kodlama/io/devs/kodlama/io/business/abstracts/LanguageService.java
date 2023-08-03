package kodlama.io.devs.kodlama.io.business.abstracts;

import java.util.List;

import kodlama.io.devs.kodlama.io.business.requests.CreateLanguageRequest;
import kodlama.io.devs.kodlama.io.business.requests.DeleteLanguageRequest;
import kodlama.io.devs.kodlama.io.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.kodlama.io.business.responses.CreateLanguageResponse;
import kodlama.io.devs.kodlama.io.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.kodlama.io.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.kodlama.io.business.responses.UpdateLanguageResponse;


public interface LanguageService {
	List<CreateLanguageResponse> add(CreateLanguageRequest createLanguageRequest) throws Exception;
	String delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
	UpdateLanguageResponse update(int id,UpdateLanguageRequest updateLanguageRequest) throws Exception;
	List<GetAllLanguagesResponse> getAll();
	GetByIdLanguageResponse getById(int id) throws Exception;
}
