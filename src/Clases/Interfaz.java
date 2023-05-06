package Clases;

import Conexiones.Conexion;
import Select.Inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Toolkit;


public class Interfaz extends javax.swing.JFrame {
    
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Timer timer;
Connection con = null;
Conexion conect = new Conexion();

    public Interfaz() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/Iconos/tacoico.png")));
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        setTitle("Jorge's Tacos APP");
        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MARCH) + 1) + "/" + cal.get(Calendar.YEAR);
        this.JLB_Fecha1.setText(fecha);
    }

    
    public class cronometro implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            GregorianCalendar tiempo = new GregorianCalendar();
            int hora,minutos,segundos;
            hora=tiempo.get(Calendar.HOUR);
            minutos=tiempo.get(Calendar.MINUTE);
            segundos=tiempo.get(Calendar.SECOND);
            txtHora1.setText(String.valueOf(hora));
            txtMinutos1.setText(String.valueOf(minutos));
            txtSegundos1.setText(String.valueOf(segundos));
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("deprecation")
	private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane1.setBackground(new Color(255, 128, 64));
        txtHora1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMinutos1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSegundos1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setBackground(new Color(128, 64, 0));
        JLB_Fecha1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtHora1.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        txtHora1.setForeground(new java.awt.Color(255, 255, 255));
        txtHora1.setText("00");

        jLabel6.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":");

        txtMinutos1.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        txtMinutos1.setForeground(new java.awt.Color(255, 255, 255));
        txtMinutos1.setText("00");

        jLabel7.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(":");

        txtSegundos1.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        txtSegundos1.setForeground(new java.awt.Color(255, 255, 255));
        txtSegundos1.setText("00");

        jLabel8.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HORA:");

        jLabel9.setFont(new Font("Dialog", Font.BOLD, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FECHA:");

        JLB_Fecha1.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        JLB_Fecha1.setForeground(new java.awt.Color(255, 255, 255));
        JLB_Fecha1.setText("00/00/00");
        
        JButton BMenu = new JButton("Menu");
        BMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Inicio().setVisible(true);
        		setVisible(false);
        	}
        });
        BMenu.setFont(new Font("Tahoma", Font.BOLD, 12));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1Layout.setHorizontalGroup(
        	jDesktopPane1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jDesktopPane1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jDesktopPane1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jDesktopPane1Layout.createSequentialGroup()
        					.addComponent(jLabel9)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(JLB_Fecha1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
        					.addComponent(jLabel8)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtHora1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel6)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtMinutos1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel7)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtSegundos1)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
        					.addComponent(BMenu, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        					.addGap(21))))
        );
        jDesktopPane1Layout.setVerticalGroup(
        	jDesktopPane1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jDesktopPane1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(BMenu)
        			.addPreferredGap(ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
        			.addGroup(jDesktopPane1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel8)
        				.addGroup(jDesktopPane1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(txtHora1)
        					.addComponent(jLabel6)
        					.addComponent(txtMinutos1)
        					.addComponent(jLabel7)
        					.addComponent(txtSegundos1))
        				.addComponent(JLB_Fecha1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1.setLayer(txtHora1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtMinutos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtSegundos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(JLB_Fecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logotype192.png"))); // NOI18N
        jMenu1.setText("INICIO");
        jMenu1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/wifi.png"))); // NOI18N
        jMenuItem1.setText("PROBAR CONEXION");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/emergency-exit.png"))); // NOI18N
        jMenuItem2.setText("SALIR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/bill9.png"))); // NOI18N
        jMenu2.setText("INVENTARIO");
        jMenu2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/group.png"))); // NOI18N
        jMenuItem7.setText("PROVEEDORES");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/scanning-barcode.png"))); // NOI18N
        jMenuItem3.setText("INGRESAR");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/barcode.png"))); // NOI18N
        jMenuItem4.setText("BUSCAR");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/carpeta.png"))); // NOI18N
        jMenuItem8.setText("USO DE MATERIAL");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        
       
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Proveedor obj = new Proveedor();
        jDesktopPane1.add(obj);
        obj.toFront();
        obj.setLocation(jDesktopPane1.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane1.getHeight() / 2 - obj.getHeight() / 2);
        try {
        obj.setMaximum(true); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Registrar obj = new Registrar();
        jDesktopPane1.add(obj);
        obj.toFront();
        obj.setLocation(jDesktopPane1.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane1.getHeight() / 2 - obj.getHeight() / 2);
        try {
        obj.setMaximum(true); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Buscar obj = new Buscar();
        jDesktopPane1.add(obj);
        obj.toFront();
        obj.setLocation(jDesktopPane1.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane1.getHeight() / 2 - obj.getHeight() / 2);
        try {
        obj.setMaximum(true); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Usar obj = new Usar();
        jDesktopPane1.add(obj);
        obj.toFront();
        obj.setLocation(jDesktopPane1.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane1.getHeight() / 2 - obj.getHeight() / 2);
        try {
        obj.setMaximum(true); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        con = conect.getConnection();
        JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "CONEXION TERMINADA");
        Conexion obj = new Conexion();
        obj.Desconexion();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        timer=new Timer(1000,new cronometro());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLB_Fecha1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JLabel txtHora1;
    private javax.swing.JLabel txtMinutos1;
    private javax.swing.JLabel txtSegundos1;
}
