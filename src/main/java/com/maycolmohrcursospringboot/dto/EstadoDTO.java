package com.maycolmohrcursospringboot.dto;

import java.io.Serializable;

import com.maycolmohrcursospringboot.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public EstadoDTO() {
	}

	public EstadoDTO(Estado entity) {
		id = entity.getId();
		nome = entity.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}