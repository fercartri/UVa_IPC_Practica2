/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2;

import javax.swing.JFrame;

/**
 *
 * @author rossa
 */
public class GestorVistas {
    private JFrame estadoActual;
    
    public GestorVistas(){
        mostrarVistaMenuPrincipal();
    }
    
    public void mostrarVistaComprarBillete(){
        if(estadoActual!=null){
            estadoActual.setVisible(false);
            estadoActual.dispose();
        }
        estadoActual=new uva.ipc.practica2.vistaComprarBillete.Vista();
        estadoActual.setVisible(true);
    }
    
    public void mostrarVistaMenuPrincipal(){
        if(estadoActual!=null){
            estadoActual.setVisible(false);
            estadoActual.dispose();
        }
        estadoActual=new uva.ipc.practica2.vistaMenuPrincipal.Vista();
        estadoActual.setVisible(true);
    }
    
    public void mostrarVistaMenuUsuario(){
        if(estadoActual!=null){
            estadoActual.setVisible(false);
            estadoActual.dispose();
        }
        estadoActual=new uva.ipc.practica2.vistaMenuUsuario.Vista();
        estadoActual.setVisible(true);
    }
    public void mostrarVistaMisViajes(){
        if(estadoActual!=null){
            estadoActual.setVisible(false);
            estadoActual.dispose();
        }
        estadoActual=new uva.ipc.practica2.vistaMisViajes.Vista();
        estadoActual.setVisible(true);
    }
    public void mostrarVistaRecargarTarjeta(){
        if(estadoActual!=null){
            estadoActual.setVisible(false);
            estadoActual.dispose();
        }
        estadoActual=new uva.ipc.practica2.vistaRecargarTarjeta.Vista();
        estadoActual.setVisible(true);
    }
    
}
