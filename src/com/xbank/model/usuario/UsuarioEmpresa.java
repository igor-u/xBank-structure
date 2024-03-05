package com.xbank.model.usuario;

import java.time.LocalDate;

public class UsuarioEmpresa extends Usuario {
	
	private String cnpj;
	private String nomeEmpresa;
	private LocalDate dataAbertura;
	
	@Override
	public String toString() {
		return "User{" +
				"nome: " + nomeEmpresa + ";" +
				"\n" + "contas: " + contasToString() + "}\n";
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

}
