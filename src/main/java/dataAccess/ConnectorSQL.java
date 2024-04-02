package dataAccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectorSQL {

    private static EntityManagerFactory entityManagerFactory = null;

    private ConnectorSQL() {
        // Constructor privado para evitar instanciación externa.
    }

    /**
     * Obtiene la instancia única de EntityManagerFactory. Si no existe, se
     * crea.
     *
     * @return Instancia única de EntityManagerFactory.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("BibliotecaPU");
        }
        return entityManagerFactory;
    }
}
