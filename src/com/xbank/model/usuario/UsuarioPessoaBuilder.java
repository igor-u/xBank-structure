package com.xbank.model.usuario;

import java.time.LocalDate;
import java.util.List;

import com.xbank.model.conta.Conta;

public class UsuarioPessoaBuilder {

	private UsuarioPessoa user = new UsuarioPessoa();

	public UsuarioPessoaBuilder comCpf(String cpf){
		user.setCpf(cpf);
		return this;
	}
	
	public UsuarioPessoaBuilder comNomeCompleto(String nomeCompleto){
		user.setNomeCompleto(nomeCompleto);
		return this;
	}
	
	public UsuarioPessoaBuilder comEstadoCivil(String estadoCivil){
		user.setEstadoCivil(estadoCivil);
		return this;
	}

	public UsuarioPessoaBuilder comDataNascimento(LocalDate dataNascimento){
		user.setDataNascimento(dataNascimento);
		return this;
	}

	public UsuarioPessoaBuilder comContas(List<Conta> contas){
		user.setContas(contas);
		return this;
	}

	public UsuarioPessoa build(){
		return user;
	}
	
}
