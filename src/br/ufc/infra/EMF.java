package br.ufc.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

	public static String PRODUCTION_PU = "SigaaJSF";
	public static String TEST_PU = "TestSigaaJSF";

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
