package com.fabio.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.fabio.curso.boot.domain.Cargo;
import com.fabio.curso.boot.domain.Funcinario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcinario, Long> implements FucionarioDao {

}
