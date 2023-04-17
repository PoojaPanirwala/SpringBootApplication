package com.jms.assignment;

// This line imports the necessary dependencies
import com.jms.assignment.Data.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// This line declares that this class is a Spring component that can be autowired by other classes
@Component

// This line adds the Lombok annotation to generate a logger instance for logging
@Slf4j
public class EmailMessageListener {

    // This line declares an instance variable of the EmailMessages class
    private final EmailMessages emailMessages;

    // This line is the constructor that initializes the instance variable using the @Autowired annotation for dependency injection
    @Autowired
    public EmailMessageListener(EmailMessages emailMessages){
        this.emailMessages = emailMessages;
    }

    // This line adds the JmsListener annotation that indicates this method listens for incoming JMS messages on the "jms.email.queue" destination
    @JmsListener(destination = "jms.email.queue")
    public void receiveEmail(Email email) {
        // This line logs the received email with the info level
        log.info("Email received={}", email);
        // This line adds the received email to the EmailMessages instance using the push method
        emailMessages.push(email);
    }
}
