package com.corejsf;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@ManagedBean
@RequestScoped
public class CustomerBean implements Serializable {
	@Resource
	private DataSource ds;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2017687577664903494L;
	private Statement stmt;
	private ResultSet result;

	public CustomerBean() {
		this.connect();
	}

	private void connect() {
		// configuration from tomcat JNDI :
		// https://tomcat.apache.org/tomcat-7.0-doc/jndi-resources-howto.html

		try {
			Context initCtx = new InitialContext();

			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			DataSource   ds = (DataSource) envCtx.lookup("jdbc/mydb");
			Connection conn = ds.getConnection();

			stmt = conn.createStatement();
			result = stmt.executeQuery("SELECT * FROM Customers");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet getAll() throws SQLException, NamingException {
			return result;
	}

	public String sortByName() {
		try {
			result = stmt.executeQuery("SELECT * FROM Customers order by Name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String sortByCity() {
		try {
			result = stmt.executeQuery("SELECT * FROM Customers order by City");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return null;
	}

}
