package com.pbasco.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbasco.language.models.Language;
import com.pbasco.language.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("addNew") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("addNew") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		List<Language> languages = languageService.allLanguages();
    		model.addAttribute("languages", languages);
            return "/languages/index.jsp";
        }
        else {
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
	}
	
	@RequestMapping(value="/languages/edit/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        }
        else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
	}
	
	@RequestMapping(value="/languages/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
            return "/languages/edit.jsp";
    }
	
	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}

	
	
}
