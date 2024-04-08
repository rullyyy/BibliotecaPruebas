/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.ILibroDAO;
import dataAccess.LibroDAO;
import dataAccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.swing.JOptionPane;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoLibro estado;

    @Column(name = "keyword")
    private String[] keyword;

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

    public LibroEntity(Long id, String titulo, String autor, EstadoLibro estado, String[] keyword) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
        this.keyword = keyword;
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

    public String[] getKeyword() {
        return keyword;
    }

    public void setKeyword(String[] keyword) {
        this.keyword = keyword;
    }

    /**
     * Método que manda a llamar al método create del acceso a datos
     *
     * @param libro
     *
     * @return LibroEntity que fue persistida
     */
    public LibroEntity create(LibroEntity libro) {
        libro.setEstado(EstadoLibro.DISPONIBLE);
        libro.setKeyword(generarKeyword(libro));
        JOptionPane.showMessageDialog(null, "Se ha guardado el libro correctamente");
        return getDataAccessConnection().create(libro);

    }

    public LibroEntity edit(LibroEntity libroExistente) {
        generarKeyword(libroExistente);
        JOptionPane.showMessageDialog(null, "Se ha editado el libro correctamente");
        return getDataAccessConnection().update(libroExistente);
    }

    public Long delete(LibroEntity libroAEliminar) throws NonexistentEntityException {

        return getDataAccessConnection().delete(libroAEliminar.getId());
    }

    /**
     * Método para obtener la interfaz del acceso a datos.
     *
     * @return Instancia de LibroDAO
     */
    public ILibroDAO getDataAccessConnection() {
        ILibroDAO libroDAO = new LibroDAO();
        return libroDAO;
    }

    public List<LibroEntity> cargarLibros() {
        LibroDAO libroDAO = new LibroDAO();
        return libroDAO.findLibroEntityEntities();
    }

    public String[] generarKeyword(LibroEntity libro) {

        String[] words = libro.getTitulo().toLowerCase(Locale.ROOT).split("\\s+");

        String[] keywords = new String[5];

        // Opción 1: Combinar todas las palabras del título
        StringBuilder keywordBuilder1 = new StringBuilder();
        for (String word : words) {
            keywordBuilder1.append(word);
        }
        keywords[0] = keywordBuilder1.toString();

        // Opción 2: Primeras tres letras de cada palabra del título
        StringBuilder keywordBuilder2 = new StringBuilder();
        for (String word : words) {
            keywordBuilder2.append(word.substring(0, Math.min(word.length(), 3)));
        }
        keywords[1] = keywordBuilder2.toString();

        // Opción 3: Solo la primera palabra del título
        keywords[2] = words[0];

        // Opción 4: Solo la última palabra del título
        keywords[3] = words[words.length - 1];

        // Opción 5: Usar el título completo pero sin espacios
        keywords[4] = libro.getTitulo().replaceAll("\\s+", "");

        for (String keyword : keywords) {
            System.out.println(keyword);
        }
        // Retornar el array de keywords generados
        return keywords;

    }

    public LibroEntity buscarLibroConDTO(DTOAgregarLibro libro) {

        return getDataAccessConnection().findLibroEntity(libro.getId());
    }

    public LibroEntity buscarLibroPorId(Long id) {

        return getDataAccessConnection().findLibroEntity(id);
    }

    public List<LibroEntity> findLibroEntityEntities() {
        return getDataAccessConnection().findLibroEntityEntities(true, -1, -1);
    }
    
    
    public LibroEntity prestarLibro(LibroEntity libro) {
        libro = getDataAccessConnection().findLibroEntity(libro.getId());
        libro.setEstado(EstadoLibro.PRESTADO);
        JOptionPane.showMessageDialog(null, "Se ha realizado el prestamo");
        return getDataAccessConnection().update(libro);
    }

    public LibroEntity devolverLibro(LibroEntity libro) {
        libro = getDataAccessConnection().findLibroEntity(libro.getId());
        libro.setEstado(EstadoLibro.DISPONIBLE);
        JOptionPane.showMessageDialog(null, "Se ha devuelto el libro");
        return getDataAccessConnection().update(libro);
    }

    public List<LibroEntity> cargarLibrosDisponibles() {
        return getDataAccessConnection().filtrarLibrosDisponibles();
    }

    public List<LibroEntity> cargarLibrosPrestados() {
        return getDataAccessConnection().filtrarLibrosPrestados();
    }
}
    
    


