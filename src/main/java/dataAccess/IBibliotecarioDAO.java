/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess;

import domain.BibliotecarioEntity;

/**
 *
 * @author xfs85
 */
public interface IBibliotecarioDAO {

    public BibliotecarioEntity create(BibliotecarioEntity Bibliotecario);

    public String consultaPasswordConMatricula(Long matricula);

    public BibliotecarioEntity consultaBibliotecarioConMatricula(Long matricula);

}
