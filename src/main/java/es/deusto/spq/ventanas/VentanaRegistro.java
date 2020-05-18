package es.deusto.spq.ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.connection.ConnectFTP;

/**
 * Ventana que da opcion a registrar a un usuario nuevo, unicamente se puede acceder antes de iniciar sesion
 * desde la VentanaLogin.
 */

public class VentanaRegistro {

	final JFrame frame;
	JLabel labelNombre, labelApellido, labelCorreo, labelContrasena, labelErrorNombre, labelErrorApellido,
			labelErrorCorreo, labelErrorContrasena, lblAdministrador, lblCorreoDelAdministrador;
	JTextField textNombre, textApellido, textCorreo, textContrasena;
	JButton botonAtras, botonSiguiente;
	Choice choiceAdmin;
	int admin;
	private JTextField textField;

	/**
	 * Esta clase abre una ventana para que el usuario pueda registrarse en nuestra BBDD
	 */
	public VentanaRegistro() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(720, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// frame.setTitle("TITULO");
		frame.setResizable(false);

		JPanel ventanaRegistro = new JPanel();
		ventanaRegistro.setLayout(null);
		frame.getContentPane().add(ventanaRegistro);
		ventanaRegistro.setVisible(true);

		labelNombre = new JLabel();
		labelNombre.setText("Introduzca su nombre:");
		labelNombre.setBounds(100, 50, 200, 30);

		labelApellido = new JLabel();
		labelApellido.setText("Introduzca su apellido:");
		labelApellido.setBounds(100, 100, 200, 30);

		labelCorreo = new JLabel();
		labelCorreo.setText("Introduzca su correo:");
		labelCorreo.setBounds(100, 150, 200, 30);

		labelContrasena = new JLabel();
		labelContrasena.setText("Introduzca su contraseña:");
		labelContrasena.setBounds(100, 200, 200, 30);

		labelErrorNombre = new JLabel();
		labelErrorNombre.setText("Error al escribir el nombre.");
		labelErrorNombre.setBounds(400, 70, 200, 30);
		labelErrorNombre.setForeground(Color.RED);
		labelErrorNombre.setVisible(false);

		labelErrorApellido = new JLabel();
		labelErrorApellido.setText("Error al escribir el apellido.");
		labelErrorApellido.setBounds(400, 120, 200, 30);
		labelErrorApellido.setForeground(Color.RED);
		labelErrorApellido.setVisible(false);

		labelErrorCorreo = new JLabel();
		labelErrorCorreo.setText("Error al escribir el correo.");
		labelErrorCorreo.setBounds(400, 170, 200, 30);
		labelErrorCorreo.setForeground(Color.RED);
		labelErrorCorreo.setVisible(false);

		labelErrorContrasena = new JLabel();
		labelErrorContrasena.setText("Error al escribir la contrasena.");
		labelErrorContrasena.setBounds(400, 220, 200, 30);
		labelErrorContrasena.setForeground(Color.RED);
		labelErrorContrasena.setVisible(false);

		textNombre = new JTextField();
		// textNombre.setText("");
		textNombre.setBounds(400, 50, 250, 30);

		textApellido = new JTextField();
		// textNombre.setText("");
		textApellido.setBounds(400, 100, 250, 30);

		textCorreo = new JTextField();
		// textCorreo.setText("");
		textCorreo.setBounds(400, 150, 250, 30);

		textContrasena = new JTextField();
		// textContrasena.setText("");
		textContrasena.setBounds(400, 200, 250, 30);

		botonAtras = new JButton();
		botonAtras.setText("Atrás");
		botonAtras.setBounds(10, 340, 200, 30);

		botonSiguiente = new JButton();
		botonSiguiente.setText("Siguiente");
		botonSiguiente.setBounds(500, 340, 200, 30);

		ventanaRegistro.add(labelNombre);
		ventanaRegistro.add(labelApellido);
		ventanaRegistro.add(labelCorreo);
		ventanaRegistro.add(labelContrasena);
		ventanaRegistro.add(labelErrorNombre);
		ventanaRegistro.add(labelErrorApellido);
		ventanaRegistro.add(labelErrorCorreo);
		ventanaRegistro.add(labelErrorContrasena);
		ventanaRegistro.add(textNombre);
		ventanaRegistro.add(textApellido);
		ventanaRegistro.add(textCorreo);
		ventanaRegistro.add(textContrasena);
		ventanaRegistro.add(botonAtras);
		ventanaRegistro.add(botonSiguiente);

		choiceAdmin = new Choice();
		choiceAdmin.add("-----------");
		choiceAdmin.add("Administrador");
		choiceAdmin.add("Usuario");
		choiceAdmin.setBounds(400, 256, 250, 32);
		ventanaRegistro.add(choiceAdmin);

		lblAdministrador = new JLabel("Tipo de cuenta:");
		lblAdministrador.setBounds(100, 247, 200, 30);
		ventanaRegistro.add(lblAdministrador);

		lblCorreoDelAdministrador = new JLabel("Correo del Administrador");
		lblCorreoDelAdministrador.setVisible(false);
		lblCorreoDelAdministrador.setBounds(100, 288, 200, 30);
		ventanaRegistro.add(lblCorreoDelAdministrador);

		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(400, 283, 250, 30);
		ventanaRegistro.add(textField);

		choiceAdmin.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Admin();
			}
		});
		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin VL = new VentanaLogin();
				VL.setVisible(true);
				frame.dispose();
			}
		});

		botonSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
	}
	
	/**
	 * Este metodo crea el objeto Users y lo registra en la BBDD
	 * @return boolean
	 */
	public boolean Registrar() {
		labelErrorNombre.setVisible(false);
		labelErrorApellido.setVisible(false);
		labelErrorCorreo.setVisible(false);
		labelErrorContrasena.setVisible(false);
		if (textNombre.getText().matches("^[a-z A-Z]*$") && !textNombre.getText().isEmpty()
				&& textApellido.getText().matches("^[a-z A-Z]*$") && !textApellido.getText().isEmpty()
				&& textCorreo.getText()
						.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
				&& !textCorreo.getText().isEmpty() && !textContrasena.getText().isEmpty()) {
			String correo_admin = "";
			if (textField.getText().isEmpty()) {
				correo_admin = "null";
			} else {
				correo_admin = textField.getText();
			}
			Users user = new Users(textNombre.getText(), textApellido.getText(), textCorreo.getText(),
					textContrasena.getText(), admin, correo_admin);
			Connect conn = new Connect();
			conn.RegisUser(user);
			VentanaLogin VL = new VentanaLogin();
			VL.setVisible(true);
			ConnectFTP Cftp = new ConnectFTP(user);
			Cftp.OpenConexion();
			frame.dispose();
			return true;
		} else if (!textNombre.getText().matches("^[a-z A-Z]*$") || textNombre.getText().isEmpty()) {
			// nombre mal
			labelErrorNombre.setVisible(true);
			return false;
		} else if (!textApellido.getText().matches("^[a-z A-Z]*$") || textApellido.getText().isEmpty()) {
			// apellido mal
			labelErrorApellido.setVisible(true);
			return false;
		} else if (!textCorreo.getText().matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
				|| textCorreo.getText().isEmpty()) {
			// correo mal
			labelErrorCorreo.setVisible(true);
			return false;
		} else if (textContrasena.getText().isEmpty()) {
			// contrasena mal
			labelErrorContrasena.setVisible(true);
			return false;
		}else {
			return false;
		}
	}
	/**
	 * Verifica si el usuario proporcionado como administrador es verdaderamente un administrador
	 * @return boolean
	 */
	public boolean Admin() {
		if (choiceAdmin.getSelectedIndex() == 0 || choiceAdmin.getSelectedIndex() == 2) {
			lblCorreoDelAdministrador.setVisible(true);
			textField.setVisible(true);
			admin = 0;
			return false;
		} else {
			lblCorreoDelAdministrador.setVisible(false);
			textField.setVisible(false);
			admin = 1;
			return true;
		}
	}
	
}
