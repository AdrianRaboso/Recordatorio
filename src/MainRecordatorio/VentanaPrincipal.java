package MainRecordatorio;

import java.awt.Frame;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author Adrián
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Frame ventana = this;
    private ImageIcon icono ;
    private TrayIcon trayIcon;
    private SystemTray sysTray;
    private int secondsPassed = 0;
    private int minutesPassed = 0;
    private Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            aumentarTiempo();

            if (minutesPassed >= sliderCantidadTiempo.getValue()) {
                sysTray.remove(trayIcon);
                ventana.setVisible(true);
                timer.stop();
                JOptionPane.showMessageDialog(ventana, JTextFieldObjetivoDiario.getText());
                jLabelEtiquetaTiempo.setText("00:00");
                minutesPassed = 0;
                secondsPassed = 0;
            }
        }
    });

    public VentanaPrincipal() {
        initComponents();
        icono = new ImageIcon(this.getClass().getResource("/Recursos/wait.png"));
        setIconImage(icono.getImage());
        setLocationRelativeTo(null);
        instanciarTray();
    }

    public void aumentarTiempo() {
        if (secondsPassed < 60) {
            secondsPassed++;
            ponerHoraLabel();
        } else {
            secondsPassed = 0;
            minutesPassed++;
            ponerHoraLabel();
        }
    }

    public void ponerHoraLabel() {
        if (minutesPassed < 10) {
            if (secondsPassed < 10) {
                jLabelEtiquetaTiempo.setText("0"+minutesPassed + ":0" + secondsPassed);
            } else {
                jLabelEtiquetaTiempo.setText("0"+minutesPassed + ":" + secondsPassed);
            }
        } else {
            if (secondsPassed < 10) {
                jLabelEtiquetaTiempo.setText(minutesPassed + ":0" + secondsPassed);
            } else {
                jLabelEtiquetaTiempo.setText(minutesPassed + ":" + secondsPassed);
            }
        }
    }

    public void instanciarTray() {
        trayIcon = new TrayIcon(icono.getImage(), JTextFieldObjetivoDiario.getText(), this.popup);
        trayIcon.setImageAutoSize(true);
        sysTray = SystemTray.getSystemTray();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new java.awt.PopupMenu();
        menuItem1 = new java.awt.MenuItem();
        sliderCantidadTiempo = new javax.swing.JSlider();
        jButtonEmpezar = new javax.swing.JButton();
        JTextFieldObjetivoDiario = new javax.swing.JTextField();
        jLabelEtiquetaTiempo = new javax.swing.JLabel();
        jButtonOcultar = new javax.swing.JButton();

        popup.setLabel("popupMenu1");
        popup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupActionPerformed(evt);
            }
        });

        menuItem1.setLabel("Abrir");
        popup.add(menuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recordatorio");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        sliderCantidadTiempo.setMajorTickSpacing(5);
        sliderCantidadTiempo.setMaximum(30);
        sliderCantidadTiempo.setPaintLabels(true);
        sliderCantidadTiempo.setPaintTicks(true);
        sliderCantidadTiempo.setSnapToTicks(true);
        sliderCantidadTiempo.setValue(15);
        sliderCantidadTiempo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sliderCantidadTiempo.setName(""); // NOI18N

        jButtonEmpezar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jButtonEmpezar.setText("Empezar!");
        jButtonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpezarActionPerformed(evt);
            }
        });

        JTextFieldObjetivoDiario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTextFieldObjetivoDiario.setText("Escribe tu objetivo diario...");
        JTextFieldObjetivoDiario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTextFieldObjetivoDiarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextFieldObjetivoDiarioFocusLost(evt);
            }
        });

        jLabelEtiquetaTiempo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEtiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEtiquetaTiempo.setText("00:00");

        jButtonOcultar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jButtonOcultar.setText("Ocultar");
        jButtonOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOcultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderCantidadTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JTextFieldObjetivoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelEtiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEtiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JTextFieldObjetivoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderCantidadTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTextFieldObjetivoDiarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextFieldObjetivoDiarioFocusGained
        if (this.JTextFieldObjetivoDiario.getText().startsWith("Escribe")) {
            this.JTextFieldObjetivoDiario.setText("");
        }
    }//GEN-LAST:event_JTextFieldObjetivoDiarioFocusGained

    private void JTextFieldObjetivoDiarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextFieldObjetivoDiarioFocusLost
        if (this.JTextFieldObjetivoDiario.getText().equals("")) {
            this.JTextFieldObjetivoDiario.setText("Escribe tu objetivo diario...");
        }
    }//GEN-LAST:event_JTextFieldObjetivoDiarioFocusLost

    private void jButtonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpezarActionPerformed
        if (!JTextFieldObjetivoDiario.getText().startsWith("Escribe")) {
            try {
                timer.start();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonEmpezarActionPerformed

    private void popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupActionPerformed
        sysTray.remove(trayIcon);
        this.setVisible(true);
    }//GEN-LAST:event_popupActionPerformed

    private void jButtonOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOcultarActionPerformed
        try {
            if (SystemTray.isSupported()) {
                sysTray.add(trayIcon);
                this.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonOcultarActionPerformed

    public static void main(String args[]) {
        /* Set the Windows 7 look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldObjetivoDiario;
    private javax.swing.JButton jButtonEmpezar;
    private javax.swing.JButton jButtonOcultar;
    private javax.swing.JLabel jLabelEtiquetaTiempo;
    private java.awt.MenuItem menuItem1;
    private java.awt.PopupMenu popup;
    private javax.swing.JSlider sliderCantidadTiempo;
    // End of variables declaration//GEN-END:variables
}
