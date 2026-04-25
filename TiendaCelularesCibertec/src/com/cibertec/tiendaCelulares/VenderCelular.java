package com.cibertec.tiendaCelulares;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VenderCelular extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	Font fuenteLabel = new Font("Tahoma", Font.BOLD, 12);
	
	JLabel lblModelo;
	JLabel lblPrecio;
	JLabel lblCantidad;
	private JTextField tfPrecio;
	private JTextField tfCantidad;
	JComboBox<String> comboBox;
	JTextArea textArea;
	
	String modelo;
	double precio;
	int cantidad;
	double porcentajeDescuento;
	String valorObsequio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VenderCelular dialog = new VenderCelular();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VenderCelular() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VenderCelular.class.getResource("/img/sell.png")));
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 20, 75, 20);
		contentPanel.add(lblModelo);
		lblModelo.setFont(fuenteLabel);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(20, 50, 75, 20);
		contentPanel.add(lblPrecio);
		lblPrecio.setFont(fuenteLabel);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(20, 80, 75, 20);
		contentPanel.add(lblCantidad);
		lblCantidad.setFont(fuenteLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(110, 20, 170, 20);
		comboBox.addItem(TiendaCelulares.modelo0);
		comboBox.addItem(TiendaCelulares.modelo1);
		comboBox.addItem(TiendaCelulares.modelo2);
		comboBox.addItem(TiendaCelulares.modelo3);
		comboBox.addItem(TiendaCelulares.modelo4);
		comboBox.setSelectedIndex(0);
		contentPanel.add(comboBox);
		
		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setBounds(110, 50, 170, 20);
		contentPanel.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(110, 80, 170, 20);
		contentPanel.add(tfCantidad);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(320, 32, 89, 23);
		contentPanel.add(btnVender);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(320, 66, 89, 23);
		contentPanel.add(btnCerrar);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 120, 414, 130);
		contentPanel.add(textArea);
		
		// Eventos
		comboBox.addActionListener(e -> mostrarPrecio());
		btnVender.addActionListener(e -> vender());
		
		btnCerrar.addActionListener(e -> dispose());
		
		mostrarPrecio();
	}
	
	// Métodos
	
	private void mostrarPrecio() {

		int indice = comboBox.getSelectedIndex();
		
        switch(indice) {
        case 0: 
			tfPrecio.setText(String.valueOf(TiendaCelulares.precio0));
			modelo = TiendaCelulares.modelo0;
			precio = TiendaCelulares.precio0;
			break;
		case 1:
			tfPrecio.setText(String.valueOf(TiendaCelulares.precio1));
			modelo = TiendaCelulares.modelo1;
			precio = TiendaCelulares.precio1;
			break;
		case 2:
			tfPrecio.setText(String.valueOf(TiendaCelulares.precio2));
			modelo = TiendaCelulares.modelo2;
			precio = TiendaCelulares.precio2;
			break;
		case 3:
			tfPrecio.setText(String.valueOf(TiendaCelulares.precio3));
			modelo = TiendaCelulares.modelo3;
			precio = TiendaCelulares.precio3;
			break;
		case 4:
			tfPrecio.setText(String.valueOf(TiendaCelulares.precio4));
			modelo = TiendaCelulares.modelo4;
			precio = TiendaCelulares.precio4;
			break;
	        }
	}
	
	private void vender() {
		textArea.setText("");
		try {
			cantidad = Integer.parseInt(tfCantidad.getText().trim());
			if(cantidad > 0) {
				double importeCompra = Math.round(precio * cantidad);
				double importeDescuento = Math.round(descuento() * 0.01* importeCompra);
				double importePagar = importeCompra - importeDescuento;
				
				TiendaCelulares.numeroVentas++;
				TiendaCelulares.importeTotalAcumulado += importePagar;
				
				textArea.setText("BOLETA DE VENTA\n\n");
				textArea.append("Modelo: " + modelo);
				textArea.append("\nPrecio (S/.): " + precio);
				textArea.append("\nCantidad: " + cantidad);
				textArea.append("\nImporte Compra: " + "S/." + importeCompra);
				textArea.append("\nImporte Descuento: " + "S/." + importeDescuento);
				textArea.append("\nImporte a Pagar: " + "S/." + importePagar);
				textArea.append("\nObsequio: " + obsequio());
				
				if(TiendaCelulares.numeroVentas % 5 == 0) {
					double porcentajeCuota = (TiendaCelulares.importeTotalAcumulado / TiendaCelulares.cuotaDiaria) * 100;
					
					JOptionPane.showMessageDialog(this,
					        "Ventas realizadas: " + TiendaCelulares.numeroVentas +
					        "\nImporte total acumulado: S/." + TiendaCelulares.importeTotalAcumulado +
					        "\nPorcentaje de cuota diaria: " + porcentajeCuota + "%",
					        "Resumen de ventas",
					        JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch(NumberFormatException error) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private double descuento() {
		if(cantidad >= 1 && cantidad <= 5) {
			porcentajeDescuento = TiendaCelulares.porcentaje1;
		}else if(cantidad <= 10) {
			porcentajeDescuento = TiendaCelulares.porcentaje2;
		}else if(cantidad <= 15) {
			porcentajeDescuento = TiendaCelulares.porcentaje3;
		} else {
			porcentajeDescuento = TiendaCelulares.porcentaje4;
		}
		
		return porcentajeDescuento;
	}
	
	private String obsequio() {
		if(cantidad == 1) {
			valorObsequio = TiendaCelulares.obsequio1;
		}else if(cantidad >=2 && cantidad <= 5) {
			valorObsequio = TiendaCelulares.obsequio2;
		} else {
			valorObsequio = TiendaCelulares.obsequio3;
		}
		
		return valorObsequio;
	}
}
