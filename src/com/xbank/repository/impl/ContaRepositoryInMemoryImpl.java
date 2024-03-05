package com.xbank.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.xbank.model.conta.Conta;
import com.xbank.model.usuario.Usuario;
import com.xbank.repository.ContaRepository;

public class ContaRepositoryInMemoryImpl implements ContaRepository {
	
	private List<Conta> contas = new ArrayList<Conta>();
	
	private static final ContaRepositoryInMemoryImpl instance = new ContaRepositoryInMemoryImpl();

	private ContaRepositoryInMemoryImpl() {

	}

	public static ContaRepositoryInMemoryImpl getInstance(){
		return instance;
	}


	@Override
	public Conta inserir(Conta conta) {
		contas.add(conta);
		return conta;
	}

	@Override
	public void excluir(long numeroConta) {
		Conta conta = contas.stream().filter(c -> c.getNumeroConta() == numeroConta).findFirst().get();
		Usuario titular = UsuarioRepositoryInMemoryImpl.getInstance().listarUsuarios().
				stream().filter(t -> t.getContas().contains(conta)).findFirst().get();
		titular.getContas().remove(conta);
		contas.remove(conta);
		
	}

}
