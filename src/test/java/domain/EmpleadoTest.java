package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.Empleado;
import dao.EmpleadoDAO;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author SDavidLedesma
 */
public class EmpleadoTest {
/*
    public EmpleadoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testRegistroNuevoEmpleado() {
        // Arrange
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre("John");
        nuevoEmpleado.setApellido("Doe");

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        // Act
        empleadoDAO.agregarEmpleado(nuevoEmpleado);
    }

    @Test
    public void testBuscarEmpleadoExistentePorID() {
        Empleado empleado = Empleado.buscarPorId(1);
        Assertions.assertNotNull(empleado); // Verificar que se haya encontrado un empleado
        Assertions.assertEquals(1, empleado.getId());
    }

    @Test
    public void testBuscarEmpleadoNoExistentePorID() {
             
        Empleado empleado = Empleado.buscarPorId(100);
        Assertions.assertNull(empleado);
         
    }

    @Test
    public void testActualizarInformacionEmpleadoExistente() {
        Empleado empleadoExistente = new Empleado(1, "Juan", "Perez");
        String nuevoNombre = "Carlos";
        String nuevoApellido = "Gonzalez";

        empleadoExistente.setNombre(nuevoNombre);
        empleadoExistente.setApellido(nuevoApellido);

        Assertions.assertEquals(nuevoNombre, empleadoExistente.getNombre());
        Assertions.assertEquals(nuevoApellido, empleadoExistente.getApellido());
    }

    @Disabled
    @Test
public void testActualizarInformacionEmpleadoNoExistente() {
    
 
}


    @Test
    public void testEliminarEmpleadoExistente() {
        Empleado empleadoExistente = new Empleado(1, "Juan", "Perez");
       EmpleadoDAO empleadoDAO = new EmpleadoDAO();
     
        empleadoDAO.eliminarEmpleado(empleadoExistente);
        
     
        
        // Verificar que el empleado eliminado sea null
        assertNull(empleadoDAO.obtenerEmpleadoPorId(empleadoExistente.getId()));
   
    }
    @Disabled
    @Test
    public void testEliminarEmpleadoNoExistente() {
        
    }

   */
}
