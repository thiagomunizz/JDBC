	package controller;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import model.Aprendizes;

	public class AprendizesJdbcDAO {
		
		private Connection conn;
		
		public AprendizesJdbcDAO(Connection conn) {
			this.conn = conn;
		}
		
		public void salvar(Aprendizes c) throws SQLException{
			String sql = "insert into aprendiz (nome,endereco,bairro,cpf) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCpf()+"')";
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} 
		
		public void deletar(int id) throws SQLException{
			String sql = "delete from aprendiz where id ="+id;
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		
	}