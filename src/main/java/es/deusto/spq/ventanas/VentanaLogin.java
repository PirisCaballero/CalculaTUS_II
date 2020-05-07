package es.deusto.spq.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class VentanaLogin extends JFrame {

	/**
	 * CalculaTUS
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUser, lblPass;
	private JButton btnAceptar, btnRegistrar;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	public VentanaLogin() {
		super("Login de usuario");
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ventanaLogin = new JPanel();
		ventanaLogin.setLayout(null);
		getContentPane().add(ventanaLogin);
		ventanaLogin.setVisible(true);
		lblUser = new JLabel();
		lblPass = new JLabel();
		txtUsuario = new JTextField();
		txtPassword = new JPasswordField();

		btnAceptar = new JButton();
		btnRegistrar = new JButton();

		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(100, 40, 120, 30);
		btnAceptar.setLocation(320, 250);

		btnRegistrar.setText("Registrarse");
		btnRegistrar.setBounds(160, 40, 120, 30);
		btnRegistrar.setLocation(140, 250);

		lblUser.setText("Introduce el nombre de usuario:");
		lblPass.setText("Introduce la contrasena:");

		lblUser.setBounds(20, 10, 300, 20);
		lblUser.setLocation(100, 100);

		txtUsuario.setBounds(20, 20, 200, 20);
		txtUsuario.setLocation(300, 100);

		lblPass.setBounds(20, 10, 300, 20);
		lblPass.setLocation(100, 140);

		txtPassword.setBounds(20, 80, 200, 20);
		txtPassword.setLocation(300, 140);

		add(txtUsuario);
		add(txtPassword);
		add(lblUser);
		add(lblPass);
		add(btnAceptar);
		add(btnRegistrar);

		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vtnRegister = new VentanaRegistro();
				dispose();
			}
		});
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Comprobacion de usuario correcto");
				Connect conn = new Connect();
				// conn.list_users();
				Users user = conn.Verificar_usuario(txtUsuario.getText(), txtPassword.getText());
				if (user != null) {
					JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + user.getNombre());
					System.out.println(user.toString());
					//VentanaPrincipal VP = new VentanaPrincipal(user);
					Ventana_CalculaTUS_II VP = new Ventana_CalculaTUS_II(user);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario no registrado");
				}

			}
		});
	}

	public static void main(String[] args) {
		//Esto es una prueba pp
		VentanaLogin VL = new VentanaLogin();
		VL.setVisible(true);
	}
}
