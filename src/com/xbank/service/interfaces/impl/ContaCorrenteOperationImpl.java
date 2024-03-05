package com.xbank.service.interfaces.impl;

import java.math.BigDecimal;

import com.xbank.model.conta.Conta;
import com.xbank.model.conta.ContaCorrente;
import com.xbank.service.interfaces.ContaCorrenteOperation;

public class ContaCorrenteOperationImpl implements ContaCorrenteOperation {

	private static final ContaCorrenteOperationImpl instance = new ContaCorrenteOperationImpl();

	private ContaCorrenteOperationImpl() {

	}

	public static ContaCorrenteOperationImpl getInstance(){
		return instance;
	}
	
	@Override
	public void depositar(BigDecimal valor, Conta conta) {
		conta.setSaldo(conta.getSaldo().add(valor));
	}

	@Override
	public void sacar(BigDecimal valor, Conta conta) {
		conta.setSaldo(conta.getSaldo().subtract(valor));
		
	}

	@Override
	public void transferir(BigDecimal valor, ContaCorrente contaOrigem, Conta contaDestino) {
		sacar(valor, contaOrigem);
		depositar(valor, contaDestino);
		
	}
	
}
