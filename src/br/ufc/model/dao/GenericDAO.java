package br.ufc.model.dao;

import java.util.Collection;

public interface GenericDAO<E> {

	public void add(E entity);

	public void remove(E entity);

	public void update(E entity);

	public Collection<E> all();

}
