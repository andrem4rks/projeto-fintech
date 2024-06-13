package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Cliente;
import br.com.fiap.fintech.exception.DBException;

public interface ClienteDAO {

	void cadastrar(Cliente cliente) throws DBException;
	void atualizar(Cliente cliente) throws DBException;
	void remover(int id) throws DBException;
	Cliente buscar(int id);
	List<Cliente> listar();
	
}
