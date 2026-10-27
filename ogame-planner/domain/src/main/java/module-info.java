/**
 * El dominio: Java puro. No declara ningún "requires" salvo java.base, así que no puede usar Spring
 * ni ninguna otra librería: el compilador lo impide.
 */
module com.kalume.ogame.domain {
    exports com.kalume.ogame.domain;
    exports com.kalume.ogame.domain.buildings.enums;
    exports com.kalume.ogame.domain.buildings.enums.lifeform;
    // com.kalume.ogame.domain.buildings se exportará cuando tenga clases (Building está vacía de momento).
}
