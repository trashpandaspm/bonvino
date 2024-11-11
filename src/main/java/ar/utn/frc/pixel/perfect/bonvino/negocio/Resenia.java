package ar.utn.frc.pixel.perfect.bonvino.negocio;


import java.time.LocalDate;


public class Resenia {
    private String comentario;
    private LocalDate fecha;
    private boolean esPremium;
    private int puntaje;
    
    public boolean esDelPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return fecha.isAfter(fechaDesde) && fecha.isBefore(fechaHasta);
    }

    public boolean esPremium() {
        return esPremium;
    }
    public int getPuntaje(){
        return puntaje;
    }
    
}
