package br.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.dao.ConectaBanco;
import br.com.dao.ConexaoDao;
import br.com.model.Campos;

public class AbrirChamado extends JFrame {

	private JPanel contentPane;
	private JTextField textData;
	private JLabel lblHora;
	private JTextField textHora;
	private JTextField textNchamado;
	private JTextField textSchamado;
	private JTextField textSolicitante;
	private JTextField textNhost;
	private JTextField textRavaya;
	private JTextField textUavaya;
	private JTextField textPosicao;
	
	Campos campos = new Campos();
    ConexaoDao conexaoDao = new ConexaoDao();
    
      Connection con = null;
	  PreparedStatement pst = null;
	  ResultSet rs =null;
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	  
	public AbrirChamado () throws ClassNotFoundException {
		
		con = ConectaBanco.conectabd();
		
		setTitle("SysCalled - Abrir Chamado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-27, -30, 680, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textData = new JTextField();
		textData.setEditable(false);
		textData.setBounds(46, 26, 86, 20);		
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(0, 29, 46, 14);
		contentPane.add(lblData);
		
		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(130, 29, 46, 14);
		contentPane.add(lblHora);
		
		textHora = new JTextField();
		textHora.setEditable(false);
		textHora.setBounds(170, 26, 86, 20);
		contentPane.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblNumeroChamado = new JLabel("Numero Chamado");
		lblNumeroChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroChamado.setBounds(270, 29, 105, 14);
		contentPane.add(lblNumeroChamado);
		
		textNchamado = new JTextField();
		textNchamado.setEditable(false);
		textNchamado.setBounds(374, 26, 86, 20);
		contentPane.add(textNchamado);
		textNchamado.setColumns(10);
		
		JLabel lblStatusChamado = new JLabel("Status Chamado");
		lblStatusChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusChamado.setBounds(467, 29, 98, 14);
		contentPane.add(lblStatusChamado);
		
		textSchamado = new JTextField();
		textSchamado.setEditable(false);
		textSchamado.setBounds(562, 26, 86, 20);
		contentPane.add(textSchamado);
		textSchamado.setColumns(10);
		
		JLabel lblSolicitante = new JLabel("Solicitante");
		lblSolicitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitante.setBounds(32, 84, 66, 14);
		contentPane.add(lblSolicitante);
		
		textSolicitante = new JTextField();
		textSolicitante.setEnabled(false);
		textSolicitante.setBounds(108, 80, 303, 20);
		contentPane.add(textSolicitante);
		textSolicitante.setColumns(10);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetor.setBounds(430, 83, 46, 14);
		contentPane.add(lblSetor);
		
		JComboBox<String> comboSetor = new JComboBox<String>();
		comboSetor.setModel(new DefaultComboBoxModel<String>(new String[] {"ORBITALL", "ORBITALL-BBS", "STEFANINI", "ADMINISTRATIVO", "TREINAMENTO"}));
		comboSetor.setEditable(true);
		comboSetor.setEnabled(false);
		comboSetor.setBounds(481, 80, 143, 20);
		contentPane.add(comboSetor);
		
		JLabel lblNomeDoHost = new JLabel("Nome do Host");
		lblNomeDoHost.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoHost.setBounds(75, 128, 91, 14);
		contentPane.add(lblNomeDoHost);
		
		textNhost = new JTextField();
		textNhost.setEnabled(false);
		textNhost.setBounds(163, 125, 183, 20);
		contentPane.add(textNhost);
		textNhost.setColumns(10);
		
		JLabel lblRamalAvaya = new JLabel("Ramal Avaya");
		lblRamalAvaya.setHorizontalAlignment(SwingConstants.CENTER);
		lblRamalAvaya.setBounds(124, 174, 87, 14);
		contentPane.add(lblRamalAvaya);
		
		textRavaya = new JTextField();
		textRavaya.setEnabled(false);
		textRavaya.setBounds(210, 171, 86, 20);
		contentPane.add(textRavaya);
		textRavaya.setColumns(10);
		
		JLabel lblUsuarioAvaya = new JLabel("Usuario Avaya");
		lblUsuarioAvaya.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioAvaya.setBounds(303, 174, 81, 14);
		contentPane.add(lblUsuarioAvaya);
		
		textUavaya = new JTextField();
		textUavaya.setEnabled(false);
		textUavaya.setBounds(392, 171, 86, 20);
		contentPane.add(textUavaya);
		textUavaya.setColumns(10);
		
		JLabel lblDescrioDoProblema = new JLabel("Descricao do Problema");
		lblDescrioDoProblema.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrioDoProblema.setBounds(19, 214, 143, 14);
		contentPane.add(lblDescrioDoProblema);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(29, 239, 600, 101);
		contentPane.add(textArea);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textData.setText(new SimpleDateFormat("dd/MM/yyyy")
				  .format(new Date(System.currentTimeMillis())));
				
				textHora.setText(new SimpleDateFormat("hh:mm")
				  .format(new Date(System.currentTimeMillis())));
				
				textPosicao.setEnabled(true);
				textSchamado.setText("Aberto");
				textSolicitante.setEnabled(true);
				textRavaya.setEnabled(true);
				textUavaya.setEnabled(true);
				textNhost.setEnabled(true);
				textArea.setEnabled(true);
				comboSetor.setEnabled(true);
				
				
				
			}
		});
		btnNovo.setBounds(53, 372, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textSchamado.setText("");
				textData.setText("");
				textHora.setText("");
				textSolicitante.setText("");   
				textRavaya.setText("");
				textUavaya.setText("");
				textNhost.setText("");
				textArea.setText("");
				textPosicao.setText("");
				comboSetor.setSelectedIndex(0);					
				
				textPosicao.setEnabled(false);
				textSolicitante.setEnabled(false);
				textRavaya.setEnabled(false);
				textUavaya.setEnabled(false);
				textNhost.setEnabled(false);
				textArea.setEnabled(false);
				comboSetor.setEnabled(false);
				
				
				
			}
		});
		btnCancelar.setBounds(269, 372, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		String sql = "INSERT INTO tbchamados (Data_Chamado, Hora_Chamado,Numero_Chamado, Status_Chamdo, Solicitante_Chamdo, Setor_Chamado, Ramal_Chamado, Host_Chamado, UsuarioA_Chamado,	Descricao_Chamado) values (?,?,?,?,?,?,?,?,?,?)";
				
				try{
				
				pst = con.prepareStatement(sql);
				
				//parametro para resgate da data
				
				String dia = textData.getText().substring(0,2);
				String mes = textData.getText().substring(3,5);
				String ano = textData.getText().substring(6);
				String dataMysql = ano+"-"+mes+"-"+dia;						
				pst.setString(1,dataMysql);
								
				pst.setString(2,textHora.getText().trim());
				pst.setString(3,textNchamado.getText().trim());
			    pst.setString(4,textSchamado.getText().trim());
			    pst.setString(5,textSolicitante.getText().trim());
				pst.setString(6,(String) comboSetor.getSelectedItem());
			    pst.setString(7,textRavaya.getText().trim());
			    pst.setString(8,textNhost.getText().trim());
			    pst.setString(9,textUavaya.getText().trim());
			    pst.setString(10,textArea.getText().trim());
			    
			    pst.execute();
			    pst.close();
				
			    JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
			    
			    textSchamado.setText("");
				textData.setText("");
				textHora.setText("");
				textSolicitante.setText("");   
				textRavaya.setText("");
				textUavaya.setText("");
				textNhost.setText("");
				textPosicao.setText("");
				textArea.setText("");
				comboSetor.setSelectedIndex(0);					
				
				textSolicitante.setEnabled(false);
				textRavaya.setEnabled(false);
				textUavaya.setEnabled(false);
				textNhost.setEnabled(false);
				textPosicao.setEnabled(false);
				textArea.setEnabled(false);
				comboSetor.setEnabled(false);
			    
			    
				
				}catch (SQLException erro) {
					
					JOptionPane.showMessageDialog(null,erro);
				}
			}
		});
		btnEnviar.setBounds(503, 372, 89, 23);
		contentPane.add(btnEnviar);
		
		textPosicao = new JTextField();
		textPosicao.setEnabled(false);
		textPosicao.setBounds(423, 126, 98, 20);
		contentPane.add(textPosicao);
		textPosicao.setColumns(10);
		
		JLabel lblPosicaoPa = new JLabel("Posicao PA");
		lblPosicaoPa.setBounds(356, 128, 66, 14);
		contentPane.add(lblPosicaoPa);
	}
}
