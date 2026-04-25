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

public class ConfigurarObsequios extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	Font fuenteLabel = new Font("Tahoma", Font.BOLD, 12);
	
	private JTextField tfObsequio1;
	private JTextField tfObsequio2;
	private JTextField tfObsequio3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarObsequios.class.getResource("/img/gift.png")));
		setBounds(100, 100, 450, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblObsequio1 = new JLabel("1 unidad");
		lblObsequio1.setBounds(20, 15, 120, 20);
		lblObsequio1.setFont(fuenteLabel);
		contentPanel.add(lblObsequio1);

		JLabel lblObsequio2 = new JLabel("2 a 5 unidades");
		lblObsequio2.setBounds(20, 45, 120, 20);
		lblObsequio2.setFont(fuenteLabel);
		contentPanel.add(lblObsequio2);

		JLabel lblObsequio3 = new JLabel("6 a más unidades");
		lblObsequio3.setBounds(20, 75, 120, 20);
		lblObsequio3.setFont(fuenteLabel);
		contentPanel.add(lblObsequio3);

		tfObsequio1 = new JTextField();
		tfObsequio1.setBounds(150, 15, 140, 20);
		contentPanel.add(tfObsequio1);
		tfObsequio1.setColumns(10);

		tfObsequio2 = new JTextField();
		tfObsequio2.setColumns(10);
		tfObsequio2.setBounds(150, 45, 140, 20);
		contentPanel.add(tfObsequio2);

		tfObsequio3 = new JTextField();
		tfObsequio3.setColumns(10);
		tfObsequio3.setBounds(150, 75, 140, 20);
		contentPanel.add(tfObsequio3);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(320, 21, 89, 23);
		contentPanel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(320, 63, 89, 23);
		contentPanel.add(btnCancelar);
		
		//Eventos
		mostrarValores();
		btnCancelar.addActionListener(e -> dispose());
		btnAceptar.addActionListener(e -> cambiarValores());

	}
	
	//Métodos
	public void mostrarValores() {
		tfObsequio1.setText(TiendaCelulares.obsequio1);
		tfObsequio2.setText(TiendaCelulares.obsequio2);
		tfObsequio3.setText(TiendaCelulares.obsequio3);

	}
	
	public void cambiarValores() {
		if(tfObsequio1.getText().trim().isEmpty() ||
			    tfObsequio2.getText().trim().isEmpty() ||
			    tfObsequio3.getText().trim().isEmpty()) {

			    JOptionPane.showMessageDialog(this, "Ingrese valores válidos", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
		dispose();
	}

}
