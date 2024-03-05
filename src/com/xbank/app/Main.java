package com.xbank.app;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.xbank.controller.UsuarioController;
import com.xbank.model.conta.Conta;
import com.xbank.model.conta.ContaCorrente;
import com.xbank.model.usuario.Usuario;
import com.xbank.model.usuario.UsuarioPessoaBuilder;
import com.xbank.repository.impl.UsuarioRepositoryInMemoryImpl;
import com.xbank.service.ContaCorrenteService;
import com.xbank.service.command.operacao.OperacoesContaCorrente;
import com.xbank.service.interfaces.impl.ContaCorrenteOperationImpl;

public class Main {

	public static void main(String[] args) {

		//Cria contas
		Conta conta1 = new ContaCorrente(123);
		Conta conta2 = new ContaCorrente(321);
		conta1.setNomeAgencia("Itau");
		conta2.setNomeAgencia("Santander");
		
		//Cria usuarios
		Usuario user1 = new UsuarioPessoaBuilder().comNomeCompleto("Joao").build();
		Usuario user2 = new UsuarioPessoaBuilder().comNomeCompleto("Maria").build();
		user1.getContas().add(conta1);
		user2.getContas().add(conta2);
		
		//Ambas as contas com saldo de 100
		conta1.setSaldo(BigDecimal.valueOf(100));
		conta2.setSaldo(BigDecimal.valueOf(100));
		
		UsuarioController userController = UsuarioController.getInstance(UsuarioRepositoryInMemoryImpl.getInstance());
		userController.inserir(user1);
		userController.inserir(user2);

		//Cria servico de conta poupanca
		ContaCorrenteService ccService = ContaCorrenteService.getInstance(ContaCorrenteOperationImpl.getInstance());
		
		//Cria params
		Map<String, Object> params = new HashMap<>();
		
		//Define valor da transferencia
		BigDecimal valorTransferencia = BigDecimal.valueOf(50);
		
		//Insere parametros
		params.put("valor", valorTransferencia);
		params.put("contaOrigem", conta1);
		params.put("contaDestino", conta2);
		
		//Executa transferencia
		ccService.executar(OperacoesContaCorrente.TRANSFERIR, params);

		//Saldo final da conta1
		System.out.println(conta1.getSaldo());
		//Saldo final da conta2
		System.out.println(conta2.getSaldo());
		
		userController.listarUsuarios();


	}

}
