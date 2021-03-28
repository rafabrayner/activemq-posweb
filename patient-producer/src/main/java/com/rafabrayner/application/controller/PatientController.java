package com.rafabrayner.application.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafabrayner.application.service.ResponseService;
import com.rafabrayner.domain.model.Patient;
import com.rafabrayner.domain.service.ProducerService;
import com.rafabrayner.presentation.dto.patient.PatientRequestTo;
import com.rafabrayner.presentation.dto.patient.PatientResponseTo;
import com.rafabrayner.presentation.dto.shared.ResponseTo;

import lombok.AllArgsConstructor;

import static com.rafabrayner.presentation.mapper.PatientMapper.from;

@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor
public class PatientController {

	private final ProducerService<Patient> patientService;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<ResponseTo<PatientResponseTo>> wait(@RequestBody PatientRequestTo patientRequest) {
        Patient patient = from(patientRequest);

        patientService.send(patient);

        return responseService.accepted(from(patient));
    }
}
