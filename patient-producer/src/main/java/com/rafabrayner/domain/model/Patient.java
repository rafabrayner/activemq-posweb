package com.rafabrayner.domain.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString(includeFieldNames = true)
public class Patient implements Serializable{

	private UUID code;
    private String name;
}
