/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess;

import domain.LibroEntity;
import domain.UsuarioEntity;

/**
 *
 * @author xfs85
 */
public interface ILibroDAO {
    public LibroEntity create(LibroEntity libro);
    public UsuarioEntity update();
    public UsuarioEntity read();
    public UsuarioEntity delete();
    public String creaValoracion();
    public String actualizaValoracionExistente();
}
