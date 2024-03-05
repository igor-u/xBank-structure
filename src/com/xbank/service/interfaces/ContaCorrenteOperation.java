package com.xbank.service.interfaces;

import java.math.BigDecimal;

import com.xbank.model.conta.Conta;
import com.xbank.model.conta.ContaCorrente;

public interface ContaCorrenteOperation {
	
	public void depositar(BigDecimal valor, Conta conta);
	
	public void sacar(BigDecimal valor, Conta conta);

	public void transferir(BigDecimal valor, ContaCorrente contaOrigem, Conta contaDestino);

}
