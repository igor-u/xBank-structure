package com.xbank.service.interfaces;

import java.math.BigDecimal;

import com.xbank.model.conta.Conta;

public interface ContaPoupancaOperation {

	public void depositar(BigDecimal valor, Conta conta);
	
	public void sacar(BigDecimal valor, Conta conta);

}
