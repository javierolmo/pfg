package com.javi.uned.pfgcommons.domain.model.specs;

import com.javi.uned.pfgcommons.domain.model.Instrument;

public abstract class Specs {

    private Long id;
    private String title;
    private String author;
    private String style;
    private Instrument[] instruments;

    public Specs() {
        instruments = new Instrument[]{};
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instrument[] getInstruments() {
        return instruments;
    }

    public void setInstruments(Instrument[] instruments) {
        this.instruments = instruments;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
