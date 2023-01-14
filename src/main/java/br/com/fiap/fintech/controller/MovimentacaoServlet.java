package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

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
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Usuario;

@WebServlet("/movimentacao")
public class MovimentacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IReceitaDAO daoReceita;
	private IDespesaDAO daoDespesa;
	private IUsuarioDAO daoUsuario;
	private CarregarDashboard carregarDashboard;

	public MovimentacaoServlet() {
		super();
		daoReceita = DAOFactory.getIReceitaDAO();
		daoDespesa = DAOFactory.getIDespesaDAO();
		daoUsuario = DAOFactory.getIUsuarioDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao-receita":
			abrirFormEdicaoReceita(request,response);
			break;
		case "abrir-form-edicao-despesa":
			abrirFormEdicaoDespesa(request, response);
			break;
		}
	}

	private void abrirFormEdicaoDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigoDespesa"));
		Despesa despesa = daoDespesa.buscarPorCodigo(id);
		request.setAttribute("despesaEdicao", despesa);
		request.getRequestDispatcher("edicaoDespesa.jsp").forward(request, response);
		
	}

	private void abrirFormEdicaoReceita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Receita receita = daoReceita.buscarPorCodigo(id);
		request.setAttribute("receitaEdicao", receita);
		request.getRequestDispatcher("edicaoReceita.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		List<Receita> listaReceita = daoReceita.getAll(usuario);
		List<Despesa> listaDespesa = daoDespesa.getAll(usuario);
		request.setAttribute("receitas", listaReceita);
		request.setAttribute("despesas", listaDespesa);
		session.setAttribute("metasUsu", CarregarDashboard.getInstance().pegarMetas(usuario.getCdUsuario()));
		session.setAttribute("saldo", CarregarDashboard.getInstance().dadosDashboard(usuario.getCdUsuario()));
		session.setAttribute("receitaUsu", CarregarDashboard.getInstance().pegarUltimasReceitas(usuario.getCdUsuario()));
		session.setAttribute("despesaUsu", CarregarDashboard.getInstance().pegarUltimasDespesas(usuario.getCdUsuario()));
		request.getRequestDispatcher("addReceitaEDespesa.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String tipo = request.getParameter("tipo");

		switch (acao) {
		case "cadastrar":
			if (tipo.equals("receita")) {
				cadastrarReceita(request, response);
			} else {
				CadastrarDespesa(request, response);
			}

			break;
		case "editar":
			if(tipo.equals("receita")) {
				editarReceita(request, response);
			}else {
				editarDespesa(request, response);
			}
			break;
		case "excluir":
			if (tipo.equals("receita")) {
				try {
					excluirReceita(request, response);
				} catch (DBException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				excluirDespesa(request, response);
			}
		}

	}

	private void excluirDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigoDespesaExcluir"));
		System.out.println(codigo);
		daoDespesa.remover(codigo);
		listar(request,response);
		
	}

	private void excluirReceita(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigoReceitaExcluir"));
		System.out.println(codigo);
		daoReceita.remover(codigo);
		listar(request,response);
		
	}

	private void editarDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		Despesa despesa = new Despesa(codigo, descricao, valor);
		daoDespesa.atualizar(despesa);
		listar(request, response);
		
	}

	private void editarReceita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		Receita receita = new Receita(codigo, descricao, valor);
		daoReceita.atualizar(receita);
		listar(request, response);
	}

	private void CadastrarDespesa(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email = request.getParameter("user");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		
		try {
			String descricao = request.getParameter("descricao");
			double valor = Double.parseDouble( request.getParameter("valor"));
			
			Despesa despesa = new Despesa(0, descricao, valor, usuario.getCdUsuario());
			
			daoDespesa.gravar(despesa);
			session.setAttribute("metasUsu", CarregarDashboard.getInstance().pegarMetas(usuario.getCdUsuario()));
			session.setAttribute("saldo", CarregarDashboard.getInstance().dadosDashboard(usuario.getCdUsuario()));
			session.setAttribute("receitaUsu", CarregarDashboard.getInstance().pegarUltimasReceitas(usuario.getCdUsuario()));
			session.setAttribute("despesaUsu", CarregarDashboard.getInstance().pegarUltimasDespesas(usuario.getCdUsuario()));
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		
	}

	private void cadastrarReceita(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email = request.getParameter("user");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		
		try {
			String descricao = request.getParameter("descricao");
			double valor = Double.parseDouble( request.getParameter("valor"));
			
			Receita receita = new Receita(0, descricao, valor, usuario.getCdUsuario());
			
			daoReceita.gravar(receita);
			session.setAttribute("metasUsu", CarregarDashboard.getInstance().pegarMetas(usuario.getCdUsuario()));
			session.setAttribute("saldo", CarregarDashboard.getInstance().dadosDashboard(usuario.getCdUsuario()));
			session.setAttribute("receitaUsu", CarregarDashboard.getInstance().pegarUltimasReceitas(usuario.getCdUsuario()));
			session.setAttribute("despesaUsu", CarregarDashboard.getInstance().pegarUltimasDespesas(usuario.getCdUsuario()));
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}

	}
}
