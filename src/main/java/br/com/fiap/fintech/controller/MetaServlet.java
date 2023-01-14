package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bo.CarregarDashboard;
import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IMetaDAO;
import br.com.fiap.fintech.dao.IUsuarioDAO;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.model.Usuario;


@WebServlet("/metaS")
public class MetaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMetaDAO daoMeta;
	private IUsuarioDAO daoUsuario;
       
    public MetaServlet() {
        super();
        daoMeta = DAOFactory.getIMetaDAO();
        daoUsuario = DAOFactory.getIUsuarioDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao-meta":
			abrirFormEdicaoMeta(request,response);
			break;
		}
		
	}

	private void abrirFormEdicaoMeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Meta metas = daoMeta.buscarPorCodigo(id);
		request.setAttribute("metaEdicao", metas);
		request.getRequestDispatcher("edicaoMeta.jsp").forward(request, response);
	
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		
		List<Meta> listaMeta = daoMeta.getAll(usuario);
		request.setAttribute("metas", listaMeta);
		session.setAttribute("metasUsu", CarregarDashboard.getInstance().pegarMetas(usuario.getCdUsuario()));
		request.getRequestDispatcher("meta.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
			case "cadastrar":
				cadastrarMeta(request, response);
				break;
			case "editar":
				editarMeta(request,response);
				break;
			case "excluir":
				excluirMeta(request, response);
		}
	}
	
	private void excluirMeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigoExcluirMeta"));
		daoMeta.remover(codigo);
		listar(request,response);
		
	}

	private void editarMeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
	
		Meta meta = new Meta(codigo, descricao, valor );
		daoMeta.atualizar(meta);
		listar(request, response);
		
	}

	private void cadastrarMeta(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email = request.getParameter("user");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		
		try {
			
			String nomeM = request.getParameter("descricao");
			double valor = Double.parseDouble(request.getParameter("valor"));
			
			Meta meta = new Meta(nomeM, valor, usuario.getCdUsuario());
			
			daoMeta.gravar(meta);
			session.setAttribute("metasUsu", CarregarDashboard.getInstance().pegarMetas(usuario.getCdUsuario()));
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
