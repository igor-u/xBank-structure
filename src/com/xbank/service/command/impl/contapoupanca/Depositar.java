package com.xbank.service.command.impl.contapoupanca;

import java.math.BigDecimal;
import java.util.Map;

import com.xbank.model.conta.Conta;
import com.xbank.service.interfaces.ContaPoupancaOperation;

public class Depositar extends ContaPoupancaCommand {

	public Depositar(ContaPoupancaOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
        BigDecimal valor = (BigDecimal) params.get("valor");
        Conta conta = (Conta) params.get("conta");
        service.depositar(valor, conta);

    }

}
