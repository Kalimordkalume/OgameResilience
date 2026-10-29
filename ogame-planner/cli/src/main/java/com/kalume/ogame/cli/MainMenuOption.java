package com.kalume.ogame.cli;

public enum MainMenuOption implements MenuOption {
    USERS_CRUD(1, "Usuarios CRUD."),
    EXIT(0, "Salir.");

    private final int id;
    private final String label;

    MainMenuOption(int i, String label) {
        this.id = i;
        this.label = label;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLabel() {
        return label;
    }

}
