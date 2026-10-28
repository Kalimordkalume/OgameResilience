/**
 * Adaptador de entrada por consola. Depende del dominio y de los casos de uso; ninguno de ellos
 * sabe que existe.
 */
module com.kalume.ogame.cli {
    requires com.kalume.ogame.domain;
    requires com.kalume.ogame.application;
    requires com.kalume.ogame.infrastructure;
}
