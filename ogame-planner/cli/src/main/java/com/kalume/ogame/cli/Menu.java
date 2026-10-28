package com.kalume.ogame.cli;

import com.kalume.ogame.cli.commands.Command;
import java.util.List;

/** Enseña las opciones numeradas, lee la elegida y ejecuta su comando. La opción 0 sale. */
public class Menu {

    private final Console console;
    private final List<Command> commands;

    public Menu(Console console, List<Command> commands) {
        this.console = console;
        this.commands = List.copyOf(commands);
    }

    public void run() {
        while (true) {
            show();
            String choice = console.ask("Opción: ").trim();
            if (choice.equals("0")) {
                return;
            }
            Command command = find(choice);
            if (command == null) {
                console.println("Opción no válida.");
            } else {
                command.run();
            }
        }
    }

    private void show() {
        console.println("");
        for (int i = 0; i < commands.size(); i++) {
            console.println((i + 1) + ". " + commands.get(i).name());
        }
        console.println("0. Salir");
    }

    private Command find(String choice) {
        try {
            int index = Integer.parseInt(choice) - 1;
            return index >= 0 && index < commands.size() ? commands.get(index) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
