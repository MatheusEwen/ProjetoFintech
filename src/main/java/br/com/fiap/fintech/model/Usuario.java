package br.com.fiap.fintech.model;

import br.com.fiap.fintech.util.CriptografiaUtils;

public class Usuario {

	private int cdUsuario;
	private String nome;
	private String email;
	private double saldo;
	private String senha;
	
	
	
	public Usuario(int cdUsuario, String nome,double saldo, String email) {
		super();
		this.cdUsuario = cdUsuario;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
	}
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		setSenha(senha);
	}
	public Usuario(int cdUsuario, String nome, String email, double saldo, String senha) {
		super();
		this.cdUsuario = cdUsuario;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
		setSenha(senha);
	}
	
	public Usuario(int cdUsuario, String nome, String email, double saldo) {
		super();
		this.cdUsuario = cdUsuario;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
		
	}
	
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
