/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.BibliotecarioDAO;
import dataAccess.IBibliotecarioDAO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import ui.DTOLogin;

/**
 *
 * @author PC
 */
@Entity
public class BibliotecarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BibliotecarioEntity() {
    }

    public BibliotecarioEntity(String nombre, String apellidos, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
    }

    public BibliotecarioEntity(Long id, String nombre, String apellidos, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
    }

    
    
     /**
     * Metodo para detonar la persistencia en la base de datos a partir de un
     * objeto que se reciba
     *
     * @param usuario
     * @return
     */
    public BibliotecarioEntity create(BibliotecarioEntity usuario) {

        return getDataAccessConnection().create(usuario);
    }
    /**
     * Método que regresa el acceso a la base de datos
     *
     * @return una instancia de IUsuarioDAO
     */
    public IBibliotecarioDAO getDataAccessConnection() {
        IBibliotecarioDAO bDAO = new BibliotecarioDAO();
        return bDAO;
    }

    /**
     * Metodo que consulta la contraseña de un usuraio utilizando su matricula
     * (ID)
     *
     * @param id id del usuario en el acceso a datos (la matricula en la UI)
     * @return Una cadena con el valor del password del usuario
     */
    public String consultaPasswordConMatricula(Long id) 
    {
        return getDataAccessConnection().consultaPasswordConMatricula(id);

    }
    /**
     * Método para hacer login que confirma que la contraseña del DTO y de la DB sea la misma 
     * 
     * @param dtoLogin DTO que se envía desde la UI
     * @return Si la contraseña es la misma regresa una entidad UsuarioEntity
     */
    public BibliotecarioEntity loginWithPassword(DTOLogin dtoLogin) 
    {
        IBibliotecarioDAO bDAO = new BibliotecarioDAO();
        String passwordUsuario = bDAO.consultaPasswordConMatricula(dtoLogin.getMatricula());
        if(passwordUsuario.equals(String.valueOf(dtoLogin.getPassword()))){
            return bDAO.consultaBibliotecarioConMatricula(dtoLogin.getMatricula());
        }else{
            return null;
        }

    }


}
