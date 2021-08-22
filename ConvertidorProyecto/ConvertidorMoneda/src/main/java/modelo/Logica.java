/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Coordinador;

/**
 *
 * @author Sistemas08
 */
public class Logica {
    Coordinador miCoordinador;
    
    public String cordobaDolar(double c){
        double dolar = (c/35.2694);
        double round = Math.round(dolar*100.00)/100.00;
        return String.valueOf(round)+ "$";
    }
    
    public int sumar(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        
        return (n1 + n2);
    }

    public String sumar(int num1, int num2) {
        System.out.println("Desde lógica");
        return (Integer.toString(num1 + num2));
    }
        
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
    
}
