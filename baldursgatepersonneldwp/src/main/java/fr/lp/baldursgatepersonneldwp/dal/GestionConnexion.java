package fr.lp.baldursgatepersonneldwp.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class GestionConnexion {
	private static DataSource dataSource;

	static
	{
		Context context;
		try {
			context = new InitialContext();
			GestionConnexion.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		return GestionConnexion.dataSource.getConnection();
	}
}


