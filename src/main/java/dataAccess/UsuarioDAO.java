package dataAccess;

import domain.UsuarioEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

public class UsuarioDAO implements IUsuarioDAO {

    private EntityManagerFactory emf = ConnectorSQL.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
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

    public UsuarioEntity update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioEntity delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public String consultaPasswordConMatricula(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            UsuarioEntity usuarioFound = em.find(UsuarioEntity.class, id);
            if (usuarioFound != null) {
                return usuarioFound.getPassword();
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
    
    

}
