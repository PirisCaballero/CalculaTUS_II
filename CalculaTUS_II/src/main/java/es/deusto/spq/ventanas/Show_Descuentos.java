package es.deusto.spq.ventanas;

import javax.swing.JFrame;

import es.deusto.spq.Users;

public class Show_Descuentos extends JFrame {

	/**
	 * Betha 1.2
	 */
	private Users main_user;

	public Show_Descuentos(Users user) {
		this.setTitle("Descuentos");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(Ventana_CalculaTUS_II.getFrame().getLocation().x + Ventana_CalculaTUS_II.getFrame().getWidth(),
				Ventana_CalculaTUS_II.getFrame().getLocation().y, 350, Ventana_CalculaTUS_II.getFrame().getHeight());
		this.setResizable(false);
		this.setLayout(null);
		this.main_user = user;

	}
}
