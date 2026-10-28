/**
 * Casos de uso: orquestan el dominio. No sabe nada de consola, web ni bases de datos.
 */
module com.kalume.ogame.application {
    requires transitive com.kalume.ogame.domain;

    exports com.kalume.ogame.application.user;
}
