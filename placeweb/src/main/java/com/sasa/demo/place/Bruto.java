/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasa.demo.place;

import org.springframework.stereotype.Component;

/**
 *
 * @author Sasa
 */
@Component
public class Bruto {

    // bruto
    public double bruto(double bruto) {

        return bruto;

    }

    // računanje odbitaka za mirovinsko 1 i 2 stup
    public double mirovinsko1(double bruto) {

        double mirovinsko1Stup = bruto * 0.15;

        return mirovinsko1Stup;
    }

    public double mirovinsko2(double bruto) {

        double mirovinsko2 = bruto * 0.05;

        return mirovinsko2;
    }
    //zdravstveno

    public double zdravstveno(double bruto) {

        double zdravstveno = bruto * 0.165;

        return zdravstveno;
    }

    public double ukupniTrosakPlace(double bruto) {

        double ukupniTrosak = bruto * 1.165;

        return ukupniTrosak;
    }

}
