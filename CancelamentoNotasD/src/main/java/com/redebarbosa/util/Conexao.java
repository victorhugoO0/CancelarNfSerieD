package com.redebarbosa.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String DRIVER = "com.ibm.db2.jcc.DB2Driver";
	private static final String URL = "jdbc:db2://192.168.100.250:50000/barbosa";
	private static final String USER = "dba";
	private static final String PASSWORD = "overhead";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("-----------------------------------------");
			System.out.println("Erro na conexão");
			e.printStackTrace();
		}
		return null;
	}
}
