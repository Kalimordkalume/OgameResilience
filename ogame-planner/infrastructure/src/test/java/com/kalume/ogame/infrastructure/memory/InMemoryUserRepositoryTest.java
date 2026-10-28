package com.kalume.ogame.infrastructure.memory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kalume.ogame.domain.Email;
import com.kalume.ogame.domain.User;
import com.kalume.ogame.domain.UserName;
import org.junit.jupiter.api.Test;

class InMemoryUserRepositoryTest {

    private final InMemoryUserRepository repository = new InMemoryUserRepository();

    @Test
    void findsASavedUserByNameAndByEmail() {
        repository.save(User.register(new UserName("kalume"), new Email("k@example.com")));

        assertTrue(repository.existsByUserName(new UserName("kalume")));
        assertTrue(repository.existsByEmail(new Email("k@example.com")));
    }

    @Test
    void doesNotFindWhatWasNeverSaved() {
        assertFalse(repository.existsByUserName(new UserName("kalume")));
        assertFalse(repository.existsByEmail(new Email("k@example.com")));
    }
}
