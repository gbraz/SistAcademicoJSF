package br.ufc.model;

public enum Sexo {
	HOMEM("Homem"), MULHER("Mulher"), OUTRO("Outro");

	private String _asString;

	Sexo(String asString) {
		_asString = asString;
	}

	public String toString() {
		return _asString;
	}
}