package com.rafabrayner.infrastructure.queue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Queue {
	public final static String PATIENT_CREATION_QUEUE = "PATIENT-CREATION.QUEUE";
}