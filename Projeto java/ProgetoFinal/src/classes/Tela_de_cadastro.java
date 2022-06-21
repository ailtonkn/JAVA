package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tela_de_cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfBusca;
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_cadastro frame = new Tela_de_cadastro();
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
	public Tela_de_cadastro() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new TitledBorder(null, "Cadastro de Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 46, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 86, 59, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 139, 59, 19);
		contentPane.add(lblNewLabel_2);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(77, 45, 96, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(77, 90, 267, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(77, 138, 267, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 202, 436, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(14, 27, 101, 27);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Usuario/Senha em branco");
				
				}else {
				try {
					
					Connection con = Conexao.faz_conexao();

					String sql = "insert into dados_senhas(usuario, senha) value (?, ?) ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2, tfSenha.getText());
					
					stmt.execute();
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null,"Usuário e senha cadastrados com sucesso!");
					
					tfUsuario.setText("");
					tfSenha.setText("");
					
				} catch (SQLException e2) {
					// TODO: handle exception
				}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(tfId.getText().equals("")) {
					
					
					JOptionPane.showMessageDialog(null, "Abra os dados para realizar alterações");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "update dados_senhas set usuario=?, senha=? where id=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2,tfSenha.getText());

					stmt.setString(3, tfId.getText());

					

					stmt.execute();

					stmt.close();

					con.close();

					

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

					

					stmt.close();

					con.close();

					

					//limpa os campos

					

					tfUsuario.setText("");

					tfSenha.setText("");

					tfId.setText("");

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
			
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtualizar.setBounds(167, 27, 101, 27);
		panel.add(btnAtualizar);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Abra os dados para realizar alterações");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "delete from dados_senhas where id=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					

					stmt.setString(1, tfId.getText());

					

					stmt.execute();

					stmt.close();

					con.close();

					

					JOptionPane.showMessageDialog(null, "Usuário excluído");

					

					stmt.close();

					con.close();

					

					//limpa os campos

					

					tfUsuario.setText("");

					tfSenha.setText("");

					tfId.setText("");

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(307, 27, 101, 27);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Abrir dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(0, 437, 436, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tfBusca = new JTextField();
		tfBusca.setForeground(Color.BLACK);
		tfBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfBusca.setBackground(Color.WHITE);
		tfBusca.setBounds(120, 27, 55, 27);
		panel_1.add(tfBusca);
		tfBusca.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Listar Dados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_senhas";

					

					PreparedStatement stmt = con.prepareStatement(sql);

							

					ResultSet rs = stmt.executeQuery();



					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();

					modelo.setNumRows(0);

					while (rs.next()) {

					

						

						modelo.addRow(new Object[]{rs.getString("id"), rs.getString("usuario"), rs.getString("senha")});

						

					}

					

					

					

					rs.close();

					con.close();

			

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

			

				}
				
		
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(185, 27, 128, 27);
		panel_1.add(btnNewButton_1);
		
		JButton tfAbrir = new JButton("Abrir");
		tfAbrir.setBounds(14, 27, 101, 27);
		panel_1.add(tfAbrir);
		tfAbrir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(323, 27, 92, 27);
		panel_1.add(btnNewButton_3);
		tfAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tfBusca.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Informe o id");
					
				}else {
				
				try {
					
						Connection con = Conexao.faz_conexao();

						String sql = "select *from dados_senhas where id=?";

					

						PreparedStatement stmt = con.prepareStatement(sql);

					

						stmt.setString(1, tfBusca.getText());
					
						ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						
						tfId.setText(rs.getString("id"));
						tfUsuario.setText(rs.getString("usuario"));
						tfSenha.setText(rs.getString("senha"));
						
					}
					
					rs.close();
					con.close();
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 204));
		panel_2.setBorder(new TitledBorder(null, "Tabela de cadastros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(0, 268, 436, 173);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 416, 140);
		panel_2.add(scrollPane);
		scrollPane.setToolTipText("");
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Id", "Usu\u00E1rio", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbDados);
	}
}
