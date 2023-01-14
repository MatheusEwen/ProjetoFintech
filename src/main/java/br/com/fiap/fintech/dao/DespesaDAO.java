package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class DespesaDAO implements IDespesaDAO{
	
	private Connection conexao = null;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Despesa despesa) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement(
							"INSERT INTO t_fit_despesa (cd_despesa, cd_usuario, vl_despesa, dt_despesa, ds_despesa) VALUES (SQ_DES.NEXTVAL, ?, ?, TO_DATE(SYSDATE), ?)");
			pstmt.setInt(1, despesa.getCdUsuario());
			pstmt.setDouble(2, despesa.getValor());
			pstmt.setString(3, despesa.getNmTitulo());
			pstmt.executeUpdate();
			System.out.println("Despesa incluida com sucesso!");
			
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
	public List<Despesa> getAll(Usuario usuario) {
		List<Despesa> despesas = new ArrayList<Despesa>();
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_despesa where cd_usuario = ?");
			pstmt.setInt(1, usuario.getCdUsuario());
			rs = pstmt.executeQuery();
			
			//Percorre todos os registros encontrados
			while (rs.next()) {
				Despesa despesa = new Despesa(rs.getInt("cd_despesa") ,rs.getString("ds_despesa"), rs.getDouble("vl_despesa"), rs.getDate("dt_despesa"), rs.getInt("cd_usuario"));
				despesas.add(despesa);
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
		return despesas;
		
	}

	@Override
	public Despesa buscarPorCodigo(int codigo) {
		ResultSet rs = null;
		Despesa despesa = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_despesa where cd_despesa = ?");
			pstmt.setInt(1, codigo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				despesa = new Despesa(rs.getInt("cd_despesa") ,rs.getString("ds_despesa"), rs.getDouble("vl_despesa"), rs.getDate("dt_despesa"), rs.getInt("cd_usuario"));
			
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
		return despesa;
	}

	@Override
	public void atualizar(Despesa despesa) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE t_fit_despesa SET vl_despesa = ?, ds_despesa = ? WHERE cd_despesa = ?");
			pstmt.setDouble(1, despesa.getValor());
			pstmt.setString(2, despesa.getNmTitulo());
			pstmt.setInt(3, despesa.getCdMovimentacao());
			pstmt.executeUpdate();
			System.out.println("Despesa ALterada com Sucesso!!");
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
			pstmt = conexao.prepareStatement("delete from t_fit_despesa where cd_despesa = ?");
			pstmt.setInt(1, codigo);
			pstmt.execute();
			System.out.println("Despesa deletada");
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
	public double somarDespesas(int cdUsuario) {
		ResultSet rs = null;
		double saldo = 0;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_despesa where cd_usuario = ?");
			pstmt.setInt(1, cdUsuario);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				saldo += rs.getDouble("vl_despesa");
	
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
	public List<Despesa> getUltimas(int cdUsuario) {
		List<Despesa> despesas = new ArrayList<Despesa>();
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM t_fit_despesa d WHERE cd_usuario = ? and d.dt_despesa > add_months(sysdate, -1)");
			pstmt.setInt(1, cdUsuario);
			rs = pstmt.executeQuery();
			
			//Percorre todos os registros encontrados
			while (rs.next()) {
				Despesa despesa = new Despesa(rs.getInt("cd_despesa") ,rs.getString("ds_despesa"), rs.getDouble("vl_despesa"), rs.getDate("dt_despesa"), rs.getInt("cd_usuario"));
				despesas.add(despesa);
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
		return despesas;
	}

}
