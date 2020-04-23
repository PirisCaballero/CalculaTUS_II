package es.deusto.spq.paneles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Panel_consola;


public class Panel_sur extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private JFrame main_frame;
	public Panel_sur(Users us , JFrame fr , String [] users) {
		main_user = us;
		main_frame = fr;
		this.setBounds(0 , 520 , main_frame.getWidth() , 200);
		this.setLayout(null);
		this.setBorder( BorderFactory.createLineBorder(Color.green));
		this.setBackground(Color.white);
		
		///Contenido
		JPanel panel_usuarios = new JPanel();
		panel_usuarios.setLayout(null);
		panel_usuarios.setBounds( 0 , 0 ,  300 , 520);
		panel_usuarios.setBackground(Color.white);
		//panel_usuarios.setBorder(BorderFactory.createLineBorder(Color.blue));
		int Y = 0;
		JLabel logo = new JLabel();
		logo.setBounds(0 , 0 , 200 , 200);
		logo.setIcon(new ImageIcon("src/main/java/es/deusto/spq/Resources/img/Logo_UD.jpg"));
		panel_usuarios.add(logo);
		for(int i = 0 ; i<4 ; i++) {
			JLabel label = new JLabel(users[i]);
			label.setFont(new Font("TimesRoman", Font.PLAIN, 17));
			label.setBounds(200 , Y , 100 , 42);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			//label.setBorder(BorderFactory.createLineBorder(Color.green));
			//System.out.println(users[i]);
			panel_usuarios.add(label);
			Y+=42;
		}
		panel_usuarios.setVisible(true);
		
		Panel_consola pc = new Panel_consola(main_user);
		pc.setVisible(true);
		
		
		this.add(panel_usuarios);this.add(pc);
	}

}
