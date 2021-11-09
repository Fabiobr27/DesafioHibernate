/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.desafio.entites;

import java.util.List;

/**
 *
 * @author fabio
 */
public interface ClienteDaoI {

    public void insertar(Cliente cliente);

    public void eliminar(Cliente cliente);

    public List<Cliente> listarClientes();

    public Cliente BuscarNombre(String nombre);

    public Cliente BuscarId(Long id);

}
