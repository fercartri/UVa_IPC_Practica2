package uva.ipc.practica2.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
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
        miModelo.resetTodo();
    }
    
    public ArrayList<String> cargarViajesAntiguos(){
        ArrayList<String> listaAntiguos = new ArrayList<>();
        listaAntiguos = miModelo.getHistorial();  //Cargar todo el historial de viajes
        for(int i = 0; i < listaAntiguos.size(); i++){  //Eliminar los que todavía no han ocurrido
            if(!billetePasado(listaAntiguos.get(i))){
                listaAntiguos.remove(i);
                i--;
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
                i--;
            }
        }

        return listaFuturos; 
    }
    
     /**
     * Consulta si la fecha seleccionada para el viaje es el mismo día que se hace la compra
     * @return true si es el mismo día y false en caso contrario
     */
    public boolean hoySeleccionado(String fApp){
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
            Date fechaApp = sdf.parse(fApp);

            if (fechaApp.equals(fechaActual)) {
                return true;
            }
            else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
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
    
    
    public ArrayList <String> cargarRutasPosiblesDialog(String origen, String destino, boolean findesemana){
        //TODO
        ArrayList<String> rutas_aux = new ArrayList<>();
        ArrayList<String> rutas = new ArrayList<>();
        
        rutas_aux = miModelo.getRutas();
        
        for(int i = 0; i < rutas_aux.size(); i++){
            String linea = rutas_aux.get(i);
            String[] token = linea.split(";");
            String ruta = token[0];
            String orig = token[1];
            String dest = token[2];
            String tiempo = token[3];
            String precio = token[4];
            String h_semana = token[5];
            String h_finde = token[6];
            
            LocalTime ahora = LocalTime.now();  //Guardar la hora actual
            Date hoy = new Date();
            if(orig.equals(origen) && dest.equals(destino)){
                if(findesemana){   //Es fin de semana
                    String[] pos_h = h_finde.split(",");
                    for(int j = 0; j < pos_h.length; j++){
                        if(hoySeleccionado(miVista.getFechaSeleccionada())){    //La fecha seleccionada es hoy
                            if(ahora.isBefore(LocalTime.parse(pos_h[j], DateTimeFormatter.ofPattern("HH:mm")))){
                                String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";                                
                                rutas.add(l);
                            }
                        }else{
                            String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                            rutas.add(l);
                        }
                    }
                }
                else{
                    String[] pos_h = h_semana.split(",");
                    for(int j = 0; j < pos_h.length; j++){
                        if(hoySeleccionado(miVista.getFechaSeleccionada()) && ahora.isBefore(LocalTime.parse(pos_h[j], DateTimeFormatter.ofPattern("HH:mm")))){
                            String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                            rutas.add(l);
                        }else if(hoy.before(miVista.getDateSeleccionada())){
                            String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                            rutas.add(l);
                        }
                    }
                }
            }
        }
            
        return rutas;
    }

    /**
     * Consulta si la fecha seleccionada por el usuario cae en fin de semana
     * @return true si es un fin de semana y false en caso contrario
     */
    private boolean getFinDeSemana(String cadenaFecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fecha = formato.parse(cadenaFecha);
            LocalDate localFecha = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            DayOfWeek dia = localFecha.getDayOfWeek();

            if(dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY){
                return true;
            }
            else{
                return false;
            }
        } catch (ParseException e) {
            // Manejar la excepción si la cadena no puede ser parseada como una fecha
            e.printStackTrace();
            return false;
        }
    }

    
    //Eventos-----------------------------------------------------------------------------
    public void procesarBtnVolver(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
    
    public void procesarDevolver(){
        if(miVista.getBilleteSeleccionado() == null){
            miVista.setErrorNoBillete();
        }
        else{
            miVista.resetError();
            
            ArrayList<String> billetesValidos = new ArrayList<>();
            billetesValidos = miModelo.getHistorial();  //Cargo todo el historial
            
            for(int i = 0; i < billetesValidos.size(); i++){
                if(billetesValidos.get(i).equals(miVista.getBilleteSeleccionado())){   //Elimino de la lista el billete seleccionado
                    billetesValidos.remove(i);
                }
            }
            
            String tokens[] = miVista.getBilleteSeleccionado().split(";");
            
            miModelo.setSaldo(miModelo.getSaldo()+ Double.parseDouble(tokens[6].replace("€", "")));
            
            miModelo.guardarHistorial(billetesValidos);
            
            miVista.cargarHistorial();
        }
    }
    
    public void procesarModificar(){
        if(miVista.getBilleteSeleccionado() == null){
            miVista.setErrorNoBillete();
        }
        else{
            miVista.resetError();
            miVista.setlbErrorDialogVisible(false);
            String tokens[] = miVista.getBilleteSeleccionado().split(";");
            miVista.cargarRutasDialog(tokens[3], tokens[4],getFinDeSemana(tokens[0]));
            miVista.setDialogVisible(true);
        }
    }

    
    public void procesarBtnCancelDialogActionPerformed(){
        miVista.setDialogVisible(false);
    }
    
    public void procesarBtnConfDialogActionPerformed(){
        //TODO MODIFICAR HISTORIAL Y ACTUALIZAR BILLETES
        if(miVista.isListaRutasPosiblesDialogSelected()){
            miVista.setlbErrorDialogVisible(false);
            boolean[] options = miVista.getDialogOptions();
            String ruta = miVista.getListaRutasPosiblesString();
            //TODO MODIFICAR EL BILLETE EN EL FICHERO
            miVista.cargarHistorial();
            miVista.setDialogVisible(false);
        }else{
            miVista.setlbErrorDialogVisible(true);
        }
    }
    
}
