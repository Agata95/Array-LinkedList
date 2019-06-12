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
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int licznik = 0;

        Wezel tymczasowy = head;
        while (licznik++ < (index -1)) {
            tymczasowy = tymczasowy.getNastepnik();
        }

        Wezel poprzednik = tymczasowy;
        Wezel nastepnik = tymczasowy.getNastepnik();

        Wezel nowyWezel = new Wezel(element);
        nowyWezel.setPoprzednik(poprzednik);
        nowyWezel.setNastepnik(nastepnik);

        if (poprzednik != null) { // przypadek kiedy edytujemy w srodku
            poprzednik.setNastepnik(nowyWezel);
        } else { // kiedy próbujemy wstawić na 0 pozycję
            head = nowyWezel;
        }
        if (nastepnik == null) {
            tail = nowyWezel;
        } else {
            nastepnik.setPoprzednik(nowyWezel);
        }
        size++;
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
