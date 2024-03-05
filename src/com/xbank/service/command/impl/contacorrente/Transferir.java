package com.xbank.service.command.impl.contacorrente;

import java.math.BigDecimal;
import java.util.Map;

import com.xbank.model.conta.Conta;
import com.xbank.model.conta.ContaCorrente;
import com.xbank.service.interfaces.ContaCorrenteOperation;

public class Transferir extends ContaCorrenteCommand {
	
	public Transferir(ContaCorrenteOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
        BigDecimal valor = (BigDecimal) params.get("valor");
        ContaCorrente contaOrigem = (ContaCorrente) params.get("contaOrigem");
        Conta contaDestino = (Conta) params.get("contaDestino");
        service.transferir(valor, contaOrigem, contaDestino);

    }	

}
