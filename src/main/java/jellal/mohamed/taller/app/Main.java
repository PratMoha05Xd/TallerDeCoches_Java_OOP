package jellal.mohamed.taller.app;

import jellal.mohamed.taller.controller.CocheController;

public class Main {

	public static void main(String[] args) {

		CocheController cocheController = CocheController.getInstance();
		cocheController.mostraSeparador("ALTA COCHE");
		cocheController.altaCoche();
		cocheController.mostraSeparador("ALTA COCHE");
		cocheController.altaCoche();
		cocheController.mostraSeparador("DEMANAR TOTS ELS COCHES");
		cocheController.demanaTotsElsCoches();
		cocheController.mostraSeparador("CERCAR UN COCHE PER MATRICULA");
		cocheController.demanaUnCoche();
		cocheController.mostraSeparador("MODIFICAR UN COCHE");
		cocheController.modificaCoche();
		cocheController.mostraSeparador("DEMANAR TOTS ELS COCHES");
		cocheController.demanaTotsElsCoches();
		cocheController.mostraSeparador("ELIMINAR UN COCHE");
		cocheController.eliminaCoche();
		cocheController.mostraSeparador("DEMANAR TOTS ELS COCHES");
		cocheController.demanaTotsElsCoches();
	}

}
