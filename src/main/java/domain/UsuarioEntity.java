/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.IUsuarioDAO;
import dataAccess.UsuarioDAO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luisp
 */
@Entity
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    @Column(name="id")
    private long id; 
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidos")
    private String apellidos;
    
    @Column(name="fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name="curp")
    private String curp;
    
    @Column(name="matricula")
    private long matricula;
    
    
    public UsuarioEntity()
    {
        
    }

    public UsuarioEntity(String nombre, String apellidos, Date fechaNacimiento, String curp, long matricula)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.matricula = matricula;
    }
    
    public UsuarioEntity(long id, String nombre, String apellidos, Date fechaNacimiento, String curp, long matricula)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.matricula = matricula;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidos() 
    {
        return apellidos;
    }

    public void setApellidos(String apellidos) 
    {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() 
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) 
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() 
    {
        return curp;
    }

    public void setCurp(String curp) 
    {
        this.curp = curp;
    }

    public long getMatricula() 
    {
        return matricula;
    }

    public void setMatricula(long matricula) 
    {
        this.matricula = matricula;
    }

    
    public UsuarioEntity create(UsuarioEntity usuario)
    {  
        
        return getDataAccessConnection().create(usuario);
    }
    /**
     * Método que regresa el acceso a la base de datos
     * @return una instancia de IUsuarioDAO
     */
    public static IUsuarioDAO getDataAccessConnection(){
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO;
    }
    @Override
    public String toString() 
    {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
                + fechaNacimiento + ", curp=" + curp + ", matricula=" + matricula + "]";
    }
}
