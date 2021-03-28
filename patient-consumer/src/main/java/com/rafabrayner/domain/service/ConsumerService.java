package com.rafabrayner.domain.service;

import javax.jms.Message;

public interface ConsumerService {

	public void process(Message message);
}
