package com.nttdata.Spring.Taller4.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nttdata.Spring.Taller4.Entidades.Cliente;
import com.nttdata.Spring.Taller4.Servicios.ClienteServicios;

@Controller
public class ControladorCliente 
{
	@Autowired(required=true)
	private ClienteServicios clienteServicio;
	@GetMapping("/clientes")
	public String  mostrarClientes(Model modelAndView)
	{
		// Se añaden al menú.
		List<Cliente> clienteList = clienteServicio.buscarTodos();
		// Se retorna el menú a la vista y modelo.
		modelAndView.addAttribute("menu", clienteList);
		return "clientes";
	}
}