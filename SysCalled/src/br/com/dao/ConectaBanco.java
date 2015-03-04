package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectaBanco {
	
	
	public static Connection conectabd() throws ClassNotFoundException{
		   
		   try{
			
			Class.forName("com.mysql.jdbc.Driver");   
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdosorb","root","root");			
			JOptionPane.showMessageDialog(null,"Conectado com Sucesso!");
			return con;
		   }
		   
		   catch(SQLException error){
			   
			   JOptionPane.showMessageDialog(null, error);
			   return null;
		   }
		   
	   }
		

}
