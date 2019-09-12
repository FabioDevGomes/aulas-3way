package com.fabio.curso.boot.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fabio.curso.boot.domain.Cargo;
import com.fabio.curso.boot.domain.Departamento;
import com.fabio.curso.boot.service.CargoService;
import com.fabio.curso.boot.service.DepartamentoService;

@Component
public class StringToCargoConverter implements Converter<String, Cargo>{
	
	@Autowired
	CargoService service;

	@Override
	public Cargo convert(String texto) {
		if(texto.isEmpty()) {
			return null;
		}
//		Long id = Long.valueOf(texto);
		return service.buscarPorId(Long.valueOf(texto));
	}

}
