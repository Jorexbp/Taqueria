package Clases;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Buscar extends javax.swing.JInternalFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
DefaultTableModel model = new DefaultTableModel();  
Statement st = null;
ResultSet rs = null;
Connection con2 = null;

    public Buscar() {
        initComponents();
        vaciarTabla();
        verDatos();
    }
    
    public void vaciarTabla(){
        String titulos[] = {"ID", "NO_CATALOGO", "MARCA", "MODELO", "NOMBRE", "DESCRIPCION", "CANTIDAD", "UBICACION", "ID_PROVEEDOR", "NOMBRE_PROVEEDOR", "CODIGO", "URL"};
        model = new DefaultTableModel(null,titulos);
        JT_TablaHistorial.setModel(model);
    }
    
    public void verDatos(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) JT_TablaHistorial.getModel();
            Conexion conect1 = new Conexion();
            con1 = conect1.getConnection();
            String dts[] = new String[12];
            String sql = "select * from registro";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dts[0] = rs.getString("Id_inventario");
                dts[1] = rs.getString("no_catalogo");
                dts[2] = rs.getString("marca");
                dts[3] = rs.getString("modelo");
                dts[4] = rs.getString("nombre");
                dts[5] = rs.getString("descripcion");               
                dts[6] = rs.getString("cantidad");
                dts[7] = rs.getString("ubicacion");
                dts[8] = rs.getString("Id_proveedores");
                dts[9] = rs.getString("nombre_proveedor");
                dts[10] = rs.getString("codigo");
                dts[11] = rs.getString("url");
                miModelo.addRow(dts);
            }
            JT_TablaHistorial.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_TablaHistorial = new javax.swing.JTable();
        buscartodo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JT_TablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NO_CATALOGO", "MARCA", "MODELO", "NOMBRE", "DESCRIPCION", "CANTIDAD", "UBICACION", "ID_PROVEEDOR", "NOMBRE_PROVEEDOR", "CODIGO", "URL"
            }
        ));
        jScrollPane1.setViewportView(JT_TablaHistorial);

        buscartodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscartodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel1.setText("INGRESE CODIGO");

        jLabel2.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUSCAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        String[] titulos = {"ID", "NO_CATALOGO" , "MARCA", "MODELO", "NOMBRE", "DESCRIPCION", "CANTIDAD", "UBICACION","ID_PROVEEDOR", "NOMBRE_PROVEEDOR", "CODIGO", "URL"};
        String[] registros = new String[100];
        String sql = "SELECT * FROM registro WHERE codigo LIKE '%" + buscartodo.getText() + "%'";
        model = new DefaultTableModel(null, titulos);
        Conexion conect1 = new Conexion();
        con2 = conect1.getConnection();
        try
        {
            st = (Statement) con2.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                registros[0] = rs.getString("id_inventario");
                registros[1] = rs.getString("no_catalogo");
                registros[2] = rs.getString("marca");
                registros[3] = rs.getString("modelo");
                registros[4] = rs.getString("nombre");
                registros[5] = rs.getString("descripcion");
                registros[6] = rs.getString("cantidad");
                registros[7] = rs.getString("ubicacion");
                registros[8] = rs.getString("id_proveedores");
                registros[9] = rs.getString("nombre_proveedor");
                registros[10] = rs.getString("codigo");
                registros[11] = rs.getString("url");
                model.addRow(registros);
            }
            JT_TablaHistorial.setModel(model);
        } catch (SQLException ex)
        {
            System.out.println("ERROR AL BUSCAR LOS DATOS : " + ex.getMessage());
        }
    }//GEN-LAST:event_buscartodoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JT_TablaHistorial;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
