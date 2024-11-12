package ar.utn.frc.pixel.perfect.bonvino.negocio;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Bodega {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="sqlite_sequence", sequenceName="Bodega")
    private int idBodega;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="region", referencedColumnName="codigoRegion")
    private RegionVitivinicola region;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private float latitud;
    
    @Column(nullable=false)
    private float longitud;
    
    @Column(nullable=false)
    private String descripcion;
    
    @Column(nullable=false)
    private String historia;
    
    @Column(nullable=false)
    private String periodoActualizacion;
    
    public String getNombre(){
        return this.nombre;
    }
    public List<String> getRegionYPais(){
        String nombre = region.getNombre();
        String pais = region.getPais();
        List<String> info = null;
        info.add(nombre);
        info.add(pais);
        return info;
    }
}
