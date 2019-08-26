package com.fabio.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fabio.curso.boot.domain.Cargo;
import com.fabio.curso.boot.domain.Departamento;
import com.fabio.curso.boot.service.CargoService;
import com.fabio.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@Autowired
	DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes redirectAttributes) {
		cargoService.salvar(cargo);
		redirectAttributes.addFlashAttribute("success","Cargo incluído com sucesso.");
		return "redirect:/cargos/cadastrar";
		
	}
	
	//essa anotação já coloca o retorno desse método na variável 'departamentos'
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamentos(){
		return departamentoService.buscarTodos();
	}
}
