package com.example.gioco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gioco.Ruolo;

import java.util.*;


@RestController
public class SorteggioRuolo extends Sorteggio{
    @Autowired

    private static Sorteggio sorteggio = new Sorteggio();
    private Map<String, Ruolo> ruoli = new HashMap<>();
    @GetMapping("/sorteggia")
    public void sorteggiaRuoli(){
      List<String> nomi = sorteggio.getNomi();
      List<Ruolo> ruoliDisponibili = new ArrayList<>(Arrays.asList(Ruolo.values()));
      if(nomi.isEmpty()){
            throw new RuntimeException("Non ci sono nomi inseriti");
        }
      for(int i = 0; i < nomi.size(); i++){

          if(nomi.size() < 8){
              throw new RuntimeException("Non ci sono nomi sufficienti per iniziare il gioco (da 8 a 15)");
          }
              if(i <= 5)
                 ruoli.put(nomi.get(i), ruoliDisponibili.get(1));
              else if (i > 5 && i < 8)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(2));
              else if (i == 8)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(3));
              else if (i == 9)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(4));
              else if (i == 10)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(5));
              else if (i == 11)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(6));
              else if (i == 12)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(1));
              else if (i == 13)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(2));
              else if (i == 14)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(3));
              else if (i == 15)
                  ruoli.put(nomi.get(i), ruoliDisponibili.get(5));

      }
    }
}
