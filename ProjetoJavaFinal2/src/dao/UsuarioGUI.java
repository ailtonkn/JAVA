package dao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import modelo.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final JButton btnNewButton_2 = new JButton("SAIR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(null, "Cadastro Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 429, 345);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(194, 58, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cadastrar novo usuario");
		lblNewLabel.setBounds(23, 27, 190, 20);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 89, 96, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 120, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 151, 96, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(122, 61, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(122, 92, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL:");
		lblNewLabel_3.setBounds(122, 123, 49, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TELEFONE:");
		lblNewLabel_4.setBounds(103, 154, 68, 14);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
				Usuario usuarios = new Usuario();
				usuarios.setNome(lblNewLabel_1.getText());
				usuarios.setCpf(lblNewLabel_2.getText());
				usuarios.setEmail(lblNewLabel_3.getText());
				usuarios.setTelefone(lblNewLabel_4.getText());

				// fazendo a validação dos dados
				if ((lblNewLabel_1.getText().isEmpty()) || (lblNewLabel_2.getText().isEmpty()) || (lblNewLabel_3.getText().isEmpty()) || (lblNewLabel_4.getText().isEmpty())) {
				   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				}
				else {

				    // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
				    UsuarioDAO dao = new UsuarioDAO();
				    dao.adiciona(usuarios);
				    JOptionPane.showMessageDialog(null, "Usuário "+lblNewLabel_1.getText()+" inserido com sucesso! ");
				}

				// apaga os dados preenchidos nos campos de texto
				lblNewLabel_1.setText("");
				lblNewLabel_2.setText("");
				lblNewLabel_3.setText("");
				lblNewLabel_4.setText("");
			}
		});
		btnNewButton.setBounds(89, 182, 101, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				lblNewLabel_2.setText("");
				lblNewLabel_3.setText("");
				lblNewLabel_4.setText("");
			}
		});
		btnNewButton_1.setBounds(241, 182, 101, 23);
		panel.add(btnNewButton_1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(141, 216, 125, 23);
		panel.add(btnNewButton_2);
	}
}
