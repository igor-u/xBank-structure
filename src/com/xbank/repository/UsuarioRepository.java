package com.xbank.repository;

import java.util.List;

import com.xbank.model.conta.Conta;
import com.xbank.model.usuario.Usuario;

public interface UsuarioRepository {

	public Usuario inserir(Usuario user);
	
	public void excluir(Usuario user);

	public void vincularConta(Usuario user, Conta conta);

	public void desvincularConta(Usuario user, long numeroConta);

	public List<Usuario> listarUsuarios();
	
}
