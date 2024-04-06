/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 * DTO que se usa en el proceso de registrar un nuevo libro. Guarda los valores de titulo y autor para 
 * pasarlos a la siguiente capa.
 * @author luisp
 */
public class DTOAgregarLibro {
    private Long id;
    private String titulo;
    private String autor;
    
    public DTOAgregarLibro() 
    {
        
    }

    public DTOAgregarLibro(Long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public DTOAgregarLibro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
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
    
    
}
