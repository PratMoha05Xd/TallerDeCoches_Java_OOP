package jellal.mohamed.taller.controller;

import java.util.ArrayList;

import jellal.mohamed.taller.modelo.domain.Coche;
import jellal.mohamed.taller.modelo.service.CocheService;
import jellal.mohamed.taller.view.CocheConsoleView;

public class CocheController {

	// Singleton
	private CocheController() {

	}

	public static jellal.mohamed.taller.controller.CocheController getInstance() {
		if (instance == null) {
			instance = new jellal.mohamed.taller.controller.CocheController();
		}

		return instance;
	}

	private static jellal.mohamed.taller.controller.CocheController instance = null;

	// Fi Singleton

	private CocheConsoleView cocheConsoleView = CocheConsoleView.getInstance();
	private CocheService cocheService = CocheService.getInstance();

	public void mostraSeparador(String missatge) {
		try {
			Thread.sleep(500);
			cocheConsoleView.mostrarMissatge(missatge, true);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			cocheConsoleView.mostrarMissatge(e.getMessage(), true);
		}

	}

	public void altaCoche() {

		try {
			Coche coche = cocheConsoleView.getData();
			cocheService.addCoche(coche);
			cocheConsoleView.mostrarMissatge("añadir Coche", false);
		} catch (Exception ex) {
			cocheConsoleView.mostrarMissatge(ex.getMessage(), true);
		}

	}

	public void modificaCoche() {

		try {
			String matricula = cocheConsoleView.getMatriculaCoche();
			Coche coche = cocheService.retornaUnCoche(matricula);
			String nomAModificar = cocheConsoleView.getModelCoche();
			coche.setModel(nomAModificar);
			int afectats = cocheService.updateCoche(coche);
			cocheConsoleView.mostrarMissatge(afectats + "Coches modificados", false);
		} catch (Exception ex) {
			cocheConsoleView.mostrarMissatge(ex.getMessage(), true);
		}

	}

	public void eliminaCoche() {

		try {
			String matricula = cocheConsoleView.getMatriculaCoche();
			Coche coche = cocheService.retornaUnCoche(String.valueOf(matricula));
			int afectats = cocheService.deleteCoche(coche.getMatricula());
			cocheConsoleView.mostrarMissatge(afectats + " coches eliminados", false);
		} catch (Exception ex) {
			cocheConsoleView.mostrarMissatge(ex.getMessage(), true);
		}

	}

	public void demanaUnCoche() {
		try {
			String matricula = cocheConsoleView.getMatriculaCoche();
			Coche coche = cocheService.retornaUnCoche(matricula);
			cocheConsoleView.mostrarMissatge(coche.toString(), false);
		} catch (Exception ex) {
			cocheConsoleView.mostrarMissatge(ex.getMessage(), true);
		}
	}

	public void demanaTotsElsCoches() {
		try {
			ArrayList<Coche> coches = cocheService.retornaTotsElsCoches();
			cocheConsoleView.mostrarDades(coches);
		} catch (Exception ex) {
			cocheConsoleView.mostrarMissatge(ex.getMessage(), true);
		}
	}

}
