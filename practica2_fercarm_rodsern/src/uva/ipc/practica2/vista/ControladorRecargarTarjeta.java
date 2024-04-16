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
    
    /**
     * Avisa al modelo de que la tarjeta de crédito ha sido pasada
     */
    public void tarjetaPasada(){
        miModelo.tarjetaCreditoPasada();
    }
    
    /**
     * Comprueba si la operación de pago por tarjeta de crédito es correcta
     * @return true si es correcta y false en caso contrario
     */
    public boolean comprobarPagoCredito(char[] p){
        String s = "";
        
        if(!miModelo.getPagadoCredito()){
            return false;
        }
        
        for(int i = 0; i < p.length; i++){
            s += p[i];
        }
        
        return s.equals("1234");
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
        miVista.mostrarPago();
    }
    
    public void procesarVolver(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
    
    public void procesarAceptar(){
        if(comprobarPagoCredito(miModelo.getPin())){   //Se ha pagado con tarjeta de crédito y el PIN es correcto
            miVista.setError(false);
            double saldoNuevo = miModelo.getSaldo() + aSumar;
            miModelo.setSaldo(saldoNuevo);
            miVista.actualizarSaldo();
            miVista.disponerPagoCorrecto();
        }
        else{
            miVista.setError(true);
        }
    }
    
    public void procesarCancelar(){
        miVista.disponerPagoCorrecto();
    }
}
