package com.rafabrayner.presentation.mapper;

import java.util.UUID;

import com.rafabrayner.domain.model.Patient;
import com.rafabrayner.presentation.dto.patient.PatientRequestTo;
import com.rafabrayner.presentation.dto.patient.PatientResponseTo;

public final class PatientMapper {
	
	public static Patient from(PatientRequestTo requestTo) {
        return Patient
                .builder()
                .code(UUID.randomUUID())
                .name(requestTo.getName())
                .build();
    }

    public static PatientResponseTo from(Patient patient) {
        return PatientResponseTo
                .builder()
                .code(patient.getCode())
                .name(patient.getName())
                .build();
    }

}
