package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CursosJdbcDAO;
import controller.JdbUtil;
import model.Cursos;


public class alterarCurso extends JFrame {
	
	JTextField txtId = new JTextField();
	JLabel id = new JLabel("ID: ");
	
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtDias = new JTextField();
	JLabel dias = new JLabel("DIAS: ");
	
	JTextField txtCarga = new JTextField();
	JLabel carga = new JLabel("CARGA: ");


	
	JButton btnSalvar = new JButton("Alterar");
	public alterarCurso(){
		super("Alterar Curso");
		
		Container paine = this.getContentPane();
		

		
		paine.add(id);
		paine.add(txtId);	
		id.setBounds(10, 15, 45, 30);
		txtId.setBounds(90, 15, 225, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 50, 70, 30);
		txtNome.setBounds(90, 50, 225, 30);	
		
		paine.add(dias);
		paine.add(txtDias);	
		dias.setBounds(10, 85, 70, 30);
		txtDias.setBounds(90, 85, 225, 30);
		
		paine.add(carga); 
		paine.add(txtCarga);
		carga.setBounds(10, 120, 70, 30);
		txtCarga.setBounds(90, 120, 225, 30);
		

		
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					
					
					Cursos curso = new Cursos();
					curso.setId(Integer.parseInt( txtId.getText() ));
					curso.setNome(txtNome.getText());
					curso.setDias(txtDias.getText());
					curso.setCarga(txtCarga.getText());
				Connection connection = JdbUtil.getConnection();
				
				CursosJdbcDAO  cursoJdbcDAO = new CursosJdbcDAO(connection);
				
				cursoJdbcDAO.alterar(curso, curso.getId());
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main( String[] args )
    {
    	alterarCurso ap = new alterarCurso();
    }
}
	
	
	
	
	