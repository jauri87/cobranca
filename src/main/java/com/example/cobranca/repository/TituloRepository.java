package com.example.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cobranca.model.Titulo;


public interface TituloRepository extends JpaRepository<Titulo, Long> {

}
