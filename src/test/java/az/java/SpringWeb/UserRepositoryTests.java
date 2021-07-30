package az.java.SpringWeb;

import az.java.SpringWeb.model.User;
import az.java.SpringWeb.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("lale@gmail.com");
        user.setPassword("12345");
        user.setFirstname("Lale");
        user.setLastname("lale");

        User savedUser = userRepository.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hello12");
        userRepository.save(user);

        User updateUser = userRepository.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("hello12");
    }

    @Test
    public void testGet() {
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        userRepository.deleteById(userId);

        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
//1.10
