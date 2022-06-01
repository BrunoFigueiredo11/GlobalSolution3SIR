package br.com.fiap.gs1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gs1.repositories.ViagemRepository;


@Controller
public class ViagemController {
	@Autowired
	private ViagemRepository viagemRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@GetMapping("/home")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("home");	
		return modelView;
	}
	
	@PostMapping("/viagem")
	public ModelAndView Criar(/*obj*/) {
		ModelAndView modelView = new ModelAndView("XXX");
	
	
		return modelView;
	}
}
