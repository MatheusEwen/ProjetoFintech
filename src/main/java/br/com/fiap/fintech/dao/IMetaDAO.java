package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.model.Usuario;

public interface IMetaDAO {
	
	void gravar(Meta meta);
	
	List<Meta> getAll(Usuario usuario);
	
	List<Meta> getAllMetas(int cdUsuario);
	
	Meta buscarPorCodigo(int codigo);
	
	void atualizar(Meta meta);
	
	void remover(int codigo);
}
