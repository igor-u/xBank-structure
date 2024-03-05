package com.xbank.repository;

import java.util.List;

import com.xbank.model.usuario.Usuario;

public interface UsuarioRepository {

	public Usuario inserir(Usuario user);
	
	public void excluir(Usuario user);
	
	public void excluirConta(Usuario user, long numeroConta);

	public List<Usuario> listarUsuarios();
	
}
