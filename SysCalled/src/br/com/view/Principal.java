package br.com.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public Principal() throws ClassNotFoundException {
		
		AbrirChamado frmAbrirChamado = new AbrirChamado();
		AcompanhaChamdo AcompanhaChamdo = new AcompanhaChamdo();
		
		
		setTitle("SysCalled > Orbitall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frmAbrirChamado.setLocationRelativeTo(null);
		
		JButton btnNovoChamado = new JButton("Novo Chamado");
		btnNovoChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAbrirChamado.setVisible(true);
				
				
			}
		});
		btnNovoChamado.setBounds(10, 36, 131, 41);
		contentPane.add(btnNovoChamado);
		
		JButton btnAcompanharChamado = new JButton("Acompanhar Chamado");
		btnAcompanharChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AcompanhaChamdo.setVisible(true);
			}
		});
		btnAcompanharChamado.setBounds(260, 36, 172, 41);
		contentPane.add(btnAcompanharChamado);
	}
}
