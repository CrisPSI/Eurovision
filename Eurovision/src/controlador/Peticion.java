package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import per.Cantantes;

public class Peticion extends Thread {

	Socket socket;
	public Peticion(Socket socket) {
		this.socket = socket;
	}
	
	private void calcular() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		
		SessionFactory sessionFactory = null;
		
		List<Cantantes> clasificacion = new ArrayList<Cantantes>();

		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

		
			int votosEspaña = Integer.parseInt(br.readLine());
			int votosAlemania = Integer.parseInt(br.readLine());
			int votosFrancia = Integer.parseInt(br.readLine());
			int votosItalia = Integer.parseInt(br.readLine());
			int votosPortugal = Integer.parseInt(br.readLine());
			int votosReinoUnido = Integer.parseInt(br.readLine());
			int votosPolonia = Integer.parseInt(br.readLine());
			int votosPaisesBajos = Integer.parseInt(br.readLine());
			int votosRumania = Integer.parseInt(br.readLine());
			int votosGrecia = Integer.parseInt(br.readLine());
			
			try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			
				Session session = null;
				
				try {
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					//España
					
					Query query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Espania");
					Cantantes cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosEspaña);
					
					session.saveOrUpdate(cantante);
										
					//Alemania
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Alemania");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosAlemania);
					
					session.saveOrUpdate(cantante);
					
					//Francia
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Francia");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosFrancia);
					
					session.saveOrUpdate(cantante);
					
					//Italia
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Italia");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosItalia);
					
					session.saveOrUpdate(cantante);
					
					//Portugal
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Portugal");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosPortugal);
					
					session.saveOrUpdate(cantante);
					
					//Reino Unido
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Reino Unido");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosReinoUnido);
					
					session.saveOrUpdate(cantante);
					
					//Polonia
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Polonia");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosPolonia);
					
					session.saveOrUpdate(cantante);
					
					//Paises Bajos
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Paises Bajos");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosPaisesBajos);
					
					session.saveOrUpdate(cantante);
					
					//Rumania
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Rumania");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosRumania);
					
					session.saveOrUpdate(cantante);
					
					//Grecia
					
					query = session.createQuery("FROM Cantantes WHERE pais = :pais");
					query.setParameter("pais", "Grecia");
					cantante = (Cantantes) query.getSingleResult();
					
					cantante.setNumVotos(votosGrecia);
					
					session.saveOrUpdate(cantante);
					
					session.getTransaction().commit();

					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					query = session.createQuery("FROM Cantantes ORDER BY num_votos DESC");
					clasificacion = query.list();
										
					os = socket.getOutputStream();
					pw = new PrintWriter(os);
					
					for(int i=0; i<clasificacion.size(); i++) {
						pw.write(clasificacion.get(i).getPais() + "\n");
						pw.write(clasificacion.get(i).getNumVotos() + "\n");
					}
					
					pw.flush();
							
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
				
			}catch(Exception e) {
				e.printStackTrace();
				if(sessionFactory != null) {
					sessionFactory.close();
				}
			}
		
			
		}catch(IOException e) {
			e.printStackTrace();			
		}finally {
			close(is);
			close(isr);
			close(br);
			close(os);
			close(pw);
			try {
				if(socket != null) {
					socket.close();
				}
			}catch(IOException e) {
					e.printStackTrace();
				
			}
		}
	}
		
	
	private void close(InputStream input) {
		try {
			if (null != input) {
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Reader reader) {
		try {
			if (null != reader) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close(OutputStream output) {
		try {
			if (null != output) {
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Writer writer) {
		try {
			if (null != writer) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		calcular();
	}
}

