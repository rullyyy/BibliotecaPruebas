/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import domain.LibroEntity;
import domain.UsuarioEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author xfs85
 */
public class LibroDAO implements ILibroDAO {

    private EntityManagerFactory emf = ConnectorSQL.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

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

//    public void edit(LibroEntity libroEntity) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            libroEntity = em.merge(libroEntity);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Long id = libroEntity.getId();
//                if (findLibroEntity(id) == null) {
//                    throw new NonexistentEntityException("The libroEntity with id " + id + " no longer exists.");
//                }
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void destroy(Long id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            LibroEntity libroEntity;
//            try {
//                libroEntity = em.getReference(LibroEntity.class, id);
//                libroEntity.getId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The libroEntity with id " + id + " no longer exists.", enfe);
//            }
//            em.remove(libroEntity);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
    public List<LibroEntity> findLibroEntityEntities() {
        return findLibroEntityEntities(true, -1, -1);
    }

    public List<LibroEntity> findLibroEntityEntities(int maxResults, int firstResult) {
        return findLibroEntityEntities(false, maxResults, firstResult);
    }

    private List<LibroEntity> findLibroEntityEntities(boolean all, int maxResults, int firstResult) {
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
//
//    public LibroEntity findLibroEntity(Long id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(LibroEntity.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
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

    @Override
    public LibroEntity delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
