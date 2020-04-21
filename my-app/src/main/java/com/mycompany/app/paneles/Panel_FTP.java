package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mycompany.app.Users;
import com.mycompany.app.Connection.ConnectFTP;

public class Panel_FTP extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private ConnectFTP cFTP;
	private JPanel p;
	private String lastDir = "";private File fichero;private JFileChooser fileChooser;
	public Panel_FTP(Users us) {
		this.main_user = us;
		this.setBounds(0 , 0 , 574 , 470);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setVisible(false);
		p = this;
		///Componentes	
		
		
		JButton button = new JButton("Escoger Archivo");
		button.setBounds(20, 76, 150, 30);
		add(button);
		
		//Logica
		cFTP = new ConnectFTP(main_user);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lastDir == "") {
					fileChooser = new JFileChooser();
				}else {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(fichero);
					lastDir = fichero.getAbsolutePath();
				}
				
				fileChooser.showOpenDialog(p);
				fichero = fileChooser.getSelectedFile();
				lastDir = fichero.getParent();
				if ( cFTP.uploadFile(fichero) ) {
					JOptionPane.showMessageDialog(null, "Archivo subido correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podiod subir el archivo");
				}
				
			}
		});
	}
}
