package org.example;

import org.example.entity.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@ActiveProfiles(value="DEV")
public class SpringBootJPAIntegrationTest {

    @Autowired
    private transient UserService userService;

    @Test
    public void shouldSaveEmployeeToDB() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName("name");

        userService.save(user);

        assertNotNull(userService.findByName(user.getName()));
    }
}