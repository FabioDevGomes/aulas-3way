package com.fabio.curso.boot.dao;

import java.util.List;

import com.fabio.curso.boot.domain.Cargo;
import com.fabio.curso.boot.domain.Funcinario;

public interface FucionarioDao {
	
	void save(Funcinario funcinario);
	void update(Funcinario funcinario);
	void delete(Long id);
	Funcinario findById(Long id);
	List<Funcinario> findAll();

}
