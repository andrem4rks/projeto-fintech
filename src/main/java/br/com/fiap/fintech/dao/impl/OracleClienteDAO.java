package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_CLIENTE (ID_CLIENTE, NM_CLIENTE, CPF_CLIENTE, NR_CONTATO) VALUES (SQ_T_CLIENTE.NEXTVAL, ?, ?, ?)";
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
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_CLIENTE SET NM_CLIENTE = ?, CPF_CLIENTE = ?, NR_CONTATO = ? WHERE ID_CLIENTE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getNumeroContato());
			stmt.setInt(4, cliente.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
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
	public void remover(int id) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_CLIENTE WHERE ID_CLIENTE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
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
	public Cliente buscar(int id) {
		Cliente cliente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CLIENTE WHERE ID_CLIENTE = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int idClinte = rs.getInt("ID_CLIENTE");
				String nome = rs.getString("NM_CLIENTE");
				String cpf = rs.getString("CPF_CLIENTE");
				String numeroContato = rs.getString("NR_CONTATO");
				
				cliente = new Cliente(idClinte, nome, cpf, numeroContato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clienteList = new ArrayList<Cliente>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CLIENTE");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idCliente = rs.getInt("ID_CLIENTE");
				String nome = rs.getString("NM_CLIENTE");
				String cpf = rs.getString("CPF_CLIENTE");
				String numeroContato = rs.getString("NR_CONTATO");
				
				clienteList.add(new Cliente(idCliente, nome, cpf, numeroContato));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clienteList;
	}

}
