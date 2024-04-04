/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.LibroDAO;

/**
 *
 * @author SDavidLedesma
 */
public class PrestamoLibroService {

    private final LibroDAO libroDAO;

    public PrestamoLibroService(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public boolean prestarLibro(Long libroId, String usuario) {
        LibroEntity libro = libroDAO.findById(libroId);
        if (libro != null && libro.getEstado() == EstadoLibro.DISPONIBLE) {
            libro.setEstado(EstadoLibro.PRESTADO);
            libroDAO.update(libro);
            return true;
        }
        return false;
    }
}
