package br.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.dao.ConectaBanco;
//import br.com.dao.ConexaoDao;


public class AcompanhaChamdo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	  Connection con = null;
	  PreparedStatement pst = null;
	  ResultSet rs =null;
	  

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	
	public AcompanhaChamdo () throws ClassNotFoundException {
		
		con = ConectaBanco.conectabd();
		
		setTitle("SysCalled > Acompanhamento dos Chamados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChamadosAberto = new JButton("Chamados Aberto");
		btnChamadosAberto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				
				geraTabela();		
				
		  }		
		});
		
		
		btnChamadosAberto.setBounds(124, 28, 119, 51);
		contentPane.add(btnChamadosAberto);
		
		JButton btnEmAndamento = new JButton("Em Andamento");
		btnEmAndamento.setBounds(253, 28, 105, 51);
		contentPane.add(btnEmAndamento);
		
		JButton btnPendenteDeTerceiros = new JButton("Pendente de Terceiros");
		btnPendenteDeTerceiros.setBounds(368, 29, 141, 50);
		contentPane.add(btnPendenteDeTerceiros);
		
		JLabel lblResultadoDaBusca = new JLabel("Resultado da Busca");
		lblResultadoDaBusca.setBounds(23, 114, 105, 20);
		contentPane.add(lblResultadoDaBusca);
		
		JButton btnTodos = new JButton("Todos");
		btnTodos.setBounds(519, 28, 94, 50);
		contentPane.add(btnTodos);
		
		table = new JTable();
		table.setBounds(23, 146, 688, 251);
		contentPane.add(table);
	}
	

	public void geraTabela() {
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //mantem o tamanho das colunas  
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); desabilita a seleção multipla  
		table.setModel(new DefaultTableModel( 
				
	            new Object [][]{},  
	            new String[] {"Código", "Nome", "Endereço",  
	            "Cidade", "Bairro", "Telefone", "Celular", "E-mail",  
	            "RG", "CPF", "Nascimento", "Sexo"}  
	    ));  
	  
		table.getColumnModel().getColumn(0).setPreferredWidth(80);  
		table.getColumnModel().getColumn(1).setPreferredWidth(270);  
		table.getColumnModel().getColumn(2).setPreferredWidth(270);  
		table.getColumnModel().getColumn(3).setPreferredWidth(150);  
		table.getColumnModel().getColumn(4).setPreferredWidth(150);  
		table.getColumnModel().getColumn(5).setPreferredWidth(100);  
		table.getColumnModel().getColumn(6).setPreferredWidth(100);  
		table.getColumnModel().getColumn(7).setPreferredWidth(300);		  
		table.getColumnModel().getColumn(9).setPreferredWidth(90);  
		table.getColumnModel().getColumn(10).setPreferredWidth(75);  
		table.getColumnModel().getColumn(11).setPreferredWidth(40);  
	  
	    ConectaPGSQL.retorna_obj_ConectaPGSQL().execSQL("select Setor_Chamado,Posicao_Pa_chamado,Hora_Chamado,Status_Chamdo,Solicitante_Chamado from tbchamados where Status_Chamdo = 'ABERTO'");  
	    enche_tabela();  
	  
//------------------------------------------------------------------------------------------	  
	private void enche_tabela() {  
	    
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();  
	    modelo.setNumRows(0);  
	  
	    try {  
	    
	    	while(ConectaPGSQL.retorna_obj_ConectaPGSQL().resultsql.next()) {  
	            modelo.addRow(new Object[] {  
	                ConectaPGSQL.retorna_obj_ConectaPGSQL().resultsql.getString("pess_codigo"),  
	                ConectaPGSQL.retorna_obj_ConectaPGSQL().resultsql.getString("pess_nome"),  
	                ConectaPGSQL.retorna_obj_ConectaPGSQL().resultsql.getString("pess_endereco"),  
	                ConectaPGSQL.retorna_obj_ConectaPGSQL().resultsql.getString("pess_cidade"),  
	                ConectaPGSQL.retorna_obj_ConectaPGSQL().resultsql.getString("pess_bairro")  
	  
	            });  
	        }  
	    }  
	    catch(SQLException erro){  
	        JOptionPane.showMessageDialog(null,"Erro ao listar no JTable "+erro);  
	  
	    }  
	}  
}