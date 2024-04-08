package domain;

import dataAccess.BibliotecarioDAO;
import dataAccess.IBibliotecarioDAO;
import static org.junit.jupiter.api.Assertions.*;
import dataAccess.IUsuarioDAO;
import dataAccess.UsuarioDAO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ui.DTOAgregarUsuario;

public class TestUsuario {

    /**
     * Esta prueba verifica que el método create() en la IUsuarioDAO funcione
     * correctamente
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
    public void testGetDataAccessConnection() {
        IUsuarioDAO mockIUsuarioDAO = mock(IUsuarioDAO.class);
        UsuarioEntity usuarioEntity = new UsuarioEntity("luis", "contreras", new Date(), "COPL030607HSRNRSA9", "235765");
        UsuarioEntity usuarioAccess = new UsuarioEntity();
        when(usuarioEntity.getDataAccessConnection()).thenReturn(mockIUsuarioDAO);
        assertEquals(usuarioAccess.getDataAccessConnection(), mockIUsuarioDAO);
    }

    @Test
    public void testFindUsuario() {
        UsuarioDAO udao = new UsuarioDAO();
        List<UsuarioEntity> usuarios = udao.findUsers(true, 0, 0);
        assertFalse(usuarios.isEmpty());

    }

    @Test
    public void testCrearUsuario() throws IllegalAccessException, InstantiationException {
        BibliotecarioEntity bibliotecarioEntity = new BibliotecarioEntity();
        UsuarioEntity usuarioEntityMock = mock(UsuarioEntity.class);
        IUsuarioDAO usuarioDAOMock = mock(IUsuarioDAO.class);
        
       
        when(usuarioEntityMock.getDataAccessConnection()).thenReturn(usuarioDAOMock);
    
        DTOAgregarUsuario usuarioDTO = new DTOAgregarUsuario();
        usuarioDTO.setNombre("waw");
        usuarioDTO.setApellido("ssj");
        usuarioDTO.setFechaNacimiento(new Date(1990, 10, 10).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        usuarioDTO.setCurp("99");
        usuarioDTO.setMatricula("Ye");

        UsuarioEntity usuarioCreado = new UsuarioEntity();
       
        when(usuarioDAOMock.existeUsuario(any(UsuarioEntity.class))).thenReturn(false);
        when(usuarioDAOMock.create(any(UsuarioEntity.class))).thenReturn(usuarioCreado);

   
        UsuarioEntity resultado = bibliotecarioEntity.registraUsuario(usuarioDTO);


        assertNotNull(resultado);
        assertEquals("waw", resultado.getNombre());
        assertEquals("ssj", resultado.getApellidos());
        assertEquals("99", resultado.getCurp());
        assertEquals("Ye", resultado.getMatricula());
    }

    @Test
    public void testEditarUsuario() {
        BibliotecarioEntity bibliotecarioEntity = new BibliotecarioEntity();;
        UsuarioEntity usuarioEntityMock = mock(UsuarioEntity.class);
        IUsuarioDAO usuarioDAOMock = mock(IUsuarioDAO.class);

        when(usuarioEntityMock.getDataAccessConnection()).thenReturn(usuarioDAOMock);

        DTOAgregarUsuario usuarioDTO = new DTOAgregarUsuario();
        usuarioDTO.setId(1);
        usuarioDTO.setNombre("NombreNuevo");
        usuarioDTO.setApellido("ApellidoNuevo");
        usuarioDTO.setFechaNacimiento(LocalDate.now());
        usuarioDTO.setCurp("CURPNuevo");
        usuarioDTO.setMatricula("MatriculaNueva");

        UsuarioEntity usuarioExistente = new UsuarioEntity(1, "NombreViejo", "ApellidoViejo", new Date(), "CURPViejo", "MatriculaVieja");

        when(usuarioEntityMock.findUser(1)).thenReturn(usuarioExistente);
        when(usuarioEntityMock.getDataAccessConnection().existeUsuario(any(UsuarioEntity.class))).thenReturn(false);

        UsuarioEntity resultado = bibliotecarioEntity.editaUsuario(usuarioDTO);

        assertEquals("NombreNuevo", resultado.getNombre());
        assertEquals("ApellidoNuevo", resultado.getApellidos());
        assertEquals("CURPNuevo", resultado.getCurp());
        assertEquals("MatriculaNueva", resultado.getMatricula());

    }
}
