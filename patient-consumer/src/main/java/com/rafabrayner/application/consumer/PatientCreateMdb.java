package com.rafabrayner.application.consumer;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafabrayner.application.service.PatientService;
import com.rafabrayner.domain.model.Patient;
import com.rafabrayner.presentation.dto.PatientTo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.rafabrayner.infrastructure.queue.model.Queue.PATIENT_CREATION_QUEUE;
import static com.rafabrayner.presentation.mapper.PatientMapper.from;

@Service
@Slf4j
@AllArgsConstructor
public class PatientCreateMdb {
	
    private final ObjectMapper objectMapper;
    private final UUID hospitalCode = UUID.randomUUID();
    private final PatientService patientService;

    @JmsListener(destination = PATIENT_CREATION_QUEUE)
    public void process(byte[] message) {
        try {
            PatientTo patientTo = objectMapper.readValue(message, PatientTo.class);
            Patient patient = patientService.update(from(patientTo, hospitalCode));
            log.info("{} received from queue {}", patient, PATIENT_CREATION_QUEUE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
