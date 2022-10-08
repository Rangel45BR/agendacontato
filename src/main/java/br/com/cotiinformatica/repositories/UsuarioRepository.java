package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {

	public void create(Usuario usuario) throws Exception {

		// abrindo conexões no banco de dados através do CONNECTIONFATORY ( PACKAGE )
		Connection connection = ConnectionFactory.openConnection();

		// executando uma rotina sql no banco de dados
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into usuario(nome, email, senha)values(?,?,md5(?))");
		preparedStatement.setString(1, usuario.getNome());
		preparedStatement.setString(2, usuario.getEmail());
		preparedStatement.setString(3, usuario.getSenha());
		preparedStatement.execute();

		connection.close();

	}

	public void update(Integer idUsuario, String novaSenha) throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("update usuario set senha = md5(?) where idUsuario = ?");
		preparedStatement.setString(1, novaSenha);
		preparedStatement.setInt(2, idUsuario);
		preparedStatement.execute();
		
		// fechando a conexão com o banco de dados
		connection.close();
		
	}
	//
	public Usuario findByEmail(String email) throws Exception {

		Connection connection = ConnectionFactory.openConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();

		Usuario usuario = null;

		// verificar se algum registro foi obtido
		if (resultSet.next()) {

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));

		}
		connection.close();

		return usuario;
	}

	public Usuario findByEmailAndSenha(String email, String senha) throws Exception {

		Connection connection = ConnectionFactory.openConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from usuario where email = ? and senha = md5(?)");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, senha);
		ResultSet resultSet = preparedStatement.executeQuery();

		Usuario usuario = null;

		// verificar se algum registro foi obtido
		if (resultSet.next()) {

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));

		}
		connection.close();

		return usuario;

	}
}
