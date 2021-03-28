package com.rafabrayner.domain.service;

public interface ProducerService<T> {
	
	public void send(T message);

}
