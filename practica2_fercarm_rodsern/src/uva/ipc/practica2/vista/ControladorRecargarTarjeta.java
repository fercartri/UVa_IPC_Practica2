package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de recargar tarjeta
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorRecargarTarjeta {
    private VistaRecargarTarjeta miVista;
    private Modelo miModelo;
    
    
    public ControladorRecargarTarjeta(VistaRecargarTarjeta vista){
        miVista = vista;
        miModelo = uva.ipc.practica2.Main.getModelo();
    }
    
    //Eventos-----------------------------------------------------------------------------
    public void procesarBillete10(){
        miVista.despulsarBilletes(0, 1, 1);
    }
    
    public void procesarBillete20(){
        miVista.despulsarBilletes(1, 0, 1);
    }
    
    public void procesarBillete50(){
        miVista.despulsarBilletes(1, 1, 0);
    }
    
    public void procesarCargarCantidad(){
        //TODO
    }
    
    public void procesarVolver(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
}
