package com.cibertec.tiendaCelulares;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarDescuentos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	Font fuenteLabel = new Font("Tahoma", Font.BOLD, 12);
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarDescuentos dialog = new ConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarDescuentos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarDescuentos.class.getResource("/img/discount.png")));
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl1 = new JLabel("1 a 5 unidades");
		lbl1.setBounds(25, 30, 140, 20);
		lbl1.setFont(fuenteLabel);
		contentPanel.add(lbl1);

		JLabel lbl2 = new JLabel("6 a 10 unidades");
		lbl2.setBounds(25, 60, 140, 20);
		lbl2.setFont(fuenteLabel);
		contentPanel.add(lbl2);

		JLabel lbl3 = new JLabel("11 a 15 unidades");
		lbl3.setBounds(25, 90, 140, 20);
		lbl3.setFont(fuenteLabel);
		contentPanel.add(lbl3);

		JLabel lbl4 = new JLabel("Más de 15 unidades");
		lbl4.setBounds(25, 120, 140, 20);
		lbl4.setFont(fuenteLabel);
		contentPanel.add(lbl4);

		tf1 = new JTextField();
		tf1.setBounds(180, 30, 86, 20);
		contentPanel.add(tf1);
		tf1.setColumns(10);

		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(180, 60, 86, 20);
		contentPanel.add(tf2);

		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(180, 90, 86, 20);
		contentPanel.add(tf3);

		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(180, 120, 86, 20);
		contentPanel.add(tf4);

		JLabel lbl1a = new JLabel("%");
		lbl1a.setBounds(280, 30, 20, 20);
		contentPanel.add(lbl1a);

		JLabel lbl1b;
		lbl1b = new JLabel("%");
		lbl1b.setBounds(280, 60, 20, 20);
		contentPanel.add(lbl1b);

		JLabel lbl1c;
		lbl1c = new JLabel("%");
		lbl1c.setBounds(280, 90, 20, 20);
		contentPanel.add(lbl1c);

		JLabel lbl1d;
		lbl1d = new JLabel("%");
		lbl1d.setBounds(280, 120, 20, 20);
		lbl1d.setFont(fuenteLabel);
		contentPanel.add(lbl1d);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(322, 30, 89, 23);
		contentPanel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(322, 60, 89, 23);
		contentPanel.add(btnCancelar);
		
		//Eventos
		mostrarValores();
		btnCancelar.addActionListener(e -> dispose());
		btnAceptar.addActionListener(e -> cambiarValores());
	}
	
	//Métodos
	public void mostrarValores() {
		tf1.setText(String.valueOf(TiendaCelulares.porcentaje1));
		tf2.setText(String.valueOf(TiendaCelulares.porcentaje2));
		tf3.setText(String.valueOf(TiendaCelulares.porcentaje3));
		tf4.setText(String.valueOf(TiendaCelulares.porcentaje4));
	}
	
	public void cambiarValores() {
		try {
			double valor1 = Double.parseDouble(tf1.getText().trim());
			double valor2 = Double.parseDouble(tf2.getText().trim());
			double valor3 = Double.parseDouble(tf3.getText().trim());
			double valor4 = Double.parseDouble(tf4.getText().trim());
			if (valor1 >= 0 && valor1 <= 100 &&
					valor2 >= 0 && valor2 <= 100 &&
				    valor3 >= 0 && valor3 <= 100 &&
				    valor4 >= 0 && valor4 <= 100) {
				TiendaCelulares.porcentaje1 = valor1;
				TiendaCelulares.porcentaje2 = valor2;
				TiendaCelulares.porcentaje3 = valor3;
				TiendaCelulares.porcentaje4 = valor4;
			} else {
				JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
			}
			dispose();
		} catch(NumberFormatException error) {
			JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
