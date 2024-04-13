package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de menu principal
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorMenuPrincipal {
    private VistaMenuPrincipal miVista;
    private Modelo miModelo;
    
    
    public ControladorMenuPrincipal(VistaMenuPrincipal vista){
        this.miVista = vista;
        this.miModelo = uva.ipc.practica2.Main.getModelo();
    }
    
    
    public void procesarComprar(){
        Main.getGestorVistas().mostrarVistaComprarBillete();
    }
    
    public void procesarTarjeta(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
    
    public void procesarSalir(){
        System.exit(0);
    }
}
