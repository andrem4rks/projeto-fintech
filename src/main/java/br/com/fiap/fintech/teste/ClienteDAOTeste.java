package br.com.fiap.fintech.teste;

import java.util.List;

import br.com.fiap.fintech.bean.Cliente;
import br.com.fiap.fintech.dao.ClienteDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class ClienteDAOTeste {
	
	public static void main(String[] args) {
		ClienteDAO dao = DAOFactory.getClienteDAO();
	
		//Cadastrar
		Cliente cliente = new Cliente(0, "nome", "000.000.000-00", "99 99999-9999");
		try {
			dao.cadastrar(cliente);
			System.out.println("Cliente cadastrado: " + cliente.toString());
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar e atualizar
		cliente = dao.buscar(2);
		cliente.setNome("Nome Atualizado");
		try {
			dao.atualizar(cliente);
			System.out.println("Cliente atualizado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Listar Clientes
		List<Cliente> lista = dao.listar();
		for (Cliente item : lista) {
			System.out.println(item.toString());
		}
		
		//Excluir Cliente
		try {
			dao.remover(3);
			System.out.println("Cliente removido!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
