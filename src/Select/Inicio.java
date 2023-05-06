package Select;

import javax.swing.*;

import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLightLaf;

import Clases.Empleados;
import Clases.Interfaz;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Inicio extends JFrame {
	private Image bg;
	private JProgressBar pb;
	private int n;
	private JLabel lblcarga;
	private JLabel lblNombre;
	private JLabel lbluser;
	private JLabel lblcontrasena;
	private JTextField tfuser;
	private JPasswordField tfpass;
	private JButton bentrar;
	private int intentos = 3;
	private JLabel opc;
	private JButton volver;
	private JToggleButton sel_admin;
	private JToggleButton sel_cliente;
//CONSTRUCTORES AQUI:

	//
	//
	//
	private void volverINIC() {
		bentrar.setVisible(false);
		lblcontrasena.setVisible(false);
		lbluser.setVisible(false);
		tfuser.setVisible(false);
		tfpass.setVisible(false);
		pb.setVisible(false);
		lblcarga.setVisible(false);
		timerEMPLEADOS.stop();
		
		opc.setVisible(false);
		sel_admin.setVisible(true);
		sel_cliente.setVisible(true);
		
		opc.setVisible(true);
		volver.setVisible(false);
	}

	private void adminSEL() {
		volver.setVisible(true);
		sel_admin.setVisible(false);
		sel_cliente.setVisible(false);
	
		opc.setVisible(false);
		timerEMPLEADOS.start();

	}

	private void clienteSEL() {
		volver.setVisible(true);
		sel_admin.setVisible(false);
		sel_cliente.setVisible(false);

		opc.setVisible(false);
		timerCLIENTES.start();

	}

	private void contraUsur(char[] input) {
		String contraIN = "";
		String nombreIN = tfuser.getText();

		for (int i = 0; i < input.length; i++) {
			contraIN += input[i];
		}

		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Jorge");
		nombres.add("Luna");
		nombres.add("Pepe");
		ArrayList<String> output = new ArrayList<String>();
		output.add("admin");
		output.add("tacos");
		output.add("tiger");
		if (intentos <= 0) {
			JOptionPane.showMessageDialog(null, "Se ha quedado sin intentos, porfavor reinicie");
		} else {
			if (nombres.contains(nombreIN) && intentos > 0) {
				if (!output.contains(contraIN)) {
					tfuser.setText(null);
					tfpass.setText(null);
					JOptionPane.showMessageDialog(null,
							"Pass incorrecta. " + "Intnntelo de nuevo. Le quedan:\n" + intentos, "Error",
							JOptionPane.ERROR_MESSAGE);
					intentos--;

				} else {
					if (nombres.indexOf(nombreIN) == output.indexOf(contraIN)) {
						setVisible(false);
						new Interfaz().setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null,
								"El nombre o la contrasena no son correctos. Le quedan:\n" + intentos,
								"Suplantacion de identidad eh", JOptionPane.ERROR_MESSAGE);
						intentos--;

					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"El nombre: " + nombreIN + " no existe\n en nuestra base de datos. Le quedan:\n" + intentos,
						"Error 404", JOptionPane.ERROR_MESSAGE);
				intentos--;

			}

		}
	}

	Timer timerEMPLEADOS = new Timer(15, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			pb.setVisible(true);
			lblcarga.setVisible(true);
			n++;
			pb.setValue(n);
			if (n == 15) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("T .");
			} else if (n == 25) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TA ..");

			} else if (n == 35) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TAC ...");
			} else if (n == 45) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACO ....");
			} else if (n == 55) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOS .....");
			} else if (n == 65) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOSS ......");
			} else if (n == 75) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOSS! .......");
			} else if (n == 85) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOSS!! ........");
			}

			else if (n == 100) {

				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("Tacos Completados");

				lblcarga.setFont(new Font("Tahoma", Font.BOLD, 14));
				lbluser.setVisible(true);
				lblcontrasena.setVisible(true);
				tfuser.setVisible(true);
				tfpass.setVisible(true);
				bentrar.setVisible(true);
				
			
				
				lblNombre.setVisible(true);
				pb.setVisible(false);
				lblcarga.setVisible(false);
				n = 0;
				timerEMPLEADOS.stop();

			}
		}
	});
	Timer timerCLIENTES = new Timer(15, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			pb.setVisible(true);
			lblcarga.setVisible(true);
			n++;
			pb.setValue(n);
			if (n == 15) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("T .");
			} else if (n == 25) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TA ..");

			} else if (n == 35) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TAC ...");
			} else if (n == 45) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACO ....");
			} else if (n == 55) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOS .....");
			} else if (n == 65) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOSS ......");
			} else if (n == 75) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOSS! .......");
			} else if (n == 85) {
				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("TACOSS!! ........");
			}

			else if (n == 100) {

				lblcarga.setBounds(132, 191, 150, 26);
				lblcarga.setText("Tacos Completados");
				lblNombre.setVisible(true);
				lblcarga.setFont(new Font("Tahoma", Font.BOLD, 14));
								pb.setVisible(false);
				lblcarga.setVisible(false);
				n = 0;
				timerCLIENTES.stop();
				empleadosini();

			}
		}

		private void empleadosini() {
			
			new Empleados().setVisible(true);
			setVisible(false);
		}
	});
	//
	//
	//

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UIManager.setLookAndFeel( new FlatLightLaf() );
					 UIManager.put( "Button.arc", 999 );
					 UIManager.put( "Component.arc", 999 );
					 UIManager.put( "ProgressBar.arc", 999 );
					 UIManager.put( "TextComponent.arc", 999 );
					 UIManager.put( "Component.innerFocusWidth", 1 );
					 UIManager.put( "Button.innerFocusWidth", 1 );
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Iconos/tacoico.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});

//Icono de la ventana
		setLocationRelativeTo(null);
		

		setTitle("Jorge's Tacos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 407, 254);
		bg = new Image("/Iconos/fondo.jpg", 400, 365);
		
		bg.setBackground(new Color(240, 240, 240));
		bg.setOpaque(false);
		setContentPane(bg);
		pb = new JProgressBar();
		pb.setBounds(10, 167, 376, 26);
		pb.setVisible(false);
		bg.setLayout(null);
		pb.setForeground(new Color(128, 64, 64));
		pb.setStringPainted(true);
		bg.add(pb);
		lblNombre = new JLabel("Jorge's tacos");
		lblNombre.setBounds(59, 0, 275, 42);
		lblNombre.setBackground(new Color(255, 128, 64));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 30));
		bg.add(lblNombre);
		lblcarga = new JLabel("Cargando...");
		lblcarga.setBounds(0, 199, 401, 26);
		lblcarga.setVisible(false);
		lblcarga.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcarga.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarga.setForeground(new Color(0, 0, 0));
		bg.add(lblcarga);
		lbluser = new JLabel("Nombre:");
		lbluser.setBorder(null);
		lbluser.setBounds(21, 20, 63, 14);
		lbluser.setVisible(false);
		lbluser.setFont(new Font("Dialog", Font.BOLD, 12));
		lbluser.setForeground(new Color(111, 53, 2));
		lbluser.setHorizontalAlignment(SwingConstants.CENTER);
		bg.add(lbluser);
		lblcontrasena = new JLabel("Contrase\u00F1a:");
		lblcontrasena.setBounds(304, 20, 87, 14);
		lblcontrasena.setVisible(false);
		lblcontrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontrasena.setForeground(new Color(111, 53, 2));
		lblcontrasena.setFont(new Font("Dialog", Font.BOLD, 12));
		bg.add(lblcontrasena);
		bentrar = new JButton("Log In");
		bentrar.setBounds(152, 44, 89, 23);
		bentrar.setVisible(false);
		bentrar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] input = tfpass.getPassword();
				contraUsur(input);

			}

		});
		bentrar.setBackground(new Color(128, 0, 0));
		bentrar.setForeground(new Color(255, 255, 255));
		bentrar.setFont(new Font("Dialog", Font.BOLD, 12));
		bg.add(bentrar);

		volver = new JButton("Volver atras");
		volver.setBounds(152, 133, 99, 23);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverINIC();

			}

		});
		volver.setVisible(false);
		bg.add(volver);

		sel_admin = new JToggleButton("Admins");
		sel_admin.setFont(new Font("Dialog", Font.BOLD, 11));
		sel_admin.setBackground(new Color(255, 128, 64));
		sel_admin.setBounds(0, 110, 121, 23);
		bg.add(sel_admin);

		sel_cliente = new JToggleButton("Empleados");
		sel_cliente.setFont(new Font("Dialog", Font.BOLD, 11));
		sel_cliente.setBackground(new Color(255, 128, 64));
		sel_cliente.setBounds(270, 110, 121, 23);
		sel_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteSEL();

			}

		});
		bg.add(sel_cliente);
		
				opc = new JLabel("Seleccione uno:");
				opc.setBounds(152, 90, 106, 16);
				bg.add(opc);
				opc.setFont(new Font("Dialog", Font.BOLD, 13));
				opc.setHorizontalAlignment(SwingConstants.CENTER);
				tfuser = new JTextField();
				tfuser.setBounds(10, 53, 92, 16);
				bg.add(tfuser);
				tfuser.setHorizontalAlignment(SwingConstants.CENTER);
				tfuser.setForeground(new Color(255, 0, 255));
				
						tfuser.setVisible(false);
						tfuser.setBorder(new LineBorder(new Color(240, 0, 0), 2, true));
						tfuser.setOpaque(false);
						tfuser.setColumns(10);
						tfpass = new JPasswordField(5);
						tfpass.setBounds(314, 48, 72, 19);
						bg.add(tfpass);
						tfpass.setVisible(false);
						tfpass.setBorder(new LineBorder(new Color(240, 0, 0), 2, true));
						tfpass.setOpaque(false);

		sel_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminSEL();

			}

		});
	}
}