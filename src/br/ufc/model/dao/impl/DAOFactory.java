package br.ufc.model.dao.impl;

import br.ufc.infra.EMF.PU;
import br.ufc.model.dao.GenericDAO;

public class DAOFactory {

	private static PU persistenceUnit = PU.PRODUCTION_PU;

	public static <E> GenericDAO<E> createDAO(Class<E> classe) {

		return new GenericDAOImpl<E>(classe, DAOFactory.persistenceUnit);
	}

	public static void setPersistenceUnit(PU persistenceUnit) {

		DAOFactory.persistenceUnit = persistenceUnit;
	}

}
