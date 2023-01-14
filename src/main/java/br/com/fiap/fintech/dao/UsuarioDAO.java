package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class UsuarioDAO implements IUsuarioDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void cadastrar(Usuario usuario) throws DBException {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement(
							"INSERT INTO t_fit_usuario (cd_usuario, nm_usuario, ds_email, vl_saldo, ds_senha) VALUES (SQ_USU.NEXTVAL, ? , ? , ?, ?)");
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setDouble(3, usuario.getSaldo());
			pstmt.setString(4, usuario.getSenha());
			
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
	public void alterar(Usuario usuario) throws DBException {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE t_fit_usuario SET nm_usuario = ?, ds_email = ? WHERE cd_usuario = ?");
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setInt(3, usuario.getCdUsuario());
			pstmt.executeUpdate();
			
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
	public void remover(String email) throws DBException {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("delete from T_FIT_USUARIO where ds_email = ?");
			pstmt.setString(1, email);
			pstmt.execute();
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
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIT_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();

			if (rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM t_fit_usuario WHERE ds_email = ?");
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario(rs.getInt("cd_usuario"), rs.getString("nm_usuario"), rs.getDouble("vl_saldo"), rs.getString("ds_email"));
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
		return usuario;
	}

	@Override
	public Usuario buscarPorCodigo(int cdUsuario) {
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM t_fit_usuario WHERE cd_usuario = ?");
			pstmt.setInt(1, cdUsuario);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario(rs.getInt("cd_usuario"), rs.getString("nm_usuario"), rs.getString("ds_email"), rs.getDouble("vl_saldo"));
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
		return usuario;
	}

}
