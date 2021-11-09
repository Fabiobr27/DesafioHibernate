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
public interface ContratoDaoI {

    public Long insertarContrato(Contrato contrato);

    public List<Contrato> mostrarTodo();

    public Contrato BuscarId(Long id);

    public void eliminarContrato(Contrato contrato);

}
