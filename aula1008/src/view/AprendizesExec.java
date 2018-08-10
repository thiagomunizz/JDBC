
	package view;

	import java.sql.Connection;

	import controller.AprendizesJdbcDAO;
	import controller.JdbUtil;
	import model.Aprendizes;

	public class AprendizesExec {
		public static void main (String []args) {
			Aprendizes aprendizes = new Aprendizes();
			
			try {
				aprendizes.setNome(" Mauro ");
				aprendizes.setEndereco("Av dos Trabalhadores, 657");
				aprendizes.setBairro("São Miguel Paulista");

				
				Connection connection = JdbUtil.getConnection();
				AprendizesJdbcDAO alunosJdbcDao = new AprendizesJdbcDAO(connection);
				
				alunosJdbcDao.salvar(aprendizes);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
