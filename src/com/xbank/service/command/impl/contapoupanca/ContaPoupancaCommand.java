package com.xbank.service.command.impl.contapoupanca;

import java.util.Map;

import com.xbank.service.command.Command;
import com.xbank.service.interfaces.ContaPoupancaOperation;

abstract class ContaPoupancaCommand implements Command {
	
	protected ContaPoupancaOperation service;
	
	protected ContaPoupancaCommand(ContaPoupancaOperation service) {
		this.service = service;
	}
	
    @Override
    public abstract void executar(Map<String, Object> params);

}
