package com.rafabrayner.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rafabrayner.presentation.dto.shared.ResponseTo;

@Service
public class ResponseService {

	public <T> ResponseEntity<ResponseTo<T>> create(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTo<T>(data));
    }

    public <T> ResponseEntity<ResponseTo<T>> ok(T data) {
        return ResponseEntity.ok(new ResponseTo<T>(data));
    }

    public <T> ResponseEntity<ResponseTo<T>> accepted(T data) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseTo<T>(data));
    }

    public <T> ResponseEntity<T> accepted() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    public <T> ResponseEntity<T> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public <T> ResponseEntity<T> noContent() {
        return ResponseEntity.noContent().build();
    }
}
