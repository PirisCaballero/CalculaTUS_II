package es.deusto.spq.ventanas;

import javax.swing.JFrame;

import es.deusto.spq.Users;

public class ShowDescuentos extends JFrame {

	/**
	 * Betha 1.2
	 */
	private Users main_user;

	public ShowDescuentos(Users user) {
		this.setTitle("Descuentos");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(VentanaCalculaTUSII.getFrame().getLocation().x + VentanaCalculaTUSII.getFrame().getWidth(),
				VentanaCalculaTUSII.getFrame().getLocation().y, 350, VentanaCalculaTUSII.getFrame().getHeight());
		this.setResizable(false);
		this.setLayout(null);
		this.main_user = user;

	}
}
