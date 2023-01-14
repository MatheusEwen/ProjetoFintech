package br.com.fiap.fintech.model;


import java.util.Calendar;

public class Investimento {

	private int cdInv;
	private int cdUsuario;
	private String nmAplicacao;
	private double vlAplicacao;
	private Calendar dtAplicacao;
	private Calendar dtVencimento;
	private String nmBanco;

	
	
	
	public Investimento(String nmBanco, int cdUsuario, String nmAplicacao, double vlAplicacao, Calendar dtAplicacao,
			Calendar dtVencimento) {
		super();
		this.cdUsuario = cdUsuario;
		this.nmAplicacao = nmAplicacao;
		this.vlAplicacao = vlAplicacao;
		this.dtAplicacao = dtAplicacao;
		this.dtVencimento = dtVencimento;
		this.nmBanco = nmBanco;
	}

	public Investimento(int cdInv, int cdUsuario, String nmAplicacao, double vlAplicacao, Calendar dtAplicacao,
			Calendar dtVencimento, String nmBanco) {
		super();
		this.cdInv = cdInv;
		this.cdUsuario = cdUsuario;
		this.nmAplicacao = nmAplicacao;
		this.vlAplicacao = vlAplicacao;
		this.dtAplicacao = dtAplicacao;
		this.dtVencimento = dtVencimento;
		this.nmBanco = nmBanco;
	}

	public Investimento() {
		super();
	}

	public Investimento(String nmAplicacao, double vlAplicacao, Calendar dtAplicacao, Calendar dtVencimento,
			String nmBanco, int cdUsuario) {
		super();
		this.cdUsuario = cdUsuario;
		this.nmAplicacao = nmAplicacao;
		this.vlAplicacao = vlAplicacao;
		this.dtAplicacao = dtAplicacao;
		this.dtVencimento = dtVencimento;
		this.nmBanco = nmBanco;
	}
	
	public Investimento(int cdInv, String nmAplicacao, double vlAplicacao, Calendar dtAplicacao, Calendar dtVencimento,
			String nmBanco) {
		super();
		this.cdInv = cdInv;
		this.nmAplicacao = nmAplicacao;
		this.vlAplicacao = vlAplicacao;
		this.dtAplicacao = dtAplicacao;
		this.dtVencimento = dtVencimento;
		this.nmBanco = nmBanco;
	}
	
	public Investimento(String nmAplicacao, double vlAplicacao, String nmBanco, Calendar dtAplicacao, Calendar dtVencimento,
			int cdUsuario) {
		super();
		this.nmAplicacao = nmAplicacao;
		this.vlAplicacao = vlAplicacao;
		this.nmBanco = nmBanco;
		this.dtAplicacao = dtAplicacao;
		this.dtVencimento = dtVencimento;
		this.cdUsuario = cdUsuario;
	}
	public int getCdInv() {
		return cdInv;
	}
	public void setCdInv(int cdInv) {
		this.cdInv = cdInv;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getNmAplicacao() {
		return nmAplicacao;
	}
	public void setNmAplicacao(String nmAplicacao) {
		this.nmAplicacao = nmAplicacao;
	}
	public double getVlAplicacao() {
		return vlAplicacao;
	}
	public void setVlAplicacao(double vlAplicacao) {
		this.vlAplicacao = vlAplicacao;
	}

	
	public Calendar getDtAplicacao() {
		return dtAplicacao;
	}
	public void setDtAplicacao(Calendar dtAplicacao) {
		this.dtAplicacao = dtAplicacao;
	}
	public Calendar getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Calendar dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public String getNmBanco() {
		return nmBanco;
	}
	public void setNmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Investimento: " + getNmAplicacao() + "\n" + 
				"Valor Investido: " + getVlAplicacao() + "\n" +
				"Banco: " + getNmBanco() + "\n" +
				"Data aplicação: " + getDtAplicacao() + "\n" +
				"Data Vencimento: " + getDtVencimento() + "\n" +
				"Cod Inv: " + getCdInv();
	}
	
	
}
