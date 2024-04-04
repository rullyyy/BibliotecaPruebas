/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import dataAccess.exceptions.NonexistentEntityException;
import domain.BibliotecarioEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author xfs85
 */
public class BibliotecarioDAO implements IBibliotecarioDAO {

   private EntityManagerFactory emf = ConnectorSQL.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public BibliotecarioEntity create(BibliotecarioEntity bibliotecarioEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bibliotecarioEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return bibliotecarioEntity;
    }

    public void edit(BibliotecarioEntity bibliotecarioEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bibliotecarioEntity = em.merge(bibliotecarioEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = bibliotecarioEntity.getId();
                if (findBibliotecarioEntity(id) == null) {
                    throw new NonexistentEntityException("The bibliotecarioEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BibliotecarioEntity bibliotecarioEntity;
            try {
                bibliotecarioEntity = em.getReference(BibliotecarioEntity.class, id);
                bibliotecarioEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bibliotecarioEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(bibliotecarioEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BibliotecarioEntity> findBibliotecarioEntityEntities() {
        return findBibliotecarioEntityEntities(true, -1, -1);
    }

    public List<BibliotecarioEntity> findBibliotecarioEntityEntities(int maxResults, int firstResult) {
        return findBibliotecarioEntityEntities(false, maxResults, firstResult);
    }

    private List<BibliotecarioEntity> findBibliotecarioEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BibliotecarioEntity.class));
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

    public BibliotecarioEntity findBibliotecarioEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BibliotecarioEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getBibliotecarioEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BibliotecarioEntity> rt = cq.from(BibliotecarioEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    @Override
    public String consultaPasswordConMatricula(Long matricula) {
       EntityManager em = null;
        try {
            em = getEntityManager();
            BibliotecarioEntity bibliotecarioFound = em.find(BibliotecarioEntity.class, matricula);
            if (bibliotecarioFound != null) {
                return bibliotecarioFound.getPassword();
            } else {
                // Handle the case when usuarioFound is null
                return null; // or throw an exception, log an error, etc.
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close(); // Close the EntityManager
            }
        }
    }

    @Override
    public BibliotecarioEntity consultaBibliotecarioConMatricula(Long matricula) {
           EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(BibliotecarioEntity.class, matricula);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
}
