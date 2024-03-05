package com.xbank.service.command.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.xbank.service.command.Command;
import com.xbank.service.command.impl.contacorrente.Depositar;
import com.xbank.service.command.impl.contacorrente.Sacar;
import com.xbank.service.command.impl.contacorrente.Transferir;
import com.xbank.service.command.operacao.OperacoesContaCorrente;
import com.xbank.service.interfaces.ContaCorrenteOperation;

public class ContaCorrenteCommandFactory {

	private final ContaCorrenteOperation service;
	
	private static ContaCorrenteCommandFactory instance;
	
	private final Map<OperacoesContaCorrente, Command> commandMap;
	
    private ContaCorrenteCommandFactory(ContaCorrenteOperation service) {
        this.service = service;
        this.commandMap = initializeCommands();
    }

    public static ContaCorrenteCommandFactory getInstance(ContaCorrenteOperation service){
        if(instance==null){
            instance = new ContaCorrenteCommandFactory(service);
        }
        return instance;
    }

    private Map<OperacoesContaCorrente, Command> initializeCommands() {
        Map<OperacoesContaCorrente, Command> map = new HashMap<>();
        map.put(OperacoesContaCorrente.SACAR, new Sacar(service));
        map.put(OperacoesContaCorrente.DEPOSITAR, new Depositar(service));
        map.put(OperacoesContaCorrente.TRANSFERIR, new Transferir(service));
        return map;
    }

    public Optional<Command> getCommand(OperacoesContaCorrente operacoes) {
        Command command = commandMap.get(operacoes);
        return Optional.ofNullable(command);
    }
	
}
