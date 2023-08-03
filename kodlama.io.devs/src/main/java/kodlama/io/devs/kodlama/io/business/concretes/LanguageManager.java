package kodlama.io.devs.kodlama.io.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.devs.kodlama.io.business.abstracts.LanguageService;
import kodlama.io.devs.kodlama.io.business.requests.CreateLanguageRequest;
import kodlama.io.devs.kodlama.io.business.requests.DeleteLanguageRequest;
import kodlama.io.devs.kodlama.io.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.kodlama.io.business.responses.CreateLanguageResponse;
import kodlama.io.devs.kodlama.io.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.kodlama.io.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.kodlama.io.business.responses.UpdateLanguageResponse;
import kodlama.io.devs.kodlama.io.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.kodlama.io.entities.concretes.Language;


@Service
public class LanguageManager implements LanguageService {

	private final LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<CreateLanguageResponse> add(CreateLanguageRequest createLanguageRequest) throws Exception {
		 if (createLanguageRequest == null || createLanguageRequest.getName() == null) {
		        throw new IllegalArgumentException("Invalid parameter!");
		    }
		List<Language> languages = languageRepository.findAll();
		for (Language language : languages) {
			if(language.getName().equals(createLanguageRequest.getName()))
			{
				throw new Exception("This language already exist");
			}
			
		}
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		languageRepository.save(language);

		List<CreateLanguageResponse> responseList = new ArrayList<>();
		responseList.add(new CreateLanguageResponse(language.getId(), language.getName()));
		return responseList;

	}

	@Override
	public String delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
		if(languageRepository.existsById(deleteLanguageRequest.getId()))
		{
			languageRepository.deleteById(deleteLanguageRequest.getId());
		}
		else
		{
			throw new Exception("No matching record found!");
		}
		
		return "Record "+ deleteLanguageRequest.getId() +" has been deleted";

	}

	@Override
	public UpdateLanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest) throws Exception {
		UpdateLanguageResponse response = new UpdateLanguageResponse();
		if(languageRepository.existsById(id))
		{
			Optional<Language> optionalLanguages = languageRepository.findById(id);
			if(optionalLanguages.isPresent())
			{
				Language language = optionalLanguages.get();
				language.setName(updateLanguageRequest.getName());
				languageRepository.save(language);
				
				response.setId(language.getId());
				response.setName(language.getName());
			}
		}
		else
		{
			throw new Exception("No matching record found!");
		}
			
		return response;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<GetAllLanguagesResponse> response = new ArrayList<>();
		List<Language> languages = languageRepository.findAll();

		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			response.add(responseItem);
		}

		return response;

	}

	@Override
	public GetByIdLanguageResponse getById(int id) throws Exception {
		GetByIdLanguageResponse response = new GetByIdLanguageResponse();
		if(languageRepository.existsById(id))
		{
			response.setId(languageRepository.findById(id).get().getId());
			response.setName(languageRepository.findById(id).get().getName());
		}
		
		else
		{
			throw new Exception("No matching record found!");
		}

		return response;
	}

}
