package ar.utn.frc.pixel.perfect.bonvino.negocio;


public class RegionVitivinicola {
    private String descripcion;
    private String nombre;
    private Provincia provincia;

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return provincia.getPais();
    }
}
