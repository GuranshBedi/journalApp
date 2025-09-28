package net.journal.journalAPP.repository;

import net.journal.journalAPP.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    public User findByUserName(String userName);
    public void deleteByUserName(String userName);
}

