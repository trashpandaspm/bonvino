package ar.utn.frc.pixel.perfect.bonvino.negocio;


import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="Reseña")
public class Resenia {
    @EmbeddedId
    private ReseniaId id;
    
    @Embeddable
    public static class ReseniaId implements Serializable{
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigoVino", referencedColumnName="codigoVino")
    private Vino vino;
    private String sommelier;
    private LocalDate fecha;
    
        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReseniaId that = (ReseniaId) o;
        return Objects.equals(vino, that.vino) &&
            Objects.equals(sommelier, that.sommelier) &&
            Objects.equals(fecha, that.fecha);
        }

        @Override
        public int hashCode() {
        return Objects.hash(vino, sommelier, fecha);
        }

        public LocalDate getFecha() {
            return this.fecha;
        }
    
    }
    @Column(nullable=false)
    private String comentario;
    @Column(nullable=false)
    private boolean esPremium;
    @Column(nullable=false)
    private int puntaje;
    
    public boolean esDelPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return id.getFecha().isAfter(fechaDesde) && id.getFecha().isBefore(fechaHasta);
    }

    public boolean esPremium() {
        return esPremium;
    }
    public int getPuntaje(){
        return puntaje;
    }
    
}
