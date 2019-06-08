/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasa.demo.place;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Sasa
 */

/**
 * @author Sasa
 *
 */
@Controller

public class PlaceController {

    @Autowired
    OsobniOdbitak ob;

    @Autowired
    Bruto brutto;

    @Autowired
    PlaceController pl;

    @Autowired
    Polja polja;

    /**
     * @param args the command line arguments
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model) {

        List<Integer> prirez = new ArrayList<>();
        prirez.add(0);
        prirez.add(1);
        prirez.add(2);
        prirez.add(3);
        prirez.add(4);
        prirez.add(5);
        prirez.add(6);
        prirez.add(7);
        prirez.add(8);
        prirez.add(9);
        prirez.add(10);
        prirez.add(11);
        prirez.add(12);
        prirez.add(13);
        prirez.add(14);
        prirez.add(15);
        prirez.add(16);
        prirez.add(17);
        prirez.add(18);

        List<Integer> brojDjece = new ArrayList<>();
        brojDjece.add(0);
        brojDjece.add(1);
        brojDjece.add(2);
        brojDjece.add(3);
        brojDjece.add(4);
        brojDjece.add(5);
        brojDjece.add(6);

        List<Integer> brojClanova = new ArrayList<>();
        brojClanova.add(0);
        brojClanova.add(1);
        brojClanova.add(2);
        brojClanova.add(3);
        brojClanova.add(4);
        brojClanova.add(5);

        model.addAttribute("test", prirez);
        model.addAttribute("djeca", brojDjece);

        model.addAttribute("clanovi", brojClanova);

        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String handlePost(@RequestParam(value = "employee", defaultValue = "0") double d, @RequestParam("clanovi") int brojClanova,
            @RequestParam("djeca") int brojDjece, @RequestParam("VrijePrireza") int VrijePrireza) {

        polja.setBrojClanova(brojClanova);
        polja.setVrijeBruto(d);
        polja.setBrojDjece(brojDjece);
        polja.setVrijePrireza(VrijePrireza);
        return "redirect:/rezultat";

    }

    @GetMapping("/rezultat")
    public String sayHello(Model theModel) {
        //OsobniOdbitak ob = new OsobniOdbitak();
        double netoPlaca = ob.osnovica(brutto.bruto(polja.getVrijeBruto()),
                ob.ukupniOdbitak(polja.getBrojClanova(), polja.getBrojDjece()));

        theModel.addAttribute("clanovi", polja.getBrojClanova());
        theModel.addAttribute("djeca", polja.getBrojDjece());
        theModel.addAttribute("VrijePrireza", polja.getVrijePrireza());

        theModel.addAttribute("getVrijeBruto", polja.getVrijeBruto());
        theModel.addAttribute("employee", polja.getVrijeBruto());
        theModel.addAttribute("PocetniBruto", polja.getVrijeBruto());

        theModel.addAttribute("mirovinsko1", brutto.mirovinsko1(polja.getVrijeBruto()));
        theModel.addAttribute("mirovinsko2", brutto.mirovinsko2(polja.getVrijeBruto()));

        theModel.addAttribute("ukupnaOlaksica", ob.ukupniOdbitak(polja.getBrojClanova(), polja.getBrojDjece()));

        if (ob.getOsnovicaZaObracunPoreza() < 0) {
            theModel.addAttribute("osnovicaZaObracunPoreza", 0);
        } else {
            theModel.addAttribute("osnovicaZaObracunPoreza", ob.getOsnovicaZaObracunPoreza());
        }

        if (ob.getOsnovicaZaObracunPoreza() < 30000) {
            theModel.addAttribute("p24", ob.getP24());
            theModel.addAttribute("p36", 0);
            theModel.addAttribute("poreziUkupno", (ob.getP24()));
        } else {
            theModel.addAttribute("p24", 7200);
            theModel.addAttribute("p36", ob.getP36());
            theModel.addAttribute("poreziUkupno", (7200 + ob.getP36()));
        }

        if (polja.getVrijePrireza() > 0 && polja.getVrijePrireza() <= 18) {

            theModel.addAttribute("prirez", ob.getUkupniPrirez());
            theModel.addAttribute("UkupnoPorezIPrirez", ob.getUkupnoPorezIPrirez());
        } else {
            theModel.addAttribute("prirez", 0);
            theModel.addAttribute("UkupnoPorezIPrirez", (ob.getUkupnoPorezIPrirez()));
        }

        theModel.addAttribute("ukupniTrosakPlace", brutto.ukupniTrosakPlace(polja.getVrijeBruto()));

        theModel.addAttribute("zdravstveno", brutto.zdravstveno(polja.getVrijeBruto()));

        theModel.addAttribute("netoPlaca", netoPlaca);

        return "viewbar";

    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String reset(Model theModel) {

        ob.setP24(0);
        ob.setP36(0);
        ob.setUkupnoPorezIPrirez(0);
        ob.setUkupniPrirez(0);

     
        return "redirect:/";
        
    }


}
