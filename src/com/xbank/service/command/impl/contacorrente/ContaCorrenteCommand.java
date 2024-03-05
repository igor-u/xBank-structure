package com.xbank.service.command.impl.contacorrente;

import java.util.Map;

import com.xbank.service.command.Command;
import com.xbank.service.interfaces.ContaCorrenteOperation;

abstract class ContaCorrenteCommand implements Command {
	
	protected ContaCorrenteOperation service;
	
	protected ContaCorrenteCommand(ContaCorrenteOperation service) {
		this.service = service;
	}
	
    @Override
    public abstract void executar(Map<String, Object> params);

}
