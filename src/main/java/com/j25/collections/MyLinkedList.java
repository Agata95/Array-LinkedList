package com.j25.collections;

import com.j25.collections.linkedlist.Wezel;

public class MyLinkedList {
    private Wezel head; // 0
    private Wezel tail; // ostatni

    private int size = 0;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Object element) {
        Wezel wezel = new Wezel(element);
        if (size == 0) {
            head = wezel;
            tail = wezel;
        } else if (size > 0) {
            tail.setNastepnik(wezel);
            wezel.setPoprzednik(tail);

            tail = wezel;
        }

        size++;
    }

    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
            return;
        }
        int licznik = 0;

        Wezel tymczasowy = head;
        while (licznik++ < (index)) {
            tymczasowy = tymczasowy.getNastepnik();
        }

        Wezel poprzednik = tymczasowy.getPoprzednik();
        Wezel nastepnik = tymczasowy;

        Wezel nowyWezel = new Wezel(element);
        nowyWezel.setPoprzednik(poprzednik);
        nowyWezel.setNastepnik(nastepnik);

        if (poprzednik != null) { // przypadek kiedy edytujemy w srodku
            poprzednik.setNastepnik(nowyWezel);
        }
        if (tymczasowy == head) {
            head = nowyWezel;
        }
        nastepnik.setPoprzednik(nowyWezel);

        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Wezel tymczasowy = head;
        int licznik = 0;
        while (licznik++ < index) {
            tymczasowy = tymczasowy.getNastepnik();
        }
        return tymczasowy.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Wezel tymczasowy = head;
        int licznik = 0;
        while (licznik++ < index) {
            tymczasowy = tymczasowy.getNastepnik();
        }

        Wezel poprzednik = tymczasowy.getPoprzednik();
        Wezel nastepnik = tymczasowy.getNastepnik();

//        tymczasowy.getPoprzednik().setNastepnik(tymczasowy.getNastepnik());
        if (poprzednik != null)
            poprzednik.setNastepnik(nastepnik);
        if (nastepnik != null)
            nastepnik.setPoprzednik(poprzednik);

        if (tymczasowy == head) { // usuwamy 1 element
            head = nastepnik;
        }

        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (size > 0) {

            Wezel tymczasowy = head;
            while (tymczasowy != null) {
                builder.append(tymczasowy.getData());
                builder.append(", ");
                tymczasowy = tymczasowy.getNastepnik();
            }

            // remove last 2 signs
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }
}
