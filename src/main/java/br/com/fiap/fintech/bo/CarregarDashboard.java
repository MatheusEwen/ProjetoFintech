package br.com.fiap.fintech.bo;

import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IDespesaDAO;
import br.com.fiap.fintech.dao.IMetaDAO;
import br.com.fiap.fintech.dao.IReceitaDAO;
import br.com.fiap.fintech.dao.IUsuarioDAO;
import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Usuario;

public class CarregarDashboard {
	
	private static CarregarDashboard carregarDashboard;

	private static IReceitaDAO daoReceita;
	private static IDespesaDAO daoDespesa;
	private static IMetaDAO daoMeta;
	private static IUsuarioDAO daoUsuario;
	
	public CarregarDashboard() {
		super();
		daoReceita = DAOFactory.getIReceitaDAO();
        daoDespesa = DAOFactory.getIDespesaDAO();
        daoMeta = DAOFactory.getIMetaDAO();
        daoUsuario = DAOFactory.getIUsuarioDAO();
	}
	
	public static CarregarDashboard getInstance() {
		if (carregarDashboard == null) {
			carregarDashboard = new CarregarDashboard();
		}
		return carregarDashboard;
	}
	
	public double dadosDashboard(int cdUsuario) {
		double valorReceita = daoReceita.somarReceitas(cdUsuario);
		double valorDespesa = daoDespesa.somarDespesas(cdUsuario);
		Usuario usuario = daoUsuario.buscarPorCodigo(cdUsuario);
		double saldoAtual = usuario.getSaldo();
		return saldoAtual + (valorReceita - valorDespesa);
		
	}
	
	public List<Meta> pegarMetas(int cdUsuario){
		List<Meta> metas = daoMeta.getAllMetas(cdUsuario);
		return metas;
		
	}
	
	public List<Receita> pegarUltimasReceitas(int cdUsuario){
		List<Receita> receitas = daoReceita.getUltimas(cdUsuario);
		return receitas;
		
	}
	
	public List<Despesa> pegarUltimasDespesas(int cdUsuario){
		List<Despesa> despesas = daoDespesa.getUltimas(cdUsuario);
		return despesas;
	}
	

}
