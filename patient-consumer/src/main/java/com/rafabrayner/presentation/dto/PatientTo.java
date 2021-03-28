package com.rafabrayner.presentation.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString(includeFieldNames = true)
public class PatientTo {

	private UUID code;
    private String name;
}
