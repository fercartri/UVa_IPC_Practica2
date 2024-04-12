package uva.ipc.practica2.vista;

import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de menu principal
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorMenuPrincipal {
    private VistaMenuPrincipal miVista;
    private Modelo miModelo;
    private GestorVistas miGestor;
    
    
    public ControladorMenuPrincipal(VistaMenuPrincipal vista){
        this.miVista = vista;
        this.miModelo = uva.ipc.practica2.Main.getModelo();
        this.miGestor = uva.ipc.practica2.Main.getGestorVistas();
    }
    
    
    public void procesarBtnComprarActionPerformed(){
        miGestor.mostrarVistaComprarBillete();
    }
}
