
package ar.utn.frc.pixel.perfect.bonvino.negocio;

import java.time.LocalDate;
import java.util.List;

public class IteradorResenia implements Iterador{
    private List<Resenia> resenias;
    private List<Object> filtros;
    private int indice;
    private boolean finalizado;

    public IteradorResenia(List<Resenia> r, List<Object> f){
        this.resenias = r;
        this.filtros = f;
    }
    
    @Override
    public void primero() {
        this.indice = 0;
    }

    @Override
    public boolean haFinalizado() {
        if((indice-1) == resenias.size()){
            this.finalizado = true;}
        else{
            this.finalizado = false;}
        return finalizado;
    }

    @Override
    public Object elementoActual() {
        boolean cumple = comprobarFiltros(filtros);
        if(cumple == true){
            return resenias.get(indice);
        }
        return null;
    }

    @Override
    public void siguiente() {
        indice++;
    }

    public boolean comprobarFiltros(List<Object> filtros) {
        LocalDate fechaDesde = (LocalDate) filtros.get(0);
        LocalDate fechaHasta = (LocalDate) filtros.get(1);
        Resenia reseniaActual = resenias.get(indice);
        return reseniaActual.esDelPeriodo(fechaDesde, fechaHasta) && reseniaActual.esPremium();
    }
    
}
