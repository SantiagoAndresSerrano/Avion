/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author santi
 */
public class Pasajero {
    private String nombre,cedula;

    public Pasajero(String nombre, String cedula) 
    {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Pasajero() 
    {
        
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }
    
     public boolean igualA(Pasajero otroPasajero) {
        boolean igual = false;
        if (cedula.equals(otroPasajero.getCedula())) {
            igual = true;
        }
        return igual;
    }
}
