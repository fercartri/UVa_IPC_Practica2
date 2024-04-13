package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de menu usuario
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorMenuUsuario {
    private VistaMenuUsuario miVista;
    private Modelo miModelo;
    
    
    public ControladorMenuUsuario(VistaMenuUsuario vista){
        this.miVista = vista;
        this.miModelo = uva.ipc.practica2.Main.getModelo();
    }
    
    //Eventos-----------------------------------------------------------------------------
    public void procesarRecargar(){
        Main.getGestorVistas().mostrarVistaRecargarTarjeta();
    }
    
    public void procesarMisViajes(){
        Main.getGestorVistas().mostrarVistaMisViajes();
    }
    
    public void procesarVolver(){
        Main.getGestorVistas().mostrarVistaMenuPrincipal();
    }
}
