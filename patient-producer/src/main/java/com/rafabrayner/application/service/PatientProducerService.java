package com.rafabrayner.application.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafabrayner.domain.model.Patient;
import com.rafabrayner.domain.service.ProducerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.rafabrayner.infrastructure.queue.model.Queue.PATIENT_CREATION_QUEUE;

@Service
@Slf4j
@AllArgsConstructor
public class PatientProducerService implements ProducerService<Patient> {
	
	private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;
	
	@Override
	public void send(Patient patient) {
		try {
            log.info("Sending {} to queue : {}", patient, PATIENT_CREATION_QUEUE);
            jmsTemplate.convertAndSend(PATIENT_CREATION_QUEUE, objectMapper.writeValueAsBytes(patient));
            log.info("Sent {} to queue : {}", patient, PATIENT_CREATION_QUEUE);
        } catch (Exception e) {
            log.error("An error occurred while sending the {}: , {}", patient, e.getMessage(), e);
        }
		
	}

}
