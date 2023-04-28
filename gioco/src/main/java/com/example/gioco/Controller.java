package com.example.gioco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class Controller {
    @Autowired

    private static Sorteggio sorteggio = new Sorteggio();


    /*
     * ES 1: get ("/add?nome=n") che aggiunge un nome n per il sorteggio (utilizzare la classe Sorteggio) 15 p
     * ES 2: get ("/sorteggia?num=n") che restituisce n nomi casuali (utilizzare la classe Sorteggio) 20 p
     * ES 3: get ("/listaNomi?sottostringa=s") che restituisce la lista dei nomi che contengono la sottostringa s 20 p
     * ES 4: creare la classe SorteggioRuolo in cui, dopo aver aggiunto i nomi ("/add?nome=n"),
     * sorteggia per ogni nome un ruolo di Lupus (get: "/sorteggia")
     * se i giocatori sono meno di 7 non sorteggia. con 8 sorteggia 5 VILLICI, 2 LUPI, 1 VEGGENTE
     * 9: precedenti + 1 MEDIUM
     * 10: + 1 INDEMONIATO
     * 11: + 1 PROTETTORE
     * 12: + 1 VILLICO
     * 13: + 1 LUPO
     * 14: + 1 VILLICO
     * 15: + 1 INDEMONIATO
     * Non consente l'aggiunta di più di 15 giocatori.
     * creare get ("/getRuoli") che restituisce tutti i ruoli e get ("getRuolo?nome=n")
     * che restituisce il ruolo del singolo giocatore  30 p
     * */

    @GetMapping("/addNome")
    public boolean addNome(@RequestParam(value = "nome") String n)
    {
        sorteggio.aggiungi(n);
        return true;
    }
    @GetMapping("/sorteggia")
    public List<String> sorteggiamento(@RequestParam(value = "num") int n) {
        List<String> nomiCasuali = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String nomeCasuale = sorteggio.next();
            nomiCasuali.add(nomeCasuale);
        }
        return nomiCasuali;
    }
    public List<String> listaNomiSottostringa(@RequestParam(value = "s") String s) {
        List<String> sottostringa = new ArrayList<>();
        List<String> nomi = sorteggio.getNomi();
        for (String nome : nomi) {
           if(nome.contains(s)){
               sottostringa.add(nome);
           }
        }
        return sottostringa;
    }
}