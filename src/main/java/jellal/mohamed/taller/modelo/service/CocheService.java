package jellal.mohamed.taller.modelo.service;

import java.util.ArrayList;

public class CocheService {

	// Singleton
	private CocheService() {

	}

	public static CocheService getInstance() {
		if (instance == null) {
			instance = new CocheService();
		}

		return instance;
	}

	private static CocheService instance = null;
	// Fin Singleton

	jellal.mohamed.taller.modelo.repository.CocheRepository cocheRepository = jellal.mohamed.taller.modelo.repository.CocheRepository.getInstance();

	public void addCoche(jellal.mohamed.taller.modelo.domain.Coche coche) {
		validaMatricula(coche.getMatricula());
		validaModel(coche.getModel());

		cocheRepository.addCoche(coche);
	}

	public int updateCoche(jellal.mohamed.taller.modelo.domain.Coche coche) {
		validaMatricula(coche.getMatricula());
		validaModel(coche.getModel());

		return cocheRepository.updateCoche(coche);
	}

	public int deleteCoche(String matricula) {
		validaMatricula(matricula);

		return cocheRepository.deleteCoche(matricula);
	}

	public jellal.mohamed.taller.modelo.domain.Coche retornaUnCoche(String matricula) {
		validaMatricula(matricula);

		return cocheRepository.retornaUnCoche(matricula);
	}

	public ArrayList<jellal.mohamed.taller.modelo.domain.Coche> retornaTotsElsCoches() {
		return cocheRepository.retornaTotsElsCoches();
	}

	private void validaModel(String model) {
		String[] parts = model.split(" ");
		if (parts.length == 2) {
		} else {
			throw new RuntimeException("Error: El modelo debe constar de dos palabras y tener un espacio en blanco.");
		}
	}

	private void validaMatricula(String matricula) {
		if (matricula.length() <= 6) {
			throw new RuntimeException("Error: La matrícula debe constar de 7 caracteres.");
		}
	}
}
