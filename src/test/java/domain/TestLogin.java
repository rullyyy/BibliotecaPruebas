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
/**
 *
 * @author luisp
 */
public class TestLogin {
    
    
    @Test 
    public void consultaContraseñaConID(){
        IUsuarioDAO usuarioDAO =  Mockito.mock(UsuarioDAO.class);
        
        Mockito.when(usuarioDAO.consultaPasswordConMatricula(3l)).thenReturn("99");
        
        UsuarioEntity userAccess = new UsuarioEntity();
        
        assertEquals(userAccess.consultaPasswordConMatricula(3l), "99");
    }
}
