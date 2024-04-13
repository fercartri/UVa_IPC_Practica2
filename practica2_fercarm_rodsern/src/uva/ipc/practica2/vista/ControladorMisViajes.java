package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de mis viajes
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorMisViajes {
    private VistaMisViajes miVista;
    private Modelo miModelo;
    
    
    public ControladorMisViajes(VistaMisViajes vista){
        miVista = vista;
        miModelo = uva.ipc.practica2.Main.getModelo();
    }
    
    //Eventos-----------------------------------------------------------------------------
    public void procesarX(){
        //TODO
    }
}
