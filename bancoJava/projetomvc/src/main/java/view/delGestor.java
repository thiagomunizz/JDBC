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

public class delGestor extends JFrame {
	
	JButton btnDeletar = new JButton("Deletar");
	JTextField id = new JTextField();
	JLabel txtId = new JLabel("Digite o id que será deletado: ");

	 
	
	public delGestor() {
	super("Deletar Gestor");
	
	Container paine = this.getContentPane();
	
	paine.add(btnDeletar);
	btnDeletar.setBounds(10, 15, 200, 30);
	
	paine.add(id);
	paine.add(txtId);
	id.setBounds(180, 75, 300, 30);
	txtId.setBounds(10, 75, 225, 30);
	
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(600, 330);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	paine.add(btnDeletar);
	btnDeletar.setBounds(250, 250, 130, 30);
	
	btnDeletar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e ) {
			try {
				Connection connection = JdbUtil.getConnection();
				GestoresJdbcDAO deletargestoresJdbcDAO = new GestoresJdbcDAO(connection);
				
				deletargestoresJdbcDAO.deletar(Integer.parseInt(id.getText()));
			}catch(Exception err) {
				err.printStackTrace();
			}
			
		}
	});
	
	}
	
	public static void main(String args[]) {
		delGestor dr = new delGestor();
	}

}
