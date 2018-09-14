	package controller;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

import model.Aprendizes;
import model.Cursos;

	public class CursosJdbcDAO {
		
		private Connection conn;
		
		public CursosJdbcDAO(Connection conn) {
			this.conn = conn;
		}
		
	public void salvar(Cursos c) throws SQLException{
			String sql = "insert into curso (nome,dias,carga) values ('"+c.getNome()+"','"+c.getDias()+"','"+c.getCarga()+"')";
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} 
		
		public void deletar(int id) throws SQLException{
			String sql = "delete from curso where id_curso ="+id;
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		
		public void alterar(Cursos c, int id) {
			String sql = "update curso set nome='"+c.getNome()+"',dias='"+c.getDias()+"',carga='"+c.getCarga()+"' where id_curso =" + id;
			System.out.println(sql);
			PreparedStatement prepareStatement;
			try {
				prepareStatement = this.conn.prepareStatement(sql);
				prepareStatement.executeUpdate();
		        prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		
		
	}