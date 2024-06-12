package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.bean.Cliente;
import br.com.fiap.fintech.dao.ClienteDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleClienteDAO implements ClienteDAO{

	private Connection conexao;

	@Override
	public void cadastrar(Cliente cliente) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.gerInstance().getConnection();
			String sql = "INSERT INTO TB_CLINTE (ID_CLIENTE, NM_CLIENTE, QT_PRODUTO, CPF_CLIENTE, NR_CONTAO) VALUES (SQ_TB_CLIENTE.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getNumeroContato());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws DBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Cliente cliente) throws DBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void buscar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
