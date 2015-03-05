package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import br.com.view.*;

public class Principal {

	private JFrame frmSyscalledOrbitall;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmSyscalledOrbitall.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public Principal() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmSyscalledOrbitall = new JFrame();
		frmSyscalledOrbitall.setTitle("SysCalled > Orbitall");
		frmSyscalledOrbitall.setBounds(100, 100, 450, 300);
		frmSyscalledOrbitall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSyscalledOrbitall.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 414, 239);
		frmSyscalledOrbitall.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNovoChamado = new JButton("Novo chamado");
		btnNovoChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirChamado frmAbrirChamado;
				try {
					frmAbrirChamado = new AbrirChamado();
					frmAbrirChamado.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNovoChamado.setMnemonic('N');
		btnNovoChamado.setToolTipText("");
		btnNovoChamado.setBounds(67, 108, 120, 40);
		panel.add(btnNovoChamado);
		
		JButton btnAcompanharChamado = new JButton("Acompanhar Chamado");
		btnAcompanharChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcompanhaChamdo frmAcompanhaChamdo;
				try {
					frmAcompanhaChamdo = new AcompanhaChamdo();
					frmAcompanhaChamdo.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAcompanharChamado.setMnemonic('A');
		btnAcompanharChamado.setBounds(225, 108, 150, 40);
		panel.add(btnAcompanharChamado);
	}
}
