package com.xbank.service.command.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.xbank.service.command.Command;
import com.xbank.service.command.impl.contapoupanca.Depositar;
import com.xbank.service.command.impl.contapoupanca.Sacar;
import com.xbank.service.command.operacao.OperacoesContaPoupanca;
import com.xbank.service.interfaces.ContaPoupancaOperation;

public class ContaPoupancaCommandFactory {

	private final ContaPoupancaOperation service;
	
	private static ContaPoupancaCommandFactory instance;
	
	private final Map<OperacoesContaPoupanca, Command> commandMap;
	
    private ContaPoupancaCommandFactory(ContaPoupancaOperation service) {
        this.service = service;
        this.commandMap = initializeCommands();
    }

    public static ContaPoupancaCommandFactory getInstance(ContaPoupancaOperation service){
        if(instance==null){
            instance = new ContaPoupancaCommandFactory(service);
        }
        return instance;
    }

    private Map<OperacoesContaPoupanca, Command> initializeCommands() {
        Map<OperacoesContaPoupanca, Command> map = new HashMap<>();
        map.put(OperacoesContaPoupanca.SACAR, new Sacar(service));
        map.put(OperacoesContaPoupanca.DEPOSITAR, new Depositar(service));
        return map;
    }

    public Optional<Command> getCommand(OperacoesContaPoupanca operacoes) {
        Command command = commandMap.get(operacoes);
        return Optional.ofNullable(command);
    }
	
}
