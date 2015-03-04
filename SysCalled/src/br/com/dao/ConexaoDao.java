package br.com.dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDao {

	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;
	
	/*	Access - "sun.jdbc.odbc.JdbcOdbcDriver"
	 * 	Mysql - "com.mysql.jdbc.Driver"
	 * 	Oracle - "oracle.jdbc.driver.OracleDriver"
	 * Microsoft SQL Server - "com.microsoft.jdbc.sqlserver.SQLServerDriver"
	 * Sysbase - "com.sysbase.jdbc2.jdbc.SybDriver"
	 * Postgre - "org.postgresql.Driver"
	 * DB2/Neon - "com.neon.jdbc.Driver"
	 */
	
	
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/bdosorb";
	public static final String login = "root";
	public static final String senha = "root";
	
			
	public static boolean getConnection(){
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login,senha);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			return true;
		}catch (ClassNotFoundException erro){
			erro.printStackTrace();
			return false;
		}catch(SQLException erro){
			erro.printStackTrace();
			return false;
		}
	}
	
	public static void close(){
		closeResultSet();
		closeStatement();
		closeConnection();
	}
	
	private static void closeConnection(){
		try{
			connection.close();
			JOptionPane.showMessageDialog(null, "Desconectou...");
		}catch(SQLException erro){
			erro.printStackTrace();
		}
	}
	
	private static void closeStatement(){
		try{
			statement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void closeResultSet(){
		try{
			resultSet.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Carrega o resultSet com o resultado do script SQL
	public static void setResultSet(String sql){
		try{
			resultSet =  statement.executeQuery(sql);
		}catch(SQLException erro){
			erro.printStackTrace();
		}
	}
	
	/*Executa um script SQL de atualização
	 * retorna um valor inteiro contendo a
	 * quantidade de linhas afetadas
	 */
	public static int runSql(String sql){
		int quant = 0 ;
		try{
			quant = statement.executeUpdate(sql);
		}catch(SQLException erro){
			erro.printStackTrace();
		}
		return quant;
	}
	
	
	
}
