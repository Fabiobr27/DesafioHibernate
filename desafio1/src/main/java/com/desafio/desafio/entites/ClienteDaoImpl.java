package com.desafio.desafio.entites;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI {

    @Autowired
    private EntityManager entityManager;
    

    @Override
    public void insertar(Cliente cliente) {

        Session s = entityManager.unwrap(Session.class);
        s.save(cliente);
        s.close();

    }

    @Override
    public void eliminar(Cliente cliente) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(cliente);
        session.close();
    }

    @Override
    public List<Cliente> listarClientes() {
        Session session = entityManager.unwrap(Session.class);
        List<Cliente> listaClientes = (List<Cliente>) session.createQuery("FROM Cliente").getResultList();
        session.close();
        return listaClientes;
    }
    

    @Override
    public Cliente BuscarId(Long idCliente) {
        Session session = entityManager.unwrap(Session.class);
        Cliente cliente = (Cliente) session.createQuery("FROM Cliente where id= " + idCliente).uniqueResult();
        session.close();
        return cliente;
    }

    @Override
    public Cliente BuscarNombre(String nombre) {
        Session session = entityManager.unwrap(Session.class);
        Cliente cliente = (Cliente) session.createQuery("FROM Cliente  where nombre= '" + nombre + "'").uniqueResult();
        session.close();
        return cliente;

    }
}
