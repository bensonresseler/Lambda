package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        List<Persoon> personen = new ArrayList<>();
        personen.add(new Persoon("Karen", "Damen", LocalDate.of(1974, 10,28)));
        personen.add(new Persoon("Kristel","Verbeke",LocalDate.of(1975,12, 10)));
        personen.add(new Persoon("Kathleen", "Aerts", LocalDate.of(1978, 6, 18)));
        PersoonLijst lijst = new PersoonLijst((p1,p2) -> p1.getLeeftijd() < p2.getLeeftijd());
        for(Persoon p: personen){
            lijst.add(p);
        }
        for(Persoon p: lijst){
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
class PersoonLijst implements Iterable<Persoon>{
    private List<Persoon> personen = new ArrayList<>();
    private BiPredicate<Persoon, Persoon> isGroter;
    public PersoonLijst(BiPredicate<Persoon, Persoon> isGroter){
        this.isGroter = isGroter;
    }
    public void add(Persoon p){
        int positie = 0;
        while(positie < personen.size() && isGroter.test(personen.get(positie), p)){
            positie++;
        }
        personen.add(positie, p);
    }
    @Override
    public Iterator<Persoon> iterator() {
        return personen.iterator();
    }
}