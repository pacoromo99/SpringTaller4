package com.nttdata.Spring.Taller4.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.Spring.Taller4.Entidades.Cliente;
import com.nttdata.Spring.Taller4.Repository.RepositorioCliente;

@Service
public class ClienteServiciosImpl implements ClienteServicios {

	@Autowired(required=true)
	RepositorioCliente repository;

	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		this.repository.save(cliente);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return this.repository.findAll();
	}

	@Override
	public List<Cliente> buscarNombreApellidos(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		return this.repository.findByNombreAndApellidos(nombre,apellidos);
	}

	public void borrar(Cliente cliente) {
		// TODO Auto-generated method stub
		repository.delete(cliente);
	}

	@Override
	public List<Cliente> buscarDni(String dni) {
		// TODO Auto-generated method stub
		return this.repository.findFirstByDni(dni);
	}
}
