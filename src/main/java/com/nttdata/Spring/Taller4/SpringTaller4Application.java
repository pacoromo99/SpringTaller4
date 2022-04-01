package com.nttdata.Spring.Taller4;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.Spring.Taller4.Entidades.Cliente;
import com.nttdata.Spring.Taller4.Servicios.ClienteServicios;

@SpringBootApplication(scanBasePackages={
		"com.nttdata.Spring.Taller4.Controladores", "com.nttdata.Spring.Taller4.Entidades","com.nttdata.Spring.Taller4.Repository","com.nttdata.Spring.Taller4.Servicios"})
public class SpringTaller4Application  implements CommandLineRunner {

	@Autowired(required=true)
	ClienteServicios cliente;


	public static void main(String[] args) {
		SpringApplication.run(SpringTaller4Application.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Cliente uno = new Cliente("Pepe","Rodriguez" , new Date(),"47589873H" );
		Cliente dos = new Cliente("Pepe","Morillo" , new Date(),"47589873J" );
		Cliente tres = new Cliente("Antonio","Rodriguez" , new Date(),"47589873L" );
		cliente.save(uno);
		cliente.save(dos);
		cliente.save(tres);
		List<Cliente> buscarTodos = cliente.buscarTodos();
		List<Cliente> buscarDni = cliente.buscarDni("47589873H");
		cliente.borrar(dos);
		System.out.println("\nTODOS\n");
		buscarTodos.stream().forEach(cliente-> System.out.println(cliente.toString()));
		System.out.println("\nDNI\n");
		buscarDni.stream().forEach(cliente-> System.out.println(cliente.toString()));
		buscarTodos = cliente.buscarTodos();
		System.out.println("\nTODOS\n");
		buscarTodos.stream().forEach(cliente-> System.out.println(cliente.toString()));
		
	}

}
