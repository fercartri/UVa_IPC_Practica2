package uva.ipc.practica2.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    
    public ArrayList<String> cargarViajesAntiguos(){
        ArrayList<String> listaAntiguos = new ArrayList<>();
        listaAntiguos = miModelo.getHistorial();  //Cargar todo el historial de viajes

        for(int i = 0; i < listaAntiguos.size(); i++){  //Eliminar los que todavía no han ocurrido
            if(!billetePasado(listaAntiguos.get(i))){
                listaAntiguos.remove(i);
            }
        }

        return listaAntiguos; 
    }
    
    public ArrayList<String> cargarViajesFuturos(){
        ArrayList<String> listaFuturos = new ArrayList<>();
        listaFuturos = miModelo.getHistorial();  //Cargar todo el historial de viajes

        for(int i = 0; i < listaFuturos.size(); i++){  //Eliminar los que ya han ocurrido
            if(billetePasado(listaFuturos.get(i))){
                listaFuturos.remove(i);
            }
        }

        return listaFuturos; 
    }
    
    /**
     * Consulta si el billete pasado como parámetro es anterior a la fecha y hora actual
     * @param billete un String con el billete en el formato adecuado
     * @return true si el billete ya ha pasado y false en caso contrario
     */
    public boolean billetePasado(String billete){
        String tokens[] = billete.split(";");

        String fecha = tokens[0];
        String hora = tokens[1];

        //Comprobar la fecha
        String fActual;
        String dia, mes, anno;

        LocalDate hoy = LocalDate.now();
        int d = hoy.getDayOfMonth();
        int m = hoy.getMonthValue();
        int a = hoy.getYear();

        if(d < 10){
            dia = "0" + d;
        }
        else{
            dia = "" + d;
        }

        if(m < 10){
            mes = "0" + m;
        }
        else{
            mes = "" + m;
        }      

        fActual = dia + "-" + mes + "-" + a;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date fechaActual = sdf.parse(fActual);
            Date fechaBillete = sdf.parse(fecha);

            if (fechaBillete.compareTo(fechaActual) < 0) { //La fecha del billete antes de la actual
                return true;
            }
            else if(fechaBillete.compareTo(fechaActual) > 0) { //La fecha del billete después de la actual
                return false;
            }
            else{   //Mismo día => Comparar horas
                LocalTime ahora = LocalTime.now();  //Guardar la hora actual

                if(ahora.isBefore(LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm")))){
                    return false;
                }
                else{
                    return true;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Eventos-----------------------------------------------------------------------------
    public void procesarBtnVolver(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
    
    public void procesarDevolver(){
        if(miVista.billeteSeleccionado() == null){
            miVista.setErrorNoBillete();
        }
        else{
            miVista.resetError();
            
            ArrayList<String> billetesValidos = new ArrayList<>();
            billetesValidos = miModelo.getHistorial();  //Cargo todo el historial
            
            for(int i = 0; i < billetesValidos.size(); i++){
                if(billetesValidos.get(i).equals(miVista.billeteSeleccionado())){   //Elimino de la lista el billete seleccionado
                    billetesValidos.remove(i);
                }
            }
            
            miModelo.guardarHistorial(billetesValidos);
            
            miVista.dispose();
            Main.getGestorVistas().mostrarVistaMisViajes();
        }
    }
    
    public void procesarModificar(){
        if(miVista.billeteSeleccionado() == null){
            miVista.setErrorNoBillete();
        }
        else{
            miVista.resetError();
            //TODO
        }
    }
}
