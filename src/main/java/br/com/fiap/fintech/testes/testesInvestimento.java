package br.com.fiap.fintech.testes;

import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IInvestimentoDAO;
import br.com.fiap.fintech.model.Investimento;

public class testesInvestimento {

	public static void main(String[] args) {
		
		IInvestimentoDAO dao = DAOFactory.getIInvestimentoDAO();
		//Inserir
		/*
		Investimento investimento = new Investimento("cdb 450%", 5099.99, "CAIXA ECONOMICA", "22/10/2022", "21/07/2023", 3);
		dao.gravar(investimento);
		
		Investimento investimento = new Investimento("LCA 102%", 2099.99, "SANTANDER", "22/10/2022", "21/07/2024", 3);
		dao.gravar(investimento);
		
		Investimento investimento = new Investimento("BITCON", 40000.99, "Binace", "22/10/2022", "21/07/2025", 3);
		dao.gravar(investimento);
		
		Investimento investimento = new Investimento("FII", 800.85, "DAYCOVAL", "22/10/2022", "21/07/2029", 3);
		dao.gravar(investimento);
		
		Investimento investimento = new Investimento("JUNTAR NO COFRE", 100.50, "MINHA CASA", "22/10/2022", "21/07/2030", 3);
		dao.gravar(investimento);
		*/
		//COnsultar Todos
		/*
		List<Investimento> investimentos = dao.getAll();
		for (Investimento item : investimentos) {
			System.out.println(item.toString());
		}
		*/
		//Buscar por codigo
		/*
		Investimento investimento = dao.buscarPorCodigo(10);
		System.out.println(investimento.toString());
		*/
		//Atualizar
		/*
		Investimento investimento = new Investimento(2, "LCA 102%", 2000.98, "22/10/2022", "21/07/2024", "SANTANDER");
		dao.atualizar(investimento);
		*/
		//Deletar
		//dao.remover(6);
		

	}

}
