package com.xbank.controller;

import com.xbank.model.conta.Conta;
import com.xbank.repository.ContaRepository;

public class ContaController {
	
	private ContaRepository repository;

	private ContaController(ContaRepository repository) {
		this.repository = repository;
	}

	private static ContaController instance;

	public static ContaController getInstance(ContaRepository repository){
		if(instance==null){
			instance = new ContaController(repository);
		}
		return instance;
	}

	public void inserir(Conta conta) {
		repository.inserir(conta);
	}
	
	public void excluir(int numeroConta) {
		repository.excluir(numeroConta);
	}
	
}
