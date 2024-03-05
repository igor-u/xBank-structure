package com.xbank.model.usuario;

import java.time.LocalDate;
import java.util.List;

import com.xbank.model.conta.Conta;

public class UsuarioEmpresaBuilder {

	private UsuarioEmpresa user = new UsuarioEmpresa();

	public UsuarioEmpresaBuilder comCnpj(String cnpj){
		user.setCnpj(cnpj);
		return this;
	}
	
	public UsuarioEmpresaBuilder comNome(String nomeEmpresa){
		user.setNomeEmpresa(nomeEmpresa);
		return this;
	}
	

	public UsuarioEmpresaBuilder comDataAbertura(LocalDate dataAbertura){
		user.setDataAbertura(dataAbertura);
		return this;
	}

	public UsuarioEmpresaBuilder comContas(List<Conta> contas){
		user.setContas(contas);
		return this;
	}

	public UsuarioEmpresa build(){
		return user;
	}
	
}
