package dataAccess;

import dataAccess.exceptions.NonexistentEntityException;
import domain.UsuarioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.random.RandomGeneratorFactory.all;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioDAO implements IUsuarioDAO {

    private EntityManager em;
    private EntityManagerFactory emf = ConnectorSQL.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public UsuarioDAO() {
        this.em = emf.createEntityManager();
    }

    
    @Override
    public UsuarioEntity create(UsuarioEntity usuarioModel) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioModel);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuarioModel;
    }

    @Override
    public UsuarioEntity read() {
        return null;
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuarioEntity){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioEntity = em.merge(usuarioEntity);
            em.getTransaction().commit();
            return usuarioEntity;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuarioEntity.getId();
                if (findUser(id) == null) {
                    try {
                        throw new NonexistentEntityException("The usuarioEntity with id " + id + " no longer exists.");
                    } catch (NonexistentEntityException ex1) {
                        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    @Override
    public UsuarioEntity delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioEntity> findUsers(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioEntity.class));
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
    public UsuarioEntity findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioEntity.class, id);
        } finally {
            em.close();
        }
    }
    
     public boolean existeUsuario(UsuarioEntity usuario) {
        String jpql = "SELECT COUNT(l) FROM UsuarioEntity l WHERE l.curp = :curp AND l.matricula = :matricula";
        Query query = em.createQuery(jpql);
        query.setParameter("curp", usuario.getCurp());
        query.setParameter("matricula", usuario.getMatricula());

        try {
            long count = (long) query.getSingleResult();
            return count > 0;
        } catch (NoResultException e) {
            return false;
        }
    }
}
