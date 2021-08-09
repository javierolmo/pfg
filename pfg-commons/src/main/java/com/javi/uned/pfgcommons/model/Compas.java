package com.javi.uned.pfgcommons.model;

import java.util.Objects;

public class Compas {

    private int numerador;
    private int denominador;
    private int pulsos;

    public Compas(){

    }

    public Compas(int numerador, int denominador, int pulsos) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.pulsos = pulsos;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getPulsos() {
        return pulsos;
    }

    public void setPulsos(int pulsos) {
        this.pulsos = pulsos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compas compas = (Compas) o;
        return numerador == compas.numerador &&
                denominador == compas.denominador &&
                pulsos == compas.pulsos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerador, denominador, pulsos);
    }
}
