package com.desafio.desafio;

import com.desafio.desafio.entites.Cliente;
import com.desafio.desafio.services.ClienteService;
import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.desafio.entites.Contrato;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;


    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Maria");
        cliente1.setPrimerApellido("Ruiz");
        cliente1.setSegundoApellido("Gonzalez");
        cliente1.setDNI("12345679D");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("JUAN");
        cliente2.setPrimerApellido("Ramirez");
        cliente2.setSegundoApellido("Benitez");
        cliente2.setDNI("12345678E");

        //Inserta el cliente en la base de datos
        clienteService.insertar(cliente1);
        clienteService.insertar(cliente2);
        //Elimina el registro de la base de datos
        //clienteDaoI.eliminar(cliente1);

        //Buscar por Apellidos y Nombre
        Cliente clienteNombre = clienteService.buscarNombre(cliente1.getNombre());

        System.out.println("EL cliente que buscas es: " + clienteNombre.getNombre());

        //Listar
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes = clienteService.listarClientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Cliente" + (i + 1) + listaClientes.get(i).getNombre());
        }
 

    }

}
