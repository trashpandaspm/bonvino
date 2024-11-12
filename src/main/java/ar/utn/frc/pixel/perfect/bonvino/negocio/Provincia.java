package ar.utn.frc.pixel.perfect.bonvino.negocio;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="sqlite_sequence", sequenceName="Provincia")
    private int codigoProvincia;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigoPais", referencedColumnName="codigoPais")
    private Pais pais;
    
    @Column(nullable=false)
    private String nombre;
    
    @OneToMany(mappedBy="provincia")
    private List<RegionVitivinicola> regiones;

    public String getPais() {
        return pais.getNombre();
    }
}
