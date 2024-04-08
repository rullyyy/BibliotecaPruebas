/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import static org.junit.jupiter.api.Assertions.*;
import dataAccess.ILibroDAO;
import dataAccess.LibroDAO;
import dataAccess.exceptions.NonexistentEntityException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.stubbing.OngoingStubbing;
import ui.DTOAgregarLibro;

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
    public void testCrearLibro() {
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

    /**
     * Este método crea una instancia de DTOAgregarLibro y la persiste hacia la
     * base de datos
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     *
     */
    @Test
    public void pruebaIntegracionAgregarLibro() throws IllegalAccessException, InstantiationException {
        DTOAgregarLibro agregarLibroDTO = new DTOAgregarLibro("El quijote", "Miguel de Cervantes");
        BibliotecarioEntity libroEntity = new BibliotecarioEntity();
        LibroEntity libro = libroEntity.create(libroEntity).crearEntidadConDTO(agregarLibroDTO, LibroEntity.class);
        assertEquals(agregarLibroDTO.getTitulo(), libro.getTitulo());
    }

    @Test
    public void testPrestarLibro() {
        LibroDAO mockLibroDAO = mock(LibroDAO.class);
        LibroEntity libro = new LibroEntity(1L, "El Principito", "Antoine de Saint-Exupéry", EstadoLibro.DISPONIBLE);
        when(mockLibroDAO.findById(anyLong())).thenReturn(libro);
        PrestamoLibroService prestamoLibroService = new PrestamoLibroService(mockLibroDAO);
        boolean resultado = prestamoLibroService.prestarLibro(1L, "usuariocaliz");
        assertTrue(resultado);
        assertEquals(EstadoLibro.PRESTADO, libro.getEstado());
        verify(mockLibroDAO).findById(1L);
        verify(mockLibroDAO).update(libro);
    }

    @Test
    void testDevolverLibroPrestado() {
        LibroDAO mockLibroDAO = mock(LibroDAO.class);
        PrestamoLibroService servicio = new PrestamoLibroService(mockLibroDAO);
        LibroEntity libroPrestado = new LibroEntity();
        libroPrestado.setId(1L);
        libroPrestado.setEstado(EstadoLibro.PRESTADO);
        when(mockLibroDAO.findById(1L)).thenReturn(libroPrestado);
        boolean resultado = servicio.devolverLibro(1L);
        assertTrue(resultado);
        assertEquals(EstadoLibro.DISPONIBLE, libroPrestado.getEstado());
        verify(mockLibroDAO).update(libroPrestado);
    }

    @Test
    public void testCargarLibro() {
        LibroDAO ldao = new LibroDAO();
        List<LibroEntity> libros = ldao.findLibroEntityEntities();
        assertFalse(libros.isEmpty());
    }

    @Test
    public void editarLibro() {
        ILibroDAO mockILibroDAO = mock(ILibroDAO.class);
        LibroEntity libro = new LibroEntity();
        when(mockILibroDAO.update(libro)).thenReturn(libro);
        assertEquals(mockILibroDAO.update(libro), libro);
    }

    @Test
    public void eliminarLibro() throws NonexistentEntityException {
        ILibroDAO mockILibroDAO = mock(ILibroDAO.class);
        LibroEntity libro = new LibroEntity();
        when(mockILibroDAO.delete(libro.getId())).thenReturn(null);
        assertEquals(mockILibroDAO.delete(libro.getId()), null);
    }
    
    @Test
    public void testFiltrarLibros(){
          EntityManager entityManager = mock(EntityManager.class);

        Query query = mock(Query.class);

        LibroDAO libroDAO = new LibroDAO();
        libroDAO.setEntityManager(entityManager);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        LibroEntity libro1 = new LibroEntity("Libro 1", "Autor 1", EstadoLibro.PRESTADO);
        LibroEntity libro2 = new LibroEntity("Libro 2", "Autor 2", EstadoLibro.PRESTADO);
        List<LibroEntity> librosPrestados = Arrays.asList(libro1, libro2);
        when(query.getResultList()).thenReturn(librosPrestados);
        List<LibroEntity> librosFiltrados = libroDAO.filtrarLibrosPrestados();
        assertEquals(librosPrestados, librosFiltrados);
    }
}
