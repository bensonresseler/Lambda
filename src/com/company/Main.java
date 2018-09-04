package com.company;

import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        int lengte = doeIets((n) -> getLengte(n));
        System.out.println("De lengte is: " + lengte);
        int aantalA = doeIets((n) -> telAantalA(n));
        System.out.println("Het aantal a's is " + aantalA);

    }

    private static int getLengte(String tekst) {
        return tekst.length();
    }

    private static int telAantalA(String tekst) {
        int aantal = 0;
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == 'a') aantal++;
        }
        return aantal;
    }

    private static int doeIets(ToIntFunction<String> functie) {
        String naam = "Karen Damen";
        return functie.applyAsInt(naam);
    }
}