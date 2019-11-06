/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        Integer date, month, years;
        String[] str = nbr.split("/");
        date = Integer.parseInt(str[0]);
        month = Integer.parseInt(str[1]);
        years = Integer.parseInt(str[2]);
        return this.convertArabeToRoman(date) + "/" + this.convertArabeToRoman(month) + "/" + this.convertArabeToRoman(years);
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
    if (nbr < 1 || nbr > 2000)
        return "valeur incorrect";
    String s = "";
    while (nbr >= 1000) {
        s += "M";
        nbr -= 1000;        }
    while (nbr >= 900) {
        s += "CM";
        nbr -= 900;
    }
    while (nbr >= 500) {
        s += "D";
        nbr -= 500;
    }
    while (nbr >= 400) {
        s += "CD";
        nbr -= 400;
    }
    while (nbr >= 100) {
        s += "C";
        nbr -= 100;
    }
    while (nbr >= 90) {
        s += "XC";
        nbr -= 90;
    }
    while (nbr >= 50) {
        s += "L";
        nbr -= 50;
    }
    while (nbr >= 40) {
        s += "XL";
        nbr -= 40;
    }
    while (nbr >= 10) {
        s += "X";
        nbr -= 10;
    }
    while (nbr >= 9) {
        s += "IX";
        nbr -= 9;
    }
    while (nbr >= 5) {
        s += "V";
        nbr -= 5;
    }
    while (nbr >= 4) {
        s += "IV";
        nbr -= 4;
    }
    while (nbr >= 1) {
        s += "I";
        nbr -= 1;
    }    
    return s;
    }

}
