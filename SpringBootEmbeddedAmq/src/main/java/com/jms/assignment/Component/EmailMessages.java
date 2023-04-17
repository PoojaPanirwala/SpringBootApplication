package com.jms.assignment.Component;

import com.jms.assignment.Data.Email;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailMessages {

    private final List<Email> jmsMessages;

    public EmailMessages() {
        this.jmsMessages = new ArrayList<>();
    }

    public void push(Email email) {
        jmsMessages.add(email);
    }

    public List<Email> getAllJmsMessages() {
        return jmsMessages;
    }
}
