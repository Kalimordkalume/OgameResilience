package com.kalume.ogame.domain.buildings;

import com.kalume.ogame.domain.buildings.enums.FacilityBuilding;
import com.kalume.ogame.domain.buildings.enums.ResourceBuilding;
import com.kalume.ogame.domain.buildings.enums.lifeform.HumanBuilding;

/**
 * Cualquier tipo de edificio. La lista de tipos permitidos está cerrada: el compilador sabe cuáles son y
 * avisa si un {@code switch} no cubre alguno. Al añadir una categoría o una raza, se añade aquí en
 * {@code permits}.
 */
public sealed interface BuildingType permits ResourceBuilding, FacilityBuilding, HumanBuilding {
}
