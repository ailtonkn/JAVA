package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class Tela_de_acesso extends JFrame {
	private JTextField efUsuario;
	private JPasswordField pfSenha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_acesso frame = new Tela_de_acesso();
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
	public Tela_de_acesso() {
		getContentPane().setBackground(new Color(0, 153, 204));
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 98, 103, 48);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(0, 51, 102));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(24, 159, 103, 48);
		getContentPane().add(lblSenha);
		
		efUsuario = new JTextField();
		efUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		efUsuario.setBackground(Color.WHITE);
		efUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		efUsuario.setForeground(new Color(0, 0, 0));
		efUsuario.setBounds(137, 108, 186, 30);
		getContentPane().add(efUsuario);
		efUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBorder(new LineBorder(new Color(0, 0, 0)));
		pfSenha.setBackground(Color.WHITE);
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pfSenha.setBounds(137, 169, 186, 30);
		getContentPane().add(pfSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_senhas where usuario=? and senha=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, efUsuario.getText());

					stmt.setString(2, new String(pfSenha.getPassword()));

					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_de_cadastro exibir = new Tela_de_cadastro(); //substituído posteriormente pela instrução que abre outra janela
						exibir.setVisible(true);
						
						setVisible(false);
						
					}else {

						JOptionPane.showMessageDialog(null, "Acesso não permitido");

					}

					

					stmt.close();

					con.close();

					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}
				
				
			}
		});
		btnNewButton.setBounds(176, 225, 108, 30);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tela de acesso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 0, 386, 388);
		getContentPane().add(panel);
		setAlwaysOnTop(true);
		setTitle("Tela de acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 427);
	}
}
