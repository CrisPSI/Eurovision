package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Vista extends JFrame {

	public JPanel mainPane, inicioPane, resultadosPane, cuartoPane, quintoPane, sextoPane, septimoPane, octavoPane, novenoPane, decimoPane ;
	public JLabel lblFondoInicio, lblFondoResultados, lblPodio;
	public JLabel lblPosicion1, lblPosicion2, lblPosicion3, lblPosicion4, lblPosicion5, lblPosicion6, lblPosicion7, lblPosicion8, lblPosicion9, lblPosicion10;
	public JLabel lblVotos1, lblVotos2, lblVotos3, lblVotos4, lblVotos5, lblVotos6, lblVotos7, lblVotos8, lblVotos9, lblVotos10;
	public JLabel lblNombreCantante1, lblNombreCantante2, lblNombreCantante3, lblNombreCantante4, lblNombreCantante5, lblNombreCantante6, lblNombreCantante7, lblNombreCantante8, lblNombreCantante9, lblNombreCantante10;
	public JLabel lblBandera1, lblBandera2, lblBandera3, lblBandera4, lblBandera5, lblBandera6, lblBandera7, lblBandera8, lblBandera9, lblBandera10;
	public JLabel lblFotoCantante1, lblFotoCantante2, lblFotoCantante3;
	public JButton btnInicio;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					Controlador controlador = new Controlador(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 680);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		resultadosPane = new JPanel();
		resultadosPane.setBounds(0, 0, 906, 643);
		resultadosPane.setVisible(false);
		
		inicioPane = new JPanel();
		inicioPane.setBounds(0, 0, 906, 643);
		mainPane.add(inicioPane);
		inicioPane.setLayout(null);
		inicioPane.setLayout(null);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		btnInicio.setBounds(350, 193, 209, 86);
		inicioPane.add(btnInicio);
		
		lblFondoInicio = new JLabel("");
		lblFondoInicio.setIcon(new ImageIcon(Vista.class.getResource("/img/FondoInicio.jpg")));
		lblFondoInicio.setBounds(0, 0, 906, 643);
		inicioPane.add(lblFondoInicio);
		mainPane.add(resultadosPane);
		resultadosPane.setLayout(null);
		
		cuartoPane = new JPanel();
		cuartoPane.setBounds(40, 388, 250, 75);
		resultadosPane.add(cuartoPane);
		cuartoPane.setLayout(null);
		
		lblPosicion4 = new JLabel("4.");
		lblPosicion4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion4.setBounds(10, 10, 23, 53);
		cuartoPane.add(lblPosicion4);
		
		lblVotos4 = new JLabel("452");
		lblVotos4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos4.setBounds(207, 9, 32, 56);
		cuartoPane.add(lblVotos4);
		
		lblNombreCantante4 = new JLabel("Nombre4");
		lblNombreCantante4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante4.setBounds(94, 10, 103, 54);
		cuartoPane.add(lblNombreCantante4);
		
		lblBandera4 = new JLabel("");
		lblBandera4.setIcon(new ImageIcon(Vista.class.getResource("/img/BAlemania.png")));
		lblBandera4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera4.setBounds(39, 21, 45, 30);
		cuartoPane.add(lblBandera4);
		
		septimoPane = new JPanel();
		septimoPane.setLayout(null);
		septimoPane.setBounds(40, 473, 250, 75);
		resultadosPane.add(septimoPane);
		
		lblPosicion7 = new JLabel("7.");
		lblPosicion7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion7.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion7.setBounds(10, 10, 23, 53);
		septimoPane.add(lblPosicion7);
		
		lblVotos7 = new JLabel("452");
		lblVotos7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos7.setBounds(207, 9, 32, 56);
		septimoPane.add(lblVotos7);
		
		lblNombreCantante7 = new JLabel("Nombre7");
		lblNombreCantante7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante7.setBounds(94, 10, 103, 54);
		septimoPane.add(lblNombreCantante7);
		
		lblBandera7 = new JLabel("");
		lblBandera7.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera7.setBounds(39, 21, 45, 30);
		septimoPane.add(lblBandera7);
		
		quintoPane = new JPanel();
		quintoPane.setLayout(null);
		quintoPane.setBounds(328, 388, 250, 75);
		resultadosPane.add(quintoPane);
		
		lblPosicion5 = new JLabel("5.");
		lblPosicion5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion5.setBounds(10, 10, 23, 53);
		quintoPane.add(lblPosicion5);
		
		lblVotos5 = new JLabel("452");
		lblVotos5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos5.setBounds(207, 9, 32, 56);
		quintoPane.add(lblVotos5);
		
		lblNombreCantante5 = new JLabel("Nombre5");
		lblNombreCantante5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante5.setBounds(94, 10, 103, 54);
		quintoPane.add(lblNombreCantante5);
		
		lblBandera5 = new JLabel("");
		lblBandera5.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera5.setBounds(39, 21, 45, 30);
		quintoPane.add(lblBandera5);
		
		octavoPane = new JPanel();
		octavoPane.setLayout(null);
		octavoPane.setBounds(328, 473, 250, 75);
		resultadosPane.add(octavoPane);
		
		lblPosicion8 = new JLabel("8.");
		lblPosicion8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion8.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion8.setBounds(10, 10, 23, 53);
		octavoPane.add(lblPosicion8);
		
		lblVotos8 = new JLabel("452");
		lblVotos8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos8.setBounds(207, 9, 32, 56);
		octavoPane.add(lblVotos8);
		
		lblNombreCantante8 = new JLabel("Nombre8");
		lblNombreCantante8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante8.setBounds(94, 10, 103, 54);
		octavoPane.add(lblNombreCantante8);
		
		lblBandera8 = new JLabel("");
		lblBandera8.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera8.setBounds(39, 21, 45, 30);
		octavoPane.add(lblBandera8);
		
		novenoPane = new JPanel();
		novenoPane.setLayout(null);
		novenoPane.setBounds(619, 473, 250, 75);
		resultadosPane.add(novenoPane);
		
		lblPosicion9 = new JLabel("9.");
		lblPosicion9.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion9.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion9.setBounds(10, 10, 23, 53);
		novenoPane.add(lblPosicion9);
		
		lblVotos9 = new JLabel("452");
		lblVotos9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos9.setBounds(207, 9, 32, 56);
		novenoPane.add(lblVotos9);
		
		lblNombreCantante9 = new JLabel("Nombre9");
		lblNombreCantante9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante9.setBounds(94, 10, 103, 54);
		novenoPane.add(lblNombreCantante9);
		
		lblBandera9 = new JLabel("");
		lblBandera9.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera9.setBounds(39, 21, 45, 30);
		novenoPane.add(lblBandera9);
		
		decimoPane = new JPanel();
		decimoPane.setLayout(null);
		decimoPane.setBounds(40, 558, 250, 75);
		resultadosPane.add(decimoPane);
		
		lblPosicion10 = new JLabel("10.");
		lblPosicion10.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion10.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion10.setBounds(0, 10, 45, 53);
		decimoPane.add(lblPosicion10);
		
		lblVotos10 = new JLabel("452");
		lblVotos10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos10.setBounds(207, 9, 32, 56);
		decimoPane.add(lblVotos10);
		
		lblNombreCantante10 = new JLabel("Nombre10");
		lblNombreCantante10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante10.setBounds(94, 10, 103, 54);
		decimoPane.add(lblNombreCantante10);
		
		lblBandera10 = new JLabel("");
		lblBandera10.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera10.setBounds(39, 21, 45, 30);
		decimoPane.add(lblBandera10);
		
		sextoPane = new JPanel();
		sextoPane.setLayout(null);
		sextoPane.setBounds(619, 388, 250, 75);
		resultadosPane.add(sextoPane);
		
		lblPosicion6 = new JLabel("6.");
		lblPosicion6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion6.setBounds(10, 10, 23, 53);
		sextoPane.add(lblPosicion6);
		
		lblVotos6 = new JLabel("452");
		lblVotos6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos6.setBounds(207, 9, 32, 56);
		sextoPane.add(lblVotos6);
		
		lblNombreCantante6 = new JLabel("Nombre6");
		lblNombreCantante6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante6.setBounds(94, 10, 103, 54);
		sextoPane.add(lblNombreCantante6);
		
		lblBandera6 = new JLabel("");
		lblBandera6.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera6.setBounds(39, 21, 45, 30);
		sextoPane.add(lblBandera6);
		
		lblPosicion3 = new JLabel("3");
		lblPosicion3.setForeground(new Color(205, 133, 63));
		lblPosicion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPosicion3.setBounds(673, 343, 48, 35);
		resultadosPane.add(lblPosicion3);
		
		lblPosicion2 = new JLabel("2");
		lblPosicion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion2.setForeground(new Color(192, 192, 192));
		lblPosicion2.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblPosicion2.setBounds(192, 325, 48, 35);
		resultadosPane.add(lblPosicion2);
		
		lblPosicion1 = new JLabel("1");
		lblPosicion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion1.setForeground(new Color(255, 215, 0));
		lblPosicion1.setFont(new Font("Times New Roman", Font.BOLD, 78));
		lblPosicion1.setBounds(430, 288, 48, 57);
		resultadosPane.add(lblPosicion1);
		
		lblPodio = new JLabel("");
		lblPodio.setIcon(new ImageIcon(Vista.class.getResource("/img/Podio.png")));
		lblPodio.setBounds(98, 221, 714, 158);
		resultadosPane.add(lblPodio);
		
		lblNombreCantante1 = new JLabel("Nombre1");
		lblNombreCantante1.setForeground(new Color(255, 255, 255));
		lblNombreCantante1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante1.setBounds(398, 12, 103, 35);
		resultadosPane.add(lblNombreCantante1);
		
		lblBandera1 = new JLabel("");
		lblBandera1.setIcon(new ImageIcon(Vista.class.getResource("/img/BEspaña.png")));
		lblBandera1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera1.setBounds(501, 14, 45, 30);
		resultadosPane.add(lblBandera1);
		
		lblVotos1 = new JLabel("452");
		lblVotos1.setForeground(new Color(255, 255, 255));
		lblVotos1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos1.setBounds(366, 1, 32, 56);
		resultadosPane.add(lblVotos1);
		
		lblFotoCantante1 = new JLabel("");
		lblFotoCantante1.setIcon(new ImageIcon(Vista.class.getResource("/img/Gianmarco.jpg")));
		lblFotoCantante1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoCantante1.setBounds(366, 52, 180, 180);
		resultadosPane.add(lblFotoCantante1);
		
		lblFotoCantante2 = new JLabel("");
		lblFotoCantante2.setIcon(new ImageIcon(Vista.class.getResource("/img/CuadradoPrueba.png")));
		lblFotoCantante2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoCantante2.setBounds(127, 100, 180, 180);
		resultadosPane.add(lblFotoCantante2);
		
		lblFotoCantante3 = new JLabel("");
		lblFotoCantante3.setIcon(new ImageIcon(Vista.class.getResource("/img/CuadradoPrueba.png")));
		lblFotoCantante3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoCantante3.setBounds(603, 133, 180, 180);
		resultadosPane.add(lblFotoCantante3);
		
		lblNombreCantante2 = new JLabel("Nombre2");
		lblNombreCantante2.setForeground(new Color(255, 255, 255));
		lblNombreCantante2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante2.setBounds(162, 55, 103, 35);
		resultadosPane.add(lblNombreCantante2);
		
		lblVotos2 = new JLabel("452");
		lblVotos2.setForeground(new Color(255, 255, 255));
		lblVotos2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos2.setBounds(135, 44, 32, 56);
		resultadosPane.add(lblVotos2);
		
		lblBandera2 = new JLabel("");
		lblBandera2.setIcon(new ImageIcon(Vista.class.getResource("/img/BHolanda.png")));
		lblBandera2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera2.setBounds(262, 58, 45, 30);
		resultadosPane.add(lblBandera2);
		
		lblBandera3 = new JLabel("");
		lblBandera3.setIcon(new ImageIcon(Vista.class.getResource("/img/BInglaterra.png")));
		lblBandera3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera3.setBounds(738, 93, 45, 30);
		resultadosPane.add(lblBandera3);
		
		lblNombreCantante3 = new JLabel("Nombre3");
		lblNombreCantante3.setForeground(new Color(255, 255, 255));
		lblNombreCantante3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCantante3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreCantante3.setBounds(638, 93, 103, 35);
		resultadosPane.add(lblNombreCantante3);
		
		lblVotos3 = new JLabel("452");
		lblVotos3.setForeground(new Color(255, 255, 255));
		lblVotos3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVotos3.setBounds(603, 82, 32, 56);
		resultadosPane.add(lblVotos3);
		
		lblFondoResultados = new JLabel("");
		lblFondoResultados.setIcon(new ImageIcon(Vista.class.getResource("/img/FondoResultados.jpg")));
		lblFondoResultados.setBounds(0, 0, 906, 643);
		resultadosPane.add(lblFondoResultados);
	}
}
