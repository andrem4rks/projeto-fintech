package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.impl.OracleClienteDAO;

public class DAOFactory {
	
	public static OracleClienteDAO getClienteDAO() {
		return new OracleClienteDAO();
	}

}
