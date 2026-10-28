package com.kalume.ogame.cli;

/** La entrada se cerró (Ctrl+Z o Ctrl+D, o se acabó el texto redirigido): no se puede preguntar más. */
public class InputClosedException extends RuntimeException {

    public InputClosedException() {
        super("La entrada se ha cerrado.");
    }
}
