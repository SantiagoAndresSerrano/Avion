/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clase;
import Modelo.Pasajero;
import Modelo.Silla;
import Modelo.Ubicacion;
import Vista.Principal;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Avion 
{
    private final Silla sillasEjecutivas[];
    private final Silla sillasEconomicas[];
    private ArrayList<Pasajero> pasajeros;
    private Principal p;
    int iteradorEjecutivas=0;
    int iteradorEconomicas=0;
    Controlador ca=new Controlador();
    public Avion()
            
    { 
           

        p=new Principal();
        p.setVisible(false);
        Clase clase;
        Ubicacion ubicacion;
        sillasEjecutivas = new Silla[8];
        sillasEconomicas= new Silla[42];

        sillasEjecutivas[0] = new Silla(1, Clase.EJECUTIVA, Ubicacion.CENTRO);
        sillasEjecutivas[1] = new Silla(2, Clase.EJECUTIVA, Ubicacion.CENTRO);
        sillasEjecutivas[2] = new Silla(3, Clase.EJECUTIVA, Ubicacion.PASILLO);
        sillasEjecutivas[3] = new Silla(4, Clase.EJECUTIVA, Ubicacion.VENTANILLA);
        sillasEjecutivas[4] = new Silla(5, Clase.EJECUTIVA, Ubicacion.VENTANILLA);
        sillasEjecutivas[5] = new Silla(6, Clase.EJECUTIVA, Ubicacion.CENTRO);
        sillasEjecutivas[6] = new Silla(7, Clase.EJECUTIVA, Ubicacion.VENTANILLA);
        sillasEjecutivas[7] = new Silla(8, Clase.EJECUTIVA, Ubicacion.PASILLO);
        
        for (int numeroSilla = 1 + 8, j = 1; j <= 42; numeroSilla++, j++)
        {

            if (j % 9 == 1 || j % 9 == 0) {
                ubicacion = Ubicacion.VENTANILLA;

            } else if (j % 6 == 2 || j % 6 == 5) {
                ubicacion = Ubicacion.CENTRO;
                
            } else {
                ubicacion = Ubicacion.PASILLO;
            }

            sillasEconomicas[j - 1] = new Silla(numeroSilla, Clase.ECONOMICA, ubicacion);
        }
        
        
        
        
        
    }
    public Silla buscarPasajeroEjecutivo(Pasajero Pasajero) {
        boolean encontrado = false;
        Silla silla = null;
        for (int i = 0; i < 8 && !encontrado; i++) {
            silla = sillasEjecutivas[i];
            if (silla.sillasAsignada() && silla.getPasajero().igualA(Pasajero)) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            silla = null;
        }
        return silla;
    }

    public Silla buscarPasajeroEconomico(Pasajero pPasajero) {
        boolean encontrado = false;
        Silla silla = null;
        for (int i = 0; i < 42 && !encontrado; i++) {
            silla = sillasEconomicas[i];
            if (silla.sillasAsignada() && silla.getPasajero().igualA(pPasajero)) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            silla = null;
        }
        return silla;
    }
    public Silla buscarPasajero(Pasajero Pasajero) {
       
        Silla silla = buscarPasajeroEjecutivo(Pasajero);
      
        if (null == silla) {
          
            silla = buscarPasajeroEconomico(Pasajero);
        }

        return silla;

    }
    
    public boolean desasignarSilla(Pasajero pPasajero) {
      
        Silla silla = buscarPasajero(pPasajero);
        boolean resultado = false;
       
        if (silla != null) {
            silla.desasignarSilla();
            resultado = true;
        }
        return resultado;
    }
    
     public Silla buscarSillaEjecutivaLibre(Ubicacion ubicacion)
    {

        boolean encontrado = false;
        Silla silla = null;
        for (int i = 0; i < sillasEjecutivas.length && !encontrado; i++) {
            silla = sillasEjecutivas[i];
            if (!(silla.sillasAsignada()) && silla.getUbicacion() == ubicacion) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            silla = null;
        }
        return silla;
    }
     
     
     public Silla buscarSillaEconomicaLibre(Ubicacion ubicacion) {
        boolean encontrado = false;
        Silla silla = null;

        for (int i = 0; i <sillasEconomicas.length && !encontrado; i++) {
            silla = sillasEconomicas[i];
            if (!(silla.sillasAsignada()) && silla.getUbicacion() == ubicacion) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            silla = null;
        }
        return silla;
    }
    
    public Silla asignarSilla(Clase clase, Ubicacion ubicacion, Pasajero pasajero) 
    {

        Silla silla = null;
        
        if (clase == Clase.EJECUTIVA) 
        {
            
            silla = buscarSillaEjecutivaLibre(ubicacion);
             if(silla!=null)
            {
                
                sillasEjecutivas[iteradorEjecutivas]=silla;
                p.la2[iteradorEjecutivas].setIcon(new ImageIcon(getClass().getResource("silla-ejec-asig.png")));
                this.iteradorEjecutivas++;
            }else{
                 System.out.println("vacia");
             }
            
        } else if (clase == Clase.ECONOMICA) {
            
            silla = buscarSillaEconomicaLibre(ubicacion);
            if(silla!=null)
            {
                
                sillasEconomicas[iteradorEconomicas]=silla;
                 ca.prin.la[iteradorEconomicas].setIcon(new ImageIcon(getClass().getResource("silla-econ-asig.png")));
                this.iteradorEconomicas++;
            }else{
                 System.out.println("vacia");
             }
        }
        if (silla != null) {
            silla.AsignarPasajero(pasajero);
        }
        return silla;

    }
    
    
    
    
    
}
