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
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

@ManagedBean
@RequestScoped
public class CustomerBean implements Serializable {
	@Resource
	private DataSource ds;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2017687577664903494L;

	public ResultSet getAll() throws SQLException, NamingException {
		Context initCtx = null;
		Context envCtx  = null;
		Connection conn = null;
	    DataSource ds;
	    // configuration from tomcat JNDI :
	    // https://tomcat.apache.org/tomcat-7.0-doc/jndi-resources-howto.html
		try 
		{
			initCtx = new InitialContext();
			envCtx  = (Context) initCtx.lookup("java:comp/env");
			
			ds   = (DataSource) envCtx.lookup("jdbc/mydb");
			conn = ds.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM Customers");
			// return ResultSupport.toResult(result)

			// CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl();
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			// or use an implementation from your database vendor
			crs.populate(result);

			return crs;
		} finally {
			conn.close();
		}
	}

}
