package br.com.fiap.fintech.dao;

public abstract class DAOFactory {

	public static IMetaDAO getIMetaDAO() {
		return new MetaDAO();
	}
	
	public static IDespesaDAO getIDespesaDAO() {
		return new DespesaDAO();
	}
	
	public static IReceitaDAO getIReceitaDAO() {
		return new ReceitaDAO();
	}
	
	public static IInvestimentoDAO getIInvestimentoDAO() {
		return new InvestimentoDAO();
	}
	
	public static IUsuarioDAO getIUsuarioDAO() {
		return new UsuarioDAO();
	}
	
	
}
