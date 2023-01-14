package br.com.fiap.fintech.model;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Driver;


public class testeConexao {

	public static void main(String[] args) {
		try {
			// Define o driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Inteface jdbc cuja implementação DriveManeger abre uma cenexao com a 
			//url definida para acesso ao banco
			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM96150","210703"
					);
			System.out.println("Conectou");
			//Fecha conexao
			conexao.close();
			
		//Tratamento de erro
		} catch (SQLException e){
			System.err.println("Não foi possivel conectar ao banco de dados");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Não foi possivel conectar ao ORACLE FIAP");
			e.printStackTrace();
		}
	}

}
