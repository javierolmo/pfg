package com.javi.uned.pfgcommons.domain.model;

public class Instrument {

    private long id;
    private String displayName;
    private String jFugueName;

    public Instrument(long id, String displayName, String jFugueName) {
        this.id = id;
        this.displayName = displayName;
        this.jFugueName = jFugueName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getjFugueName() {
        return jFugueName;
    }

    public void setjFugueName(String jFugueName) {
        this.jFugueName = jFugueName;
    }
}
