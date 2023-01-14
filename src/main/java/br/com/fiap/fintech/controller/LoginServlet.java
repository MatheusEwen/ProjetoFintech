package br.com.fiap.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bo.CarregarDashboard;
import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IDespesaDAO;
import br.com.fiap.fintech.dao.IReceitaDAO;
import br.com.fiap.fintech.dao.IUsuarioDAO;
import br.com.fiap.fintech.model.Usuario;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IUsuarioDAO dao;
	private IReceitaDAO daoReceita;
	private IDespesaDAO daoDespesa;
	private CarregarDashboard carregarDashboard;
    
    public LoginServlet() {
        super();
        dao = DAOFactory.getIUsuarioDAO();
        daoReceita = DAOFactory.getIReceitaDAO();
        daoDespesa = DAOFactory.getIDespesaDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(email, senha);
		
		if (dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			Usuario usuario2 = dao.buscarPorEmail(email);
			int cdUsuario = usuario2.getCdUsuario();
			session.setAttribute("saldo", CarregarDashboard.getInstance().dadosDashboard(cdUsuario));
			session.setAttribute("metasUsu", CarregarDashboard.getInstance().pegarMetas(cdUsuario));
			session.setAttribute("receitaUsu", CarregarDashboard.getInstance().pegarUltimasReceitas(cdUsuario));
			session.setAttribute("despesaUsu", CarregarDashboard.getInstance().pegarUltimasDespesas(cdUsuario));
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
		
	}

}
