/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo;

import dataAccess.IUsuarioDAO;
import dataAccess.UsuarioDAO;
import domain.EstadoLibro;
import domain.LibroEntity;
import domain.UsuarioEntity;
import java.util.Date;
import ui.DTOLogin;
import ui.LoginFrm;

/**
 *
 * @author luisp
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UsuarioEntity user = new UsuarioEntity(); 
        new LoginFrm().setVisible(true);

//        DTOLogin dtoLogin = new DTOLogin(3, "99");
//        UsuarioEntity usuarioObtenido = login.solicitaLogin(dtoLogin);
//        System.out.println(usuarioObtenido.getId());
//        System.out.println("");
        
    LibroEntity libro = new LibroEntity("P", "P", EstadoLibro.PRESTADO);
    }

}
