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
		conta2.setNomeAgencia("Nubank");
		
		//Cria usuarios
		Usuario user1 = new UsuarioPessoaBuilder().comNomeCompleto("Joao").build();
		Usuario user2 = new UsuarioPessoaBuilder().comNomeCompleto("Maria").build();
		
		UsuarioController userController = UsuarioController.getInstance(UsuarioRepositoryInMemoryImpl.getInstance());

		userController.vincularConta(user1, conta1);
		userController.vincularConta(user2, conta2);

		//Cria servico de conta corrente
		ContaCorrenteService ccService = ContaCorrenteService.getInstance(ContaCorrenteOperationImpl.getInstance());

		//Cria params
		Map<String, Object> params = new HashMap<>();

		//Deposita 100 (tipo da moeda) em ambas as contas
		params.put("valor", BigDecimal.valueOf(100));
		params.put("conta", conta1);
		ccService.executar(OperacoesContaCorrente.DEPOSITAR, params);

		params.put("valor", BigDecimal.valueOf(100));
		params.put("conta", conta2);
		ccService.executar(OperacoesContaCorrente.DEPOSITAR, params);

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

		//Insere users no repositorio
		userController.inserir(user1);
		userController.inserir(user2);

		userController.listarUsuarios();

	}

}
