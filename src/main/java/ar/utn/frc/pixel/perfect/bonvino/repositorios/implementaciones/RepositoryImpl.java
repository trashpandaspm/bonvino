package ar.utn.frc.pixel.perfect.bonvino.repositorios.implementaciones;

import ar.utn.frc.pixel.perfect.bonvino.repositorios.contexto.DbContext;
import ar.utn.frc.pixel.perfect.bonvino.repositorios.interfaces.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.HibernateException;

public abstract class RepositoryImpl<T, K> implements Repository<T, K> {
    protected EntityManager manager;

    private final Class<T> entityClass;

    public RepositoryImpl() {
        this.manager = DbContext.getInstance().getManager();
        this.entityClass = ReflectionUtil.getGenericTypeClass(getClass());
    }

    public Class<T> getEntityClass() {
        return this.entityClass;
    }

    @Override
    public void add(T entity) {
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(entity);
            this.manager.getTransaction().commit();
        } catch (HibernateException ex) {
            this.manager.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(T entity) {
        this.manager.getTransaction().begin();
        this.manager.merge(entity);
        this.manager.getTransaction().commit();
    }

    public T delete(Integer id) {
        this.manager.getTransaction().begin();
        T entity = this.findById(id);
        this.manager.remove(entity);
        this.manager.getTransaction().commit();
        return entity;
    }

    public T findById(Integer id) {
        return this.manager.find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        String className = getEntityClass().getSimpleName();
        try {
            String jpql = String.format("SELECT e FROM %s e",  className);
            Query query = this.manager.createQuery(jpql);
            return query.getResultList();
        }catch (HibernateException ex) {
            System.out.println("llegue hasta aca");
            throw new RuntimeException(ex);
        }
    }
}
