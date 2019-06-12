package com.j25.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainBenchmarkList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        dodajIlesElementow(1000000, list);

        Long startTime = System.currentTimeMillis(); // obecny czas w milisekundach

        // sprawdzanie wydajności ... operacji
        dodajIlesElementowNaPoczatek(100000, list);

        Long stopTime = System.currentTimeMillis(); // obecny czas w milisekundach
        System.out.println("Czas: " + (stopTime - startTime));
    }

    private static void dodajIlesElementow(int ile, List<Integer> lista) {
        for (int i = 0; i < ile; i++) {
            lista.add(i);
        }
    }
    private static void dodajIlesElementowNaPoczatek(int ile, List<Integer> lista) {
        for (int i = 0; i < ile; i++) {
            lista.add(0, i);
        }
    }
}
