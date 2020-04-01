package com.driveeat.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driveeat.entity.TimetablesDefinitions;
import com.driveeat.repository.TimetablesDefinitionsRepository;

@Service
public class TimetablesDefinitionsService {

	@Autowired
	private TimetablesDefinitionsRepository timetablesDefinitionsRepository;

	public List<TimetablesDefinitions> getAll() {
		return (List<TimetablesDefinitions>) timetablesDefinitionsRepository.findAll();
	}

	public Optional<TimetablesDefinitions> getOne(Integer Id) {
		return timetablesDefinitionsRepository.findById(Id);
	}

	public void addNew(TimetablesDefinitions timetablesDefinitions) {
		timetablesDefinitionsRepository.save(timetablesDefinitions);
	}

	public void update(TimetablesDefinitions timetablesDefinitions) {
		timetablesDefinitionsRepository.save(timetablesDefinitions);
	}

	public void delete(Integer id) {
		timetablesDefinitionsRepository.deleteById(id);
	}
}
