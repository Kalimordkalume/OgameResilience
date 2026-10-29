package com.kalume.ogame.cli.users;

import com.kalume.ogame.cli.MenuOption;

public enum UsersMenuOption implements MenuOption {

    CREATE(1, "Crear nuevo usuario."),
    RETRIEVE_BY_ID(2, "Buscar un usuario."),
    RETRIEVE_ALL(3, "Listar todos los usuarios."),
    UPDATE(4, "Actualizar un usuario."),
    DELETE(5, "Borrar un usuario."),
    BACK(0, "Ir atrás.");

    private final int id;
    private final String label;

    UsersMenuOption(int i, String label) {
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
