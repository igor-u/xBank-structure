package com.xbank.service.command.impl.contacorrente;

import java.math.BigDecimal;
import java.util.Map;

import com.xbank.model.conta.Conta;
import com.xbank.service.interfaces.ContaCorrenteOperation;

public class Sacar extends ContaCorrenteCommand {

	public Sacar(ContaCorrenteOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
        BigDecimal valor = (BigDecimal) params.get("valor");
        Conta conta = (Conta) params.get("numeroConta");
        service.sacar(valor, conta);

    }	
}
