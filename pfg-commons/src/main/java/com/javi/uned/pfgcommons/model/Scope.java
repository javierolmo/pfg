package com.javi.uned.pfgcommons.model;

import java.util.Objects;

public class Scope {

    private Tesitura tesitura;
    private Clave clave;

    public Scope(){

    }

    public Scope(Tesitura tesitura, Clave clave) {
        this.tesitura = tesitura;
        this.clave = clave;
    }

    public Tesitura getTesitura() {
        return tesitura;
    }

    public void setTesitura(Tesitura tesitura) {
        this.tesitura = tesitura;
    }

    public Clave getClave() {
        return clave;
    }

    public void setClave(Clave clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scope scope = (Scope) o;
        return Objects.equals(tesitura, scope.tesitura) &&
                Objects.equals(clave, scope.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tesitura, clave);
    }
}
