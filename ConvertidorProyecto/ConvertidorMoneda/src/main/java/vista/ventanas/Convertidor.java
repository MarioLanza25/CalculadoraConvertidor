package vista.ventanas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Eugenio
 */
public class Convertidor extends Frame implements ActionListener, KeyListener {

    TextField pantalla = null;
    Button tecla = null;
    int operando1 = 0;
    int operando2 = 0;
    double valor;
    String operacion = null;
    boolean newDigitBlock = true;

    Coordinador miCoordinador;

    public Convertidor() {
        this.setTitle("Calculadora y conversor");
        this.setSize(300, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                //Concluye el programa cuando se cierra la ventana
                System.exit(0);
            }
        });

        //=== Display ===
        pantalla = new TextField();
        pantalla.setText("0");
        pantalla.setSize(50, HEIGHT);
        pantalla.addKeyListener(this);
        pantalla.setBackground(Color.cyan);
        this.add(pantalla, BorderLayout.NORTH);

        //--- Teclas ----
        Panel panel01 = new Panel();
        panel01.setLayout(new GridLayout(5, 3));
        tecla = new Button("9");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("8");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("+");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("7");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("6");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("-");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("5");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("4");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("Cordoba a dolar");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("3");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("2");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("C");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("1");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("0");
        tecla.addActionListener(this);
        panel01.add(tecla);
        tecla = new Button("=");
        tecla.addActionListener(this);
        panel01.add(tecla);
        this.add(panel01, BorderLayout.CENTER);
    }

    //--- Método de la interfaz ActionListener ---
    @Override
    public void actionPerformed(ActionEvent ae) {
        String teclaPulsada = ((Button) ae.getSource()).getLabel();

        
       if (teclaPulsada.equals("C")) {
            pantalla.setText("0");
            operando1 = 0;
            operando2 = 0;
            
            newDigitBlock = true;
        } else if (teclaPulsada.equals("=")) {
            operando2 = Integer.parseInt(pantalla.getText());
            if (operacion != null) {
                if (operacion.equals("+")) {
                    //pantalla.setText(Integer.toString(operando1 + operando2));
                    pantalla.setText(miCoordinador.sumar(operando1, operando2));
                } else if (operacion.equals("-")) {
                    pantalla.setText(Integer.toString(operando1 - operando2));
                }
                else if(operacion.equals("Cordoba a dolar")){
                    pantalla.setText(miCoordinador.cordobaDolar(operando1));
                }
            }
            newDigitBlock = true;
            operacion = null;
        } else if (teclaPulsada.equals("+") || teclaPulsada.equals("-") || teclaPulsada.equals("Cordoba a dolar")){
            operacion = teclaPulsada;
            operando1 = Integer.parseInt(pantalla.getText());
            newDigitBlock = true;
        } else {
            if (newDigitBlock == true) {
                pantalla.setText(teclaPulsada);
                newDigitBlock = false;
            } else {
                pantalla.setText(pantalla.getText() + teclaPulsada);
                //--- Quitar 0 al principio ---
                if (pantalla.getText().length() > 1 && (pantalla.getText().charAt(0) == '0')) {
                    pantalla.setText(pantalla.getText().substring(1));
                }
            }
        }
//          valor = Double.parseDouble(pantalla.getText());
//          
//              if(teclaPulsada.equals("C => D")){
//                  pantalla.setText(miCoordinador.cordobaDolar(valor));
//              }
          
    }

    //--- Métodos de la interfaz KeyListener ---
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}
