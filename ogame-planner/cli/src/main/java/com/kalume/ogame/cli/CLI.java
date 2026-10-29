package com.kalume.ogame.cli;

public class CLI {
    private Console console;
    private MainMenu mainMenu;
    private boolean isRunning;

    public CLI(Console console, MainMenu mainMenu) {
        this.console = console;
        this.mainMenu = mainMenu;
        this.isRunning = false;

    }

    private void changeIsRunningStatusTo(boolean value) {
        this.isRunning = value;
    }

    public interface ScreenBehavior {
        ScreenId getScreenId();

        void render();
    }

    public enum ScreenId {
        MAIN,
        USERS
    }

    public class MainScreen implements ScreenBehavior {

        @Override
        public ScreenId getScreenId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getScreenId'");
        }

        @Override
        public void render() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'render'");
        }

    }

    public void start() {
        changeIsRunningStatusTo(true);
        try {
            while (isRunning) {
                MainMenuOption option = mainMenu.askOption();
                switch (option) {
                    case USERS_CRUD -> console.println("Aquí irá el CRUD de usuarios");
                    case EXIT -> stop();
                }
            }
        } catch (InputClosedException e) {
            console.println("");
            stop();
        }
    }

    private void stop() {
        console.println("Gracias por usar Ogame-Tracker CLI.");
        console.println("Hasta la próxima");
        changeIsRunningStatusTo(false);
    }

}
