package es.deusto.spq.ventanas;

import javax.swing.JFrame;

import es.deusto.spq.Users;

/**
 * Ventana lateral que muestra un listado con los descuentos posibles para el acliente.
 * Se accede a traves de PanelUser, boton "Ver descuentos".
 */

public class ShowDescuentos extends JFrame {

	/**
	 * Betha 1.2
	 */
	private Users main_user;

	/**
	 * Abre una ventana para poder ver los descuentos
	 * @deprecated
	 * @param user
	 */
	public ShowDescuentos(Users user) {
		this.setTitle("Descuentos");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setBounds(VentanaCalculaTUSII.getFrame().getLocation().x + VentanaCalculaTUSII.getFrame().getWidth(),
					VentanaCalculaTUSII.getFrame().getLocation().y, 350, VentanaCalculaTUSII.getFrame().getHeight());
		} catch (Exception e) {
			// TODO: handle exception			
			this.setBounds(700 , 250 , 350 , 550);
		}
		
		this.setResizable(false);
		this.setLayout(null);
		this.main_user = user;

	}
}
