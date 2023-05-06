package Clientes;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pedidos extends JFrame {
	//Dos atributos para poder conectarme a mi BBDD
	Connection conexion;
	Statement sentencia;
	//Est constructor me conecta
	public void conectatarBaseDatos() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Linea que carga el driver
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver");
        }
        try {//Este url es el q me dice donde esta la BBDD 
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\itacadam\\Desktop\\Clientes.accdb");} catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Error en la direcci�n de la base de datos");
  }
  try {
      sentencia = conexion.createStatement();
  } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Error al crear la conexi�n con la base de datos");
  }
}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pedidos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				//Esto para que al final se cierre la conexion con BBDD
				   try {
				            sentencia.close();
				        } catch (SQLException e1) {
				            JOptionPane.showMessageDialog(null, "Error al cerrar la base de datos" + e1);
				        }
			}
		});
		
		conectatarBaseDatos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
