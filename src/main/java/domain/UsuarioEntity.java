/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.IUsuarioDAO;
import dataAccess.UsuarioDAO;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ui.DTOAgregarUsuario;
import ui.DTOLogin;

/**
 *
 * @author luisp
 */
@Entity

public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "curp")
    private String curp;
    
    @Column (name = "Matricula")
    private String matricula;


    public UsuarioEntity() {

    }

    public UsuarioEntity(String nombre, String apellidos, Date fechaNacimiento, String curp, String matricula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.matricula = matricula;
    }

    public UsuarioEntity(int id, String nombre, String apellidos, Date fechaNacimiento, String curp, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
                + fechaNacimiento + ", curp=" + curp + "]";
    }

    /**
     * Metodo para detonar la persistencia en la base de datos a partir de un
     * objeto que se reciba
     *
     * @param usuario
     * @return
     */
    public UsuarioEntity create(DTOAgregarUsuario usuario) {

        return getDataAccessConnection().create(crearEntidadConDTO(usuario));
    }
    
    public UsuarioEntity crearEntidadConDTO(DTOAgregarUsuario DTOUsuario){
        LocalDate localDate = DTOUsuario.getFechaNacimiento();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        UsuarioEntity usuario = new UsuarioEntity(DTOUsuario.getNombre(), DTOUsuario.getApellido(), date,
            DTOUsuario.getCurp(),DTOUsuario.getMatricula());
        return usuario;
    }

    /**
     * Método que regresa el acceso a la base de datos
     *
     * @return una instancia de IUsuarioDAO
     */
    public IUsuarioDAO getDataAccessConnection() {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO;
    }
    
    /**
     * Método para traer a los usuarios de la Base de Datos
     * 
     * @return Lista de Usuarios
     */
    public List<UsuarioEntity> findUsuarioEntityEntities() {
        return getDataAccessConnection().findUsers(true, -1, -1);
    }
    
    
    /**
     * Método para traer un solo Usuario de la Base de Datos
     * 
     * @param id
     * @return 
     */
    public UsuarioEntity findUser(int id){
        return getDataAccessConnection().findUser(id);
    }
    
    

   
}
