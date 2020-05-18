package es.deusto.spq.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.deusto.spq.Local;
import es.deusto.spq.Users;
import es.deusto.spq.ventanas.ShowDescuentos;
import es.deusto.spq.ventanas.VentanaOpinion;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;
import es.deusto.spq.ventanas.VentanaModificar;

/**
 * Panel que muestra botones que dan acceso a unas de las opciones
 *  que tiene un usuario: ver descuentos, control parental, opinanos
 *   y ver estadisticas.
 */

public class PanelUser extends JPanel {

	JButton btnDescuento, btnEstadisticas, btnModificarCuenta;
	int admin;
	Users user;

	private ArrayList<Local> userList = new ArrayList<Local>();
	private PanelDatos pd;

	private static ShowDescuentos sd;
	private PanelControl pcont;
	private Users main_user;

	/**
	 * Este panel te permite ver las estadisticas, las opciones de usuario, el control parental y las estadisticas
	 * @param u
	 * @param pdts
	 */
	public PanelUser(Users u, PanelDatos pdts) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 574, 470);
		this.setVisible(true);
		this.user = u;
		this.pd = pdts;

		JLabel lblTitulo = new JLabel("Opciones de usuario");
		lblTitulo.setBounds(50, 11, 433, 56);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		Font auxFont = lblTitulo.getFont();
		lblTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		add(lblTitulo);
//		
//		pcont = new PanelControl(main_user, pdts);
//		
		btnDescuento = new JButton("Ver descuentos");
		btnDescuento.setBounds(178, 85, 200, 23); //se puede mover donde querais, estaba aqui pork el panel esta vacio
		add(btnDescuento);

		JButton btnControl = new JButton("Control parental");
		btnControl.setBounds(178, 135, 200, 23);
		add(btnControl);
		
		JButton btnOpinanosd = new JButton("Opínanos :D");
		btnOpinanosd.setBounds(178, 185, 200, 23);
		add(btnOpinanosd);
		
		btnEstadisticas = new JButton("Ver estadísticas");
		btnEstadisticas.setBounds(178, 235, 200, 23); 
		add(btnEstadisticas);
		
		btnModificarCuenta = new JButton("Modificar cuenta");
		btnModificarCuenta.setBounds(178, 285, 200, 23); //se puede mover donde querais, estaba aqui pork el panel esta vacio
		add(btnModificarCuenta);

		
		sd = new ShowDescuentos(main_user);
		sd.setVisible(false);
		btnDescuento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				descuentoAccion();
			}
		});
		
		btnControl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlUsuario();
			}
		});
		
		btnOpinanosd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				opinarAccion();
			}
		});
		
		btnEstadisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				estadisticas();				
			}
		});
		
		btnModificarCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modificaCuenta();
			}
		});
	}
	/**
	 * Abre una ventana que muestra las estadisticas
	 */
	public void estadisticas() {
		VentanaCalculaTUSII.pc.setPanel(8);
	}
	/**
	 * Abre una ventana para que puedas dejar una reseña de la aplicación
	 */
	public void opinarAccion() {
		VentanaOpinion vp = new VentanaOpinion(user);
		vp.setVisible(true);
	}
	/**
	 * Abre una ventana para poder ver los datos de tus usuarios
	 */
	public void controlUsuario() {
		VentanaCalculaTUSII.pc.setPanel(7);
	}
	/**
	 * Abre una ventana para ver los descuentos
	 * @deprecated
	 */
	public void descuentoAccion() {
		sd.setVisible(true);
	}
	/**
	 * Abre una ventana para poder modificar tus ajustes de cuenta (usuario y contraseña)
	 */
	public void modificaCuenta() {
		VentanaModificar vm = new VentanaModificar(user);
		vm.setVisible(true);
	}
}
