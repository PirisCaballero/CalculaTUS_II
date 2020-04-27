package es.deusto.spq.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class VentanaModificar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblUser, lblPass;
	private JButton btnGuardar;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	public VentanaModificar(Users u) {
		super("Modificar datos");
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ventanaModificar = new JPanel();
		ventanaModificar.setLayout(null);
		getContentPane().add(ventanaModificar);
		ventanaModificar.setVisible(true);
		lblUser = new JLabel();
		lblPass = new JLabel();
		txtUsuario = new JTextField();
		txtPassword = new JTextField();
		
		btnGuardar = new JButton();
		
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(100, 40, 120, 60);
		btnGuardar.setLocation(250, 230);
		
		lblUser.setText("Introduce nuevo nombre de usuario:");
		lblPass.setText("Introduce la nueva contraseña:");

		lblUser.setBounds(20, 10, 300, 20);
		lblUser.setLocation(80, 100);

		txtUsuario.setBounds(20, 20, 200, 20);
		txtUsuario.setLocation(300, 100);

		lblPass.setBounds(20, 10, 300, 20);
		lblPass.setLocation(80, 140);

		txtPassword.setBounds(20, 80, 200, 20);
		txtPassword.setLocation(300, 140);

		add(txtUsuario);
		add(txtPassword);
		add(lblUser);
		add(lblPass);
		add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((txtUsuario.getText().isEmpty()) || (txtPassword.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor");
				}
				else {
					u.setEmail(txtUsuario.getText());
					//TODO CONEXION CON BD
					Connect cn = new Connect();
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Datos cambiados correctamente");
				}							
			}
		});
	}
	
}
