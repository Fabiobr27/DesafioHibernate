/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.desafio.services;

import com.desafio.desafio.entites.Cliente;
import com.desafio.desafio.entites.ClienteDaoI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabio
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDaoI clienteDao;

    @Override
    public void insertar(Cliente cliente) {

        clienteDao.insertar(cliente);

    }

    @Override
    public void eliminar(Cliente cliente) {
        clienteDao.eliminar(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteDao.listarClientes();
    }

    @Override
    public Cliente buscarId(long id) {
        return clienteDao.BuscarId(id);
    }

    @Override
    public Cliente buscarNombre(String nombre) {
        return clienteDao.BuscarNombre(nombre);
    }

}
