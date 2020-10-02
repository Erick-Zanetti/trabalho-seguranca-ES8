package br.erick.unidep.apiseguranca.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduto;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idmarca", foreignKey = @ForeignKey(name = "FK_marca_produto"))
    @JsonManagedReference
    private Marca marca;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Long getIdproduto() {
        return idproduto;
    }
    public void setIdproduto(Long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
