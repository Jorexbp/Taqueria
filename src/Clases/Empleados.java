package Clases;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import Conexiones.Conexion_Clientes;
import Select.Image;
import Select.Inicio;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;

public class Empleados extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DefaultTableModel tabla = new DefaultTableModel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int Fila, int Colum) {
			return false;
		}
	};

	private Image contentPane;
	private JTable Jtable;
	Connection con1;
	Statement st;
	private JScrollPane scrollPane;
	private JTextField teliminar;
	private JButton bBuscar;
	private JTextField tBuscar;
	private JLabel lbuscar;
	private JButton bAnadir;
	private JLabel bAnadir_Nom;
	private JLabel lanadir;
	private JTextField tNombre;
	private JLabel bAnadir_Ped;
	private JButton GRegistro;
	private JButton bVolver;
	private JTextField TPedido;
	private JButton BMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados frame = new Empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 

private void nuevoRegistro() {

	
		if (tNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE", "Advertencia", JOptionPane.WARNING_MESSAGE);
		} else if (TPedido.equals("")) {
			JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				Connection con = null;
				Conexion_Clientes conect = new Conexion_Clientes();
				con = conect.getConnection();
				
				String sql = "insert into Pedidos (Nombre_Usuario,Pedido) values (?,?)";
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setString(1, tNombre.getText());
				pst.setString(2,TPedido.getText());
				
			
				int n = pst.executeUpdate();
				if (n > 0) {
					JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE");

				}
			} catch (SQLException | HeadlessException e) {
				JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE"+e, "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void buscarRegistro(int busca) {

		try {
			
			String tit[] = { "ID_Pedido", "Nombre_Usuario", "Pedido" };
			String reg[] = new String[100];// Solo me mostrara los 100 primero regisytos
			String sql = "select * from Pedidos where ID_Pedido =" + busca;
			tabla = new DefaultTableModel(null, tit);
			Connection con = null;
			Conexion_Clientes conect = new Conexion_Clientes();// Lo conecto a mi conexion de clientes
			con = conect.getConnection();

			// Le concateno el valor q quiero 


			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				reg[0] = rs.getString("ID_Pedido");
				reg[1] = rs.getString("Nombre_Usuario");
				reg[2] = rs.getString("Pedido");
				tabla.addRow(reg);// Hago q se me muestren solo estos campos
				// Ya funciona
			}
			Jtable.setModel(tabla);// Y aqui se munestran
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void eliminarPedido(int eliminar) {// Con esto pillo el id del pedido que se quiere eliminar
		// POR FIN FUNCIONA JODER
		int opc = JOptionPane.showConfirmDialog(this, "�ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == JOptionPane.YES_OPTION) {
			try {
				Connection con = null;
				Conexion_Clientes conect = new Conexion_Clientes();// Lo conecto a mi conexion de clientes
				con = conect.getConnection();
				con.createStatement();
				String sql = "delete from Pedidos where ID_Pedido = " + eliminar;// Le concateno el valor q quiero
																					// eliminar
				PreparedStatement pst = con.prepareStatement(sql);// Ejecuto query

				int n = pst.executeUpdate();
				if (n > 0) {
					JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
			}
		}

	}


	public void cargarTitulosColumas() {
		tabla.addColumn("ID_Pedido");
		tabla.addColumn("Nombre_Usuario");
		tabla.addColumn("Pedido");
		this.Jtable.setModel(tabla);
	}

	/**
	 * Create the frame.
	 */
	public Empleados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Empleados.class.getResource("/Iconos/tacoico.png")));
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 UIManager.put( "Button.arc", 999 );
		 UIManager.put( "Component.arc", 999 );
		 UIManager.put( "ProgressBar.arc", 999 );
		 UIManager.put( "TextComponent.arc", 999 );
		 UIManager.put( "Component.innerFocusWidth", 1 );
		 UIManager.put( "Button.innerFocusWidth", 1 );

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
cargarCombo();
			}

			private void cargarCombo() {
				

					try {
						
						String tit[] = { "ID_Pedido", "Nombre_Usuario", "Pedido" };
						String reg[] = new String[100];// Solo me mostrara los 100 primero regisytos
						String sql = "select * from Pedidos";
						tabla = new DefaultTableModel(null, tit);
						Connection con = null;
						Conexion_Clientes conect = new Conexion_Clientes();// Lo conecto a mi conexion de clientes
						con = conect.getConnection();

						// Le concateno el valor q quiero eliminar

						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sql);

						while (rs.next()) {

							reg[0] = rs.getString("ID_Pedido");
							reg[1] = rs.getString("Nombre_Usuario");
							reg[2] = rs.getString("Pedido");
							tabla.addRow(reg);// Hago q se me muestren solo estos campos
							// Ya funciona
						}
						Jtable.setModel(tabla);// Y aqui se munestran
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		
		contentPane = new Image("/Iconos/fondo.jpg", 450, 365);
		contentPane.setOpaque(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 129, 301, 104);
		contentPane.add(scrollPane);

		Jtable = new JTable();
		Jtable.setFont(new Font("Dialog", Font.BOLD, 11));
		
		cargarTitulosColumas();

		scrollPane.setViewportView(Jtable);

		JButton JEliminar = new JButton("Eliminar:");
		JEliminar.setFont(new Font("Dialog", Font.BOLD, 11));
		JEliminar.setBounds(228, 95, 89, 23);
		JEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!teliminar.getText().isBlank()){
					int eliminar = Integer.parseInt(teliminar.getText());
					
					eliminarPedido(eliminar);
					new Empleados().setVisible(true);
					setVisible(false);
					teliminar.setText(null);
				}else {
					JOptionPane.showMessageDialog(null,"No ha ingresado ningun pedido");
				}
				
			}

		});
		contentPane.add(JEliminar);

		new JTextField();
		
		teliminar = new JTextField();
		teliminar.setBounds(338, 96, 86, 20);
		contentPane.add(teliminar);
		teliminar.setColumns(10);

	
		JLabel leliminar = new JLabel("Introduce ID:");
		leliminar.setFont(new Font("Dialog", Font.BOLD, 11));
		leliminar.setBounds(349, 62, 75, 23);
		contentPane.add(leliminar);

		bBuscar = new JButton("Buscar:");
		bBuscar.setFont(new Font("Dialog", Font.BOLD, 11));
		bBuscar.setBounds(23, 95, 89, 23);
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tBuscar.getText().isEmpty()) {
					new Empleados().setVisible(true);
					setVisible(false);
				}else {
				int busca = Integer.parseInt(tBuscar.getText());
				
				buscarRegistro(busca);
				tBuscar.setText(null);
				}
				}

		});
		contentPane.add(bBuscar);

		tBuscar = new JTextField();
		tBuscar.setBounds(122, 96, 86, 20);
		contentPane.add(tBuscar);
		tBuscar.setColumns(10);

		lbuscar = new JLabel("Introduce el id del pedido:");
		lbuscar.setFont(new Font("Dialog", Font.BOLD, 11));
		lbuscar.setBounds(23, 64, 185, 18);
		lbuscar.setVisible(false);
		contentPane.add(lbuscar);

		bAnadir = new JButton("Anadir registro\r\n ");
		bAnadir.setFont(new Font("Dialog", Font.BOLD, 11));
		bAnadir.setBounds(296, 10, 130, 58);
		bAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TPedido.setVisible(true);
				bVolver.setVisible(true);
				JEliminar.setVisible(false);
				teliminar.setVisible(false);
				leliminar.setVisible(false);
				bBuscar.setVisible(false);
				tBuscar.setVisible(false);
				lbuscar.setVisible(false);
				bAnadir.setVisible(false);
				lanadir.setVisible(false);
				tNombre.setVisible(true);
				bAnadir_Ped.setVisible(true);
				
				bAnadir_Nom.setVisible(true);
				GRegistro.setVisible(true);
//				JOptionPane.showMessageDialog(null, "PEDIDO A�ADIDO CON EXITO");
			}
		});
		contentPane.add(bAnadir);

		bAnadir_Nom = new JLabel("Nombre Cliente:");
		bAnadir_Nom.setFont(new Font("Dialog", Font.BOLD, 11));
		bAnadir_Nom.setBounds(24, 24, 113, 29);
		bAnadir_Nom.setVisible(false);
		contentPane.add(bAnadir_Nom);

		lanadir = new JLabel("MANUAL:");
		lanadir.setBounds(228, 32, 75, 14);
		lanadir.setFont(new Font("Dialog", Font.BOLD, 12));
		lanadir.setForeground(new Color(255, 0, 0));
		contentPane.add(lanadir);

		tNombre = new JTextField();
		tNombre.setBounds(147, 28, 86, 20);
		tNombre.setVisible(false);
		contentPane.add(tNombre);
		tNombre.setColumns(10);

		bAnadir_Ped = new JLabel("Pedido del cliente:");
		bAnadir_Ped.setFont(new Font("Dialog", Font.BOLD, 11));
		bAnadir_Ped.setBounds(23, 66, 114, 29);
		bAnadir_Ped.setVisible(false);
		contentPane.add(bAnadir_Ped);

		GRegistro = new JButton("Guardar ");
		GRegistro.setFont(new Font("Dialog", Font.BOLD, 11));
		GRegistro.setBounds(345, 161, 89, 23);
		GRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				nuevoRegistro();
				
			
			 new Empleados().setVisible(true);
				
				setVisible(false);
				
			
			}
		});
		GRegistro.setVisible(false);
		contentPane.add(GRegistro);

		bVolver = new JButton("Volver");
		bVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		bVolver.setBounds(0, 238, 89, 23);
		bVolver.setVisible(false);
		bVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TPedido.setVisible(false);
				bVolver.setVisible(false);
				JEliminar.setVisible(true);
				teliminar.setVisible(true);
				leliminar.setVisible(true);
				bBuscar.setVisible(true);
				tBuscar.setVisible(true);
				lbuscar.setVisible(true);
				bAnadir.setVisible(true);
				lanadir.setVisible(true);
				tNombre.setVisible(false);
				bAnadir_Ped.setVisible(false);
	
				bAnadir_Nom.setVisible(false);
				GRegistro.setVisible(false);
				

			}
		});
		contentPane.add(bVolver);
		
		TPedido = new JTextField();
		TPedido.setVisible(false);
		TPedido.setBounds(147, 70, 96, 20);
		contentPane.add(TPedido);
		TPedido.setColumns(10);
		
		BMenu = new JButton("Menu");
		BMenu.setFont(new Font("Dialog", Font.BOLD, 11));
		BMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inicio().setVisible(true);
				setVisible(false);
			}
		});
		BMenu.setBounds(338, 238, 89, 23);
		contentPane.add(BMenu);
	}
}
