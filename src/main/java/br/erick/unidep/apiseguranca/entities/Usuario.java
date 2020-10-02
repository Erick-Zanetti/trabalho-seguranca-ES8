package br.erick.unidep.apiseguranca.entities;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @ManyToOne
    @JoinColumn(name = "idempresa", foreignKey = @ForeignKey(name = "FK_usuario_empresa"))
    @JsonManagedReference
    private Empresa empresa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Long getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
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
