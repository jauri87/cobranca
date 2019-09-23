package com.example.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobranca.model.Titulo;
import com.example.cobranca.repository.TituloRepository;

@Service
public class TituloService {
	
	@Autowired
	private TituloRepository repository;
	
	public void save(Titulo titulo) {
		repository.save(titulo);
	}
	
	public List<Titulo> listarTodos() {
		return repository.findAll();
	}

}
