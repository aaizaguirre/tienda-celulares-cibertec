package com.cibertec.tiendaCelulares;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class TiendaCelulares extends JFrame {
	
	// ===== DATOS DE CELULARES =====
	
	//Celular 1 - extraido de: https://tottus.falabella.com.pe/tottus-pe/product/149215025/IPHONE-15-128GB-NEGRO/149215029
	public static String modelo0 = "Iphone 15 128 GB";
	// Precio en soles
	public static double precio0 = 2499.0;
	// Almacenamiento en GB
	public static int almacenamiento0 = 128;
	public static int anioLanzamiento0 = 2023;
	// Tamaño en pulgadas
	public static double tamanoPantalla0 = 6.0;
	
	//Celular 2 - extraido de: https://www.falabella.com.pe/falabella-pe/product/80017601/celular-redmi-a7-pro-4gb-128/80017601
	public static String modelo1 = "Redmi A7 Pro 4 GB + 128 GB";
	// Precio en soles
	public static double precio1 = 449.0;	
	// Almacenamiento en GB
	public static int almacenamiento1 = 128; 				
	public static int anioLanzamiento1 = 2026;
	// Tamaño en pulgadas
	public static double tamanoPantalla1 = 6.9;				
	
	//Celular 3 - extraido de: https://www.falabella.com.pe/falabella-pe/product/21398141/celular-samsung-galaxy-s26-ultra-512gb-black/21398141
	public static String modelo2 = "Samsung Galaxy S26 Ultra 512 GB";
	// Precio en soles
	public static double precio2 = 5299.0;		
	// Almacenamiento en GB
	public static int almacenamiento2 = 512; 			
	public static int anioLanzamiento2 = 2026;
	// Tamaño en pulgadas
	public static double tamanoPantalla2 = 6.9;					

	//Celular 4 - extraido de: https://www.falabella.com.pe/falabella-pe/product/21374351/celular-xiaomi-redmi-note-15-8gb-256gb-negro/21374351
	public static String modelo3 = "Xiaomi Redmi Note 15 8GB + 256 GB";
	// Precio en soles
	public static double precio3 = 799.0;	
	// Almacenamiento en GB
	public static int almacenamiento3 = 256; 		
	public static int anioLanzamiento3 = 2026;
	// Tamaño en pulgadas
	public static double tamanoPantalla3 = 6.7;				
	
	//Celular 5 - extraido de: https://www.falabella.com.pe/falabella-pe/product/149495955/moto-razr-60-ultra-161t-verde/149495956
	public static String modelo4 = "Moto Razr 60 Ultra 16 GB + 1024 GB";
	// Precio en soles
	public static double precio4 = 8599.0;	
	// Almacenamiento en GB
	public static int almacenamiento4 = 1024; 			
	public static int anioLanzamiento4 = 2024;
	// Tamaño en pulgadas
	public static double tamanoPantalla4 = 6.0;			
	
	// ===== CONFIGURACIÓN =====
	
	// Descuentos
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequios
	public static String obsequio1 = "Audífonos";
	public static String obsequio2 = "Funda protectora";
	public static String obsequio3 = "Power bank";
	
	// Declaración de variables
	Font titulosMenu = new Font("Segoe UI", Font.BOLD, 14);
	
	JMenuBar menuBar;
	
	JMenu mnArchivo;
	JMenuItem mntmSalir;
	
	JMenu mnMantenimiento;
	JMenuItem mntmConsultar;
	JMenuItem mntmModificar;
	JMenuItem mntmListar;
	
	JMenu mnVentas;
	JMenuItem mntmVender;
	
	JMenu mnConfiguracion;
	JMenuItem mntmDescuentos;
	JMenuItem mntmObsequios;
	
	JMenu mnAyuda;
	JMenuItem mntmAcercaDe;

	// ===== ATRIBUTOS DE GUI =====
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// ===== MAIN =====
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiendaCelulares frame = new TiendaCelulares();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ===== CONSTRUCTOR =====
	public TiendaCelulares() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TiendaCelulares.class.getResource("/img/store.png")));
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(titulosMenu);
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/exit.png")));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(titulosMenu);
		menuBar.add(mnMantenimiento);
		
		mntmConsultar = new JMenuItem("Consultar celular");
		mntmConsultar.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/query.png")));
		mnMantenimiento.add(mntmConsultar);
		
		mntmModificar = new JMenuItem("Modificar celular");
		mntmModificar.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/modify.png")));
		mnMantenimiento.add(mntmModificar);
		
		mntmListar = new JMenuItem("Listar celulares");
		mntmListar.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/list.png")));
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(titulosMenu);
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/sell.png")));
		mnVentas.add(mntmVender);
		
		mnConfiguracion = new JMenu("Configuración");
		mnConfiguracion.setFont(titulosMenu);
		menuBar.add(mnConfiguracion);
		
		mntmDescuentos = new JMenuItem("Configurar descuentos");
		mntmDescuentos.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/discount.png")));
		mnConfiguracion.add(mntmDescuentos);
		
		mntmObsequios = new JMenuItem("Configurar obsequios");
		mntmObsequios.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/gift.png")));
		mnConfiguracion.add(mntmObsequios);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(titulosMenu);
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de Tienda");
		mntmAcercaDe.setIcon(new ImageIcon(TiendaCelulares.class.getResource("/img/about.png")));
		mnAyuda.add(mntmAcercaDe);
		
		// Eventos
		mntmSalir.addActionListener(e -> salir());
		mntmConsultar.addActionListener(e -> abrirConsultar());
	}
	
	// Métodos
	private void salir() {
		System.exit(0);
	}
	
	private void abrirConsultar() {
		new ConsultarCelular().setVisible(true);
	}
}
