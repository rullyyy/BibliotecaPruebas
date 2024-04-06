/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess;

import dataAccess.exceptions.NonexistentEntityException;
import domain.LibroEntity;

/**
 *
 * @author xfs85
 */
public interface ILibroDAO {
    public LibroEntity create(LibroEntity libro);
    public LibroEntity update(LibroEntity libro);
    public LibroEntity read();
    public Long delete(Long id) throws NonexistentEntityException ;
    public String creaValoracion();
    public String actualizaValoracionExistente();
    public LibroEntity findLibroEntity(Long id);
    public boolean existeLibro(LibroEntity libro);
}
