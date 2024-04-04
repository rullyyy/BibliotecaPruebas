package domain;
import static org.junit.jupiter.api.Assertions.*;
import dataAccess.IUsuarioDAO;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class TestUsuario{  
    /**
     * Esta prueba verifica que el método create() en la IUsuarioDAO funcione correctamente
     */
    @Test
    public void testPersistenciaCreacionDeUsuario() {
        
        IUsuarioDAO mockIUsuarioDAO = mock(IUsuarioDAO.class);
        UsuarioEntity usuarioData = new UsuarioEntity();
        when(mockIUsuarioDAO.create(usuarioData)).thenReturn(usuarioData);
        assertEquals(mockIUsuarioDAO.create(usuarioData), usuarioData);
    }
    /**
     * Metodo que prueba que el metodo para acceder a la capa de acceso a datos
     */
    public void testGetDataAccessConnection(){
        IUsuarioDAO mockIUsuarioDAO = mock(IUsuarioDAO.class);
        UsuarioEntity usuarioEntity = new UsuarioEntity("luis", "contreras", new Date(), "COPL030607HSRNRSA9");
        UsuarioEntity usuarioAccess = new UsuarioEntity();
        when(usuarioEntity.getDataAccessConnection()).thenReturn(mockIUsuarioDAO);
        assertEquals(usuarioAccess.getDataAccessConnection(), mockIUsuarioDAO);
    }
}