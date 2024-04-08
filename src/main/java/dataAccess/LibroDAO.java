/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import dataAccess.exceptions.NonexistentEntityException;
import domain.EstadoLibro;
import domain.LibroEntity;
import domain.UsuarioEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author xfs85
 */

public class LibroDAO implements ILibroDAO {

 
    private EntityManager entityManager;
    private EntityManagerFactory emf = ConnectorSQL.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public LibroDAO() {
        this.entityManager = emf.createEntityManager();
    }

    
    @Override
    public LibroEntity create(LibroEntity libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return libro;
    }

    @Override
    public LibroEntity update(LibroEntity libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro); // Actualiza la entidad
            em.getTransaction().commit();
            return libro;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("No se pudo actualizar el libro", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public String creaValoracion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String actualizaValoracionExistente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long delete(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LibroEntity libroEntity;
            try {
                libroEntity = em.getReference(LibroEntity.class, id);
                libroEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libroEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(libroEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public List<LibroEntity> findLibroEntityEntities() {
        return findLibroEntityEntities(true, -1, -1);
    }

    public List<LibroEntity> findLibroEntityEntities(int maxResults, int firstResult) {
        return findLibroEntityEntities(false, maxResults, firstResult);
    }

    @Override
    public List<LibroEntity> findLibroEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LibroEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public LibroEntity findLibroEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LibroEntity.class, id);
        } finally {
            em.close();
        }
    }

//    public int getLibroEntityCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<LibroEntity> rt = cq.from(LibroEntity.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }
//    
    public LibroEntity findById(Long libroId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LibroEntity read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     /**
     * Verifica si un libro ya existe en la base de datos.
     * 
     * @param libro El libro a verificar.
     * @return true si el libro ya existe, false si no existe.
     */
    public boolean existeLibro(LibroEntity libro) {
        String jpql = "SELECT COUNT(l) FROM LibroEntity l WHERE l.titulo = :titulo AND l.autor = :autor";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("titulo", libro.getTitulo());
        query.setParameter("autor", libro.getAutor());

        try {
            long count = (long) query.getSingleResult();
            return count > 0;
        } catch (NoResultException e) {
            return false;
        }
    }
    
    @Override
    public List<LibroEntity> filtrarLibrosPrestados(){
        String jpql = "SELECT l FROM LibroEntity l WHERE l.estado = :estado";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("estado", EstadoLibro.PRESTADO);

        List<LibroEntity> librosPrestados = query.getResultList();
        return librosPrestados;
    }

    @Override
    public List<LibroEntity> filtrarLibrosDisponibles(){
        String jpql = "SELECT l FROM LibroEntity l WHERE l.estado = :estado";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("estado", EstadoLibro.DISPONIBLE);

        List<LibroEntity> librosDisponibles = query.getResultList();
        return librosDisponibles;
    }

     public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
