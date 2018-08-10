	package controller;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import model.Cursos;

	public class CursosJdbcDAO {
		
		private Connection conn;
		
		public CursosJdbcDAO(Connection conn) {
			this.conn = conn;
		}
		
		public void salvar(Cursos c) throws SQLException{
			String sql = "insert into cursos (nome,endereco,bairro) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"')";
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} 
		
		public void deletar(int id) throws SQLException{
			String sql = "delete from cursos where id ="+id;
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		
	}
