package com.mycompany.app.ventanas;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaLogin extends JFrame {

	public VentanaLogin() {
		super("Login de usuario");
		this.setSize(600, 400);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ventanaLogin = new JPanel();
		ventanaLogin.setLayout(null);
		getContentPane().add(ventanaLogin);
		ventanaLogin.setVisible(true);
		JLabel lblUser = new JLabel();
		JLabel lblPass = new JLabel();
		JTextField txtUsuario = new JTextField();
		JPasswordField txtPassword = new JPasswordField();
		
		JButton btnAceptar = new JButton();
		JButton btnRegistrar = new JButton();
		
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(100, 40, 120, 30);
		btnAceptar.setLocation(320, 250);
		
		btnRegistrar.setText("Registrarse");
		btnRegistrar.setBounds(160, 40, 120, 30);
		btnRegistrar.setLocation(140, 250);
		
		lblUser.setText("Introduce el nombre de usuario:");
		lblPass.setText("Introduce la contrasena:");
		
		lblUser.setBounds(20, 10, 300, 20);
		lblUser.setLocation(100, 100);
		
		txtUsuario.setBounds(20, 20, 200, 20);
		txtUsuario.setLocation(300, 100);
		
		lblPass.setBounds(20, 10, 300, 20);
		lblPass.setLocation(100, 140);
		
		txtPassword.setBounds(20, 80, 200, 20);
		txtPassword.setLocation(300, 140);
		
		
		add(txtUsuario);
		add(txtPassword);
		add(lblUser);
		add(lblPass);
		add(btnAceptar);
		add(btnRegistrar);
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.out.println("Comprobacion de usuario correcto");
			}
		});
		
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vtnRegister = new VentanaRegistro();
				setVisible(false);
				System.out.println("No tienes cuenta?");
			}
		});
	
	}
	
	//main para probar la ejecucion de la ventana. Ventana principal, deriva al resto
	public static void main(String[] args) {
		VentanaLogin a = new VentanaLogin();
		a.setVisible(true);
	}
	
	
		
}
