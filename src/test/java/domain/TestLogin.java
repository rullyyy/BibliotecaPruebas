/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

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
        IUsuarioDAO usuarioDAO =  Mockito.mock(UsuarioDAO.class);
        
        Mockito.when(usuarioDAO.consultaPasswordConMatricula(3l)).thenReturn("99");
        
        UsuarioEntity userAccess = new UsuarioEntity();
        
        assertEquals(userAccess.consultaPasswordConMatricula(3l), "99");
    }
    
    /**
     * Prueba para la interacción de UI y Dominio
     * En esta prueba creamos una instancia de la clase Login, probamos que los valores que nos 
     * regresa sean los mismos que enviamos para un usuario
     */
    @Test
    public void solicitaInicioSesion()
    {
        // Instancia del loginFRM
        LoginFrm login = new LoginFrm();
        // Creación de un DTO de prueba
        DTOLogin dtoLogin = new DTOLogin(1, "admin");
        // Creación de una entidad de usuario para el accesso a dominio
        UsuarioEntity user = new UsuarioEntity();
        // Establecemos los mismos valores para el usuario de dominio
        user.setId(1);
        user.setPassword("admin");
        // Utilizamos Mockito para devolver el objeto de dominio cuando se llame al solicitar login
        Mockito.when(login.solicitaLogin(dtoLogin)).thenReturn(user);
        // comprobamos que los valores coincida¿n
        assertEquals(login.solicitaLogin(dtoLogin).getPassword(), user.getPassword());
    }
    /**
     * Prueba unitaria de integración para comprobar que se inicie sesión correctamente
     */
    @Test
    public void login()
    {
        LoginFrm login = new LoginFrm();
        // cambiar por un valor existente en la base de datos
        DTOLogin dtoLogin = new DTOLogin(3, "99");
        // Comprobamos que el valor que se regresa en el método de login sea el correspondiente a nuestro DTO
        assertEquals(login.solicitaLogin(dtoLogin).getId(), dtoLogin.getMatricula());

    }
}
