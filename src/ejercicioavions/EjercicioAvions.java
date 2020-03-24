/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioavions;

import Controlador.Avion;
import Controlador.Controlador;
import Modelo.Pasajero;
import Modelo.Silla;
import Vista.Eliminar;
import Vista.Principal;
import Vista.Registro;

/**
 *
 * @author santi
 */
public class EjercicioAvions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Avion a=new Avion();
    Eliminar e=new Eliminar();
    Registro r=new Registro();
    Silla s=new Silla();
    Pasajero p=new Pasajero();
    Principal prin=new Principal();
   
    Controlador c=new Controlador(a,e,r,s,p,prin);
    
    
    }
    
}
