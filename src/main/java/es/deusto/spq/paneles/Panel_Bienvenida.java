package es.deusto.spq.paneles;
import java.awt.Color;

import javax.swing.*;

import es.deusto.spq.Users;


public class Panel_Bienvenida extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	public Panel_Bienvenida(Users us) {
		main_user = us;
		this.setBounds(0 , 0 , 574, 470);
		this.setLayout(null);
		this.setBackground(Color.white);
	}

}
