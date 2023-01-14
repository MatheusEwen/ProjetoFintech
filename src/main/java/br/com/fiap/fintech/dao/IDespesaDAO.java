package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.model.Usuario;


public interface IDespesaDAO {

	void gravar(Despesa despesa);
	
	List<Despesa> getAll(Usuario usaurio);
	
	List<Despesa> getUltimas(int cdUsuario);
	
	Despesa buscarPorCodigo(int codigo);
	
	void atualizar(Despesa despesa);
	
	void remover(int codigo);
	
	double somarDespesas(int cdUsuario);
	
}
