package com.epicode.U5D1.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("Elemento con id " + id + "non trovato.");
    }
}
