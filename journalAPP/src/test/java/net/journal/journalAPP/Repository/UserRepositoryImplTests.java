package net.journal.journalAPP.Repository;

import net.journal.journalAPP.entity.User;
import net.journal.journalAPP.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    public void saveNewUser(User user){
        userRepositoryImpl.getUserForSA();
    }
}
