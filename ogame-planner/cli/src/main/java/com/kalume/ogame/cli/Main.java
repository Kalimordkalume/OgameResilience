package com.kalume.ogame.cli;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {

        String name = System.getProperty("stdin.encoding");
        Charset charset = (name != null) ? Charset.forName(name) : Charset.defaultCharset();
        Console console = new Console(System.in, System.out, charset);

        console.println("Programa iniciado...");

        console.println("Iniciando consola interactiva...");
        MenuInputParser parser = new MenuInputParser();
        MainMenu mainMenu = new MainMenu(console, parser, "MAIN MENU");
        CLI cliClient = new CLI(console, mainMenu);

        cliClient.start();

    }
}
