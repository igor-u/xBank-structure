package com.xbank.service.interfaces.impl;

import java.math.BigDecimal;

import com.xbank.model.conta.Conta;
import com.xbank.service.interfaces.ContaPoupancaOperation;

public class ContaPoupancaOperationImpl implements ContaPoupancaOperation {
	
	private static final ContaPoupancaOperationImpl instance = new ContaPoupancaOperationImpl();

	private ContaPoupancaOperationImpl() {

	}

	public static ContaPoupancaOperationImpl getInstance(){
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

}
