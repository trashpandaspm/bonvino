package ar.utn.frc.pixel.perfect.bonvino.negocio;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="sqlite_sequence", sequenceName="Pais")
    private int codigoPais;
    
    @Column(nullable=false, unique=true)
    private String nombre;
    
    @OneToMany(mappedBy = "pais")
    private List<Provincia> provincias;

    public String getNombre() {
        return nombre;
    }
}
