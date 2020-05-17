package es.deusto.spq.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.deusto.spq.Users;
import es.deusto.spq.Users.Type;
import es.deusto.spq.connection.Connect;

/**
 * Panel que se da de opcion a usar como consola, solo los usuarios
 * que son administradores pueden usarlo.
 */

public class PanelConsola extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	JTextArea consola;
	JCheckBox checkConsola;

	// JScrollPane sp;

	private Users main_user;
	/**
	 * En este panel se construye el objeto consola, mediante el cual el usuario administrador puede interactuiar con la BBDD
	 * @param user
	 */
	public PanelConsola(Users user) {
		main_user = user;
		this.setBounds(300 , 0 , 724 , 200);
		this.setLayout(null);
		
		
		
		//////Contenido
		JButton desbloc = new JButton("D");
		desbloc.setBounds(674,0,50,50);
		desbloc.setOpaque(true);
		consola = new JTextArea();
		// consola.setText("Inserte texto aqui...");
		consola.setBounds(0, 0, 724, 200);
		consola.setForeground(Color.green);
		consola.setBackground(Color.BLACK);
		consola.setCaretColor(Color.green);
		Font f = new Font("Serif", Font.BOLD, 15);
		consola.setFont(f);
		consola.setLineWrap(true);
		consola.setWrapStyleWord(true);
		consola.setMargin(new Insets(10, 10, 10, 10));
		consola.setCaretPosition(0);
		consola.setEnabled(false);
		addText(main_user.getNombre() + " >> BIENVENIDO A CALCULATUS II ");
		this.add(desbloc);
		this.add(consola);
		
		desbloc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desBloc();
			}
		});

	}
	/**
	 * Este metodo añade texto a la consola
	 * @param text
	 */
	public void addText(String text) {
		consola.setText(text );
	}
	/**
	 * Esta funcion desbloquea la consola en funcion de si el usuario es admin o no
	 */
	public void desBloc() {
		if(main_user.getAdmin()==1) {
			JOptionPane.showMessageDialog(null, "Es usted administrador, tiene acceso");
			consola.setEnabled(true);
		}else {
			JOptionPane.showMessageDialog(null, "Acceso restringido a administradores");
			consola.setEnabled(false);
		}
	}
}