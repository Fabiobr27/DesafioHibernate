//tabla alumno
package com.desafio.desafio.entites;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

    private Long id;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private String DNI;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUMNO", nullable = false, precision = 15)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOMBRE", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 50)
    public String getPrimerApellido() {
        return primerapellido;
    }

    public void setPrimerApellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    @Column(name = "SEGUNDO_APELLIDO", nullable = false, length = 50)
    public String getSegundoApellido() {
        return segundoapellido;
    }

    public void setSegundoApellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    @Column(name = "DNI", nullable = false, length = 9, unique = true)
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Cliente")
    private List<Contrato> contratos;

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public void addContrato(Contrato contrato) {
        contrato.setCliente(this);
        contratos.add(contrato);
    }

    public void removeContrato(Contrato contrato) {
        contrato.setCliente(null);
        contratos.remove(contrato);
    }

}
