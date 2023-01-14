package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class ReceitaDAO implements IReceitaDAO{

	private Connection conexao = null;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Receita receita) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement(
							"INSERT INTO t_fit_receita (cd_receita, cd_usuario, vl_receita, dt_receita, ds_receita) VALUES (SQ_REC.NEXTVAL, ?, ?, TO_DATE(SYSDATE), ?)");
			pstmt.setInt(1, receita.getCdUsuario());
			pstmt.setDouble(2, receita.getValor());
			pstmt.setString(3, receita.getNmTitulo());
			pstmt.executeUpdate();
			
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
	public List<Receita> getAll(Usuario usuario) {
		
		List<Receita> receitas = new ArrayList<Receita>();
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_receita where cd_usuario = ?");
			pstmt.setInt(1, usuario.getCdUsuario());
			rs = pstmt.executeQuery();
			
			//Percorre todos os registros encontrados
			while (rs.next()) {
				Receita receita = new Receita(rs.getInt("cd_receita") ,rs.getString("ds_receita"), rs.getDouble("vl_receita"), rs.getDate("dt_receita"), rs.getInt("cd_usuario"));
				receitas.add(receita);
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
		return receitas;
		
	}

	@Override
	public Receita buscarPorCodigo(int codigo) {
		ResultSet rs = null;
		Receita receita = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_receita where cd_receita = ?");
			pstmt.setInt(1, codigo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				receita = new Receita(rs.getInt("cd_receita") ,rs.getString("ds_receita"), rs.getDouble("vl_receita"), rs.getDate("dt_receita"), rs.getInt("cd_usuario"));
			
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
		return receita;
	}

	@Override
	public void atualizar(Receita receita) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE t_fit_receita SET vl_receita = ?, ds_receita = ? WHERE cd_receita = ?");
			pstmt.setDouble(1, receita.getValor());
			pstmt.setString(2, receita.getNmTitulo());
			pstmt.setInt(3, receita.getCdMovimentacao());
			pstmt.executeUpdate();
			System.out.println("Receita ALterada com Sucesso!!");
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
			pstmt = conexao.prepareStatement("delete from t_fit_receita where cd_receita = ?");
			pstmt.setInt(1, codigo);
			pstmt.execute();
			System.out.println("Receita deletada");
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
	public double somarReceitas(int cdUsuario) {
		ResultSet rs = null;
		double saldo = 0;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_receita where cd_usuario = ?");
			pstmt.setInt(1, cdUsuario);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				saldo += rs.getDouble("vl_receita");
	
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
		
		
		return saldo;
	}

	@Override
	public List<Receita> getUltimas(int cdUsuario) {
		List<Receita> receitas = new ArrayList<Receita>();
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM t_fit_receita r WHERE cd_usuario = ? and r.dt_receita > add_months(sysdate, -1)");
			pstmt.setInt(1, cdUsuario);
			rs = pstmt.executeQuery();
			
			//Percorre todos os registros encontrados
			while (rs.next()) {
				Receita receita = new Receita(rs.getInt("cd_receita") ,rs.getString("ds_receita"), rs.getDouble("vl_receita"), rs.getDate("dt_receita"), rs.getInt("cd_usuario"));
				receitas.add(receita);
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
		return receitas;
	}

	
}
