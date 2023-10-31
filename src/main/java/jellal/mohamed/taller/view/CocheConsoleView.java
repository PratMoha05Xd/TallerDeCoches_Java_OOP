package jellal.mohamed.taller.view;

import java.util.ArrayList;

import jellal.mohamed.taller.modelo.domain.Coche;

public class CocheConsoleView extends BaseConsoleView {

	// Singleton
	private CocheConsoleView() {
	}

	public static CocheConsoleView getInstance() {
		if (instance == null) {
			instance = new CocheConsoleView();
		}
		return instance;
	}

	private static CocheConsoleView instance = null;
	// Fi Singleton

	public Coche getData() {
		Coche coche = new Coche();

		coche.setMatricula(this.getMatriculaCoche());
		coche.setModel(this.getModelCoche());
		return coche;
	}
	public String getMatriculaCoche() {
		return this.getString("Introduce la matricula del coche:");

	}

	public String getModelCoche() {
		return this.getString("Introduce el modelo del coche");
	}

	public void mostrarDades(ArrayList<Coche> coches) {
		if (coches != null) {
			for (Coche c : coches) {
				mostrarDades(c);
			}
		}
	}

	public void mostrarDades(Coche coche) {
		System.out.println(coche.toString());
	}

}
