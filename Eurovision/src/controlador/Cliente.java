package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Thread{

	int edad;
	String voto;
	
	public Cliente(int edad) {
		this.edad = edad;
	}
	
	@Override
	public void run() {
		
		int random = (int)(1+(Math.random()*100));

		if(edad==3) {
			if(random<=7) {
				voto="España";
			}else if(random>=8 && random<=10){
				voto="Alemania";
			}else if(random>=11 && random<=23) {
				voto="Francia";
			}else if(random>=24 && random<=30) {
				voto="Italia";
			}else if(random>=31 && random<=37) {
				voto="Portugal";
			}else if(random>=38 && random<=51) {
				voto="Reino Unido";
			}else if(random>=52 && random<=61) {
				voto="Polonia";
			}else if(random>=62 && random<=88) {
				voto="Paises Bajos";
			}else if(random>=89 && random<=95) {
				voto="Rumania";
			}else {
				voto="Grecia";
			}
		}else if(edad==4) {
			if(random<=14) {
				voto="España";
			}else if(random>=15 && random<=20){
				voto="Alemania";
			}else if(random>=21 && random<=33) {
				voto="Francia";
			}else if(random>=34 && random<=40) {
				voto="Italia";
			}else if(random>=41 && random<=46) {
				voto="Portugal";
			}else if(random>=47 && random<=58) {
				voto="Reino Unido";
			}else if(random>=59 && random<=65) {
				voto="Polonia";
			}else if(random>=66 && random<=81) {
				voto="Paises Bajos";
			}else if(random>=82 && random<=90) {
				voto="Rumania";
			}else {
				voto="Grecia";
			}
		}else if(edad==5) {
			if(random<=5) {
				voto="España";
			}else if(random>=6 && random<=15){
				voto="Alemania";
			}else if(random>=16 && random<=27) {
				voto="Fracia";
			}else if(random>=28 && random<=33) {
				voto="Italia";
			}else if(random>=34 && random<=40) {
				voto="Portugal";
			}else if(random>=41 && random<=54) {
				voto="Reino Unido";
			}else if(random>=55 && random<=61) {
				voto="Polonia";
			}else if(random>=62 && random<=71) {
				voto="Paises Bajos";
			}else if(random>=72 && random<=88) {
				voto="Rumania";
			}else {
				voto="Grecia";
			}
		}else if(edad==6) {
			if(random<=3) {
				voto="España";
			}else if(random>=4 && random<=20){
				voto="Alemania";
			}else if(random>=21 && random<=25) {
				voto="Francia";
			}else if(random>=26 && random<=37) {
				voto="Italia";
			}else if(random>=38 && random<=49) {
				voto="Portugal";
			}else if(random>=50 && random<=58) {
				voto="Reino Unido";
			}else if(random>=59 && random<=65) {
				voto="Polonia";
			}else if(random>=66 && random<=76) {
				voto="Paises Bajos";
			}else if(random>=77 && random<=91) {
				voto="Rumania";
			}else {
				voto="Grecia";
			}
		}
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	

}
