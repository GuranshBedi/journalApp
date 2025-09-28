package net.journal.journalAPP.service;

import net.journal.journalAPP.scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTests {
    @Autowired
    private UserScheduler userScheduler;

    @Test
    public void testFetchUsersAndSendMail(){
        userScheduler.fetchUsersAndSendSAMAIL();
    }
}
