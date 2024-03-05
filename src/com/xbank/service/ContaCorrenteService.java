package com.xbank.service;

import java.util.Map;
import java.util.Optional;

import com.xbank.service.command.Command;
import com.xbank.service.command.factory.ContaCorrenteCommandFactory;
import com.xbank.service.command.operacao.OperacoesContaCorrente;
import com.xbank.service.interfaces.ContaCorrenteOperation;

public class ContaCorrenteService {

	private ContaCorrenteOperation service;

	private ContaCorrenteService(ContaCorrenteOperation service) {
		this.service = service;
	}

	private static ContaCorrenteService instance;

	public static ContaCorrenteService getInstance(ContaCorrenteOperation service){
		if(instance==null){
			instance = new ContaCorrenteService(service);
		}
		return instance;
	}
	
	public void executar(OperacoesContaCorrente operacao, Map<String, Object> params) {
		Optional<Command> command = ContaCorrenteCommandFactory.getInstance(service).getCommand(operacao);
		if(command.isPresent()){
			command.get().executar(params);
		}
		else{
			System.out.println("Command not found for the operation " + operacao);
		}

	}
	
}
