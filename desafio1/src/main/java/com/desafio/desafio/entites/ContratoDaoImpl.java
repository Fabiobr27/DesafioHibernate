/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.desafio.entites;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fabio
 */
public class ContratoDaoImpl  implements ContratoDaoI{
    
    @Autowired
	EntityManager entityManager;

	@Override
	public Long insertarContrato(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		Long id =  (Long) session.save(contrato);
		session.close();
		return id;
	}

	@Override
	public List<Contrato> mostrarTodo() {
		Session session = entityManager.unwrap(Session.class);
		List<Contrato> listado = (List<Contrato>) session.createQuery("FROM Contrato").getResultList();
		session.close();
		return listado;
	}

	@Override
	public Contrato BuscarId(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contrato = (Contrato) session.createQuery("FROM Contrato WHERE id="+id).uniqueResult();
		session.close();
		return contrato;
	}

	
	@Override
	@Transactional
	public void eliminarContrato(Contrato contrato) {
		entityManager.remove(entityManager.merge(contrato));			
	}
	
    
}
