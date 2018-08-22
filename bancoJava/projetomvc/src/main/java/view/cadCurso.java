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

/**
 * Hello world!
 *
 */
public class cadCurso extends JFrame
{
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
		
	JTextField txtDias = new JTextField();
	JLabel dias = new JLabel("DIAS: ");
	
	JTextField txtCarga = new JTextField();
	JLabel carga = new JLabel("CARGA: ");
	


	JButton btnSalvar = new JButton("Salvar");

	public cadCurso(){
		super("Cadastro de Cursos");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(dias);
		paine.add(txtDias);	
		dias.setBounds(10, 50, 70, 30);
		txtDias.setBounds(90, 50, 225, 30);	
		
		paine.add(carga);
		paine.add(txtCarga);	
		carga.setBounds(10, 85, 70, 30);
		txtCarga.setBounds(90, 85, 225, 30);
		

		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Cursos cursos = new Cursos();
				cursos.setNome(txtNome.getText());
				cursos.setDias(txtDias.getText());
				cursos.setCarga(txtCarga.getText());

				
				Connection connection = JdbUtil.getConnection();
				CursosJdbcDAO cursosJdbcDao = new CursosJdbcDAO(connection);
				
				cursosJdbcDao.salvar(cursos);
				
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
    	cadCurso cadcurso = new cadCurso();
    }
}