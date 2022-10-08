package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// retornar conexão com o banco de dados
	public static Connection openConnection()  throws Exception {
		
		//nome do DRIVE JDBC,  para conexão com o banco de dados
		Class.forName("org.postgresql.Driver");
		
		// abrir conexão usando o endereço do banco de dados
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_agendacontatos","postgres","coti");
		
		
		
		
		
		
		
	}

}
