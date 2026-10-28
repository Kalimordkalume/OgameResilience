package com.kalume.ogame.domain;

/**
 * Puerto: el dominio dice qué necesita guardar y consultar; cómo se hace lo decide otro módulo
 * (ahora en memoria, mañana una base de datos).
 */
public interface UserRepository {

    void save(User user);

    boolean existsByUserName(UserName userName);

    boolean existsByEmail(Email email);
}
