package br.com.fiap.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IUsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Usuario;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUsuarioDAO dao;
	
    public UsuarioServlet() {
        super();
        dao = DAOFactory.getIUsuarioDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "excluir":
			excluir(request,response);
			break;
		}
	}
		
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (request.getParameter("email"));
		try {
			dao.remover(email);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}


	private void cadastrar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			double saldo = Double.parseDouble( request.getParameter("saldo"));
			
			Usuario usuario = new Usuario(0, nome, email, saldo, senha);
			
			dao.cadastrar(usuario);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		
		
	}

}


	
