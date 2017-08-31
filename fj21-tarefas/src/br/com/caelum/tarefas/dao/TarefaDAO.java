package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tarefas.model.Tarefa;

public class TarefaDAO {
	
	private Connection connection;
	
	public TarefaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Tarefa tarefa) {
		String sql = "insert into tarefas (descricao) values (?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Tarefa> lista(){
		List<Tarefa> tarefas = new ArrayList<>();
		try {
			String sql = "select * from tarefas";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Long id) {
		try {
			String sql = "delete from tarefas where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Tarefa buscaPorId(Long id) {
		try {
			String sql = "select * from tarefas where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Tarefa tarefa = new Tarefa();
			while(rs.next()) {
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
			}
			stmt.close();
			rs.close();
			return tarefa;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Tarefa tarefa) {
		try {
			String sql = "update tarefas set descricao = ? where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setLong(2, tarefa.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void finaliza(Long id) {
		try {
			String sql = "update tarefas set finalizado = ? where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setLong(2, id);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
