package ar.utn.frc.pixel.perfect.bonvino.negocio;

import jakarta.persistence.*;

@Entity
public class RegionVitivinicola {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="sqlite_sequence", sequenceName="RegionVitivinicola")
    private int codigoRegion;
    
    @Column(nullable=false)
    private String descripcion;
    @Column(nullable=false)
    private String nombre;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigoProvincia", referencedColumnName="codigoProvincia")
    private Provincia provincia;
    
    @OneToOne(mappedBy="region", cascade = CascadeType.REFRESH)
    private Bodega bodega;

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return provincia.getPais();
    }
}
