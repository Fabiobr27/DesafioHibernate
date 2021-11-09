/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.desafio.services;

import com.desafio.desafio.entites.Cliente;
import java.util.List;

/**
 *
 * @author fabio
 */
public interface ClienteService {
        public void  insertar (Cliente cliente);  
        public void eliminar(Cliente cliente);
        public List<Cliente> listarClientes();
        public Cliente buscarId(long id);
	public Cliente buscarNombre(String nombre);
}
