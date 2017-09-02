package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.model.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean existeUsuario(Usuario usuario) {
		try {
			String sql = "select * from usuarios where nome like ? and senha like ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, "%"+usuario.getNome()+"%");
			stmt.setString(2, "%"+usuario.getSenha()+"%");

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				if(usuario.getNome().equals(nome)&&usuario.getSenha().equals(senha)) {
					return true;
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

}
