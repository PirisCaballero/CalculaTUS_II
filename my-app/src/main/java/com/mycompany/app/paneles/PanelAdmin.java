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
	JButton btnGuardar;
	int admin;
	
	private ArrayList<Local> userList = new ArrayList<Local>();
	
	public PanelAdmin(Users u){
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(240, 100, 530, 360);
		this.setVisible(true);
		
		lblCambiarTipo = new JLabel();
		lblCambiarTipo.setText("Cambiar tipo de usuario:");
		lblCambiarTipo.setBounds(80, 90, 140, 30);
		this.add(lblCambiarTipo);
		
		lblUsuarioAsociado = new JLabel();
		lblUsuarioAsociado.setText("Elige un usuario:");
		lblUsuarioAsociado.setBounds(80, 120, 140, 30);
		this.add(lblUsuarioAsociado);
		
		choiceUsuario = new Choice();
		Connect cn = new Connect();
		//userList = cn.cambio_de__tipo_de_usuario(log_user, user_to_change, cambio);
		choiceUsuario.setBounds(280, 120, 170, 30);
		this.add(choiceUsuario);
		
		choiceAdmin = new Choice();
		choiceAdmin.add("-----------");
		choiceAdmin.add("Administrador");
		choiceAdmin.add("Usuario");
		choiceAdmin.setBounds(280, 90, 170, 30);
		this.add(choiceAdmin);

		choiceAdmin.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (choiceAdmin.getSelectedIndex() == 0 || choiceAdmin.getSelectedIndex() == 2) {
					
					admin = 0;
				} else {
					
					admin = 1;
				}
			}
		});

		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(this.getWidth() / 2 - 50, 240, 50, 10);
		btnGuardar.setSize(80, 30);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Crear local");
				
				Connect conn = new Connect();
				//System.out.println(conn.cambio_de__tipo_de_usuario(log_user, user_to_change, cambio););
			}
		});
		
		this.add(btnGuardar);
	}
	
}
