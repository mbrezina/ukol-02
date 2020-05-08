package cz.czechitas.webapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;

@Controller
public class HlavniController {
    Map<Integer, Eten> zasobaJidla;

    @RequestMapping("/nahodny")
    public @ResponseBody
    String posliJidlo() throws JsonProcessingException {
        ModelAndView drzak = new ModelAndView("index");
        zasobaJidla = new TreeMap<>();
        zasobaJidla.put(0, new Eten(0, "Krentenboly", "jsou sladké housky trochu podobné naší vánočce, Nizozemci si do nich dávají sýr"));
        zasobaJidla.put(1, new Eten(1, "Peppernoten", "jsou sladkosti, které se prodávají kolem Mikuláše"));
        zasobaJidla.put(2, new Eten(2, "Oliebollen", "jsou koblihy, co se jedí na konci roku, každoročně noviny uveřejňují žebříček těch nejlepších prodejců"));
        zasobaJidla.put(3, new Eten(3, "Haring", "je naložený slaneček s cibulí, kupují se ve stáncích, jinak Nizozemci mají rádi také smažené ryby"));
        zasobaJidla.put(4, new Eten(4, "Stropvafle", "jsou sladké kulaté oplatky spojené sirupem, dají se koupit i v ČR, ale nemají tu chuť"));
        zasobaJidla.put(5, new Eten(5, "Kroket", "je to pečené mleté maso, ale vlastně nevím, co to je, můj muž se po tom může utlouct"));
        zasobaJidla.put(6, new Eten(6, "Gouda", "je tvrdý sýr vyráběný holandským způsobem, je jich strašně moc druhů, například starý, mladý, kmínový..."));
        zasobaJidla.put(7, new Eten(7, "Pindakaas", "je burákové máslo, doslova to znamená burákový sýr"));
        zasobaJidla.put(8, new Eten(8, "Hagelslag", "jsou malé kousky čokolády, které se sypou na chleba, nebo mohou být ovocné a barevné"));

        System.out.println("Vybírám další jídlo");

        int nahoda = (int) (Math.random() * zasobaJidla.size());
        System.out.println(nahoda);
        Eten jedno_jidlo = zasobaJidla.get(nahoda);
        System.out.println(jedno_jidlo);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(jedno_jidlo);
        return jsonStr;

    }
}



