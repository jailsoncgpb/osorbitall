package br.com.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.dao.ConexaoDao;


public class AcompanhaChamdo extends JFrame {

	private static final long serialVersionUID = -1230438525737825081L;
	private JTable table;
	private JButton btnChamadosAberto;
	private JButton btnEmAndamento;
	private JButton btnPendenteDeTerceiros;
	private JLabel lblResultadoDaBusca;
	private JButton btnTodos;
	private JPanel contentPane;
    private Vector<String> cabecalho = new Vector<String>();
    private Vector<Vector> linhas = new Vector<Vector>();
    private int consulta = 0;

    
	  public static void main(String args[]) throws ClassNotFoundException	  {
	    JFrame janela = new AcompanhaChamdo();
	    janela.setUndecorated(true);
	    janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    janela.setVisible(true);
	  }
	  
	  public AcompanhaChamdo() throws ClassNotFoundException  {   
		  
		  
	    setTitle( "SysCalled > Acompanhamento dos Chamados" );
	    setBounds(100,100,450, 300);
	    contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
	    btnChamadosAberto = new JButton("Chamados Aberto");
	    btnChamadosAberto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consulta = 1;
				if (!ConexaoDao.getConnection())  {
					JOptionPane.showMessageDialog(null, "Falha na conexão, o sistema será fechado!");
					System.exit(0);
				}else{
				    geraTabela();
				    JFrame janela;
					try {
						janela = new AcompanhaChamdo();
					    janela.setVisible(true);
	                    dispose();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnChamadosAberto.setBounds(124, 28, 119, 51);
		contentPane.add(btnChamadosAberto);
	
		btnEmAndamento = new JButton("Em Andamento");
		btnEmAndamento.setBounds(253, 28, 105, 51);
		contentPane.add(btnEmAndamento);
		
		btnPendenteDeTerceiros = new JButton("Pendente de Terceiros");
		btnPendenteDeTerceiros.setBounds(368, 29, 141, 50);
		contentPane.add(btnPendenteDeTerceiros);
		
		lblResultadoDaBusca = new JLabel("Resultado da Busca");
		lblResultadoDaBusca.setBounds(23, 114, 105, 20);
		contentPane.add(lblResultadoDaBusca);
		
		btnTodos = new JButton("Todos");
		btnTodos.setBounds(519, 29, 94, 50);
		contentPane.add(btnTodos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 240, 403, 290);
		contentPane.add(scrollPane);
		
		
	    if (!ConexaoDao.getConnection())
	    {
	      JOptionPane.showMessageDialog(null, "Falha na conexão, o sistema será fechado!");
	      System.exit(0);
	    }

		table = new JTable();
	    
       	geraTabela();
 
       	table = new JTable(linhas,cabecalho);
    	JScrollPane scroller = new JScrollPane( table );
    	scrollPane.setViewportView(scroller);
       
        
	  }

	  private void geraTabela(){
			try{
				cabecalho = new Vector<String>();
				linhas = new Vector<Vector>();
				
				System.out.println("consulta: "+consulta);
		    
				if(consulta == 0){
					ConexaoDao.setResultSet("select * from tbchamados");
				}else if(consulta == 1){
					ConexaoDao.setResultSet("select * from tbchamados where idLogChamado = "+2);
				}
				
				ConexaoDao.resultSet.next();  
				ResultSetMetaData rsmd = ConexaoDao.resultSet.getMetaData();
				for ( int i = 1; i <= rsmd.getColumnCount(); ++i ) 
					cabecalho.addElement( rsmd.getColumnName( i ) );
					do {
						Vector<Object> linhaAtual = new Vector<Object>();
						for ( int i = 1; i <= rsmd.getColumnCount(); i++ ){
							switch( rsmd.getColumnType(i)){
								case Types.VARCHAR:
									linhaAtual.addElement(ConexaoDao.resultSet.getString(i));break;
								case Types.TIMESTAMP:
									linhaAtual.addElement(ConexaoDao.resultSet.getDate(i));break;
								case Types.INTEGER:
									linhaAtual.addElement(ConexaoDao.resultSet.getInt(i));break;
								case Types.DATE:
									linhaAtual.addElement(ConexaoDao.resultSet.getDate(i));break;
								case Types.DECIMAL:
									linhaAtual.addElement(ConexaoDao.resultSet.getDouble(i));break;
							}
						}
						linhas.addElement(linhaAtual);     
					} 
					while ( ConexaoDao.resultSet.next() );       
						table = new JTable( linhas, cabecalho );
						JScrollPane scroller = new JScrollPane( table );
						getContentPane().add(scroller, BorderLayout.CENTER);
					}catch (SQLException erro) { }
				} 
}
