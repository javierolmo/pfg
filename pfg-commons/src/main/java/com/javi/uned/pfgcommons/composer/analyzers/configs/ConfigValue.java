package com.javi.uned.pfgcommons.composer.analyzers.configs;

public class ConfigValue <T> {

    private final T value;
    private final Integer weight;

    public ConfigValue(T value, Integer weight) {
        this.value = value;
        this.weight = weight;
    }

    public T getValue() {
        return value;
    }

    public Integer getWeight() {
        return weight;
    }
}
