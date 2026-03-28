package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assinatura")
    private Long idAssinatura;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_plano", nullable = false)
    private TipoPlano tipo;

    public Plano() {}

    public Long getIdAssinatura() { return idAssinatura; }
    public void setIdAssinatura(Long idAssinatura) { this.idAssinatura = idAssinatura; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public TipoPlano getTipo() { return tipo; }
    public void setTipo(TipoPlano tipo) { this.tipo = tipo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plano plano = (Plano) o;
        return Objects.equals(idAssinatura, plano.idAssinatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssinatura);
    }

    @Override
    public String toString() {
        return "Plano{" +
                "idAssinatura=" + idAssinatura +
                ", valor=" + valor +
                ", tipo=" + tipo +
                '}';
    }
}