package com.kalume.ogame.domain.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kalume.ogame.domain.buildings.enums.FacilityBuilding;
import com.kalume.ogame.domain.buildings.enums.ResourceBuilding;
import com.kalume.ogame.domain.buildings.enums.lifeform.HumanBuilding;
import org.junit.jupiter.api.Test;

class BuildingTypeTest {

    /** Sin "default": si BuildingType permite un tipo nuevo y aquí falta su caso, no compila. */
    private static String group(BuildingType type) {
        return switch (type) {
            case ResourceBuilding resource -> "recursos";
            case FacilityBuilding facility -> "instalaciones";
            case HumanBuilding human -> "humanos";
        };
    }

    @Test
    void everyBuildingTypeBelongsToItsGroup() {
        assertEquals("recursos", group(ResourceBuilding.METAL_MINE));
        assertEquals("instalaciones", group(FacilityBuilding.ROBOTICS_FACTORY));
        assertEquals("humanos", group(HumanBuilding.RESIDENTIAL_SECTOR));
    }

    @Test
    void constantsFollowTheJavaNamingConvention() {
        assertEquals("DEUTERIUM_SYNTHESIZER", ResourceBuilding.DEUTERIUM_SYNTHESIZER.name());
        assertEquals("NANITE_FACTORY", FacilityBuilding.NANITE_FACTORY.name());
    }
}
