package test;

import entity.User;
import entity.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class testJPA {

    @Autowired
    UserRepository userRepository;
    @Test
    public void testBaseQuery() throws Exception {
        User user=new User();
        userRepository.findAll();
        userRepository.findUserByName();
//        userRepository.findOne(1l);
//        userRepository.save(user);
//        userRepository.delete(user);
//        userRepository.count();
//        userRepository.exists(1l);
        // ...
    }

}
