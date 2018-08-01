package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {
	public static void main (String []args) {
		Alunos alunos = new Alunos();
		
		try {
			alunos.setNome("Vitor ");
			alunos.setEndereco("Av Dos Libaneses, 55");
			alunos.setBairro("Jd Exterior");
			alunos.setCep(55155);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			alunosJdbcDao.deletar(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
