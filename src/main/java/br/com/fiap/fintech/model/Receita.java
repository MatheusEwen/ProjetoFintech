package br.com.fiap.fintech.model;

import java.util.Date;

public class Receita {

	private int cdMovimentacao;
	private String nmTitulo;
	private double valor;
	private Date dtMovimentacao;
	private int cdUsuario;
	
	
	
	public Receita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCdMovimentacao() {
		return cdMovimentacao;
	}

	public void setCdMovimentacao(int cdMovimentacao) {
		this.cdMovimentacao = cdMovimentacao;
	}

	public String getNmTitulo() {
		return nmTitulo;
	}

	public void setNmTitulo(String nmTitulo) {
		this.nmTitulo = nmTitulo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDtMovimentacao() {
		return dtMovimentacao;
	}

	public void setDtMovimentacao(Date dtMovimentacao) {
		this.dtMovimentacao = dtMovimentacao;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	
	
	
	public Receita(int cdMovimentacao, String nmTitulo, double valor, Date dtMovimentacao, int cdUsuario) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmTitulo;
		this.valor = valor;
		this.dtMovimentacao = dtMovimentacao;
		this.cdUsuario = cdUsuario;
	}

	public Receita(int cdMovimentacao, String nmTitulo, double valor, Date dtMovimentacao) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmTitulo;
		this.valor = valor;
		this.dtMovimentacao = dtMovimentacao;
	}
	
	public Receita(int cdMovimentacao, String nmTitulo, double valor, int cdUsuario) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmTitulo;
		this.valor = valor;
		this.cdUsuario = cdUsuario;
	}

	public Receita(String nmTitulo, double valor, Date dtMovimentacao, int cdUsuario) {
		super();
		this.nmTitulo = nmTitulo;
		this.valor = valor;
		this.dtMovimentacao = dtMovimentacao;
		this.cdUsuario = cdUsuario;
	}

	public Receita(int cdMovimentacao, String nmTitulo, double valor) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmTitulo;
		this.valor = valor;
	}
	

}
