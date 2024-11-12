package ar.utn.frc.pixel.perfect.bonvino.repositorios.interfaces;

import java.util.List;


public interface Repository<T, K> {
    void add(T entity);
    void update(T entity);
    T delete(K id);
    T findById(K id);
    List<T> findAll();
}
