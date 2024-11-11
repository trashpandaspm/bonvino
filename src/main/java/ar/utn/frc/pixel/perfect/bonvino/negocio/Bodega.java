package ar.utn.frc.pixel.perfect.bonvino.negocio;

import java.util.List;


public class Bodega {
    private String nombre;
    private RegionVitivinicola region;
    private float latitud;
    private float longitud;
    private String descripcion;
    private String historia;
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
