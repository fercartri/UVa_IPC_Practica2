package uva.ipc.practica2.vista;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * Clase para la interfaz gráfica de la vista de mis viajes
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class VistaMisViajes extends javax.swing.JFrame {
    private final ControladorMisViajes miControlador;
    
    /**
     * Crea la nueva vista de mis viajes
     */
    public VistaMisViajes() {
        initComponents();
        miControlador = new ControladorMisViajes(this);
        cargarHistorial();      
    }
    
    public void cargarHistorial(){
        ArrayList<String> aux = new ArrayList<>();
        
        listaAntiguos.removeAll();
        aux = miControlador.cargarViajesAntiguos();
        String[] add = new String[aux.size()];
        for(int i = 0; i < add.length; i++){
            add[i] = aux.get(i);
        }
        
        listaAntiguos.setListData(add);
        
        listaFuturos.removeAll();
        aux = miControlador.cargarViajesFuturos();
        add = new String[aux.size()];
        for(int i = 0; i < add.length; i++){
            add[i] = aux.get(i);
        }
        
        listaFuturos.setListData(add);
    }
    
    public String billeteSeleccionado(){
        return listaFuturos.getSelectedValue();
    }
    
    public void setErrorNoBillete(){
        lbError.setText("Debe seleccionar un billete");
    }
    
    public void resetError(){
        lbError.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlobal = new javax.swing.JPanel();
        pnlListas = new javax.swing.JPanel();
        pnlListaAtiguos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAntiguos = new javax.swing.JList<>();
        pnlListaFuturos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaFuturos = new javax.swing.JList<>();
        pnlError = new javax.swing.JPanel();
        lbError = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        lblViajes = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        pnlBtnModificar = new javax.swing.JPanel();
        btnDevolver = new javax.swing.JButton();
        btnEquipaje = new javax.swing.JButton();
        pnlBtnVolver = new javax.swing.JPanel();
        btnVolver = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tren Castilla y León");

        panelGlobal.setBackground(new java.awt.Color(233, 255, 255));
        panelGlobal.setLayout(new java.awt.BorderLayout());

        pnlListas.setBackground(new java.awt.Color(233, 255, 255));
        pnlListas.setMinimumSize(new java.awt.Dimension(400, 100));
        pnlListas.setPreferredSize(new java.awt.Dimension(400, 100));
        pnlListas.setLayout(new java.awt.GridLayout(2, 1));

        pnlListaAtiguos.setBackground(new java.awt.Color(233, 255, 255));
        pnlListaAtiguos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlListaAtiguosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(94, 145, 136));
        jLabel1.setText("BILLETES ANTIGUOS:");
        pnlListaAtiguos.add(jLabel1);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 80));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 150));

        listaAntiguos.setBackground(new java.awt.Color(204, 255, 255));
        listaAntiguos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAntiguos.setToolTipText("");
        jScrollPane1.setViewportView(listaAntiguos);

        pnlListaAtiguos.add(jScrollPane1);

        pnlListas.add(pnlListaAtiguos);

        pnlListaFuturos.setBackground(new java.awt.Color(233, 255, 255));
        pnlListaFuturos.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBackground(new java.awt.Color(233, 255, 255));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(94, 145, 136));
        jLabel2.setText("BILLETES FUTUROS:");
        jPanel1.add(jLabel2);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 80));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(450, 150));

        listaFuturos.setBackground(new java.awt.Color(204, 255, 255));
        listaFuturos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaFuturos.setToolTipText("");
        jScrollPane3.setViewportView(listaFuturos);

        jPanel1.add(jScrollPane3);

        pnlListaFuturos.add(jPanel1);

        pnlError.setBackground(new java.awt.Color(233, 255, 255));

        lbError.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlErrorLayout = new javax.swing.GroupLayout(pnlError);
        pnlError.setLayout(pnlErrorLayout);
        pnlErrorLayout.setHorizontalGroup(
            pnlErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
            .addGroup(pnlErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlErrorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbError)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlErrorLayout.setVerticalGroup(
            pnlErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(pnlErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlErrorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbError)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlListaFuturos.add(pnlError);

        pnlListas.add(pnlListaFuturos);

        panelGlobal.add(pnlListas, java.awt.BorderLayout.CENTER);

        pnlTitulo.setBackground(new java.awt.Color(233, 255, 255));
        pnlTitulo.setMinimumSize(new java.awt.Dimension(400, 100));

        lblViajes.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblViajes.setForeground(new java.awt.Color(94, 145, 136));
        lblViajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViajes.setText("MIS VIAJES");
        pnlTitulo.add(lblViajes);

        panelGlobal.add(pnlTitulo, java.awt.BorderLayout.PAGE_START);

        pnlButtons.setBackground(new java.awt.Color(233, 255, 255));
        pnlButtons.setMinimumSize(new java.awt.Dimension(400, 100));
        pnlButtons.setLayout(new java.awt.GridLayout(2, 0, 0, 15));

        pnlBtnModificar.setBackground(new java.awt.Color(233, 255, 255));
        pnlBtnModificar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        btnDevolver.setBackground(new java.awt.Color(94, 145, 136));
        btnDevolver.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolver.setText("DEVOLVER BILLETE");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        pnlBtnModificar.add(btnDevolver);

        btnEquipaje.setBackground(new java.awt.Color(94, 145, 136));
        btnEquipaje.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnEquipaje.setForeground(new java.awt.Color(255, 255, 255));
        btnEquipaje.setText("MODIFICAR BILLETE");
        btnEquipaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipajeActionPerformed(evt);
            }
        });
        pnlBtnModificar.add(btnEquipaje);

        pnlButtons.add(pnlBtnModificar);

        pnlBtnVolver.setBackground(new java.awt.Color(233, 255, 255));

        btnVolver.setBackground(new java.awt.Color(94, 145, 136));
        btnVolver.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlBtnVolver.add(btnVolver);

        pnlButtons.add(pnlBtnVolver);

        panelGlobal.add(pnlButtons, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGlobal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Eventos-----------------------------------------------------------------------------
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        miControlador.procesarBtnVolver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void pnlListaAtiguosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlListaAtiguosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlListaAtiguosAncestorAdded

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        miControlador.procesarDevolver();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnEquipajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipajeActionPerformed
        miControlador.procesarModificar();
    }//GEN-LAST:event_btnEquipajeActionPerformed
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEquipaje;
    private javax.swing.JToggleButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lblViajes;
    private javax.swing.JList<String> listaAntiguos;
    private javax.swing.JList<String> listaFuturos;
    private javax.swing.JPanel panelGlobal;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlBtnVolver;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlError;
    private javax.swing.JPanel pnlListaAtiguos;
    private javax.swing.JPanel pnlListaFuturos;
    private javax.swing.JPanel pnlListas;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
