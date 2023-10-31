package jellal.mohamed.taller.modelo.repository;

import java.util.ArrayList;
import java.util.Iterator;

public class CocheRepository {

	// Singleton
	private CocheRepository() {
		llistaCoches = new ArrayList<jellal.mohamed.taller.modelo.domain.Coche>();
	}

	public static jellal.mohamed.taller.modelo.repository.CocheRepository getInstance() {
		if (instance == null) {
			instance = new jellal.mohamed.taller.modelo.repository.CocheRepository();
		}

		return instance;
	}

	private static jellal.mohamed.taller.modelo.repository.CocheRepository instance = null;
	// Fi Singleton

	private ArrayList<jellal.mohamed.taller.modelo.domain.Coche> llistaCoches;

	public void addCoche(jellal.mohamed.taller.modelo.domain.Coche coche) {
		llistaCoches.add(coche);

	}

	public int updateCoche(jellal.mohamed.taller.modelo.domain.Coche coche) {
		int resultat = 0;

		for (jellal.mohamed.taller.modelo.domain.Coche element : llistaCoches) {
			if (element.getMatricula().equals(coche.getMatricula()) ) {
				element.setModel(coche.getModel());
				resultat++;
				break;
			}
		}

		return resultat;
	}

	public int deleteCoche(String matricula) {
		int resultat = 0;

		Iterator<jellal.mohamed.taller.modelo.domain.Coche> iterador = llistaCoches.iterator();
		while (iterador.hasNext()) {
			jellal.mohamed.taller.modelo.domain.Coche element = iterador.next();
			if (element.getMatricula().equals(matricula)) {
				llistaCoches.remove(element);
				resultat++;
				break;
			}
		}

		return resultat;
	}

	public jellal.mohamed.taller.modelo.domain.Coche retornaUnCoche(String matricula) {
		jellal.mohamed.taller.modelo.domain.Coche resultat = null;

		for (jellal.mohamed.taller.modelo.domain.Coche element : llistaCoches) {
			if (element.getMatricula().equals(matricula) ) {
				resultat = element;
				break;
			}
		}

		if (resultat == null) {
			throw new RuntimeException("No hi ha cap Coche amb la matricula " + matricula);
		}

		return resultat;
	}

	public ArrayList<jellal.mohamed.taller.modelo.domain.Coche> retornaTotsElsCoches() {
		return llistaCoches;
	}

}
