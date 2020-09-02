package net.nerddash.simpleauctionapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import net.nerddash.simpleauctionapi.model.ApiEntity;

public abstract class ApiServiceImpl<E extends ApiEntity, R extends JpaRepository<E, Long>> implements ApiService<E> {

	@Autowired
	protected R repository;

	@Override
	public E validate(E entity) throws Exception {
		return entity;
	}

	@Override
	public List<E> findExisting(E entity) {
		List<E> tList = new ArrayList<E>();
		tList.add(entity);
		return tList;
	}

	@Override
	public boolean shouldUpdate(E entity) {
		return true;
	}
	
	@Override
	public boolean shouldRead(E entity) {
		return true;
	}

}
