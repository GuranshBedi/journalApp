package net.journal.journalAPP.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmail(){
        emailService.sendEmail("bediguransh26@gmail.com","HEllO", "Welcome Bro");
    }
}
