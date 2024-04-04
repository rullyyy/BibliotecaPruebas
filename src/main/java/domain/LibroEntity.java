/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.ILibroDAO;
import dataAccess.LibroDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import ui.DTOAgregarLibro;

/**
 *
 * @author xfs85
 */
@Entity
public class LibroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "id")
    private Long id;
    
    @Column(name ="titulo")
    private String titulo;

    @Column(name ="autor")
    private String autor;
 
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private EstadoLibro estado;
//
//    @Column(name="keyword")
//    private String keyword;
//    
    
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
    
//    
//    public String getKeyword() {
//        return keyword;
//    }
//
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }
//    
    
    /**
     * Método que manda a llamar al método create del acceso a datos
     * @param DTOLibro 
     * @return LibroEntity que fue persistida
     */
    
    public LibroEntity create(DTOAgregarLibro DTOLibro){
        return getDataAccessConnection().create(creaEntidadConDTO(DTOLibro));
    }
    /**
     * Método para obtener una instancia de LibroEntity con un DTO
     * @param DTOLibro DTO con los datos para registrar al libro
     * @return LibroEntity con los valores requeridos según el DTOLibro
     */
    
    public LibroEntity creaEntidadConDTO(DTOAgregarLibro DTOLibro)
    {
        LibroEntity libro = new LibroEntity(DTOLibro.getTitulo(), DTOLibro.getAutor(),EstadoLibro.DISPONIBLE);
        return libro;
    }
    /**
     * Método para obtener la interfaz del acceso a datos.
     * @return Instancia de LibroDAO
     */
     public ILibroDAO getDataAccessConnection()
     {
        ILibroDAO libroDAO = new LibroDAO();
        return libroDAO;
    }
     
     public List<LibroEntity> cargarLibros(){
         LibroDAO libroDAO = new LibroDAO();
        return libroDAO.findLibroEntityEntities();
     }
}
