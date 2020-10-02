package br.erick.unidep.apiseguranca.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "marca")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmarca;

    @OneToMany(mappedBy = "marca")
    @JsonBackReference
    private List<Produto> produtos;

    @Column(name = "nome")
    private String nome;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Long getIdmarca() {
        return idmarca;
    }
    public void setIdmarca(Long idmarca) {
        this.idmarca = idmarca;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
