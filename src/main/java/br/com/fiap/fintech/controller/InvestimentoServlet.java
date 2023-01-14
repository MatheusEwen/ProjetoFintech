package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.IInvestimentoDAO;
import br.com.fiap.fintech.dao.IUsuarioDAO;
import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Usuario;


@WebServlet("/investimentoS")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IInvestimentoDAO daoInvestimento;
	private IUsuarioDAO daoUsuario;
	
    public InvestimentoServlet() {
        super();
        daoInvestimento = DAOFactory.getIInvestimentoDAO();
        daoUsuario = DAOFactory.getIUsuarioDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao-inv":
			abrirFormEdicaoInvestimento(request,response);
			break;
		}
	}

	
	private void abrirFormEdicaoInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Investimento investimento = daoInvestimento.buscarPorCodigo(id);
		request.setAttribute("investimentoEdicao", investimento);
		request.getRequestDispatcher("edicaoInvestimento.jsp").forward(request, response);
		
		
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		
		List<Investimento> listaInvestimento = daoInvestimento.getAll(usuario);
		request.setAttribute("investimentos", listaInvestimento);
		request.getRequestDispatcher("investimento.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
			case "cadastrar":
				cadastrarInvestimento(request,response);
				break;
			case "editar":
			try {
				editarInvestimento(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			case "excluir":
				excluirInvestimento(request,response);
		}
		
	}


	private void excluirInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigoExcluirInv"));
		System.out.println(codigo);
		daoInvestimento.remover(codigo);
		listar(request,response);
		
	}


	private void editarInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nomeI");
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar dtAplicacao = Calendar.getInstance();
		dtAplicacao.setTime(format.parse(request.getParameter("dtAplicacao")));
		
		Calendar dtVencimento = Calendar.getInstance();
		dtVencimento.setTime(format.parse(request.getParameter("dtVencimento")));
		
		String banco = request.getParameter("banco");
		
		Investimento investimento = new Investimento(codigo, nome, valor, dtAplicacao, dtVencimento, banco );
		daoInvestimento.atualizar(investimento);
		listar(request, response);
		
	}


	private void cadastrarInvestimento(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("user");
		Usuario usuario = daoUsuario.buscarPorEmail(email);
		System.out.println(usuario.getCdUsuario());
		
		try {
			
			String nomeI = request.getParameter("nomeI");
			System.out.println(nomeI);
			double valor = Double.parseDouble(request.getParameter("valor"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dtAplicacao = Calendar.getInstance();
			dtAplicacao.setTime(format.parse(request.getParameter("dtAplicacao")));
			Calendar dtVencimento = Calendar.getInstance();
			
			dtVencimento.setTime(format.parse(request.getParameter("dtVencimento")));
			
			String banco = request.getParameter("banco");
			
			Investimento investimento = new Investimento(banco, usuario.getCdUsuario(), nomeI, valor, dtAplicacao, dtVencimento);
			
			daoInvestimento.gravar(investimento);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
