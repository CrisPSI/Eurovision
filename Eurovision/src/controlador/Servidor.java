package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception{
		ServerSocket socketEscucha = null;
		
		try {
			socketEscucha = new ServerSocket(9876);
			System.out.println("Arrancando el servidor");
			
			while(true) {
				try {
					Socket conexion = socketEscucha.accept();
					Peticion hilo = new Peticion(conexion);
					
					Thread.sleep(2000);
					
					hilo.start();
				}catch(IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
			throw e;
		}finally {
			try {
				if(socketEscucha != null) {
					socketEscucha.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
