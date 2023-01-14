package br.com.fiap.fintech.testes;

import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IMetaDAO;


public class Teste {

	public static void main(String[] args) {
		
		/*
		 * OBS: 
		 * 	Nesta classe Teste se encontra os metodos: insert, update, select, delete da classe META.
		 * 	A implementação das outras classes estão nos seus respectivas classes de teste.
		 * 
		 * Vá desfazendo os comentarios para testar os métodos
		 * 
		 * 
		 */
		
		
		IMetaDAO dao = DAOFactory.getIMetaDAO();
		//criando meta
		/*
		Meta meta1 = new Meta("viagem", 5000.59, 3);
		IMetaDAO dao = DAOFactory.getIMetaDAO();
		dao.gravar(meta1);
		
		Meta meta1 = new Meta("Carro novo", 20000.00, 3);
		IMetaDAO dao = DAOFactory.getIMetaDAO();
		dao.gravar(meta1);
		
		Meta meta1 = new Meta("facul", 10000, 3);
		IMetaDAO dao = DAOFactory.getIMetaDAO();
		dao.gravar(meta1);
		
		Meta meta1 = new Meta("Casa nova", 100000.00, 3);
		IMetaDAO dao = DAOFactory.getIMetaDAO();
		dao.gravar(meta1);
		
		Meta meta1 = new Meta("Casamento", 7000, 3);
		IMetaDAO dao = DAOFactory.getIMetaDAO();
		dao.gravar(meta1);
		*/
		
		//Listando todas as metas
		/*
		List<Meta> metas = dao.getAll();
		
		for (Meta item : metas) {
			System.out.println(item.getCodUsuario() + " " + item.getTitulo() + " " + item.getVlMeta());
		}
		*/
		//Atualizando
		/*
		Meta meta = new Meta(5, "vida louca", 15.56);
		dao.atualizar(meta);
		*/
		//Deletando
		//dao.remover(7);
		
		
		
		/*
		//Criando Usuario
		Usuario usu1 = new Usuario("1", "Matheus", "matheus@gmail.com");
		usu1.addUsuBanco();
		usu1.setGenero("M");
		System.out.println("====================================================");
		
		//Criando receita
		Receita receita1 = new Receita("1", "salario", 2500.5);
		usu1.incluirReceita(receita1);
		receita1.conDadosMovimentacao();
		System.out.println("====================================================");
		
		//Criando Despesa
		Despesa despesa1 = new Despesa("1", "Conta de luz", 200);
		usu1.incluirDespesa(despesa1);
		System.out.println("====================================================");
		
		//Consultando dados do usuario
		usu1.consultarDados();
		System.out.println("====================================================");
		*/
		
		
		
		
		
		

	}

}
