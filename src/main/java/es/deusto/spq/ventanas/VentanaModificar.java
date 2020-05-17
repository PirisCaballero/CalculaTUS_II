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
import es.deusto.spq.paneles.PanelNorte;

/**
 * Ventana que da opcion a modificar los datos como nombre de usuario o contraseña.
 */

public class VentanaModificar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblUser, lblPass;
	private JButton btnGuardar;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private Connect c = new Connect();
	private Users main_user;

	/**
	 * Esta clase abre una ventana que permite modifuicar los datos de usuario
	 * @param u
	 */
	public VentanaModificar(Users u) {
		super("Modificar datos");
		this.main_user = u;
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				JOptionPane.showMessageDialog(null, "Guardado: "+Save());
			}
		});
	}
	/**
	 * Esta funcion guarda los cambios en la BBDD
	 * @return boolean
	 */
	public boolean Save() {
		boolean update = false;
		if((txtUsuario.getText().isEmpty()) || (txtPassword.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor");
		}
		else {
			String nombre = txtUsuario.getText();
			String pass = txtPassword.getText();
			update = c.updateData(main_user, nombre, pass);
		}		
		return update;
	}
	
}
