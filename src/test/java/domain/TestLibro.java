/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import static org.junit.jupiter.api.Assertions.*;
import dataAccess.ILibroDAO;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
/**
 *
 * @author xfs85
 */
public class TestLibro {
    /*
    Este metodo de prueba verifica que el metodo create() de la clase
    LibroDAO funcione correctamente, creando un nuevo objeto LibroEntity 
    */
    
    @Test
    public void testCrearLibro(){
        ILibroDAO mockILibroDAO = mock(ILibroDAO.class);
        LibroEntity libro = new LibroEntity();
        when(mockILibroDAO.create(libro)).thenReturn(libro);
        assertEquals(mockILibroDAO.create(libro), libro);
    }
    
    @Test
public void testGetDataAccessConnection() {
    ILibroDAO mockILibroDAO = mock(ILibroDAO.class);
    LibroEntity libro = mock(LibroEntity.class);
    when(libro.getDataAccessConnection()).thenReturn(mockILibroDAO);
    assertEquals(libro.getDataAccessConnection(), mockILibroDAO);
}

}
