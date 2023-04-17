package com.jms.assignment;

// This line imports the necessary dependencies
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.jms.assignment.Data.Email;

// This line declares that this class is a Spring component that can be autowired by other classes
@Component

// This line adds the Lombok annotation to generate a logger instance for logging
@Slf4j
public class EmailMessagePublisher {

    // This line declares an instance variable of the JmsTemplate class
    private final JmsTemplate jmsTemplate;

    // This line is the constructor that initializes the instance variable using the @Autowired annotation for dependency injection
    @Autowired
    public EmailMessagePublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    // This line declares a method that sends an email message to the "jms.email.queue" destination
    public boolean sendMyEmail(Email email) {
        try {
            // This line converts and sends the email to the JMS queue using the JmsTemplate instance
            jmsTemplate.convertAndSend("jms.email.queue", email);
            // This line logs the success message
            log.info("Email Sent to AMQ");
            return true;
        } catch (Exception ex) {
            // This line logs the error message in case of an exception and returns false
            log.error("Failed to send email to AMQ", ex);
            return false;
        }
    }
}
