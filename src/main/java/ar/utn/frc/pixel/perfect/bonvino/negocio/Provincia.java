package ar.utn.frc.pixel.perfect.bonvino.negocio;

import java.util.List;

public class Provincia {
    private Pais pais;
    private String nombre;
    private List<RegionVitivinicola> regiones;

    public String getPais() {
        return pais.getNombre();
    }
}
