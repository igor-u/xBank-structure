package com.xbank.service;

import java.util.Map;
import java.util.Optional;

import com.xbank.service.command.Command;
import com.xbank.service.command.factory.ContaPoupancaCommandFactory;
import com.xbank.service.command.operacao.OperacoesContaPoupanca;
import com.xbank.service.interfaces.ContaPoupancaOperation;

public class ContaPoupancaService {

	private ContaPoupancaOperation service;

	private ContaPoupancaService(ContaPoupancaOperation service) {
		this.service = service;
	}

	private static ContaPoupancaService instance;

	public static ContaPoupancaService getInstance(ContaPoupancaOperation service){
		if(instance==null){
			instance = new ContaPoupancaService(service);
		}
		return instance;
	}
	
	public void executar(OperacoesContaPoupanca operacao, Map<String, Object> params) {
		Optional<Command> command = ContaPoupancaCommandFactory.getInstance(service).getCommand(operacao);
		if(command.isPresent()){
			command.get().executar(params);
		}
		else{
			System.out.println("Command not found for the operation " + operacao);
		}

	}
	
}
