package com.nttdata.Spring.Taller4.Servicios;



import java.util.List;

import com.nttdata.Spring.Taller4.Entidades.Cliente;

public interface ClienteServicios {
	public void save(Cliente cliente);
	List<Cliente> buscarTodos();
	List<Cliente> buscarNombreApellidos(String nombre, String apellidos);
	List<Cliente> buscarDni(String dni);
	public void borrar(Cliente cliente);

}
