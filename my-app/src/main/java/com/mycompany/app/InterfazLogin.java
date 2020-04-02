package com.mycompany.app;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.*;

public class InterfazLogin extends JFrame {

	public InterfazLogin() {
		super("Registro de Administrador");
		this.setSize(600, 400);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentes();
	}
	public static void main(String[] args) {
		InterfazLogin a = new InterfazLogin();
		a.setVisible(true);
	}
	
	public void componentes() {
		JLabel u = new JLabel();
		JLabel pass = new JLabel();
		JLabel passVerif = new JLabel();
		JTextField usuario = new JTextField();
		JPasswordField password = new JPasswordField();
		JPasswordField passwordVerif = new JPasswordField();
		
		JButton aceptar = new JButton();
		JButton volver = new JButton("Volver");
		
		aceptar.setText("Aceptar");
		aceptar.setBounds(100, 40, 100, 30);
		aceptar.setLocation(320, 250);
		
		volver.setText("Volver");
		volver.setBounds(100, 40, 100, 30);
		volver.setLocation(180, 250);
		
		u.setText("Introduce el nombre de usuario:");
		pass.setText("Introduce la contrase�a:");
		passVerif.setText("Repite la contrase�a:");
		
		u.setBounds(20, 10, 300, 20);
		u.setLocation(100, 50);
		
		usuario.setBounds(20, 20, 200, 20);
		usuario.setLocation(300, 50);
		
		pass.setBounds(20, 10, 300, 20);
		pass.setLocation(100, 80);
		
		password.setBounds(20, 80, 200, 20);
		password.setLocation(300, 80);
		
		passVerif.setBounds(20, 10, 300, 20);
		passVerif.setLocation(100, 110);
		
		passwordVerif.setBounds(20, 100, 200, 20);
		passwordVerif.setLocation(300, 110);
		
		add(usuario);
		add(password);
		add(passwordVerif);
		add(u);
		add(pass);
		add(passVerif);
		add(aceptar);
		add(volver);
	}
}
