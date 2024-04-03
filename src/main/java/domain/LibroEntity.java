/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.ILibroDAO;
import dataAccess.LibroDAO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author xfs85
 */
@Entity
public class LibroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private Long id;
    
    @Column(name ="titulo")
    private String titulo;

    @Column(name ="autor")
    private String autor;
 
    
    @Column(name="estado")
    private EstadoLibro estado;

    
    
    public LibroEntity() {
    }

   
    public LibroEntity(Long id, String titulo, String autor, EstadoLibro estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
    }

    public LibroEntity(String titulo, String autor, EstadoLibro estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    
    public LibroEntity create(LibroEntity libro){
        return getDataAccessConnection().create(libro);
    }
    
     public ILibroDAO getDataAccessConnection() {
        ILibroDAO libroDAO = new LibroDAO();
        return libroDAO;
    }
}
