package com.xbank.model.conta;

import java.math.BigDecimal;

import com.xbank.model.usuario.Usuario;

public abstract class Conta {
	
	protected long numeroConta;
	protected String nomeAgencia;
	protected BigDecimal saldo;
	protected Usuario titular;
	
	public Conta(long numeroConta) {
		this.numeroConta = numeroConta;
		this.saldo = BigDecimal.ZERO;
	}
	public long getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getNomeAgencia() {
		return nomeAgencia;
	}
	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Usuario getTitular() {
		return titular;
	}
	public void setTitular(Usuario titular) {
		this.titular = titular;
	}

}
