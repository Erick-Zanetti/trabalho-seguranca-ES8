package br.erick.unidep.apiseguranca.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempresa;

    @OneToMany(mappedBy = "empresa")
    @JsonBackReference
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "empresa")
    @JsonBackReference
    private List<Cliente> clientes;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "ins_estadual")
    private String ins_estadual;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Long getIdempresa() {
        return idempresa;
    }
    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIns_estadual() {
        return ins_estadual;
    }
    public void setIns_estadual(String ins_estadual) {
        this.ins_estadual = ins_estadual;
    }

    public Date getCreated() {
        return created;
    }
    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    public Date getUpdated() {
        return updated;
    }
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
