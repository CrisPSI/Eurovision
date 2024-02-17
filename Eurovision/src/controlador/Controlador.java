package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import per.PorcentajesRangoedad;
import per.Votante;
import vista.Vista;

public class Controlador implements ActionListener{
	Vista vista = new Vista();
	int[][] tablaPorcentajes;
	static List<String> clasificacionPais = new ArrayList<>();
	static List<Integer> clasificacionVotos = new ArrayList<>();
	int id = 0;
	public Controlador (Vista frame) {
		vista = frame;
		this.vista.btnInicio.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.vista.btnInicio) {
			
			SessionFactory sessionFactory = null;
			
			try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
				
				tablaPorcentajes = crearTablaPorcentajes(sessionFactory);

				int votosEspaña=0, votosAlemania=0, votosFrancia=0, votosItalia=0, votosPortugal=0, votosReinoUnido=0, votosPolonia=0, votosPaisesBajos=0, votosRumania=0, votosGrecia=0;

				
				for(int i=0; i<10; i++) {
					for(int j=3; j<7; j++) {
						
						double totalHabitantes = tablaPorcentajes[0][i];
						double porcentajeVotos = tablaPorcentajes[j][i]/100;
						int numVotos = (int)((totalHabitantes*porcentajeVotos)/500000);
						
						if(numVotos < 3) {
							numVotos = 3;
						}
							
						for(int k=0; k<numVotos; k++) {
							Cliente votante = new Cliente(j);
						
							votante.start();
							
							crearVotante(sessionFactory, votante, id);
							
							id++;
							
							if(votante.getVoto().equals("España")){
								votosEspaña++;
							}else if(votante.getVoto().equals("Alemania")) {
								votosAlemania++;
							}else if(votante.getVoto().equals("Francia")) {
								votosFrancia++;
							}else if(votante.getVoto().equals("Italia")) {
								votosItalia++;
							}else if(votante.getVoto().equals("Portugal")) {
								votosPortugal++;
							}else if(votante.getVoto().equals("Reino Unido")) {
								votosReinoUnido++;
							}else if(votante.getVoto().equals("Polonia")) {
								votosPolonia++;
							}else if(votante.getVoto().equals("Paises Bajos")) {
								votosPaisesBajos++;
							}else if(votante.getVoto().equals("Rumania")) {
								votosRumania++;
							}else if(votante.getVoto().equals("Grecia")) {
								votosGrecia++;
							}
						}
					}
				}
				
			enviarAlServidor(votosEspaña, votosAlemania, votosFrancia, votosItalia, votosPortugal, votosReinoUnido, votosPolonia, votosPaisesBajos, votosRumania, votosGrecia);
				
			for(int i=0; i<10; i++) {
				String lblBandera = ("lblBandera" + (i+1));
				JLabel lbl = (JLabel) vista.getClass().getDeclaredField(lblBandera).get(vista);
				if(clasificacionPais.get(i).equals("Espania")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BEspaña.png")));
				}else if(clasificacionPais.get(i).equals("Alemania")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BAlemania.png")));
				}else if(clasificacionPais.get(i).equals("Francia")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BFrancia.png")));
				}else if(clasificacionPais.get(i).equals("Italia")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BItalia.png")));
				}else if(clasificacionPais.get(i).equals("Portugal")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BPortugal.png")));
				}else if(clasificacionPais.get(i).equals("Reino Unido")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BInglaterra.png")));
				}else if(clasificacionPais.get(i).equals("Polonia")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BPolonia.png")));
				}else if(clasificacionPais.get(i).equals("Paises Bajos")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BHolanda.png")));
				}else if(clasificacionPais.get(i).equals("Rumania")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BRumania.png")));
				}else if(clasificacionPais.get(i).equals("Grecia")) {
					lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/BGrecia.png")));
				}
				
				String lblNombreCantante = ("lblNombreCantante" + (i+1));
				lbl = (JLabel) vista.getClass().getDeclaredField(lblNombreCantante).get(vista);
				if(clasificacionPais.get(i).equals("Espania")) {
					lbl.setText("Joel");
				}else if(clasificacionPais.get(i).equals("Alemania")) {
					lbl.setText("Hilda");
				}else if(clasificacionPais.get(i).equals("Francia")) {
					lbl.setText("Bastian");
				}else if(clasificacionPais.get(i).equals("Italia")) {
					lbl.setText("Gianmarco");
				}else if(clasificacionPais.get(i).equals("Portugal")) {
					lbl.setText("Matilde");
				}else if(clasificacionPais.get(i).equals("Reino Unido")) {
					lbl.setText("Hanna");
				}else if(clasificacionPais.get(i).equals("Polonia")) {
					lbl.setText("Paul");
				}else if(clasificacionPais.get(i).equals("Paises Bajos")) {
					lbl.setText("Dennis");
				}else if(clasificacionPais.get(i).equals("Rumania")) {
					lbl.setText("Amalia");
				}else if(clasificacionPais.get(i).equals("Grecia")) {
					lbl.setText("Orelle");
				}
				
				String lblVotos = ("lblVotos" + (i+1));
				lbl = (JLabel) vista.getClass().getDeclaredField(lblVotos).get(vista);
				lbl.setText(String.valueOf(clasificacionVotos.get(i)));
				
				if(i<3) {
					String lblFotoCantante = ("lblFotoCantante" + (i+1));
					lbl = (JLabel) vista.getClass().getDeclaredField(lblFotoCantante).get(vista);
					if(clasificacionPais.get(i).equals("Espania")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Joel.jpg")));
					}else if(clasificacionPais.get(i).equals("Alemania")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Hilda.jpg")));
					}else if(clasificacionPais.get(i).equals("Francia")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Bastian.jpg")));
					}else if(clasificacionPais.get(i).equals("Italia")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Gianmarco.jpg")));
					}else if(clasificacionPais.get(i).equals("Portugal")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Matilde.jpg")));
					}else if(clasificacionPais.get(i).equals("Reino Unido")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Hanna.jpg")));
					}else if(clasificacionPais.get(i).equals("Polonia")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Paul.jpg")));
					}else if(clasificacionPais.get(i).equals("Paises Bajos")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Dennis.jpg")));
					}else if(clasificacionPais.get(i).equals("Rumania")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Amalia.jpg")));
					}else if(clasificacionPais.get(i).equals("Grecia")) {
						lbl.setIcon(new ImageIcon(Vista.class.getResource("/img/Orelle.jpg")));
					}
				}
			}
			
			this.vista.inicioPane.setVisible(false);
			this.vista.resultadosPane.setVisible(true);
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				if(sessionFactory != null) {
					sessionFactory.close();
				}
			}
		}
	}
	
	public static int[][] crearTablaPorcentajes(SessionFactory sessionFactory){
		int[][] tablaPorcentajes = new int[7][10];
		List<PorcentajesRangoedad> listaPorcentajes = new ArrayList <PorcentajesRangoedad>();

		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
						
			Query query = session.createQuery("FROM PorcentajesRangoedad");
			listaPorcentajes = query.list();
			
			for(int i=0; i<10; i++) {
				tablaPorcentajes[0][i] = listaPorcentajes.get(i).getTotalHabitantes();
				tablaPorcentajes[1][i] = listaPorcentajes.get(i).getRango19();
				tablaPorcentajes[2][i] = listaPorcentajes.get(i).getRango1017();
				tablaPorcentajes[3][i] = listaPorcentajes.get(i).getRango1825();
				tablaPorcentajes[4][i] = listaPorcentajes.get(i).getRango2640();
				tablaPorcentajes[5][i] = listaPorcentajes.get(i).getRango4165();
				tablaPorcentajes[6][i] = listaPorcentajes.get(i).getRangoMas66();
			}
		}catch(HibernateException e) {
			e.printStackTrace();
			if(session != null) {
				session.getTransaction().rollback();
			}
		}finally {
			session.close();
		}
		
		return tablaPorcentajes;
	}
	
	public static void crearVotante(SessionFactory sessionFactory, Cliente votante, int id) {
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			
			
			Votante nuevoVotante = new Votante(id, votante.getVoto());
			
			
			session.saveOrUpdate(nuevoVotante);
			
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			if(session != null) {
				session.getTransaction().rollback();
			}
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public static void enviarAlServidor(int votosEspaña, int votosAlemania, int votosFrancia, int votosItalia, int votosPortugal, int votosReinoUnido, int votosPolonia, int votosPaisesBajos, int votosRumania, int votosGrecia) {
		Socket socket = null;
		PrintWriter pw = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
			socket = new Socket();
			socket.connect(direccion);
			
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);
			
			pw.write(votosEspaña + "\n" + votosAlemania + "\n" + votosFrancia + "\n" + votosItalia + "\n" + votosPortugal + "\n" + votosReinoUnido + "\n" + votosPolonia + "\n" + votosPaisesBajos + "\n" + votosRumania + "\n" + votosGrecia + "\n");
			
			pw.flush();
			
			isr = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isr);
			
			for(int i = 0; i<10; i++) {
				clasificacionPais.add(br.readLine());
				System.out.println(clasificacionPais.get(i));
				clasificacionVotos.add(Integer.parseInt(br.readLine()));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			close(socket);
			close(pw);
		}
	}
	
	private static void close(Socket socket) {
		try {
			if (null != socket) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void close(Writer writer) {
		try {
			if (null != writer) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}