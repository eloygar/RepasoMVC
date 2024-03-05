package controlador;

import modelo.Logica;
import vista.VentanaEliminar;
import vista.VentanaInsertar;
import vista.VentanaListar;
import vista.VentanaPrincipal;
import vista.VentanaUpdate;


public class Principal {
	
	Logica miLogica;
//	VentanaPrincipal miVentanaPrincipal;
//	VentanaBuscar miVentanaBuscar;
//	VentanaRegistro miVentanaRegistro;
	Coordinador miCoordinador;
	
	
	VentanaInsertar miVentanaInsertar;
	
	VentanaListar miVentanaListar;
	
	VentanaEliminar miVentaEliminar;
	
	VentanaUpdate miVentanaUpdate;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Principal miPrincipal=new Principal();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		
		miVentanaInsertar = new VentanaInsertar();
		miVentanaListar = new VentanaListar();
		miVentaEliminar = new VentanaEliminar();
		miVentanaUpdate = new VentanaUpdate();
//		
//		miVentanaPrincipal=new VentanaPrincipal();
//		miVentanaRegistro=new VentanaRegistro();
//		miVentanaBuscar= new VentanaBuscar();
		miLogica=new Logica();
		miCoordinador= new Coordinador();
		
		/*Se establecen las relaciones entre clases*/
		
		miVentanaInsertar.setCoordinador(miCoordinador);
		miVentanaListar.setCoordinador(miCoordinador);
		miVentaEliminar.setCoordinador(miCoordinador);
		miVentanaUpdate.setCoordinador(miCoordinador);
		
		
//		miVentanaPrincipal.setCoordinador(miCoordinador);
//		miVentanaRegistro.setCoordinador(miCoordinador);
//		miVentanaBuscar.setCoordinador(miCoordinador);
		miLogica.setCoordinador(miCoordinador);
		
		/*Se establecen relaciones con la clase coordinador*/
		
		miCoordinador.setMiVentanaInsertar(miVentanaInsertar);
		miCoordinador.setMiVentanaListar(miVentanaListar);
		miCoordinador.setMiVentanaEliminar(miVentaEliminar);
		miCoordinador.setMiVentanaUpdate(miVentanaUpdate);
		
//		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
//		miCoordinador.setMiVentanaRegistro(miVentanaRegistro);
//		miCoordinador.setMiVentanaBuscar(miVentanaBuscar);
		miCoordinador.setMiLogica(miLogica);
		

		miVentanaInsertar.setVisible(false);
		miVentanaListar.setVisible(false);
		miVentaEliminar.setVisible(false);
		miVentanaUpdate.setVisible(true);
	
//		miVentanaPrincipal.setVisible(true);
	}

}
