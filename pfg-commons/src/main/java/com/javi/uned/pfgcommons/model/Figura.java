package com.javi.uned.pfgcommons.model;

import java.util.Objects;

public class Figura {

    private String type;
    private int value;
    private double duration;

    public Figura(){

    }

    public Figura(String type, int value, double duration) {
        this.type = type;
        this.value = value;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura = (Figura) o;
        return value == figura.value &&
                Double.compare(figura.duration, duration) == 0 &&
                Objects.equals(type, figura.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value, duration);
    }

    @Override
    public String toString() {
        return "Figura{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", duration=" + duration +
                '}';
    }
}
