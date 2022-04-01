package com.nttdata.Spring.Taller4.Controladores;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.Spring.Taller4.Entidades.Cliente;
import com.nttdata.Spring.Taller4.Servicios.ClienteServicios;

@Controller
@RequestMapping("/")
public class ControladorCliente 
{
	@Autowired(required=true)
	private ClienteServicios clienteServicio;
	@GetMapping("clientes")
	public String  mostrarClientes(Model modelAndView)
	{
		// Se añaden al menú.
		List<Cliente> clienteList = clienteServicio.buscarTodos();
		// Se retorna el menú a la vista y modelo.
		modelAndView.addAttribute("menu", clienteList);
		return "mostrarClientes";
	}
	@GetMapping("annadirCliente")
	public String  annadirClientes(Model modelAndView)
	{
		return "annadirCliente";
	}
	@GetMapping("registroCliente")
	public String  registroClientes(Model modelAndView)
	{
		Cliente registro = new Cliente();
		clienteServicio.save(registro);
		return "mostrarClientes";
	}
}