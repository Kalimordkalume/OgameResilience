package com.kalume.ogame.cli;

/** Contrato de las opciones de cualquier menú: un número para elegirla y un texto para mostrarla. */
public interface MenuOption {

    int getId();

    String getLabel();
}
