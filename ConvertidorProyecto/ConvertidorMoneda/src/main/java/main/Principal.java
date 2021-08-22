package main;


import controlador.Coordinador;
import modelo.Logica;
import vista.ventanas.Convertidor;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sistemas08
 */
public class Principal {
    
    public static void main(String[] args){
        Coordinador miCoordinador = new Coordinador();
        Logica miLogica = new Logica();
        Convertidor miConvertidor = new Convertidor();
        
        miLogica.setCoordinador(miCoordinador);
        miConvertidor.setCoordinador(miCoordinador);
        
        miCoordinador.setLogica(miLogica);
        miCoordinador.setCalculadora(miConvertidor);
        
        miConvertidor.setVisible(true);
    }
    
}
