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
    
    /**
     * Consulta el saldo de la tarjeta de TCyL
     * @return un double mayor o igual a cero con el saldo
     */
    public double getSaldo(){
        return miModelo.getSaldo();
    }
    
    /**
     * Consulta el número de billetes adquiridos
     * @return un número mayor o igual a cero con el número de billetes
     */
    public int getNumBilletes(){
        return miModelo.getNumBilletes();
    }
    
    /**
     * Actualiza en la cabecera el número de billetes
     */
    public void actualizarNumBilletes(){
        String cadena = "NÚMERO DE BILLETES COMPRADOS: ";
        String numero = String.valueOf(getNumBilletes());
        cadena = cadena.concat(numero);
        miVista.lbNumBilletesSetText(cadena);
    }
    
    /**
     * Actualiza en la cabecera el saldo de la tarjeta
     */
    public void actualizarSaldo(){
        String cadena = "SALDO DE LA TARJETA: ";
        String euro = "€";
        String dinero = String.valueOf(getSaldo());
        cadena = cadena.concat(dinero);
        cadena = cadena.concat(euro);
        miVista.lbSaldoSetText(cadena);
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
