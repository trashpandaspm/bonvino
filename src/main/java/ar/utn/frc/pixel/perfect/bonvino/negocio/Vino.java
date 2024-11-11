package ar.utn.frc.pixel.perfect.bonvino.negocio;

import java.util.List;


public class Vino {
    private List<Resenia> resenias;
    private List<Object> filtros;
    private float promedio;
    private int puntaje;
    private int contador;
    private String nombre;
    private float precio;
    private Bodega bodega;
    private Varietal varietal;
    private int anada;
    private String imagenEtiqueta;
    private String notaDeCataBodega;
    
    public float tomarPuntajeReseniaEnPeriodo(List<Object> filtros) {
        contador = 0;
        puntaje = 0;
        IteradorResenia iterador = crearIterador(resenias);
        iterador.primero();
        while(iterador.haFinalizado() == false){
            Resenia reseniaActual = (Resenia) iterador.elementoActual();
            if (reseniaActual != null){
                puntaje += reseniaActual.getPuntaje();
                contador++;
            }
            iterador.siguiente();
        }
        float promedio = calcularPromedio();
        return promedio;
    }
    public IteradorResenia crearIterador(List<Resenia> resenias){
        IteradorResenia i = new IteradorResenia(resenias, filtros);
        return i;
    }

    public float calcularPromedio() {
        if(contador != 0){
        float promedio = puntaje / contador;
        return promedio;
        }else{
        return -1;
        }
    }
    public String getNombre(){
        return this.nombre;
    }
    public float getPrecio(){
        return precio;
    }

    public List<String> buscarInfoBodega() {
        String nombre = bodega.getNombre();
        List<String> regionPais = bodega.getRegionYPais();
        List<String> info = null;
        info.add(nombre);
        info.add(regionPais.get(0));
        info.add(regionPais.get(1));
        return info;
    }
    public String buscarVarietal(){
        return varietal.getDescripcion();
    }

    public int getAnada() {
        return this.anada;
    }

    public String getImagen() {
        return this.imagenEtiqueta;
    }

    public String getNota() {
        return this.notaDeCataBodega;
    }
}
