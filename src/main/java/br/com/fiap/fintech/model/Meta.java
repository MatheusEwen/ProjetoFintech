package br.com.fiap.fintech.model;

public class Meta {
	
	private String titulo;
	private double vlMeta;
	private int codUsuario;
	private int cdMeta;
	
	
	
	public Meta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meta(String titulo, double vlMeta, int codUsuario, int cdMeta) {
		super();
		this.titulo = titulo;
		this.vlMeta = vlMeta;
		this.codUsuario = codUsuario;
		this.cdMeta = cdMeta;
	}



	public Meta(int cdMeta ,String titulo, double vlMeta) {
		super();
		this.cdMeta = cdMeta;
		this.titulo = titulo;
		this.vlMeta = vlMeta;
	}

	public Meta( String titulo, double vlMeta, int codUsuario) {
		super();
		this.titulo = titulo;
		this.vlMeta = vlMeta;
		this.codUsuario = codUsuario;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getVlMeta() {
		return vlMeta;
	}
	public void setVlMeta(double vlMeta) {
		this.vlMeta = vlMeta;
	}
	
	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	

	public int getCdMeta() {
		return cdMeta;
	}

	public void setCdMeta(int cdMeta) {
		this.cdMeta = cdMeta;
	}

	@Override
	public String toString() {
		return "Meta: " + getTitulo() + "\n" + "Valor: " + getVlMeta();
	}

	

}
