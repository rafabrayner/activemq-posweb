package com.rafabrayner.presentation.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import com.rafabrayner.domain.model.Patient;
import com.rafabrayner.presentation.dto.PatientTo;

public final class PatientMapper {

	public static Patient from(PatientTo pacienteTo, UUID hospitalCode) {
        return Patient
                .builder()
                .code(pacienteTo.getCode())
                .name(pacienteTo.getName())
                .hospitalCode(hospitalCode)
                .hospitalizationDateTime(LocalDateTime.now())
                .status("Hospitalized")
                .build();
    }
}
