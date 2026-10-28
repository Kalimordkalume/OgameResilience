package com.kalume.ogame.infrastructure.memory;

import com.kalume.ogame.domain.Email;
import com.kalume.ogame.domain.User;
import com.kalume.ogame.domain.UserName;
import com.kalume.ogame.domain.UserRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/** Guarda los usuarios en un mapa: se pierden al cerrar el programa. */
public class InMemoryUserRepository implements UserRepository {

    private final Map<UUID, User> users = new LinkedHashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public boolean existsByUserName(UserName userName) {
        return users.values().stream().anyMatch(user -> user.getUserName().equals(userName));
    }

    @Override
    public boolean existsByEmail(Email email) {
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }
}
