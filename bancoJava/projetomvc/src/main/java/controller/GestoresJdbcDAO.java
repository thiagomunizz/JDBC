package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Aprendizes;
import model.Gestores;

public class GestoresJdbcDAO {
	
	private Connection conn;
	
	public GestoresJdbcDAO(Connection conn) {
		this.conn = conn;
	} 
	
	public void salvar(Gestores c) throws SQLException{
		String sql = "insert into gestor (nome,endereco,bairro,cpf) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCpf()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	} 
	
	public void deletar(int id) throws SQLException{
		String sql = "delete from gestores where id ="+id;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}