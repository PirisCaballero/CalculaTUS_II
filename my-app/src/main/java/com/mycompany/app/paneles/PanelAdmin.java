package com.mycompany.app.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import com.mycompany.app.Local;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;



public class PanelAdmin extends JPanel{
	JLabel lblCambiarTipo, lblUsuarioAsociado;
	Choice choiceAdmin, choiceUsuario;
	JButton btnGuardar, btnRefresh;
	int admin;
	Users user;
	
	private ArrayList<Local> userList = new ArrayList<Local>();
	
	public PanelAdmin(Users u){
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(240, 100, 530, 360);
		this.setVisible(true);
		this.user = u;
		
		lblCambiarTipo = new JLabel();
		lblCambiarTipo.setText("Cambiar tipo de usuario:");
		lblCambiarTipo.setBounds(80, 90, 140, 30);
		this.add(lblCambiarTipo);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(431, 11, 89, 23);
		add(btnRefresh);
		
		lblUsuarioAsociado = new JLabel();
		lblUsuarioAsociado.setText("Elige un usuario:");
		lblUsuarioAsociado.setBounds(80, 120, 140, 30);
		this.add(lblUsuarioAsociado);
		
		choiceUsuario = new Choice();
		Connect cn = new Connect();
		ArrayList<Users> ul = cn.getUsers_byAdmin(user);
		for(Users us : ul) {
			choiceUsuario.add(us.getEmail());
		}
		choiceUsuario.setBounds(280, 120, 170, 30);
		this.add(choiceUsuario);
		
		choiceAdmin = new Choice();
		choiceAdmin.add("-----------");
		choiceAdmin.add("Administrador");
		choiceAdmin.add("Usuario");
		choiceAdmin.setBounds(280, 90, 170, 30);
		this.add(choiceAdmin);

		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(this.getWidth() / 2 - 50, 240, 50, 10);
		btnGuardar.setSize(80, 30);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(choiceAdmin.getSelectedItem() + "  ||  " + choiceUsuario.getSelectedItem());
				Connect conn = new Connect();
				int admin = 2;
				if( choiceAdmin.getSelectedItem().equals("Administrador") ) {
					admin = 1;
				}else if( choiceAdmin.getSelectedItem().equals("Usuario") ) {
					admin = 0;
				}else {
					JOptionPane.showMessageDialog(null, "Debes de introducir un tipo de usuario");
				}
				if( admin < 2 ) {
					boolean cambio_efectivo = conn.cambio_de__tipo_de_usuario(user, choiceUsuario.getSelectedItem(), admin); 
					System.out.println(cambio_efectivo);
					if(cambio_efectivo) {
						JOptionPane.showMessageDialog(null, "El cambio de tipo de cuenta ha sido efectivo");
					}else {
						JOptionPane.showMessageDialog(null, "El cambio de tipo de cuenta NO ha sido efectivo");
					}
				}
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Refreshing...");
				choiceUsuario.removeAll();
				Connect cn = new Connect();
				ArrayList<Users> ul = cn.getUsers_byAdmin(user);
				for(Users us : ul) {
					choiceUsuario.add(us.getEmail());
				}
			}
		});
		
		
		this.add(btnGuardar);
	}
}
