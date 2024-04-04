/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.BibliotecarioDAO;
import dataAccess.IBibliotecarioDAO;
import dataAccess.IUsuarioDAO;
import dataAccess.UsuarioDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import ui.DTOLogin;
import ui.LoginFrm;
/**
 *
 * @author luisp
 */
public class TestLogin {
    
    /**
     * Prueba para comprobar que el método para obtener la contraseña funciona correctamente.
     */
    @Test 
    public void consultaContraseñaConID(){
        IBibliotecarioDAO bdao =  Mockito.mock(BibliotecarioDAO.class);
        
        Mockito.when(bdao.consultaPasswordConMatricula(1L)).thenReturn("99");
        
        BibliotecarioEntity userAccess = new BibliotecarioEntity();
        
        assertEquals(userAccess.consultaPasswordConMatricula(1L), "99");
    }
    
    /**
     * Prueba para la interacción de UI y Dominio
     * En esta prueba creamos una instancia de la clase Login, probamos que los valores que nos 
     * regresa sean los mismos que enviamos para un usuario
     */
    @Test
    public void solicitaInicioSesion()
    {
  
    // Mock del objeto LoginFrm
    LoginFrm login = Mockito.mock(LoginFrm.class);

    // Creación de un DTO de prueba
    DTOLogin dtoLogin = new DTOLogin(1, "admin");

    // Creación de una entidad de usuario para el acceso a dominio
    BibliotecarioEntity user = new BibliotecarioEntity();
    user.setId(1L);
    user.setPassword("admin");

    // Establecemos los mismos valores para el usuario de dominio
    Mockito.when(login.solicitaLogin(dtoLogin)).thenReturn(user);

    // Llamada al método que estamos probando
    BibliotecarioEntity returnedUser = login.solicitaLogin(dtoLogin);

    // comprobamos que los valores coincidan
    assertEquals(returnedUser.getPassword(), user.getPassword());

    }
    /**
     * Prueba unitaria de integración para comprobar que se inicie sesión correctamente
     */
    @Test
    public void login()
    {
        LoginFrm login = new LoginFrm();
        // cambiar por un valor existente en la base de datos
        DTOLogin dtoLogin = new DTOLogin(1, "99");
        // Comprobamos que el valor que se regresa en el método de login sea el correspondiente a nuestro DTO
        assertEquals(login.solicitaLogin(dtoLogin).getId(), dtoLogin.getMatricula());

    }
}
