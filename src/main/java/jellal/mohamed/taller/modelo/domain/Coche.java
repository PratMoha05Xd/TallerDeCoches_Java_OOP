package jellal.mohamed.taller.modelo.domain;


public class Coche {

	private String matricula;
	private String model;


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", model=" + model + "]";
	}

}
