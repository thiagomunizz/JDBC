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
			String sql = "delete from aprendiz where id_aprendiz ="+id;
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		
		public void alterar(Aprendizes c, int id) {
			String sql = "update aprendiz set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',cpf='"+c.getCpf()+"' where id_aprendiz =" + id;
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