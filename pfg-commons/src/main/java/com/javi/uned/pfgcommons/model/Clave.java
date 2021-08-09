package com.javi.uned.pfgcommons.model;

import java.util.Objects;

public class Clave {

    private String step;
    private int line;

    public Clave() {

    }

    public Clave(String step, int line) {
        this.step = step;
        this.line = line;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clave clave = (Clave) o;
        return line == clave.line &&
                Objects.equals(step, clave.step);
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, line);
    }
}
