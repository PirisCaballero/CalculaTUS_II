package paneles;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import com.mycompany.app.Local;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;

import java.awt.Choice;
public class Panel_producto extends JPanel{
	
	/**
	 * CalculaTUS_II
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Local> locList = new ArrayList<Local>();
	private Choice choice;
	private JTextField textField;
	private JTextField textField_1;
	public Panel_producto( Users us ) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.white);
		this.setBounds(240, 100, 530, 360);
		
		JLabel lblLocal = new JLabel("Local: ");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(50, 50, 150, 30);
		add(lblLocal);
		
		choice = new Choice();
		Connect cn = new Connect();
		locList = cn.getLocales(us);
		for( Local l : locList) {
			choice.add(l.getNombre());
		}
		choice.setBounds(250, 50, 150, 30);
		add(choice);
		
		JLabel lblPrecio = new JLabel("Nombre: ");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(50, 100, 150, 30);
		add(lblPrecio);
		
		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_1.setBounds(50, 150, 150, 30);
		add(lblPrecio_1);
		
		textField = new JTextField();
		textField.setBounds(250, 100, 150, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 150, 150, 30);
		add(textField_1);
		this.setVisible(false);
		
	}
	public void refreshList(Users us) {
		locList.clear();
		choice.removeAll();
		Connect cn = new Connect();
		locList = cn.getLocales(us);
		for( Local l : locList) {
			choice.add(l.getNombre());
			System.out.println("Añadido de nuevo");
		}
		choice.repaint();
	}
}
