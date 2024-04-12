package uva.ipc.practica2.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de comprar billete
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorComprarBillete {
    private VistaComprarBillete miVista;
    private Modelo miModelo;
    private String datosBillete;
   
    
    /**
     * Inicializar la vista y el modelo a partir de una vista proporcionada
     * @param vista un objeto vista cualquiera
     */
    public ControladorComprarBillete(VistaComprarBillete vista) {
        this.miVista = vista;
        this.miModelo = uva.ipc.practica2.Main.getModelo();
    }
    
    /**
     * Consultar todas las estaciones posibles del sistema
     * @return estaciones un ArrayList<String> con el nombre de las estaciones
     */
    public ArrayList<String> cargarEstaciones(){
        ArrayList<String> estaciones = new ArrayList<>();
        estaciones = miModelo.getEstaciones();
        return estaciones;
    }
    
    /**
     * Consultar todas las rutas posibles del sistema para un origen y destino dados en una fecha determinada
     * @param origen la estación de origen
     * @param destino la estación de destino
     * @param findesemana true si el billete es para un día de fin de semana y false si no lo es
     * @return rutas un ArrayList<String> con las rutas posibles
     */
    public ArrayList<String> cargarRutasPosibles(String origen, String destino, boolean findesemana){
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
            
            if(orig.equals(origen) && dest.equals(destino)){
                if(findesemana){   //Es fin de semana
                    String[] pos_h = h_finde.split(",");
                    for(int j = 0; j < pos_h.length; j++){
                        String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                        rutas.add(l);
                    }
                }
                else{
                    String[] pos_h = h_semana.split(",");
                    for(int j = 0; j < pos_h.length; j++){
                        String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                        rutas.add(l);
                    }
                }
            }
        }
            
        return rutas;
    }
    
    /**
     * Resetea los valores al estado inicial
     */
    public void resetTodo(){
        miModelo.resetTodo();
    }

    /**
     * Comprueba si existe la ruta entre dos estaciones
     * @param o la estación de origen
     * @param d la estación de destino
     * @return true si existe una ruta y false si no existe
     */
    public boolean compEstaciones(String o, String d){
        ArrayList<String> rutas = new ArrayList<>();
        
        rutas = miModelo.getRutas();
        
        for(int i = 0; i < rutas.size(); i++){
            String linea = rutas.get(i);
            String[] token = linea.split(";");
            String orig = token[1];
            String dest = token[2];
            if (orig.equals(o) && dest.equals(d)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Comprueba si la fecha seleccionada por el usuario es válida
     * @return true si es válida y false en caso contrario
     */
    public boolean compFecha(String fApp){
        if(fApp == null){
            return false;
        }
        
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

            if (fechaApp.compareTo(fechaActual) >= 0) {
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
    
    /**
     * Avisa al modelo de que la tarjeta de crédito ha sido pasada
     */
    public void tarjetaCreditoPasada(){
        miModelo.tarjetaCreditoPasada();
    }
    
    /**
     * Se procesa el pago, si es posible, mediante la tarjeta de renfe
     * @param precio un número mayor o igual que cero
     * @return true si el pago se ha llevado a cabo con éxito y false en caso contrario
     */
    public boolean tarjetaRenfePasada(double precio){
        if(precio <= miModelo.getSaldo()){  //Se puede procesar el pago
            miModelo.tarjetaRenfePasada();
            miModelo.setSaldo(miModelo.getSaldo()-precio);
            return true;
        }
        else{
            return false;
        }
    }
    
    public void prepararDatosHistorial(String billete){
        datosBillete = billete;
    }
    
    public void meterBilleteHistorial(){
        miModelo.guardarHistorial(datosBillete, miVista.getBicicleta(),miVista.getMascota(), miVista.getSilla());
    }
    
    //PROCESAR EVENTOS------------------------------------------------------------------------------------
    public void procesarBtnSigP1ActionPerformed(){
        if(!compEstaciones(miVista.getOrigen(), miVista.getDestino())){    //Ruta no valida\\
            miVista.setTextoLbError1("Ruta no existente");
            miVista.setVisibilidadLbError1(true);
        }
        else if(!compFecha(miVista.getFecha())){  //Ruta correcta pero fecha no valida
            miVista.setTextoLbError1("Fecha no válida");
            miVista.setVisibilidadLbError1(true);
            
        }
        else{   //Ambas son correctas
            miVista.setVisibilidadLbError1(false);
            miVista. cargarRutasPosibles(miVista.getOrigen(), miVista.getDestino(), miVista.getFinDeSemana());
            miModelo.guardarFecha(miVista.getFecha());
            miModelo.guardarOrigen(miVista.getOrigen());
            miModelo.guardarDestino(miVista.getDestino());

            miVista.setVisible(0,1,0);       
            miVista.setNoVisible(1,0,1);
        }
    }
    
    public void procesarBtnSigP2ActionPerformed(){
        if(miVista.isListaRutasPosiblesSelected()){   //Hay algún elemento seleccionado
            //TODO coger el dato del billete de la lista de rutas posibles
            int indice = miVista.getListaRutasPosiblesIndex();
            String datosBillete = miVista.getListaRutasPosiblesString();
            prepararDatosHistorial(datosBillete);
            miVista.setRadioButtonCredito(false);
            miVista.setRadioButtonRenfe(false);
            miVista.setVisible(0,0,1);
            miVista.setNoVisible(1,1,0);
        }
        else{   //No hay elementos seleccionados
             miVista.setVisibilidadLbError3(true);
        }    
    }
    
    public void procesarBtnAntP2ActionPerformed(){
        miVista.setVisible(1,0,0);
        miVista.setNoVisible(0,1,1);
    }
            
    
    public void procesarRadioBtnRenfeActionPerformed(){
        resetTodo();    
        miVista.setVisibilidadLbError4(false);
        if(miVista.getRadioButtonCredito()){
            miVista.setRadioButtonCredito(false);
        }
        miVista.setRadioButtonRenfe(true);
        miVista.setVisibilidadLbTarjetaRenfe(true);
        miVista.setVisibilidadLbMantenerRenfe(true);
        miVista.setVisibilidadLbTarjetaCredito(false);
        miVista.setVisibilidadLbMantenerCredito(false);
        miVista.setVisibilidadLbPin(false);
        miVista.setVisibilidadPin(false);
        miVista.setVisibilidadButtonPin(false);
    }
    
    public void procesarRadioBtnCreditoActionPerformed(){
        resetTodo();
        miVista.setVisibilidadLbError4(false);
        if(miVista.getRadioButtonRenfe()){
              miVista.setRadioButtonRenfe(false);
        }
        miVista.setRadioButtonCredito(true);
        miVista.setVisibilidadLbTarjetaRenfe(false);
        miVista.setVisibilidadLbMantenerRenfe(false);
        miVista.setVisibilidadLbTarjetaCredito(true);
        miVista.setVisibilidadLbMantenerCredito(true);
        miVista.setVisibilidadLbPin(true);
        miVista.setVisibilidadPin(true);
        miVista.setVisibilidadButtonPin(true);
    }
    
    public void procesarBtnAntP3ActionPerformed(){
        miVista.setVisible(0,1,0);
        miVista.setNoVisible(1,0,1);
    }
    
    public void procesarBtnIntercambioActionPerformed(){
        int origen = miVista.getIndexOrigen();
        int destino = miVista.getIndexDestino();
        miVista.setIndexDestino(origen);
        miVista.setIndexOrigen(destino);
    }
    
    public void procesarBtnPinActionPerformed(){
         if(comprobarPagoCredito(miVista.getPin())){   //Se ha pagado con tarjeta de crédito y el PIN es correcto
            miVista.setVisibilidadLbError4(false);
            miVista.setVisibilidadPagoCorrecto(true);
            meterBilleteHistorial();
        }
        else{
            miVista.setPinText("");
            miVista.setTextoLbError4("Error al procesar el pago");
            miVista.setVisibilidadLbError4(true);
        }
    }
    
    public void procesarBtnBilleteActionPerformed(){
        miVista.resetTodo();
        miVista.setVisible(1,0,0);
        miVista.setNoVisible(0,1,1);
        miVista.disponerPagoCorrecto();
    }
    
    public void procesarBtnSalirActionPerformed(){
        System.exit(0);
    }
    
}
