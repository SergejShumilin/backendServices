package org.example;

import org.example.dao.UserRepository;
import org.example.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@ActiveProfiles(value="DEV")
public class SpringBootJPAIntegrationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldSaveEmployeeToDB() {
        User user = new User();
        user.setId(1);
        user.setName("name");

        userRepository.save(user);

        Optional<User> optionalEmployee = userRepository.findById(1);
        User emp = null;
        if(optionalEmployee.isPresent()){
            emp = optionalEmployee.get();
        }

        assertNotNull(emp);
    }
}