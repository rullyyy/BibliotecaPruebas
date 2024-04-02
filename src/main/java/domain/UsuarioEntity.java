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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    
 
    
    @Column(name="password")
    private String password;
    
    public UsuarioEntity()
    {
        
    }

    public UsuarioEntity(String nombre, String apellidos, Date fechaNacimiento, String curp, String password)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.password = password;
    }
    
    public UsuarioEntity(long id, String nombre, String apellidos, Date fechaNacimiento, String curp, String password)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.password = password;
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

   public String getPassword()
   {
       return this.password;
   }
   
   public void setPassword(String password)
   {
       this.password = password;
   }
   
   @Override
    public String toString() 
    {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
                + fechaNacimiento + ", curp=" + curp  + "]";
    }
    
   /**
    * Metodo para detonar la persistencia en la base de datos a partir de un objeto que se reciba
    * @param usuario
    * @return 
    */
    
    public UsuarioEntity create(UsuarioEntity usuario)
    {  
        
        return getDataAccessConnection().create(usuario);
    }
    /**
     * Método que regresa el acceso a la base de datos
     * @return una instancia de IUsuarioDAO
     */
    public IUsuarioDAO getDataAccessConnection(){
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO;
    }

    public String consultaPasswordConMatricula(Long id)
    {
        return getDataAccessConnection().consultaPasswordConMatricula(id);
        
    }
    
}
