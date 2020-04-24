package com.pbasco.language.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.pbasco.language.models.Language;
import com.pbasco.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;	
	}
	
	// returns all the books
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	// retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        }
        else {
            return null;
        }
    }
    
    // update a language
    public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
    	Optional <Language> temp = languageRepository.findById(id);
    	if(temp != null) {
    		temp.get().setName(name);
    		temp.get().setCreator(creator);
    		temp.get().setCurrentVersion(currentVersion);
    		
    		return temp.get();
    	}
    	return null;
    }
    
    // adds a language
    public Language addLanguage(Language l) {
    	return languageRepository.save(l);
    }
    
    // removes a language
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }

	public void updateLanguage(@Valid Language language) {
		// TODO Auto-generated method stub
		
	}
}