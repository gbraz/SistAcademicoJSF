package br.ufc.infra;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EMF {

	public static String PRODUCTION_PU = "SigaaJSF";
	public static String TEST_PU = "TestSigaaJSF";

	private static javax.persistence.EntityManagerFactory instance = null;
	private static String persistenceUnit = null;

	public static javax.persistence.EntityManagerFactory instance(String persistenceUnit) {

		if (instance == null || !persistenceUnit.equals(EMF.persistenceUnit)) {
			instance = Persistence.createEntityManagerFactory(persistenceUnit);
			EMF.persistenceUnit = persistenceUnit;
		}

		return instance;
	}

	public static EntityManager em(String persistenceUnit) {
		return EMF.instance(persistenceUnit).createEntityManager();
	}
}
