package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.mycompany.app.Local;
import com.mycompany.app.Users;
import com.mycompany.app.ventanas.Show_Descuentos;

public class PanelUser extends JPanel {

	JButton btnDescuento;
	int admin;
	Users user;

	private ArrayList<Local> userList = new ArrayList<Local>();
	private Panel_Datos pd;

	private static Show_Descuentos sd;

	private Users main_user;

	public PanelUser(Users u, Panel_Datos pdts) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 574, 470);
		this.setVisible(true);
		this.user = u;
		this.pd = pdts;

		btnDescuento = new JButton("Ver Descuentos");
		btnDescuento.setBounds(178, 35, 200, 23); //se puede mover donde querais, estaba aqui pork el panel esta vacio
		add(btnDescuento);

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
	}
}
