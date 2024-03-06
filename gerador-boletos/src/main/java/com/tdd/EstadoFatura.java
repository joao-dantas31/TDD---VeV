package com.tdd;

public enum EstadoFatura {
    PAGA("PAGA"), PENDENTE("PENDENTE");

    private final String estado;

    EstadoFatura(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}