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
import Vista.Eliminar;
import Vista.Principal;
import Vista.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Controlador implements ActionListener

{
    Avion a;
    Eliminar e;
    Registro r;
    Silla s;
    Pasajero p;
    Principal prin;
    
   
    public Controlador(Avion a, Eliminar e, Registro r, Silla s, Pasajero p, Principal prin) {
        super();
        this.a = a;
        this.e = e;
        this.r = r;
        this.s = s;
        this.p = p;
        this.prin = prin;
      
        actionListener(this);
    }

    Controlador() {
    }
    
    public void actionListener(ActionListener ae)
    {
        e.jButton1.addActionListener(ae);
        prin.jButton1.addActionListener(ae);
        prin.jButton2.addActionListener(ae);
        prin.jButton3.addActionListener(ae);
        r.jButton1.addActionListener(ae);
        r.jcUbicacion.addActionListener(ae);
        r.jcClase.addActionListener(ae);
       
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Eliminar"))
        {
            
        
        }
        
        if(ae.getActionCommand().equals("Eliminar Usuario"))
        {
            e.setVisible(true);
        
        }
        if(ae.getActionCommand().equals("Registrar Usuario"))
        {
            r.setVisible(true);
        
        }
        if(ae.getActionCommand().equals("Calcular porcentaje"))
        {
            
        
        }
        if(ae.getActionCommand().equals("Registrar"))
        {
            
            p=new Pasajero(r.jtCedula.getText(),r.jtNombre.getText());
            s=new Silla();
            Ubicacion u = null;
            Clase c=null;
            //Seleccione, Centro, Pasillo, Ventanilla
           if(r.jcUbicacion.getSelectedItem().equals("Centro"))
           {
               u=Ubicacion.CENTRO;
           }
           if(r.jcUbicacion.getSelectedItem().equals("Pasillo"))
           {
               u=Ubicacion.PASILLO;
           }
           if(r.jcUbicacion.getSelectedItem().equals("Ventanilla"))
           {
               u=Ubicacion.VENTANILLA;
           }
           
            //Seleccione, Ejecutiva, Economica
           if(r.jcClase.getSelectedItem().equals("Ejecutiva"))
           {
               c=Clase.EJECUTIVA;
           }
           if(r.jcClase.getSelectedItem().equals("Economica"))
           {
               c=Clase.ECONOMICA;
           }
           
           
               try 
               {
                   if(c==null || u==null)
                   {
                       throw new Exception("Vacio");
                   }
                   
               
               a.asignarSilla(c, u, p);
                   
                   
                   
            } catch (Exception ex) 
            {
                
            }
            r.setVisible(false);
        }
        
        
    }
    
    

}
