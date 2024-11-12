package ar.utn.frc.pixel.perfect.bonvino.negocio;

import java.util.List;


public class IteradorVinos implements Iterador{
    private List<Vino> vinos;
    private List<Object> filtros;
    private int indice;
    private boolean finalizado;
    
    public IteradorVinos(List<Vino> v, List<Object> f){
        this.vinos = v;
        this.filtros = f;
    }
    
    @Override
    public void primero(){
        this.indice = 0;
    }
    
    @Override
    public boolean haFinalizado(){
        if((indice-1) == vinos.size()){
            this.finalizado = true;}
        else{
            this.finalizado = false;}
        return finalizado;
    }

    @Override
    public Vino elementoActual() {
        return this.vinos.get(this.indice);
    }

    @Override
    public void siguiente() {
        indice++;
    }

    float calcularPuntaje(List<Object> filtros, Vino vinoActual) {
        float puntaje = vinoActual.tomarPuntajeReseniaEnPeriodo(filtros);
        return puntaje;
    }

    List<String> buscarInformacion(Vino vinoActual) {
        String nombre = vinoActual.getNombre();
        float precio = vinoActual.getPrecio();
        List<String> infoBodega = vinoActual.buscarInfoBodega();
        List<String> varietales = vinoActual.buscarVarietal();
        List<String> info = null;
        info.add(nombre);
        info.add(String.valueOf(precio));
        info.add(infoBodega.get(0));
        info.add(infoBodega.get(1));
        for (String v : varietales){
            info.add(v);
        }
        return info;
    }
}
