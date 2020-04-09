package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

@Controller
public class HlavniController {

    Long sekvence = 1000L;
    private List<Clanek> seznamClanku;

    public HlavniController() {
        seznamClanku = new ArrayList<>();
        seznamClanku.add(new Clanek(sekvence++, "Velikonoce se blíží", "Karel May"));
        seznamClanku.add(new Clanek(sekvence++, "Recept na Mazanec", "Jana Novotná"));
        seznamClanku.add(new Clanek(sekvence++, "Koronavirus", "Kája Mařík"));
        seznamClanku.add(new Clanek(sekvence++, "Kindervajíčka jsou ve slevě", "Apolena Malá"));
        seznamClanku.add(new Clanek(sekvence++, "Vánoce jsou tady", "Pavel Slepička"));
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView zobrazIndex() {
        return new ModelAndView("redirect:/seznam");
    }

    @RequestMapping(value = "/seznam", method = RequestMethod.GET)
    public ModelAndView zobrazSeznam() {
        ModelAndView drzak = new ModelAndView("index");
        drzak.addObject("clanky", seznamClanku);
        return drzak;
    }

    @RequestMapping(value = "/seznam/{idClanku}", method = RequestMethod.POST, params = "_method=DELETE")
    public ModelAndView smazClanek(@PathVariable("idClanku") Long idClanku) {
        smazClanekPodleCisla(idClanku);
        return new ModelAndView("redirect:/seznam");
    }


    @RequestMapping(value = "/detail/{idClanku:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView zobrazDetail(@PathVariable Long idClanku) {
        ModelAndView drzak = new ModelAndView("detail");
        Clanek jeden = findById(idClanku);
        drzak.addObject("jedenClanek", jeden);
        return drzak;
    }

    @RequestMapping(value = "/detail/{idClanku:[0-9]+}", method = RequestMethod.POST)
    public ModelAndView zpracujDetail(@PathVariable("idClanku") Long idClanku, DetailForm detailForm) {
        upravClanek(idClanku, detailForm);
        return new ModelAndView("redirect:/seznam");
    }

    @RequestMapping(value = "/novy", method = RequestMethod.GET)
    public ModelAndView zobrazNovy() {
        ModelAndView drzak = new ModelAndView("detail");
        drzak.addObject("jedenClanek", new DetailForm());
        return drzak;

        //upravClanek(cislo, detailForm);
        //return new ModelAndView("redirect:/seznam");
    }

    @RequestMapping(value = "/novy", method = RequestMethod.POST)
    public ModelAndView zpracujNovy(DetailForm detailForm) {
        ModelAndView drzak = new ModelAndView("detail");
        ulozClanek(detailForm);
        return new ModelAndView("redirect:/seznam");

    }

    private void ulozClanek(DetailForm detailform) {
        String nazev = detailform.getNazev();
        String autor = detailform.getAutor();
        Clanek novyClanek = new Clanek(sekvence++, nazev, autor);
        seznamClanku.add(novyClanek);
    }

    private void upravClanek(Long cislo, DetailForm detailForm) {
        Clanek upravovanyClanek = findById(cislo);
        upravovanyClanek.setNazev(detailForm.getNazev());
        upravovanyClanek.setAutor(detailForm.getAutor());

    }

    private void smazClanekPodleCisla(Long idClanku) {
        Clanek clanek = findById(idClanku);
        seznamClanku.remove(clanek);

    }

    //private int ziskejIndexClankuPodleCisla(Long idClanku) {
    //   for (int i = 0; i < clanky.size(); i++) {
    //      if (clanky.get(i).getIdClanku().equals(idClanku)) {
    //         return i;
    //     }
    //    }
    //    return -1;
    //}


    //    private Clanek ziskejClanekPodleCisla(Long idClanku) {
//        int index = ziskejIndexClankuPodleCisla(idClanku);
//        return seznamClanku.get(index);
//    }
//
    private Clanek findById(Long idHledanehoClanku) {
        for (Clanek clanek : seznamClanku) {
            if (clanek.getIdClanku().equals(idHledanehoClanku)) {
                return clanek;
            }
        }
        return null;

    }


}





