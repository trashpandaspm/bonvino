package ar.utn.frc.pixel.perfect.bonvino.negocio;

import ar.utn.frc.pixel.perfect.bonvino.interfaz.InterfazExcel;
import ar.utn.frc.pixel.perfect.bonvino.interfaz.Principal;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ControladorGenerarReporte {
    private Principal principal;
    private List<Vino> vinos;
    private List<Object> filtros;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private TreeMap<Float, List<Vino>> vinosConPuntaje;

    
    public ControladorGenerarReporte(Principal principal) {

        this.principal = principal;
        this.vinosConPuntaje = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void buscarYCalcularPuntajeDeVinos(LocalDate fechaDesde, LocalDate fechaHasta){
        filtros.add(fechaDesde);
        filtros.add(fechaHasta);
        
        IteradorVinos iterador = crearIterador(vinos);
        
        iterador.primero();
        while(iterador.haFinalizado() == false){
            Vino vinoActual = iterador.elementoActual();
            float puntaje = iterador.calcularPuntaje(filtros, vinoActual);
            List<String> informacion = iterador.buscarInformacion(vinoActual);
            iterador.siguiente();
        }
    }
    
    public IteradorVinos crearIterador(List<Vino> vinos){
        IteradorVinos i = new IteradorVinos(vinos, filtros);
        return i;
    }

    public void tomarFechas(String fechaDesde, String fechaHasta) {
        setFechaDesde(fechaDesde);
    }

    public void setFechaDesde(String fechaDesde) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaDesde = LocalDate.parse(fechaDesde, formateador);
    }
    public void ordenarVinos(float promedio, Vino vino) {
        vinosConPuntaje.computeIfAbsent(promedio, v -> new ArrayList<>()).add(vino);
    }

    public void obtenerPrimeros10Vinos() throws IOException {
        InterfazExcel interfazExcel = new InterfazExcel();
        List<Vino> top10Vinos = new ArrayList<>();
        List<Float> puntajesPromedio = new ArrayList<>();
        for (Map.Entry<Float, List<Vino>> entrada : vinosConPuntaje.entrySet()) {
            List<Vino> vinosConMismoPuntaje = entrada.getValue();
            
            for (int i = 0; i < vinosConMismoPuntaje.size() && top10Vinos.size() < 10; i++) {
                top10Vinos.add(vinosConMismoPuntaje.get(i));
                puntajesPromedio.add(entrada.getKey());}
            
            if (top10Vinos.size() == 10) {
                break;
            }}
        interfazExcel.exportarExcel(top10Vinos, puntajesPromedio);
    }
}
