package br.com.fiap.fintech.model;

import java.util.Date;

abstract class Movimentacao {

	private int cdMovimentacao;
	private String nmTitulo;
	private double valor;
	private Date dtMovimentacao;
	private int cdUsuario;
	
	
	
	public Movimentacao(int cdMovimentacao, String nmTitulo, double valor, Date dtMovimentacao) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmTitulo;
		this.valor = valor;
		this.dtMovimentacao = dtMovimentacao;
		
	}

	public Movimentacao(String nmTitulo, double valor, Date dtMovimentacao, int cdUsuario) {
		super();
		this.nmTitulo = nmTitulo;
		this.valor = valor;
		this.dtMovimentacao = dtMovimentacao;
		this.cdUsuario = cdUsuario;
	}


	public Movimentacao(int cdMovimentacao, String nmtitulo, double valor) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmtitulo;
		this.valor = valor;
		this.dtMovimentacao = new Date(new Date().getTime());
		
	}
	
	public Movimentacao(int cdMovimentacao, String nmtitulo, double valor, int cdUsuario) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.nmTitulo = nmtitulo;
		this.valor = valor;
		this.dtMovimentacao = new Date(new Date().getTime());
		this.cdUsuario = cdUsuario;
	}

	public void conDadosMovimentacao() {
		System.out.println(toString());
	}
	
	public int getCdMovimentacao() {
		return cdMovimentacao;
	}
	public void setCdMovimentacao(int cdMovimentacao) {
		this.cdMovimentacao = cdMovimentacao;
	}
	public String getNmtitulo() {
		return nmTitulo;
	}
	public void setNmtitulo(String nmtitulo) {
		this.nmTitulo = nmtitulo;
	}
	public String getDsObservacao() {
		return nmTitulo;
	}
	public void setDsObservacao(String dsObservacao) {
		this.nmTitulo = dsObservacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + getNmtitulo() + "\n" + "Valor: "  + getValor() + "\n" + "Data: " + getDtMovimentacao();
	}

	public Date getDtMovimentacao() {
		return dtMovimentacao;
	}

	public void setDtMovimentacao(Date dtMovimentacao) {
		this.dtMovimentacao = dtMovimentacao;
	}
}
