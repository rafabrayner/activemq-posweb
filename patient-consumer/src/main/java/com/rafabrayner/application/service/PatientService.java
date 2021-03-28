package com.rafabrayner.application.service;

import org.springframework.stereotype.Service;

import com.rafabrayner.domain.model.Patient;

import lombok.AllArgsConstructor;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class PatientService {
	
	// TODO user repository
	// private final PacienteRepository repository;
	
	public Patient update(Patient patient) {
        return nonNull(patient) ? patient : null;
    }

}
