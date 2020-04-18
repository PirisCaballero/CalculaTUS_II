package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mycompany.app.Local;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;

public class Panel_Local extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblRegistrarLocal , lblNombreLocal , lblDireccion, lblCodPostal , lblOpinion;
	private JTextField txtNombreLocal , txtDireccion , txtCodPostal;
	private JTextArea txtOpinion;
	private JButton btnLocalCreado;
	private Users main_user; 
	public Panel_Local(Users user) {
		this.setBounds(0, 0, 524, 470);
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		
		///Contenido
		
		lblRegistrarLocal = new JLabel();
		lblRegistrarLocal.setText("Registrar local");
		lblRegistrarLocal.setBounds(this.getWidth() / 2 - 60, 10, 140, 30);
		Font auxFont = lblRegistrarLocal.getFont();
		lblRegistrarLocal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		this.add(lblRegistrarLocal);
		
		lblNombreLocal = new JLabel();
		lblNombreLocal.setText("Nombre del local:");
		lblNombreLocal.setBounds(140, 70, 140, 30);
		this.add(lblNombreLocal);
		
		txtNombreLocal = new JTextField();
		txtNombreLocal.setText("");
		txtNombreLocal.setBounds(260, 70, 170, 30);
		this.add(txtNombreLocal);
		
		lblDireccion = new JLabel();
		lblDireccion.setText("Introduce la direccion:");
		lblDireccion.setBounds(111, 120, 140, 30);
		this.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setText("");
		txtDireccion.setBounds(260, 120, 170, 30);
		this.add(txtDireccion);
		
		lblCodPostal = new JLabel();
		lblCodPostal.setText("Introduce el codigo postal:");
		lblCodPostal.setBounds(88, 170, 160, 30);
		this.add(lblCodPostal);
		
		txtCodPostal = new JTextField();
		txtCodPostal.setText("");
		txtCodPostal.setBounds(260, 170, 170, 30);
		this.add(txtCodPostal);
		
		lblOpinion = new JLabel();
		lblOpinion.setText("Deja tu opinion:");
		lblOpinion.setBounds(30, 200, 160, 30);
		this.add(lblOpinion);
		
		txtOpinion = new JTextArea();
		txtOpinion.setText("");
		txtOpinion.setBounds(20, 230, 480, 80);
		txtOpinion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		txtOpinion.setLineWrap(true);
		txtOpinion.setWrapStyleWord(true);
		txtOpinion.setMargin(new Insets(10, 10, 10, 10));
		txtOpinion.setCaretPosition(0);
		this.add(txtOpinion);
		
		btnLocalCreado = new JButton();
		btnLocalCreado.setText("Enviar");
		btnLocalCreado.setBounds(getWidth() / 2 - 50, 320, 50, 10);
		btnLocalCreado.setSize(80, 30);
		this.add(btnLocalCreado);
		
		btnLocalCreado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connect cn = new Connect();
				Local loc = new Local(txtNombreLocal.getText() , txtDireccion.getText() , Integer.parseInt(txtCodPostal.getText()) , txtOpinion.getText());
				cn.RegisLocal(main_user, loc);
			}
		});
	}

}
