package com.j25.collections.linkedlist;

public class Wezel {
    private Object data;
    private Wezel nastepnik;
    private Wezel poprzednik;

    public Wezel(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Wezel getNastepnik() {
        return nastepnik;
    }

    public void setNastepnik(Wezel nastepnik) {
        this.nastepnik = nastepnik;
    }

    public Wezel getPoprzednik() {
        return poprzednik;
    }

    public void setPoprzednik(Wezel poprzednik) {
        this.poprzednik = poprzednik;
    }
}
