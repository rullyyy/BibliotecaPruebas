/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.BibliotecarioDAO;
import dataAccess.IBibliotecarioDAO;
import dataAccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;
import ui.DTOAgregarLibro;
import ui.DTOAgregarUsuario;
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
  
    
    public <T> T crearEntidadConDTO(Object dto, Class<T> entityClass) throws IllegalAccessException, InstantiationException {
        T entidad = entityClass.newInstance();
        Field[] camposDTO = dto.getClass().getDeclaredFields();
        Field[] camposEntidad = entityClass.getDeclaredFields();

        for (Field campoDTO : camposDTO) {
            campoDTO.setAccessible(true);
            for (Field campoEntidad : camposEntidad) {
                campoEntidad.setAccessible(true);
                if (campoEntidad.getName().equals(campoDTO.getName())) {
                    Object value = campoDTO.get(dto);
                    if (value instanceof LocalDate && campoEntidad.getType().equals(Date.class)) {
                        LocalDate localDate = (LocalDate) value;
                        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        campoEntidad.set(entidad, date);
                    } else {
                        campoEntidad.set(entidad, campoDTO.get(dto));
                    }
                    break;
                }
            }
        }
        return entidad;
    }
    public UsuarioEntity registraUsuario(DTOAgregarUsuario usuarioDTO) throws IllegalAccessException, InstantiationException{
         UsuarioEntity usuario = crearEntidadConDTO(usuarioDTO, UsuarioEntity.class);
        if(usuario.getDataAccessConnection().existeUsuario(usuario) == false){
            return usuario.create(usuario);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Libro Existente");
        }
        return null;
        
    }
    
    public UsuarioEntity editaUsuario(DTOAgregarUsuario usuarioDTO){
        
        UsuarioEntity ue = new UsuarioEntity();
        UsuarioEntity usuarioExistente = ue.findUser(usuarioDTO.getId());
         LocalDate localDate = usuarioDTO.getFechaNacimiento();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setApellidos(usuarioDTO.getApellido());
        usuarioExistente.setFechaNacimiento(date);
        usuarioExistente.setCurp(usuarioDTO.getCurp());
        usuarioExistente.setMatricula(usuarioDTO.getMatricula());
        
        if(usuarioExistente.getDataAccessConnection().existeUsuario(usuarioExistente) == false){
            return usuarioExistente.edit(usuarioExistente);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Ha ingresado datos de un usuario ya existente (CURP o Matricula)");
        }
        return null;
    }
    
    public LibroEntity registraLibro(DTOAgregarLibro libroDTO) throws IllegalAccessException, InstantiationException{
       LibroEntity libro = crearEntidadConDTO(libroDTO, LibroEntity.class);
        if(libro.getDataAccessConnection().existeLibro(libro) == false){
            return libro.create(libro);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Libro Existente");
        }
        return null;
  
    }
    
    
    
    
    public LibroEntity editaLibro(DTOAgregarLibro libroDTO) throws IllegalAccessException, InstantiationException{
        LibroEntity lb = new LibroEntity();
        
        LibroEntity libroExistente = lb.buscarLibroConDTO(libroDTO);
        
        libroExistente.setTitulo(libroDTO.getTitulo());
        libroExistente.setAutor(libroDTO.getAutor());
         
        if(libroExistente.getDataAccessConnection().existeLibro(libroExistente)== false){
            return libroExistente.edit(libroExistente);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Ha ingresado datos de un libro ya existente");
        }
        return null;
        
    }
    
    public Long eliminaLibro(DTOAgregarLibro DTOlibro)throws NonexistentEntityException{
        LibroEntity lb = new LibroEntity();
        LibroEntity libroExistente = lb.buscarLibroConDTO(DTOlibro);
        
        libroExistente.setId(DTOlibro.getId());
        libroExistente.setTitulo(DTOlibro.getTitulo());
        libroExistente.setAutor(DTOlibro.getAutor());
        return libroExistente.delete(libroExistente);
   
    }
    
    public float solicitaValoracionLibro(LibroEntity libro){
        String [] keyword = libro.getKeyword();
        ValoracionLibro valoracionLibro = new ValoracionLibro();
        return valoracionLibro.obtieneValoracion(keyword);
    }

   public LibroEntity obtieneLibro(Long id){
       LibroEntity libro = new LibroEntity();
       return libro.buscarLibroPorId(id); 
   }

}
