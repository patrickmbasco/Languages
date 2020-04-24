package com.pbasco.language.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbasco.language.models.Language;
import com.pbasco.language.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService languageService;	
	public LanguageApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index(){
		return languageService.allLanguages();
	}
	
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language add(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
        Language language = new Language(name, creator, currentVersion);
        return languageService.addLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
    	Language language = languageService.findLanguage(id);
    	return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
        Language language = new Language(name, creator, currentVersion);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
    }
	
}
