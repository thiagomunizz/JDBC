package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.GestoresJdbcDAO;
import controller.JdbUtil;
import model.Aprendizes;
import model.Gestores;


/**
 * Hello world!
 *
 */
public class App extends JFrame
{
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
		
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");

	JButton btnSalvar = new JButton("Salvar");

	public App(){
		super("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(90, 50, 225, 30);	
		
		paine.add(bairro);
		paine.add(txtBairro);	
		bairro.setBounds(10, 85, 70, 30);
		txtBairro.setBounds(90, 85, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Gestores gestores = new Gestores();
				gestores.setNome(txtNome.getText());
				gestores.setEndereco(txtEnd.getText());
				gestores.setBairro(txtBairro.getText());
				
				Connection connection = JdbUtil.getConnection();
				GestoresJdbcDAO gestoresJdbcDao = new GestoresJdbcDAO(connection);
				
				gestoresJdbcDao.salvar(gestores);
				
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
    	App app = new App();
    }
}
