package com.fabio.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fabio.curso.boot.domain.Cargo;
import com.fabio.curso.boot.domain.Departamento;
import com.fabio.curso.boot.domain.Funcionario;
import com.fabio.curso.boot.domain.UF;
import com.fabio.curso.boot.service.CargoService;
import com.fabio.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success","Funcionario incluído com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	//essa anotação já coloca o retorno desse método na variável 'cargos'
	@ModelAttribute("cargos")
	public List<Cargo> listaCargos(){
		return cargoService.buscarTodos();
	}

	//essa anotação já coloca o retorno desse método na variável 'ufs'
	@ModelAttribute("ufs")
	public UF[] listaUfs(){
		return UF.values();
	}
}
