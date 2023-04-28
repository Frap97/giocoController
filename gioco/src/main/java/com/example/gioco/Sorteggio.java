package com.example.gioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorteggio {
    private List<String> nomi = new ArrayList<>();
    private boolean daMischiare = true;
    private int nextName = 0;
    public void aggiungi(String nome){
        nomi.add(nome);
        daMischiare = true;
        nextName = 0;
    }

    public String next(){
        if(daMischiare){
            Collections.shuffle(nomi);
            daMischiare = false;
        }
        if(nextName >= nomi.size())
            throw new IndexOutOfBoundsException("Nomi finiti");
        return nomi.get(nextName++);
    }

    public List<String> getNomi() {
        return nomi;
    }

    public boolean isDaMischiare() {
        return daMischiare;
    }
}