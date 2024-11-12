package ar.utn.frc.pixel.perfect.bonvino.negocio;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vino {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="sqlite_sequence", sequenceName="Vino")
    private int codigoVino;
    
    @OneToMany(mappedBy = "vino")
    private List<Resenia> resenias;
    private List<Object> filtros;
    @ManyToMany
    @JoinTable(
            name="VinoXVarietal",
            joinColumns=@JoinColumn(name="codigoVino"),
            inverseJoinColumns=@JoinColumn(name="codigoVarietal")
    )
    private List<Varietal> varietales;
    
    private float promedio;
    private int puntaje;
    private int contador;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private float precio;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bodega", referencedColumnName="idBodega")
    private Bodega bodega;
    
    @Column(name="añada", nullable=false)
    private int anada;
    
    @Column(name="imagen", nullable=false)
    private String imagenEtiqueta;
    
    @Column(nullable=false)
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
    public List<String> buscarVarietal(){
        List<String> descripciones = new ArrayList<>();
        for(Varietal varietal : varietales) {
            descripciones.add(varietal.getDescripcion());
        }
        return descripciones;
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
