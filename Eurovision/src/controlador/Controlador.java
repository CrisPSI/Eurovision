package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista;

public class Controlador implements ActionListener{
	Vista vista = new Vista();
	
	public Controlador (Vista frame) {
		vista = frame;
		
		this.vista.btnInicio.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.vista.btnInicio) {
			this.vista.inicioPane.setVisible(false);
			this.vista.resultadosPane.setVisible(true);
		}
	}

}
