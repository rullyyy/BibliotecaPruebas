/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo;

import dataAccess.IUsuarioDAO;
import dataAccess.UsuarioDAO;
import domain.UsuarioEntity;
import java.util.Date;

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
     System.out.println(user.consultaPasswordConMatricula(Long.valueOf(3)));
     
    }

}
