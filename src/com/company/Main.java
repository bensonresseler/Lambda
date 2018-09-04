package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        List<Persoon> personen = new ArrayList<>();
        personen.add(new Persoon("Karen", "Damen", LocalDate.of(1974, 10,28)));
        personen.add(new Persoon("Kristel","Verbeke",LocalDate.of(1975,12, 10)));
        personen.add(new Persoon("Kathleen", "Aerts", LocalDate.of(1978, 6, 18)));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wilt u sorteren op\n" +
                "1. voornaam\n" +
                "2. achternaam\n" +
                "3. leeftijd\n" +
                "Uw keuze? ");
        int keuze = Integer.parseInt(scanner.nextLine());
        switch (keuze){
            case 1: Collections.sort(personen, new Comparator<Persoon>() {
                @Override
                public int compare(Persoon p1, Persoon p2) {
                    return p1.getVoornaam().compareTo(p2.getVoornaam());
                }
            });
                break;
            case 2:  Collections.sort(personen, new Comparator<Persoon>() {
                @Override
                public int compare(Persoon p1, Persoon p2) {
                    return p1.getAchternaam().compareTo(p2.getAchternaam());
                }
            });
                break;
            case 3:   Collections.sort(personen, new Comparator<Persoon>() {
                @Override
                public int compare(Persoon p1, Persoon p2) {
                    return Integer.compare(p1.getLeeftijd(), p2.getLeeftijd());
                }
            });

                break;
                default:
                    System.out.println("Foute input.");
        }

        for(Persoon p: personen){
            System.out.println(p);
        }

    }
}
class Persoon{
    private String voornaam;
    private String achternaam;
    private LocalDate gebdatum;

    public Persoon(String voornaam, String achternaam, LocalDate gebdatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.gebdatum = gebdatum;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public LocalDate getGebdatum() {
        return gebdatum;
    }
    public int getLeeftijd(){
        LocalDate vandaag = LocalDate.now();
        Period periode = Period.between(gebdatum, vandaag);
        return periode.getYears();
    }
    @Override
    public String toString() {
        return String.format("%s %s is %d jaar oud.", voornaam, achternaam, getLeeftijd());
    }
}