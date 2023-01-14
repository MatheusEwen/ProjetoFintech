package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.singleton.ConnectionManager;


public class InvestimentoDAO implements IInvestimentoDAO{

	private Connection conexao = null;
	PreparedStatement pstmt = null;
	
	
	@Override
	public void gravar(Investimento inv) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao
					.prepareStatement(
							"INSERT INTO t_fit_investimento (cd_inv, cd_usuario, nm_aplicacao, vl_aplicacao, dt_aplicacao, dt_vencimento, ds_banco) VALUES (SQ_INV.NEXTVAL, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, inv.getCdUsuario());
			pstmt.setString(2, inv.getNmAplicacao());
			pstmt.setDouble(3, inv.getVlAplicacao());
			
			java.sql.Date dataAplicacao = new java.sql.Date(inv.getDtAplicacao().getTimeInMillis());
			pstmt.setDate(4, dataAplicacao);
			
			
			java.sql.Date dataVencimento = new java.sql.Date(inv.getDtVencimento().getTimeInMillis());
			pstmt.setDate(5, dataVencimento);
			
			
			pstmt.setString(6, inv.getNmBanco());
			pstmt.executeUpdate();
			System.out.println("Investimento incluido com sucesso");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Investimento> getAll(Usuario usuario) {
		List<Investimento> investimentos = new ArrayList<Investimento>();
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_investimento where cd_usuario = ?");
			pstmt.setInt(1, usuario.getCdUsuario());
			rs = pstmt.executeQuery();
			
			//Percorre todos os registros encontrados
			while (rs.next()) {
				
				 java.sql.Date data1 = rs.getDate("dt_aplicacao"); 
				 Calendar dtAplicacao = Calendar.getInstance();
				 dtAplicacao.setTimeInMillis(data1.getTime());
				 
				 java.sql.Date data2 = rs.getDate("dt_vencimento"); 
				 Calendar dtVencimento = Calendar.getInstance();
				 dtVencimento.setTimeInMillis(data2.getTime());
				 
				Investimento investimento = new Investimento(rs.getInt("cd_inv") ,rs.getInt("cd_usuario") ,rs.getString("nm_aplicacao"), rs.getInt("vl_aplicacao"), dtAplicacao, dtVencimento, rs.getString("ds_banco"));
				investimentos.add(investimento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
				pstmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return investimentos;
		
	}

	@Override
	public Investimento buscarPorCodigo(int codigo) {
		ResultSet rs = null;
		Investimento investimento = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_investimento where cd_inv = ?");
			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				java.sql.Date data1 = rs.getDate("dt_aplicacao"); 
				 Calendar dtAplicacao = Calendar.getInstance();
				 dtAplicacao.setTimeInMillis(data1.getTime());
				 
				 java.sql.Date data2 = rs.getDate("dt_vencimento"); 
				 Calendar dtVencimento = Calendar.getInstance();
				 dtVencimento.setTimeInMillis(data2.getTime());
				 
				investimento = new Investimento(rs.getInt("cd_inv") ,rs.getInt("cd_usuario") ,rs.getString("nm_aplicacao"), rs.getInt("vl_aplicacao"), dtAplicacao, dtVencimento, rs.getString("ds_banco"));
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
				pstmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return investimento;
	}

	@Override
	public void atualizar(Investimento inv) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("update t_fit_investimento set nm_aplicacao = ?, vl_aplicacao = ?, dt_aplicacao = ?, dt_vencimento = ?, ds_banco = ? where cd_inv = ?");
			pstmt.setString(1, inv.getNmAplicacao());
			pstmt.setDouble(2, inv.getVlAplicacao());
			
			java.sql.Date dataAplicacao = new java.sql.Date(inv.getDtAplicacao().getTimeInMillis());
			pstmt.setDate(3, dataAplicacao);
			
			
			java.sql.Date dataVencimento = new java.sql.Date(inv.getDtVencimento().getTimeInMillis());
			pstmt.setDate(4, dataVencimento);
			
			pstmt.setString(5, inv.getNmBanco());
			pstmt.setInt(6, inv.getCdInv());
			pstmt.execute();
			System.out.println("Investimeto ALterado com Sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public void remover(int codigo) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("delete from t_fit_investimento where cd_inv = ?");
			pstmt.setInt(1, codigo);
			pstmt.execute();
			System.out.println("Investimento deletado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	
	
}
