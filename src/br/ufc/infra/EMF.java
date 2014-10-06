package br.ufc.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

	public enum PU {
		PRODUCTION_PU("SigaaJSF"), TEST_PU("TestSigaaJSF");

		private String _asString;

		PU(String puAsString) {
			this._asString = puAsString;
		}

		public String toString() {
			return this._asString;
		}

	}

	private static EntityManagerFactory instance = null;
	private static String persistenceUnit = null;

	public static EntityManagerFactory instance(String persistenceUnit) {

		if (instance == null || isOutraPersistenceUnit(persistenceUnit)) {
			instance = Persistence.createEntityManagerFactory(persistenceUnit);
			EMF.persistenceUnit = persistenceUnit;
		}

		return instance;
	}

	private static boolean isOutraPersistenceUnit(String persistenceUnit) {

		return !persistenceUnit.equals(EMF.persistenceUnit);
	}

	public static EntityManager em(String persistenceUnit) {

		return EMF.instance(persistenceUnit).createEntityManager();
	}
}
