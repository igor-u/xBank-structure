package com.xbank.repository;

import com.xbank.model.conta.Conta;

public interface ContaRepository {
	
	public Conta inserir(Conta conta);
	
	public void excluir(long numeroConta);

}
