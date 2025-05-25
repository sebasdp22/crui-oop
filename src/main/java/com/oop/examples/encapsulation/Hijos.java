package com.oop.examples.encapsulation;

import javax.print.attribute.standard.MediaSize.NA;

public class Hijos extends Person {
    private String tipePlay;
    private String club;
    private boolean tareaRealizada;

    public Hijos(String name, int age, String email, String tipePlay, String club, boolean tareaRealizada) {
        super(name, age, email);
        this.tipePlay = tipePlay;
        this.club = club;
        this.tareaRealizada = tareaRealizada;
    }

    // Getters
    public String getTipePlay() {
        return tipePlay;
    }

    public String getClub() {
        return club;
    }

    public boolean isTareaRealizada() {
        return tareaRealizada;
    }

    // Setters
    public void setTareaRealizada(boolean tareaRealizada) {
        this.tareaRealizada = tareaRealizada;
    }

    // Métodos de comportamiento
    public void realizoTarea() {
        if (tareaRealizada) {
            System.out.println("Podes hacer deporte");
        } else {
            System.out.println("No podes hacer deporte");
        }
    }
}
