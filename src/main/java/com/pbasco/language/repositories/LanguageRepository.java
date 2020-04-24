package com.pbasco.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pbasco.language.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();

}
