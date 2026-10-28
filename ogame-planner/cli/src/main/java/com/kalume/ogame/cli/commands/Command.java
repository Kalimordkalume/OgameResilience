package com.kalume.ogame.cli.commands;

/** Una opción del menú: pregunta lo que necesite, llama al caso de uso y enseña el resultado. */
public interface Command {

    String name();

    void run();
}
