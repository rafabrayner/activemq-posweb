package com.rafabrayner.presentation.dto.patient;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PatientResponseTo {
	private UUID code;
    private String name;
}
