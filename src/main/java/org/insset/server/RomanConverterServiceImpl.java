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
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        int result = 0;
        char last = 'a';
        for (int i = 0; i < nbr.length(); i++) {
            switch(nbr.charAt(i)) {
                case 'M':
                    result += 1000;
                    if (last == 'I') result = result - 2;
                    break;
                case 'D':
                    result += 500;
                    if (last == 'I') result = result - 2;
                    break;
                case 'C':
                    result += 100;
                    if (last == 'I') result = result - 2;
                    break;
                case 'L':
                    result += 50;
                    if (last == 'I') result = result - 2;
                    break;
                case 'X':
                    result += 10;
                    if (last == 'I') result = result - 2;
                    break;
                case 'V':
                    result += 5;
                    if (last == 'I') result = result - 2;
                    break;
                case 'I':
                    result += 1;
                    break;
            }
            last = nbr.charAt(i);
        }
        
        return result;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        String result = "";
        
        while (nbr != 0) {
            if (nbr == 999) {
                result += "IM";
                nbr -= 999;
            }
            
            else if (nbr >= 900 && nbr < 1000) {
                result += "CM";
                nbr -= 900;
            }            
            
            else if (nbr == 499) {
                result += "ID";
                nbr -= 499;
            }
            
            else if (nbr >= 400 && nbr < 499) {
                result += "CD";
                nbr -= 400;
            }
            
            else if (nbr == 99) {
                result += "IC";
                nbr -= 99;
            }
            
            else if (nbr >= 90 && nbr < 99) {
                result += "XC";
                nbr -= 90;
            }
            
            else if (nbr == 49) {
                result += "IL";
                nbr -= 49;
            }
            
            else if (nbr >= 40 && nbr < 49) {
                result += "XL";
                nbr -= 40;
            }
            
            else if (nbr == 9) {
                result += "IX";
                nbr -= 9;
            }
            
            else if (nbr == 4) {
                result += "IV";
                nbr -= 4;
            }
            
            else if (nbr >= 1000) {
                result += 'M';
                nbr -= 1000;
            }
            else if (nbr >= 500) {
                result += 'D';
                nbr -= 500;

            }
            else if (nbr >= 100) {
                result += 'C';
                nbr -= 100;
            }
            else if (nbr >= 50) {
                result += 'L';
                nbr -= 50;
            }
            else if (nbr >= 10) {
                result += 'X';
                nbr -= 10;
            }
            else if (nbr >= 5) {
                result += 'V';
                nbr -= 5;
            }
            else if (nbr >= 1) {
                result += 'I';
                nbr -= 1;
            }
        }
        return result;
    }

}
