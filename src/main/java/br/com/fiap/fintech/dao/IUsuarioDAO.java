package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Usuario;


public interface IUsuarioDAO {

	void cadastrar(Usuario usuario)throws DBException;
	void alterar(Usuario usuario)throws DBException;
	void remover(String email)throws DBException;
	boolean validarUsuario(Usuario usuario);
	Usuario buscarPorEmail(String email);
	Usuario buscarPorCodigo(int cdUsuario);
	
}
