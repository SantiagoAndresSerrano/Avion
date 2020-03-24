/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Silla {
    
    private int numero;
    private Clase clase;
    private Ubicacion ubicacion;
    private Pasajero pasajero;

    public Silla() {
        super();
    }

    public Silla(int numero, Clase clase, Ubicacion ubicacion) {
        super();
        this.numero = numero;
        this.clase = clase;
        this.ubicacion = ubicacion;
        this.pasajero = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }
    
    public boolean sillaAsignadaPasajero(Pasajero pasajeros) {

        boolean asignadaPasajero = true;
        if (null == pasajero) 
        {
            asignadaPasajero = false;
        } else if (pasajero.equals(pasajeros)) {
            asignadaPasajero = true;
        }
        return asignadaPasajero;
    }
    
    public void AsignarPasajero(Pasajero pasajeros) {
        pasajero = pasajeros;

    }

    public void desasignarSilla() {
        pasajero = null;
    }

    public boolean sillasAsignada() {

        boolean asignada = true;
        if (null == pasajero) {
            asignada = false;
        }
        return asignada;
    }
    public boolean sillaAsignada( )
    {
        boolean asignada = true;
        if( null == pasajero )
        {
            asignada = false;
        }
        return asignada;
    }
    
    
}