package com.xbank.model.usuario;

import java.time.LocalDate;

public class UsuarioPessoa extends Usuario {

	private String cpf;
	private String nomeCompleto;
	private String estadoCivil;
	private LocalDate dataNascimento;

	@Override
	public String toString() {
		return "User{" +
				"nome: " + nomeCompleto + ";" +
				"\n" + "contas: " + contasToString() + "}\n";
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
