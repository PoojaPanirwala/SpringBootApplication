package com.jms.assignment;

// This line imports the necessary dependencies
import com.jms.assignment.Data.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This line declares that this class is a REST controller and handles incoming HTTP requests
@RestController

// This line adds the Lombok annotation to generate a logger instance for logging
@Slf4j
public class EmailController {

    // This line declares two instance variables of the EmailMessagePublisher and EmailMessages classes
    private final EmailMessagePublisher emailMessagePublisher;
    private final EmailMessages emailMessages;

    // This line is the constructor that initializes the instance variables using the @Autowired annotation for dependency injection
    @Autowired
    public EmailController(EmailMessagePublisher emailMessagePublisher, EmailMessages emailMessages) {
        this.emailMessagePublisher = emailMessagePublisher;
        this.emailMessages = emailMessages;
    }

    // This line maps incoming POST requests to the / path and expects a JSON request body of type Email
    @PostMapping("/")
    public String sendEmail(@RequestBody Email email) {
        // This line logs the received email request with the info level
        log.info("Received Email Request from Controller {}", email);
        // This line calls the sendEmail method of the EmailMessagePublisher instance to send the email
        boolean isMessageSent = emailMessagePublisher.sendEmail(email);
        // This line returns a response message depending on whether the email was sent successfully or not
        return isMessageSent ? "Hurray! It's Success!" : "Oops! It's Failed!";
    }

    // This line maps incoming GET requests to the / path and returns a list of Email objects as a JSON response body
    @GetMapping("/")
    @ResponseBody
    public List<Email> getAllMessage() {
        // This line calls the getAllJmsMessages method of the EmailMessages instance to get all the stored emails
        return emailMessages.getAllJmsMessages();
    }
}
