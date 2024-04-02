package domain;
import static org.junit.jupiter.api.Assertions.*;
import dataAccess.IUsuarioDAO;
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
    
    public void testCreacionUsuario(){
        
    }
}