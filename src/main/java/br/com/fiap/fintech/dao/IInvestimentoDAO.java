package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Usuario;

public interface IInvestimentoDAO {

void gravar(Investimento inv);
	
	List<Investimento> getAll(Usuario usuario);
	
	Investimento buscarPorCodigo(int codigo);
	
	void atualizar(Investimento inv);
	
	void remover(int codigo);

}
