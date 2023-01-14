package br.com.fiap.fintech.testes;

import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;

import br.com.fiap.fintech.dao.IReceitaDAO;
import br.com.fiap.fintech.model.Receita;

public class testesReceita {

	public static void main(String[] args) {
		
		IReceitaDAO dao = DAOFactory.getIReceitaDAO();
		//Inserir
		/*
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Receita receita = new Receita("Salario", 2003.50, data, 3);
		dao.gravar(receita);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Receita receita = new Receita("Retorno investimento", 10000.50, data, 3);
		dao.gravar(receita);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Receita receita = new Receita("Presente da sogra", 100.78, data, 3);
		dao.gravar(receita);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Receita receita = new Receita("Dinheiro achado na rua", 20.00, data, 3);
		dao.gravar(receita);
		
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Receita receita = new Receita("Salario da esposa", 3500.50, data, 3);
		dao.gravar(receita);
		*/
		//COnsultar Todos
		/*
		List<Receita> receitas = dao.getAll();
		for (Receita item : receitas) {
			System.out.println(item.toString());
		}
		*/
		//Buscar por codigo
		/*
		Receita receita = dao.buscarPorCodigo(5);
		System.out.println(receita.toString());
		*/
		//Atualizar
		/*
		java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		Receita receita = new Receita(5, "Salario", 1299.99, data);
		dao.atualizar(receita);
		*/
		//Deletar
		dao.remover(5);
		
		

	}

}
