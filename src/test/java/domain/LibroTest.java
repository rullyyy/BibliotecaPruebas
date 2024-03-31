/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import dao.LibroDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author xfs85
 */
public class LibroTest {

    public LibroTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Libro.
     */
    @Test
    public void testGetId() {

        Libro libro = new Libro(1L, "Java Basics", "L. Contreras", "waw");

        Long idObtenido = libro.getId();

        assertEquals(1, idObtenido);
    }

    /**
     * Test of setId method, of class Libro.
     */
    @Test
    public void testSetId() {

        Libro libro = new Libro();

        libro.setId(2L);

        assertEquals(2, libro.getId());
    }

    /**
     * Test of getTitulo method, of class Libro.
     */
    @Test
    public void testGetTitulo() {

        Libro libro = new Libro(1L, "Harry Potter", "J.K. Rowling", "Luna");

        String tituloObtenido = libro.getTitulo();

        assertEquals("Harry Potter", tituloObtenido);
    }

    /**
     * Test of setTitulo method, of class Libro.
     */
    @Test
    public void testSetTitulo() {

        Libro libro = new Libro();

        libro.setTitulo("Como programar para dummies");

        assertEquals("Como programar para dummies", libro.getTitulo());
    }

    /**
     * Test of getAutor method, of class Libro.
     */
    @Test
    public void testGetAutor() {

        Libro libro = new Libro(1L, "Harry Potter", "J.K. Rowling", "Luna");

        String autorObtenido = libro.getAutor();

        assertEquals("J.K. Rowling", autorObtenido);
    }

    /**
     * Test of setAutor method, of class Libro.
     */
    @Test
    public void testSetAutor() {

        Libro libro = new Libro();

        libro.setAutor("J.R.R. Tolkien");

        assertEquals("J.R.R. Tolkien", libro.getAutor());
    }

    /**
     * Test of getEditorial method, of class Libro.
     */
    @Test
    public void testGetEditorial() {

        Libro libro = new Libro(1L, "Harry Potter", "J.K. Rowling", "Salamandra");

        String editorialObtenida = libro.getEditorial();

        assertEquals("Salamandra", editorialObtenida);
    }

    /**
     * Test of setEditorial method, of class Libro.
     */
    @Test
    public void testSetEditorial() {

        Libro libro = new Libro();

        libro.setEditorial("Planeta");

        assertEquals("Planeta", libro.getEditorial());
    }

    @Test
    public void testAgregaLibro() {
        // Arrange
        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();
        libro.setTitulo("El nombre del viento");
        libro.setAutor("Patrick Rothfuss");
        libro.setEditorial("Plaza & Janés");

        libroDAO.agregarLibro(libro);

        Libro libroObtenido = libroDAO.obtenerLibroPorId(libro.getId());
        assertNotNull(libroObtenido);
        assertEquals(libro.getTitulo(), libroObtenido.getTitulo());
        assertEquals(libro.getAutor(), libroObtenido.getAutor());
        assertEquals(libro.getEditorial(), libroObtenido.getEditorial());
    }

    @Test
    public void testActualizaLibro() {

        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();
        libro.setTitulo("El nombre del viento");
        libro.setAutor("Patrick Rothfuss");
        libro.setEditorial("Plaza & Janés");
        libroDAO.agregarLibro(libro);

        libro.setTitulo("El temor de un hombre sabio");
        libro.setAutor("Patrick Rothfuss");
        libro.setEditorial("Plaza & Janés");

        libroDAO.actualizarLibro(libro);

        Libro libroActualizado = libroDAO.obtenerLibroPorId(libro.getId());
        assertNotNull(libroActualizado);
        assertEquals(libro.getTitulo(), libroActualizado.getTitulo());
        assertEquals(libro.getAutor(), libroActualizado.getAutor());
        assertEquals(libro.getEditorial(), libroActualizado.getEditorial());
    }

    @Test
    public void testEliminaLibro() {

        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();
        libro.setTitulo("El nombre del viento");
        libro.setAutor("Patrick Rothfuss");
        libro.setEditorial("Plaza & Janés");
        libroDAO.agregarLibro(libro);

        libroDAO.eliminarLibro(libro.getId());

        assertNull(libroDAO.obtenerLibroPorId(libro.getId()));
    }

    @Test
    public void testbuscarLibro() {

        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();
        libro.setTitulo("El nombre del viento");
        libro.setAutor("Patrick Rothfuss");
        libro.setEditorial("Plaza & Janés");
        libroDAO.agregarLibro(libro);

        Libro libroObtenido = libroDAO.obtenerLibroPorId(libro.getId());

        assertNotNull(libroObtenido);
        assertEquals(libro.getTitulo(), libroObtenido.getTitulo());
        assertEquals(libro.getAutor(), libroObtenido.getAutor());
        assertEquals(libro.getEditorial(), libroObtenido.getEditorial());
    }
    
    @Test
    public void testGetEstado() {
   
        Libro libro = new Libro();
        libro.setEstado("Disponible"); 

     
        String estadoObtenido = libro.getEstado();

      
        assertEquals("Disponible", estadoObtenido);
    }

    @Test
  public void testSetEstado() {
    
        Libro libro = new Libro();

   
        libro.setEstado("Prestado");

 
        assertEquals("Prestado", libro.getEstado());
    }

    @Test
    public void testEstadoInicialLibroDisponible() {
    
        Libro libro = new Libro();

  
        assertEquals("Disponible", libro.getEstado());
    }

    @Test
    public void testCambioEstadoLibro() {
        // Arrange
        Libro libro = new Libro();
        libro.setEstado("Prestado"); // Supongamos que el libro está disponible

        // Act
        libro.setEstado("Disponible"); // Cambiar el estado a prestado

        // Assert
        assertEquals("Disponible", libro.getEstado());
    }
}
