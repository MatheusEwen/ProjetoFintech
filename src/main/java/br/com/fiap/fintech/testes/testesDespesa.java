package br.com.fiap.fintech.testes;

import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IDespesaDAO;
import br.com.fiap.fintech.model.Despesa;

public class testesDespesa {

	public static void main(String[] args) {
		
		IDespesaDAO dao = DAOFactory.getIDespesaDAO();
		//Inserir
		/*
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Despesa despesa = new Despesa("Conta de luz", 150.50, data, 3);
		dao.gravar(despesa);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Despesa despesa = new Despesa("Conta de agua", 90.50, data, 3);
		dao.gravar(despesa);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Despesa despesa = new Despesa("Aluguel", 500.90, data, 3);
		dao.gravar(despesa);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Despesa despesa = new Despesa("Compras", 200.50, data, 3);
		dao.gravar(despesa);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Despesa despesa = new Despesa("Poster do baby yoda", 50.99, data, 3);
		dao.gravar(despesa);
		*/
		//COnsultar Todos
		/*
		List<Despesa> despesas = dao.getAll();
		for (Despesa item : despesas) {
			System.out.println(item.toString());
		}
		*/
		//Buscar por codigo
		/*
		Despesa despesa = dao.buscarPorCodigo(17);
		System.out.println(despesa.toString());
		*/
		//Atualizar
		/*
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Despesa despesa = new Despesa(8, "HBO", 12.99, data);
		dao.atualizar(despesa);
		*/
		//Deletar
		dao.remover(9);
		

	}

}
