
	package view;

	import java.sql.Connection;

	import controller.CursosJdbcDAO;
    import controller.CursosJdbcDAO;
    import controller.JdbUtil;
	import model.Cursos;

	public class AprendizesExec {
		public static void main (String []args) {
			Cursos cursos = new Cursos();
			
			try {
				cursos.setNome(" Ética ");
				cursos.setDias("Quar");
				cursos.setCarga("2 horas");

				
				Connection connection = JdbUtil.getConnection();
				CursosJdbcDAO cursosJdbcDao = new CursosJdbcDAO(connection);
				
				cursosJdbcDao.salvar(cursos);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}