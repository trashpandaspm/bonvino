package ar.utn.frc.pixel.perfect.bonvino.negocio;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Varietal {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="sqlite_sequence", sequenceName="Pais")
    private int codigoVarietal;
    
    @ManyToMany(mappedBy="varietales")
    private List<Vino> vinos;
    
    @Column(nullable=false)
    private String descripcion;
    
    @Column(nullable=false)
    private float porcentajeComposicion;
    
    public String getDescripcion(){
        return descripcion;
    }
}
