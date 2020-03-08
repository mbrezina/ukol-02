package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class HlavniController {

    /*
    private static final List<String> JIDLO = Arrays.asList(
            "Krentenboly",
            "Peppernoten",
            "Oliebollen",
            "Haring",
            "Stropvafle",
            "Kroket",
            "Gouda",
            "Pindakaas",
            "Hagelslag"
    );

    private static final List<String> POPIS = Arrays.asList(
            "jsou sladké housky trochu podobné naší vánočce, Nizozemci si do nich dávají sýr",
            "jsou sladkosti, které se prodávají kolem Mikuláše",
            "jsou koblihy, co se jedí na konci roku, každoročně noviny uveřejňují žebříček těch nejlepších prodejců",
            "je naložený slaneček s cibulí, kupují se ve stáncích, jinak Nizozemci mají rádi také smažené ryby",
            "jsou sladké kulaté oplatky spojené sirupem, dají se koupit i v ČR, ale nemají tu chuť",
            "já vlastně nevím, co to je, je to nějaké mleté maso a můj holandský muž se po tom může utlouct",
            "je tvrdý sýr vyráběný holandským způsobem, je jich strašně moc druhů, například starý, mladý, kmínový...",
            "je burákové máslo, doslova to znamená burákový sýr",
            "jsou malé kousky čokolády, které se sypou na chleba, nebo mohou být ovocné a barevné"
    );
    */
    @RequestMapping({"/", "/index.html"})
    public ModelAndView zobrazIndex() {
        ModelAndView drzak = new ModelAndView("index");
        List<Eten> seznamJidla = new ArrayList<>();
        seznamJidla.add(new Eten("Krentenboly","jsou sladké housky trochu podobné naší vánočce, Nizozemci si do nich dávají sýr"));
        seznamJidla.add(new Eten("Peppernoten","jsou sladkosti, které se prodávají kolem Mikuláše"));
        seznamJidla.add(new Eten("Oliebollen", "jsou koblihy, co se jedí na konci roku, každoročně noviny uveřejňují žebříček těch nejlepších prodejců"));
        seznamJidla.add(new Eten("Haring", "je naložený slaneček s cibulí, kupují se ve stáncích, jinak Nizozemci mají rádi také smažené ryby"));
        seznamJidla.add(new Eten("Stropvafle", "jsou sladké kulaté oplatky spojené sirupem, dají se koupit i v ČR, ale nemají tu chuť"));
        seznamJidla.add(new Eten("Kroket", "je to pečené mleté maso, ale vlastně nevím co to je, můj muž se po tom může utlouct"));
        seznamJidla.add(new Eten("Gouda", "je tvrdý sýr vyráběný holandským způsobem, je jich strašně moc druhů, například starý, mladý, kmínový..."));
        seznamJidla.add(new Eten("Pindakaas", "je burákové máslo, doslova to znamená burákový sýr"));
        seznamJidla.add(new Eten("Hagelslag", "jsou malé kousky čokolády, které se sypou na chleba, nebo mohou být ovocné a barevné"));


        System.out.println("Vybírám další jídlo");

        //ModelAndView drzak = new ModelAndView("index");
        int nahoda = (int) (Math.random() * seznamJidla.size() );
        System.out.println(nahoda);
        Eten jedno_jidlo = seznamJidla.get(nahoda);
        System.out.println(jedno_jidlo.getNazev());
        drzak.addObject("objekt_jidla", jedno_jidlo);

        ++nahoda;
        String jeden_odkaz = "images/" + nahoda + ".jpg";
        System.out.println(jeden_odkaz);
        drzak.addObject("odkazNaObrazek", jeden_odkaz);
        drzak.addObject("datum", LocalDateTime.now());

        return drzak;
    }
}



