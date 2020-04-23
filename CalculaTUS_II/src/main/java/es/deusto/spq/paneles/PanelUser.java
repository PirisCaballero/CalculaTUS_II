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
import es.deusto.spq.ventanas.Show_Descuentos;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class PanelUser extends JPanel {

	JButton btnDescuento;
	int admin;
	Users user;

	private ArrayList<Local> userList = new ArrayList<Local>();
	private Panel_Datos pd;

	private static Show_Descuentos sd;
	private PanelControl pcont;
	private Users main_user;

	public PanelUser(Users u, Panel_Datos pdts) {
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
		
		sd = new Show_Descuentos(main_user);
		sd.setVisible(false);
		btnDescuento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("btnDescuento");
				sd.setVisible(true);
			}
		});
		
		btnControl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ventana_CalculaTUS_II.pc.setPanel(7);
			}
		});
	}
}
