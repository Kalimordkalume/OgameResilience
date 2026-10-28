package com.kalume.ogame.application.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kalume.ogame.domain.Email;
import com.kalume.ogame.domain.User;
import com.kalume.ogame.domain.UserName;
import com.kalume.ogame.domain.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CreateUserTest {

    /** Repositorio falso, solo para este test: así application no depende de infrastructure. */
    private static class FakeUserRepository implements UserRepository {
        final List<User> saved = new ArrayList<>();

        @Override
        public void save(User user) {
            saved.add(user);
        }

        @Override
        public boolean existsByUserName(UserName userName) {
            return saved.stream().anyMatch(u -> u.getUserName().equals(userName));
        }

        @Override
        public boolean existsByEmail(Email email) {
            return saved.stream().anyMatch(u -> u.getEmail().equals(email));
        }
    }

    private final FakeUserRepository repository = new FakeUserRepository();
    private final CreateUser createUser = new CreateUser(repository);

    @Test
    void savesTheNewUser() {
        var user = createUser.execute(new UserName("kalume"), new Email("k@example.com"));

        assertEquals(List.of(user), repository.saved);
    }

    @Test
    void rejectsADuplicatedUserName() {
        createUser.execute(new UserName("kalume"), new Email("k@example.com"));

        var error = assertThrows(UserAlreadyExistsException.class,
                () -> createUser.execute(new UserName("kalume"), new Email("otro@example.com")));

        assertTrue(error.getMessage().contains("kalume"));
        assertEquals(1, repository.saved.size());
    }

    @Test
    void rejectsADuplicatedEmail() {
        createUser.execute(new UserName("kalume"), new Email("k@example.com"));

        assertThrows(UserAlreadyExistsException.class,
                () -> createUser.execute(new UserName("otro"), new Email("K@Example.com")));
        assertEquals(1, repository.saved.size());
    }
}
