package com.kalume.ogame.cli;

import com.kalume.ogame.cli.users.UsersMenu;

public class CLI {
    private final Console console;
    private final MainMenu mainMenu;
    private final UsersMenu usersMenu;
    private boolean isRunning;

    public CLI(Console console, MainMenu mainMenu, UsersMenu usersMenu) {
        this.console = console;
        this.mainMenu = mainMenu;
        this.usersMenu = usersMenu;
        this.isRunning = false;

    }

    private void changeIsRunningStatusTo(boolean value) {
        this.isRunning = value;
    }

    public void start() {
        changeIsRunningStatusTo(true);
        try {
            while (isRunning) {
                MainMenuOption option = mainMenu.askOption();
                switch (option) {
                    case USERS_CRUD -> runUsersMenu();
                    case EXIT -> stop();
                }
            }
        } catch (InputClosedException e) {
            console.println("");
            stop();
        }
    }

    private void runUsersMenu() {
        boolean inUsers = true;
        while (inUsers) {
            switch (usersMenu.askOption()) {
                case CREATE -> notImplementedYet();
                case RETRIEVE_BY_ID -> notImplementedYet();
                case RETRIEVE_ALL -> notImplementedYet();
                case UPDATE -> notImplementedYet();
                case DELETE -> notImplementedYet();
                case BACK -> inUsers = false;
            }
        }
    }

    private void notImplementedYet() {
        console.println("Esta opción aún no está implementada.");
    }

    private void stop() {
        console.println("Gracias por usar Ogame-Tracker CLI.");
        console.println("Hasta la próxima");
        changeIsRunningStatusTo(false);
    }

}
