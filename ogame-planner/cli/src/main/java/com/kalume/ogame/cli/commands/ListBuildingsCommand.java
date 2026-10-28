package com.kalume.ogame.cli.commands;

import com.kalume.ogame.cli.Console;
import com.kalume.ogame.domain.buildings.enums.FacilityBuilding;
import com.kalume.ogame.domain.buildings.enums.ResourceBuilding;
import com.kalume.ogame.domain.buildings.enums.lifeform.HumanBuilding;
import java.util.Arrays;

public class ListBuildingsCommand implements Command {

    private final Console console;

    public ListBuildingsCommand(Console console) {
        this.console = console;
    }

    @Override
    public String name() {
        return "Ver edificios";
    }

    @Override
    public void run() {
        console.println("Recursos:       " + Arrays.toString(ResourceBuilding.values()));
        console.println("Instalaciones:  " + Arrays.toString(FacilityBuilding.values()));
        console.println("Humanos:        " + Arrays.toString(HumanBuilding.values()));
    }
}
