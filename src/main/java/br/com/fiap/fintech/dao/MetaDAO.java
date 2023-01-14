package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class MetaDAO implements IMetaDAO{

	private Connection conexao = null;
	PreparedStatement pstmt = null;
	
	
	@Override
	public void gravar(Meta meta) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao
					.prepareStatement(
							"INSERT INTO t_fit_meta (cd_meta, cd_usuario, nm_meta, vl_necessario) VALUES (SQ_META.NEXTVAL, ?, ?, ? )");
			pstmt.setInt(1, meta.getCodUsuario());
			pstmt.setString(2, meta.getTitulo());
			pstmt.setDouble(3, meta.getVlMeta());
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
	public List<Meta> getAll(Usuario usuario) {
		//CRIA UMA LISTA DE METAS
	List<Meta> metas = new ArrayList<Meta>();
	ResultSet rs = null;
	try {
		conexao = ConnectionManager.getInstance().getConnection();
		pstmt = conexao.prepareStatement("select * from t_fit_meta where cd_usuario = ?");
		pstmt.setInt(1, usuario.getCdUsuario());
		rs = pstmt.executeQuery();
		
		//Percorre todos os registros encontrados
		while (rs.next()) {
			Meta meta = new Meta(rs.getString("nm_meta"), rs.getDouble("vl_necessario"), rs.getInt("cd_usuario"), rs.getInt("cd_meta"));
			metas.add(meta);
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
	return metas;
	
	
	}
	
	public List<Meta> getAllMetas(int cdUsuario) {
		//CRIA UMA LISTA DE METAS
	List<Meta> metas = new ArrayList<Meta>();
	ResultSet rs = null;
	try {
		conexao = ConnectionManager.getInstance().getConnection();
		pstmt = conexao.prepareStatement("select * from t_fit_meta where cd_usuario = ?");
		pstmt.setInt(1, cdUsuario);
		rs = pstmt.executeQuery();
		
		//Percorre todos os registros encontrados
		while (rs.next()) {
			Meta meta = new Meta(rs.getString("nm_meta"), rs.getDouble("vl_necessario"), rs.getInt("cd_usuario"), rs.getInt("cd_meta"));
			metas.add(meta);
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
	return metas;
	
	
	}

	@Override
	public Meta buscarPorCodigo(int codigo) {
		ResultSet rs = null;
		Meta meta = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("select * from t_fit_meta where cd_meta = ?");
			pstmt.setInt(1, codigo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("cd_usuario");
				String titulo = rs.getString("nm_meta");
				double vl = rs.getDouble("vl_necessario");
				int cdMeta = rs.getInt("cd_meta");
				
				meta = new Meta(titulo, vl, id, cdMeta);
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
		return meta;
	}

	@Override
	public void atualizar(Meta meta) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("update t_fit_meta set nm_meta = ?, vl_necessario = ? where cd_meta = ?");
			pstmt.setString(1, meta.getTitulo());
			pstmt.setDouble(2, meta.getVlMeta());
			pstmt.setInt(3, meta.getCdMeta());
			pstmt.execute();
			System.out.println("Meta ALterada com Sucesso!!");
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
			pstmt = conexao.prepareStatement("delete from t_fit_meta where cd_meta = ?");
			pstmt.setInt(1, codigo);
			pstmt.execute();
			System.out.println("Meta deletada");
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
