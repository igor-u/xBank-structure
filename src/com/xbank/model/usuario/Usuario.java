package com.xbank.model.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.xbank.model.conta.Conta;

public abstract class Usuario {
	
	protected List<Conta> contas = new ArrayList<Conta>();
	
	public String contasToString() {
		StringJoiner contasString = new StringJoiner(", ");
		for (Conta conta : contas) {
			contasString.add(conta.getNumeroConta() + " - " + conta.getNomeAgencia() + ";") ;
		}
		return contasString.toString();
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
