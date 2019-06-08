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
public class Polja {
    
    
    
    	private  double VrijeBruto;

	protected  double VrijePrireza;
	public double employee = VrijeBruto;

	private  int brojDjece;
	private  int brojClanova;
       
    public double getVrijeBruto() {
        return VrijeBruto;
    }

    public void setVrijeBruto(double VrijeBruto) {
        this.VrijeBruto = VrijeBruto;
    }

    public double getVrijePrireza() {
        return VrijePrireza;
    }

    public void setVrijePrireza(int VrijePrireza) {
        this.VrijePrireza = VrijePrireza;
    }

    public double getEmployee() {
        return employee;
    }

    public void setEmployee(double employee) {
        this.employee = employee;
    }

    public int getBrojDjece() {
        return brojDjece;
    }

    public void setBrojDjece(int brojDjece) {
        this.brojDjece = brojDjece;
    }

    public int getBrojClanova() {
        return brojClanova;
    }

    public void setBrojClanova(int brojClanova) {
        this.brojClanova = brojClanova;
    }
    
 
        
        public Polja(){
        }


        
        
}
