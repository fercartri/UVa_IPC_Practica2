package uva.ipc.practica2.vista;

/**
 * Clase para la interfaz gráfica de la vista de menu usuario
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class VistaMenuUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenuUsuario
     */
    public VistaMenuUsuario() {
        initComponents();
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
        pnlTextos = new javax.swing.JPanel();
        lbSaldo = new javax.swing.JLabel();
        lbNumBilletes = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        pnlBtnSup = new javax.swing.JPanel();
        btnRecargar = new javax.swing.JButton();
        btnMisViajes = new javax.swing.JButton();
        pnlBtnInf = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlobal.setBackground(new java.awt.Color(233, 255, 255));
        panelGlobal.setLayout(new java.awt.BorderLayout(15, 15));

        pnlTextos.setBackground(new java.awt.Color(233, 255, 255));
        pnlTextos.setLayout(new java.awt.GridLayout(2, 1, 0, 15));

        lbSaldo.setBackground(new java.awt.Color(233, 255, 255));
        lbSaldo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lbSaldo.setForeground(new java.awt.Color(94, 145, 136));
        lbSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSaldo.setText("SALDO DE LA TARJETA: X€");
        pnlTextos.add(lbSaldo);

        lbNumBilletes.setBackground(new java.awt.Color(233, 255, 255));
        lbNumBilletes.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lbNumBilletes.setForeground(new java.awt.Color(94, 145, 136));
        lbNumBilletes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumBilletes.setText("NÚMERO DE BILLETES COMPRADOS: XX");
        pnlTextos.add(lbNumBilletes);

        panelGlobal.add(pnlTextos, java.awt.BorderLayout.PAGE_START);

        pnlBotones.setBackground(new java.awt.Color(233, 255, 255));
        pnlBotones.setLayout(new java.awt.GridLayout(2, 0));

        pnlBtnSup.setBackground(new java.awt.Color(233, 255, 255));

        btnRecargar.setBackground(new java.awt.Color(94, 145, 136));
        btnRecargar.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnRecargar.setForeground(new java.awt.Color(255, 255, 255));
        btnRecargar.setText("RECARGAR TARJETA");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });
        pnlBtnSup.add(btnRecargar);

        btnMisViajes.setBackground(new java.awt.Color(94, 145, 136));
        btnMisViajes.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnMisViajes.setForeground(new java.awt.Color(255, 255, 255));
        btnMisViajes.setText("MIS VIAJES");
        pnlBtnSup.add(btnMisViajes);

        pnlBotones.add(pnlBtnSup);

        pnlBtnInf.setBackground(new java.awt.Color(233, 255, 255));

        btnVolver.setBackground(new java.awt.Color(94, 145, 136));
        btnVolver.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnInfLayout = new javax.swing.GroupLayout(pnlBtnInf);
        pnlBtnInf.setLayout(pnlBtnInfLayout);
        pnlBtnInfLayout.setHorizontalGroup(
            pnlBtnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
            .addGroup(pnlBtnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBtnInfLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnVolver)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlBtnInfLayout.setVerticalGroup(
            pnlBtnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
            .addGroup(pnlBtnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBtnInfLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnVolver)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlBotones.add(pnlBtnInf);

        panelGlobal.add(pnlBotones, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMisViajes;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lbNumBilletes;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JPanel panelGlobal;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlBtnInf;
    private javax.swing.JPanel pnlBtnSup;
    private javax.swing.JPanel pnlTextos;
    // End of variables declaration//GEN-END:variables
}
