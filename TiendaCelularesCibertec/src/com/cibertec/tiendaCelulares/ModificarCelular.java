package com.cibertec.tiendaCelulares;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class ModificarCelular extends JDialog {
	
	Font fuenteLabel = new Font("Tahoma", Font.BOLD, 12);
	
	JLabel lblModelo;
	JLabel lblPrecio;
	JLabel lblAlmacenamiento;
	JLabel lblAnioLanzamiento;
	JLabel lblTamanoPantalla;
	JButton btnCerrar;
	
	JComboBox<String> comboBox;
	private JTextField tfAlmacenamiento;
	private JTextField tfAnioLanzamiento;
	private JTextField tfPrecio;
	private JTextField tfTamanioPantalla;

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarCelular dialog = new ModificarCelular();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarCelular() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCelular.class.getResource("/img/modify.png")));
		setTitle("Modificar celular");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(fuenteLabel);
		lblModelo.setBounds(10, 30, 180, 20);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.):");
		lblPrecio.setFont(fuenteLabel);
		lblPrecio.setBounds(10, 60, 180, 20);
		contentPanel.add(lblPrecio);
		
		lblAlmacenamiento = new JLabel("Almacenamiento (GB):");
		lblAlmacenamiento.setFont(fuenteLabel);
		lblAlmacenamiento.setBounds(10, 90, 180, 20);
		contentPanel.add(lblAlmacenamiento);
		
		lblAnioLanzamiento = new JLabel("Año de lanzamiento:");
		lblAnioLanzamiento.setFont(fuenteLabel);
		lblAnioLanzamiento.setBounds(10, 120, 180, 20);
		contentPanel.add(lblAnioLanzamiento);
		
		lblTamanoPantalla = new JLabel("Tamaño de pantalla (pulg):");
		lblTamanoPantalla.setFont(fuenteLabel);
		lblTamanoPantalla.setBounds(10, 150, 180, 20);
		contentPanel.add(lblTamanoPantalla);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(fuenteLabel);
		btnGuardar.setBounds(219, 215, 90, 25);
		contentPanel.add(btnGuardar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(fuenteLabel);
		btnCerrar.setBounds(335, 215, 90, 25);
		contentPanel.add(btnCerrar);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem(TiendaCelulares.modelo0);
		comboBox.addItem(TiendaCelulares.modelo1);
		comboBox.addItem(TiendaCelulares.modelo2);
		comboBox.addItem(TiendaCelulares.modelo3);
		comboBox.addItem(TiendaCelulares.modelo4);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(200, 30, 224, 20);
		contentPanel.add(comboBox);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(200, 60, 224, 20);
		contentPanel.add(tfPrecio);
		
		tfAlmacenamiento = new JTextField();
		tfAlmacenamiento.setBounds(200, 90, 224, 20);
		contentPanel.add(tfAlmacenamiento);
		tfAlmacenamiento.setColumns(10);
		
		tfAnioLanzamiento = new JTextField();
		tfAnioLanzamiento.setColumns(10);
		tfAnioLanzamiento.setBounds(200, 120, 224, 20);
		contentPanel.add(tfAnioLanzamiento);
		
		tfTamanioPantalla = new JTextField();
		tfTamanioPantalla.setColumns(10);
		tfTamanioPantalla.setBounds(200, 150, 224, 20);
		contentPanel.add(tfTamanioPantalla);
		
		// Eventos
		btnGuardar.addActionListener(e -> modificarDatos());
		btnCerrar.addActionListener(e -> dispose());
		comboBox.addActionListener(e -> definirDatos());
		
		// Iniciar con los datos del pimer modelo ya establecidos
		definirDatos();
		
	}
	
	// Métodos
	public void definirDatos() {
		int indice = comboBox.getSelectedIndex();
		
		switch(indice) {
			case 0: 
				tfPrecio.setText(String.valueOf(TiendaCelulares.precio0));
				tfAlmacenamiento.setText(String.valueOf(TiendaCelulares.almacenamiento0));
				tfAnioLanzamiento.setText(String.valueOf(TiendaCelulares.anioLanzamiento0));
				tfTamanioPantalla.setText(String.valueOf(TiendaCelulares.tamanoPantalla0));
				break;
			case 1:
				tfPrecio.setText(String.valueOf(TiendaCelulares.precio1));
				tfAlmacenamiento.setText(String.valueOf(TiendaCelulares.almacenamiento1));
				tfAnioLanzamiento.setText(String.valueOf(TiendaCelulares.anioLanzamiento1));
				tfTamanioPantalla.setText(String.valueOf(TiendaCelulares.tamanoPantalla1));
				break;
			case 2:
				tfPrecio.setText(String.valueOf(TiendaCelulares.precio2));
				tfAlmacenamiento.setText(String.valueOf(TiendaCelulares.almacenamiento2));
				tfAnioLanzamiento.setText(String.valueOf(TiendaCelulares.anioLanzamiento2));
				tfTamanioPantalla.setText(String.valueOf(TiendaCelulares.tamanoPantalla2));
				break;
			case 3:
				tfPrecio.setText(String.valueOf(TiendaCelulares.precio3));
				tfAlmacenamiento.setText(String.valueOf(TiendaCelulares.almacenamiento3));
				tfAnioLanzamiento.setText(String.valueOf(TiendaCelulares.anioLanzamiento3));
				tfTamanioPantalla.setText(String.valueOf(TiendaCelulares.tamanoPantalla3));
				break;
			case 4:
				tfPrecio.setText(String.valueOf(TiendaCelulares.precio4));
				tfAlmacenamiento.setText(String.valueOf(TiendaCelulares.almacenamiento4));
				tfAnioLanzamiento.setText(String.valueOf(TiendaCelulares.anioLanzamiento4));
				tfTamanioPantalla.setText(String.valueOf(TiendaCelulares.tamanoPantalla4));
				break;
		}
	}
		
	public void modificarDatos() {
		try {
			int indice = comboBox.getSelectedIndex();
			double precio = Double.parseDouble(tfPrecio.getText().trim());
	        int almacenamiento = Integer.parseInt(tfAlmacenamiento.getText().trim());
	        int anio = Integer.parseInt(tfAnioLanzamiento.getText().trim());
	        double pantalla = Double.parseDouble(tfTamanioPantalla.getText().trim());
	        
	        switch(indice) {
	        case 0:
                TiendaCelulares.precio0 = precio;
                TiendaCelulares.almacenamiento0 = almacenamiento;
                TiendaCelulares.anioLanzamiento0 = anio;
                TiendaCelulares.tamanoPantalla0 = pantalla;
                break;
            case 1:
                TiendaCelulares.precio1 = precio;
                TiendaCelulares.almacenamiento1 = almacenamiento;
                TiendaCelulares.anioLanzamiento1 = anio;
                TiendaCelulares.tamanoPantalla1 = pantalla;
                break;
            case 2:
                TiendaCelulares.precio2 = precio;
                TiendaCelulares.almacenamiento2 = almacenamiento;
                TiendaCelulares.anioLanzamiento2 = anio;
                TiendaCelulares.tamanoPantalla2 = pantalla;
                break;
            case 3:
                TiendaCelulares.precio3 = precio;
                TiendaCelulares.almacenamiento3 = almacenamiento;
                TiendaCelulares.anioLanzamiento3 = anio;
                TiendaCelulares.tamanoPantalla3 = pantalla;
                break;
            case 4:
                TiendaCelulares.precio4 = precio;
                TiendaCelulares.almacenamiento4 = almacenamiento;
                TiendaCelulares.anioLanzamiento4 = anio;
                TiendaCelulares.tamanoPantalla4 = pantalla;
                break;
	        }
	        
	        JOptionPane.showMessageDialog(this, "Datos actualizados correctamente", "Guardado exitoso", JOptionPane.INFORMATION_MESSAGE);
	        dispose();
	        
		} catch(NumberFormatException error) {
			JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
