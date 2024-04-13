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
    private double aSumar;
    
    public ControladorRecargarTarjeta(VistaRecargarTarjeta vista){
        miVista = vista;
        miModelo = uva.ipc.practica2.Main.getModelo();
        
    }
    
    public double getSaldo(){
        return miModelo.getSaldo();
    }
    
    //Eventos-----------------------------------------------------------------------------
    public void procesarBillete10(){
        miVista.despulsarBilletes(0, 1, 1);
        aSumar = 10;        
    }
    
    public void procesarBillete20(){
        miVista.despulsarBilletes(1, 0, 1);
        aSumar = 20;    
    }
    
    public void procesarBillete50(){
        miVista.despulsarBilletes(1, 1, 0);
        aSumar = 50;   
    }
    
    public void procesarCargarCantidad(){
        double saldoNuevo = miModelo.getSaldo() + aSumar;
        miModelo.setSaldo(saldoNuevo);
        miVista.actualizarSaldo();
    }
    
    public void procesarVolver(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
}
