package br.erick.unidep.apiseguranca.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idempresa", foreignKey = @ForeignKey(name = "FK_cliente_empresa"))
    @JsonManagedReference
    private Empresa empresa;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "data_nascimento")
    private Date data_nascimento;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Long getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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
