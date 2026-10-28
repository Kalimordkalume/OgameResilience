/**
 * Implementaciones concretas de los puertos del dominio (almacenamiento, etc.).
 */
module com.kalume.ogame.infrastructure {
    requires com.kalume.ogame.domain;

    exports com.kalume.ogame.infrastructure.memory;
}
