package dataAccess;

import domain.UsuarioEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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


    
}
