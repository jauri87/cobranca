package com.example.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobranca.model.StatusTitulo;
import com.example.cobranca.model.Titulo;
import com.example.cobranca.repository.TituloRepository;
import com.example.cobranca.service.TituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TituloService service;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView view = new ModelAndView("CadastroTitulo");
		view.addObject(new Titulo());
		return view;
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> titulos = service.listarTodos();
		ModelAndView view = new ModelAndView("PesquisaTitulo");
		view.addObject("titulos", titulos);
		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {
		

		ModelAndView view = new ModelAndView("CadastroTitulo");
		
		if(errors.hasErrors()) {
			return view;
			
		}

		service.save(titulo);
		view.addObject("mensagem", "Titulo salvo com sucesso!");

		return view;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());

	}

}
