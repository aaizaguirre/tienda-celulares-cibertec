package com.cibertec.tiendaCelulares;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Font;

public class ListarCelulares extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCelulares dialog = new ListarCelulares();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCelulares() {
		setTitle("Listado de celulares");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCelulares.class.getResource("/img/list.png")));
		setBounds(100, 100, 500, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		scrollPane.setBounds(10, 11, 464, 205);
		contentPanel.add(scrollPane);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(112, 227, 89, 23);
		contentPanel.add(btnCerrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(277, 227, 89, 23);
		contentPanel.add(btnListar);
		
		//Eventos
		btnCerrar.addActionListener(e -> dispose());
		
		btnListar.addActionListener(e -> listar());
	}

	// Métodos
	private void listar() {
		textArea.setText("LISTADO DE CELULARES DISPONIBLES\n\n");
		textArea.append("Modelo                       : " + TiendaCelulares.modelo0);
		textArea.append("\nPrecio                       : " + TiendaCelulares.precio0);
		textArea.append("\nAlmacenamiento (GB)          : " + TiendaCelulares.almacenamiento0);
		textArea.append("\nAño de lanzamiento           : " + TiendaCelulares.anioLanzamiento0);
		textArea.append("\nTamaño de pantalla (pulg)    : " + TiendaCelulares.tamanoPantalla0);
		
		textArea.append("\n\nModelo                    : " + TiendaCelulares.modelo1);
		textArea.append("\nPrecio                       : " + TiendaCelulares.precio1);
		textArea.append("\nAlmacenamiento (GB)          : " + TiendaCelulares.almacenamiento1);
		textArea.append("\nAño de lanzamiento           : " + TiendaCelulares.anioLanzamiento1);
		textArea.append("\nTamaño de pantalla (pulg)    : " + TiendaCelulares.tamanoPantalla1);
		
		textArea.append("\n\nModelo                    : " + TiendaCelulares.modelo2);
		textArea.append("\nPrecio                       : " + TiendaCelulares.precio2);
		textArea.append("\nAlmacenamiento (GB)          : " + TiendaCelulares.almacenamiento2);
		textArea.append("\nAño de lanzamiento           : " + TiendaCelulares.anioLanzamiento2);
		textArea.append("\nTamaño de pantalla (pulg)    : " + TiendaCelulares.tamanoPantalla2);
		
		textArea.append("\n\nModelo                    : " + TiendaCelulares.modelo3);
		textArea.append("\nPrecio                       : " + TiendaCelulares.precio3);
		textArea.append("\nAlmacenamiento (GB)          : " + TiendaCelulares.almacenamiento3);
		textArea.append("\nAño de lanzamiento           : " + TiendaCelulares.anioLanzamiento3);
		textArea.append("\nTamaño de pantalla (pulg)    : " + TiendaCelulares.tamanoPantalla3);
		
		textArea.append("\n\nModelo                    : " + TiendaCelulares.modelo4);
		textArea.append("\nPrecio                       : " + TiendaCelulares.precio4);
		textArea.append("\nAlmacenamiento (GB)          : " + TiendaCelulares.almacenamiento4);
		textArea.append("\nAño de lanzamiento           : " + TiendaCelulares.anioLanzamiento4);
		textArea.append("\nTamaño de pantalla (pulg)    : " + TiendaCelulares.tamanoPantalla4);
		
		textArea.setCaretPosition(0);
	}
}
