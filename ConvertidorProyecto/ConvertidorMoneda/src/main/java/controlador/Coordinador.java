/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Logica;
import vista.ventanas.Convertidor;


/**
 *
 * @author Sistemas08
 */
public class Coordinador {
    Logica miLogica;
    Convertidor miCalculadora;
    
    public String cordobaDolar(double cordoba){
        return miLogica.cordobaDolar(cordoba);
    }
    
    public int sumar(String num1, String num2) {
        return miLogica.sumar(num1, num2);
    }

    public String sumar(int num1, int num2) {
        System.out.println(num1);
        System.out.println(num2);
        return miLogica.sumar(num1, num2);
    }
        
    public void setLogica(Logica miLogica) {
        this.miLogica = miLogica;
    }

//    public void cargarPanel(int panel) {
//        switch(panel){
//            case 1:
//                miVentana.definirPanel(miPanel1);
//                break;
//            case 2:
//                miVentana.definirPanel(miPanel2);
//                break;
//            case 3:
//                miCalculadora = new Calculadora();
//                miCalculadora.setVisible(true);
//            default:
//                break;
//        }
//            
//    }

    public void setCalculadora(Convertidor miCalculadora) {
        this.miCalculadora = miCalculadora;
    }
}
