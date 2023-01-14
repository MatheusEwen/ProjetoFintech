package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Usuario;

public interface IReceitaDAO {

	void gravar(Receita receita);
	
	List<Receita> getAll(Usuario usuario);
	
	List<Receita> getUltimas(int cdUsuario);
	
	Receita buscarPorCodigo(int codigo);
	
	void atualizar(Receita receita);
	
	void remover(int codigo);
	
	double somarReceitas(int cdUsuario);
	
	
}
