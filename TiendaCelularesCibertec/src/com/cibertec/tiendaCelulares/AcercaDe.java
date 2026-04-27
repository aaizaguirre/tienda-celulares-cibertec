package com.cibertec.tiendaCelulares;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;

public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/img/about.png")));
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTitulo = new JLabel("Tienda 1.0");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 32));
			lblTitulo.setBounds(10, 11, 414, 50);
			contentPanel.add(lblTitulo);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 65, 414, 2);
		contentPanel.add(separator);
		
		JLabel lblAutores = new JLabel("Autores");
		lblAutores.setForeground(Color.GRAY);
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAutores.setBounds(10, 72, 414, 50);
		contentPanel.add(lblAutores);
		
		JLabel lblLuana = new JLabel("Luana Reyna Frias Morales");
		lblLuana.setForeground(Color.LIGHT_GRAY);
		lblLuana.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuana.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLuana.setBounds(20, 133, 404, 22);
		contentPanel.add(lblLuana);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(182, 261, 89, 23);
		contentPanel.add(btnCerrar);
		
		JLabel lblLuis = new JLabel("Luis Fabiano Caycho Poma");
		lblLuis.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuis.setForeground(Color.LIGHT_GRAY);
		lblLuis.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLuis.setBounds(20, 166, 404, 22);
		contentPanel.add(lblLuis);
		
		JLabel lblNicolas = new JLabel("Nicolas Emilio Loli Alaya");
		lblNicolas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicolas.setForeground(Color.LIGHT_GRAY);
		lblNicolas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNicolas.setBounds(20, 194, 404, 22);
		contentPanel.add(lblNicolas);
		
		JLabel lblAaron = new JLabel("Raúl Aarón Izaguirre Olortegui");
		lblAaron.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaron.setForeground(Color.LIGHT_GRAY);
		lblAaron.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAaron.setBounds(20, 228, 404, 22);
		contentPanel.add(lblAaron);
		
		// Eventos
		btnCerrar.addActionListener(e -> dispose());
	}
}
