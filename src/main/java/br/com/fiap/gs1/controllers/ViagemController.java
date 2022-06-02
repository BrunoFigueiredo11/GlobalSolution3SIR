package br.com.fiap.gs1.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gs1.dtos.ViagemDto;
import br.com.fiap.gs1.models.Viagem;
import br.com.fiap.gs1.repositories.ViagemRepository;

@Controller
public class ViagemController {
	@Autowired
	private ViagemRepository viagemRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/home")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("/home");

		List<Viagem> viagemDaRepository = viagemRepository.findAll();
		modelView.addObject("listarViagem", viagemDaRepository);

		return modelView;
	}

	@GetMapping("/cadastro")
	public ModelAndView cadastro(ViagemDto viagemDto) {
		return new ModelAndView("viagem/cadastro");
	}

	@PostMapping("cadastrar")
	public ModelAndView salvar(@Valid ViagemDto viagemDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("viagem/cadastro");
		}

		Viagem viagemEntity = modelMapper.map(viagemDto, Viagem.class);
		viagemRepository.save(viagemEntity);
		return new ModelAndView("redirect:/home");
	}

	@GetMapping("/viagem/{id}/delete")
	public ModelAndView deletar(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("redirect:/home");

		this.viagemRepository.deleteById(id);
		return model;
	}

	@GetMapping("/viagem/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, ViagemDto request) {
		Optional<Viagem> optionalViagem = viagemRepository.findById(id);

		if (optionalViagem.isPresent()) {
			Viagem viagem = optionalViagem.get();
			request.fromViagem(viagem);
			ModelAndView model = new ModelAndView("viagem/edit");
			model.addObject("viagemId", viagem.getId());
			return model;
		}

		//
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/viagem/{id}")
	public ModelAndView update(@PathVariable Long id, @Valid ViagemDto request, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("viagem/edit");
			model.addObject("viagemId", id);
			return model;
		}
		
		Optional<Viagem> optionalViagem = viagemRepository.findById(id);
		
		if(optionalViagem.isPresent()){
			Viagem viagem = modelMapper.map(request, Viagem.class);
			viagem.setId(id);
			viagemRepository.save(viagem);
			return new ModelAndView("redirect:/home");
		}
		
		return new ModelAndView("redirect:/viagem");
	}

}
